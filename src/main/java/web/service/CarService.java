package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    List<Car> createCars();

    List<Car> getCarsEqualTo(List<Car> cars, int count);
}
