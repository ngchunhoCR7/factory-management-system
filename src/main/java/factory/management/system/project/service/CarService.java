package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Car;
import factory.management.system.project.mapper.CarMapper;
import factory.management.system.project.pojo.CarInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CarController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class CarService {
    
    @Autowired
    private CarMapper carMapper;

    /**
     * 获取车辆列表
     *
     * @return
     */
    public List<Car> carList() {
        return carMapper.selectAll();
    }

    /**
     * 获取车辆信息列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<CarInfo> getCdInfo(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<CarInfo>) MyDruid.of(carMapper).retrieveInfo(pageSizeInfo);
    }

    /**
     * 获取单个车辆信息
     *
     * @return
     */
    public CarInfo getInfoById(Integer carId) {
        return carMapper.selectInfoById(carId);
    }

    /**
     * 获取车辆列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Car> getCars(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Car>) MyDruid.of(carMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个车辆
     *
     * @param CarId
     * @return
     */
    public Car getCar(Integer CarId) {
        return (Car) MyDruid.of(carMapper).retrieve(CarId);
    }

    /**
     * 新增车辆
     *
     * @param Car
     */
    public void insertCar(Car Car) {
        MyDruid.of(carMapper).insert(Car);
    }

    /**
     * 更新车辆
     *
     * @param Car
     */
    public void updateCar(Car Car) {
        MyDruid.of(carMapper).update(Car);
    }

    /**
     * 删除车辆
     *
     * @param CarId
     */
    public void deleteCar(Integer CarId) {
        MyDruid.of(carMapper).delete(CarId);
    }
}
