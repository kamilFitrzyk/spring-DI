package springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import springframework.pets.CatPetService;
import springframework.pets.PetService;
import springframework.pets.PetServiceFactory;
import springframework.sfgdi.repositories.EnglishGreetingRepository;
import springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import springframework.sfgdi.services.*;

@Configuration
public class GreetingServiceConfig {

    @Profile({"dog","default"})
    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean("petService")
    PetService DogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPerService("dog");
    }

    @Profile("cat")
    @Bean
    PetService CatPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPerService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishService i18nSpanishService(){
        return new I18nSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectorGreetingService propertyInjectorGreetingService() {
        return new PropertyInjectorGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
