package osgiR6Annotations_practice.core.schedulers;


import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Designate(ocd= OSGiR6SchedulerConfig.class)
public class OSGiR6Scheduler implements Runnable{

    @Reference
    private Scheduler scheduler;
    private int schedulerID;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Activate
    protected void activate(OSGiR6SchedulerConfig config){
        schedulerID = config.schedulerName().hashCode();
    }

    @Modified
    protected void modified(OSGiR6SchedulerConfig config){
        removeScheduler();
        schedulerID = config.schedulerName().hashCode(); //Update the schedulerID
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(OSGiR6SchedulerConfig config) {
        removeScheduler();
    }


    private void removeScheduler(){
      LOGGER.info("--- Removing the Scheduler Job '{}'", schedulerID);
      scheduler.unschedule(String.valueOf(schedulerID));
    }

    private void addScheduler(OSGiR6SchedulerConfig config){
        if(config.serviceEnabled()){
            LOGGER.info("--- ServiceEnabled Set to true, adding the scheduler---");
            ScheduleOptions options = scheduler.EXPR(config.schedulerExpression());
            options.name(String.valueOf(schedulerID));
            options.canRunConcurrently(false);
            scheduler.schedule(this,options);
        }
        else{
            LOGGER.info("--- ServiceEnabled Set to false, NOT adding the scheduler---");
        }

    }

    @Override
    public void run(){

        LOGGER.info("--- RUNNING The scheduler task---");


    }
}
