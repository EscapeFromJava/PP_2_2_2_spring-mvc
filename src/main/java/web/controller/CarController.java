package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showAllCars(@RequestParam(required = false) Integer count, Model model) {
        List<Car> cars = carService.createCars();
        model.addAttribute("cars", carService.getCarsEqualTo(cars, count == null ? cars.size() : count));
        return "cars";
    }
}
