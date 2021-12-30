package springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springframework.sfgdi.controllers.ConstructorInjectionController;
import springframework.sfgdi.controllers.MyController;
import springframework.sfgdi.controllers.PropertyInjectionController;
import springframework.sfgdi.controllers.SetterInjectionController;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx  = SpringApplication.run(SfgDiApplication.class, args);

        MyController myController = (MyController) ctx.getBean("myController");

        String greeting = myController.sayHello();

        System.out.println(greeting);

        System.out.println("---Property");

        PropertyInjectionController propertyInjectionController = (PropertyInjectionController) ctx.getBean("propertyInjectionController");

        System.out.println(propertyInjectionController.getGreeting());

        System.out.println("---Setter");

        SetterInjectionController setterInjectionController = (SetterInjectionController) ctx.getBean("setterInjectionController");

        System.out.println(setterInjectionController.getGreeting());

        System.out.println("---Construct");

        ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) ctx.getBean("constructorInjectionController");

        System.out.println(constructorInjectionController.getGreeting());
    }

}
