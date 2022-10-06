package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showAllCars(@RequestParam(required = false) Integer count, Model model) {
        model.addAttribute("cars", carService.getCarsEqualTo(count == null ? carService.getCars().size() : count));
        model.addAttribute("brands", Brand.values());
        return "cars";
    }

    @GetMapping("/filter")
    public String showOnlyAudi(@RequestParam("brand") String brand, Model model) {
        model.addAttribute("cars", carService.getCars().stream().filter(c -> c.getBrand().equals(brand)).collect(Collectors.toList()));
        return "cars";
    }
    @PostMapping
    public String addCar(@ModelAttribute("newCar") Car car) {
        car.setId(carService.getCars().size() + 1);
        carService.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String deleteCar(@PathVariable("id") int id){
        carService.deleteCarById(id);
        return "redirect:/cars";
    }
}
