package web.service;

import org.springframework.stereotype.Service;
import web.controller.Brand;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car(1, Brand.BMW.name(), 5, 14399D));
        cars.add(new Car(2, Brand.VOLVO.name(), 60, 13699D));
        cars.add(new Car(3, Brand.AUDI.name(), 8, 18450D));
        cars.add(new Car(4, Brand.LADA.name(), 14, 2345D));
        cars.add(new Car(5, Brand.MERCEDES_BENZ.name(), 600, 11230D));
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsEqualTo(int count) {
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCarById(int id) {
        cars.remove(id);
    }

}
