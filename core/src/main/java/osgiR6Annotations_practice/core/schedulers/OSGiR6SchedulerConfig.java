package osgiR6Annotations_practice.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "OSGi R6 Scheduler", description = "OSGi R6 Scheduler config Description")
public @interface OSGiR6SchedulerConfig {
        /**
         * schedulerName
         *
         * @return String name
         */
        @AttributeDefinition(name = "Scheduler name", description = "Scheduler name", type = AttributeType.STRING)
        public String schedulerName() default "OSGi R6 Annotation Scheduler Example";

        /**
         * schedulerConcurrent
         *
         * @return schedulerConcurrent
         */
        @AttributeDefinition(name = "Concurrent", description = "Schedule task concurrently", type = AttributeType.BOOLEAN)
        boolean schedulerConcurrent() default true;

        /**
         * serviceEnabled
         *
         * @return serviceEnabled
         */
        @AttributeDefinition(name = "Enabled", description = "Enable Scheduler", type = AttributeType.BOOLEAN)
        boolean serviceEnabled() default true;

        /**
         * schedulerExpression
         *
         * @return schedulerExpression
         */
        @AttributeDefinition(name = "Expression", description = "Cron-job expression. Default: run every hour.", type = AttributeType.STRING)
        String schedulerExpression() default " 0/1 0/4 0 ? * * *";
    }

