package springframework.sfgdi.services;

public class PropertyInjectorGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }

}
