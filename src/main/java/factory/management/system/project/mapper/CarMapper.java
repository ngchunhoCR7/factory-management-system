package factory.management.system.project.mapper;

import factory.management.system.project.entity.Car;
import factory.management.system.project.pojo.CarInfo;
import factory.management.system.project.utils.MyMapper;

import java.util.List;

public interface CarMapper extends MyMapper<Car> {

    @Override
    public List<CarInfo> selectInfo();

    @Override
    public CarInfo selectInfoById(Object carId);
}