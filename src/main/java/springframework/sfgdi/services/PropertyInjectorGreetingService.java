package springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectorGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }

}
