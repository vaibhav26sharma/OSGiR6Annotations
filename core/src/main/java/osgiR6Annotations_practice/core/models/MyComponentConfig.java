package osgiR6Annotations_practice.core.models;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Hello World Config", description = "This config is using r6 annotations")
public @interface MyComponentConfig {
    @AttributeDefinition(name="Welcome Message", description = "This message is displayed on the component startup")
    String welcome_message() default "Hello World";

    @AttributeDefinition(name = "Welcome Message Count", description="This is the number of times, the welcome message will be displayed. " +
            "If less than one, no message will be displayed.")
    int welcome_count() default  3;

    @AttributeDefinition(name="Output Goodbye", description="Set this if the component should output a goodbye message.")
    boolean output_goodbye() default true;

    @AttributeDefinition(name = "Expression", description = "Cron-job expression. Default: run every hour.",
            type = AttributeType.STRING)
    String schedulerExpression() default "0 0 0/1 1/1 * ? *";
}
