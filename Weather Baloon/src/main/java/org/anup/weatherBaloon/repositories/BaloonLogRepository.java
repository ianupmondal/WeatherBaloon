package org.anup.weatherBaloon.repositories;

import org.anup.weatherBaloon.model.BaloonLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaloonLogRepository extends MongoRepository<BaloonLog, Long> {

   // Integer minTemperature(String temperature);
   // Integer meanTemperature(String temperature);
  //  Integer maxTemperature(String temperature);
}
