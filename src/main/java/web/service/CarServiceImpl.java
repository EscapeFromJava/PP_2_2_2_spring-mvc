package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public int getCount(List<Car> cars) {
        return cars.size();
    }
}
