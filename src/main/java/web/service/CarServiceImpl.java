package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 5, 14399D));
        cars.add(new Car("Volvo", 60, 13699D));
        cars.add(new Car("Audi", 8, 18450D));
        cars.add(new Car("Lada", 14, 2345D));
        cars.add(new Car("MB", 600, 11230D));
        return cars;
    }

    @Override
    public List<Car> getCarsEqualTo(List<Car> cars, int count) {
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
