package ua.smart.bottle.smartbottle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.smart.bottle.smartbottle.model.Water;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface WaterRepository extends MongoRepository<Water, String> {

    Water findItemById(String id);

    List<Water> findAll();

    List<Water> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    long count();

}
