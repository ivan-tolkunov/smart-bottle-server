package ua.smart.bottle.smartbottle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ua.smart.bottle.smartbottle.repository.WaterRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses
        = {
        WaterRepository.class
})
public class SmartBottleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartBottleApplication.class, args);
    }

}
