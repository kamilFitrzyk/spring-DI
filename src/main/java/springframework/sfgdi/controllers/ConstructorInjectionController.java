package springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springframework.sfgdi.services.GreetingService;
import springframework.sfgdi.services.GreetingServiceImpl;

@Controller
public class ConstructorInjectionController {

    private final GreetingService greetingService;


    public ConstructorInjectionController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
