package com.carmanagement.system.repository;
import com.carmanagement.system.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByAno(int ano);
    List<Car> findByColor(String color);

    List<Car> findByPrice(long price);
    List<Car> findByBrand(String brand);


}
