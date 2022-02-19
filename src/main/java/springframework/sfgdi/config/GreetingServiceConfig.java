package springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springframework.pets.PetService;
import springframework.pets.PetServiceFactory;
import springframework.sfgdi.datasource.FakeDataSource;
import springframework.sfgdi.repositories.EnglishGreetingRepository;
import springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import springframework.sfgdi.services.*;

import java.awt.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${di.username}") String username,
                                  @Value("${di.password}") String password,
                                  @Value("${di.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

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
    PropertyInjectorGreetingService propertyInjectorGreetingService() {
        return new PropertyInjectorGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
