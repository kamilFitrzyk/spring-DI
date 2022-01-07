package springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.sfgdi.services.ConstructorGreetingService;

class ConstructorInjectionControllerTest {

    public ConstructorInjectedController construct;

    @BeforeEach
    void setUp() {
        construct = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(construct.getGreeting());
    }
}