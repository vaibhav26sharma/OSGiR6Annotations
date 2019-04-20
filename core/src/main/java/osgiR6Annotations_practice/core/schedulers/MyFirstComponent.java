package osgiR6Annotations_practice.core.schedulers;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import osgiR6Annotations_practice.core.models.MyComponentConfig;

//import org.osgi.service.component.annotations.Deactivate;
//import org.osgi.service.event.Event;

//import java.util.HashMap;

@Component
@Designate(ocd=MyComponentConfig.class)
public class MyFirstComponent {

    private volatile boolean doRun;
    @Reference
    private EventAdmin eventAdmin;
    Logger LOGGER = LoggerFactory.getLogger(MyFirstComponent.class);

 /*   @Activate
    protected void activate() {

        LOGGER.info("--- Activating MyFirstComponent OSGi R6 annotations---");
        final Thread t = new Thread() {
            public void run() {

                doIt();
            }

        };
        t.setDaemon(true);
        doRun = true;
        t.start();

    }*/

 @Activate
 protected  void activate(MyComponentConfig config){
     for(int i =0; i <config.welcome_count();i++){
         LOGGER.info("---"+config.welcome_message()+"---");
     }


 }

    /*private void doIt() {
        while (doRun) {
            final Event event = new Event("alive", new HashMap<>());
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Deactivate
    protected void deactivate(){
        doRun = false;
    }*/


}


