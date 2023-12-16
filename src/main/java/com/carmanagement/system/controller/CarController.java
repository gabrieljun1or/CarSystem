package com.carmanagement.system.controller;

import com.carmanagement.system.entities.Car;
import com.carmanagement.system.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
@Controller
public class CarController { private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping("/index")
    public String showCarList(Model model) {
        List<Car> cars = (List<Car>) carRepository.findAll();
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/add-car")
    public String showCarForm(Car car) {
        return "add-car";
    }

    @PostMapping("/add-car")
    public String addCar(Car car) {
        carRepository.save(car);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        carRepository.delete(car);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));

        model.addAttribute("car", car);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, @Valid Car car,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            car.setId(id);
            return "update";

        }
        carRepository.save(car);
        return "redirect:/index";

    }
}
