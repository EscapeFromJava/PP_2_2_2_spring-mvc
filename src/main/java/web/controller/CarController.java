package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String showAllCars(@RequestParam(defaultValue = "5", required = false) Integer count,
                              ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 5, 14399D));
        cars.add(new Car("Volvo", 60, 13699D));
        cars.add(new Car("Audi", 8, 18450D));
        cars.add(new Car("Audi", 4, 9745D));
        cars.add(new Car("MB", 600, 11230D));
        model.addAttribute("cars", cars.stream().limit(count).collect(Collectors.toList()));
        return "cars";
    }
}
