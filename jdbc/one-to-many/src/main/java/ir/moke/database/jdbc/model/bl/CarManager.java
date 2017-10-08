package ir.moke.database.jdbc.model.bl;

import ir.moke.database.jdbc.model.dao.CarDao;
import ir.moke.database.jdbc.model.to.CarTo;

import java.util.List;

public class CarManager {
    public void registerCar(CarTo carTo, long fk) {
        CarDao carDao = new CarDao();
        carDao.insert(carTo, fk);
    }

    public void modifyCar(CarTo carTo, long fk) {
        CarDao carDao = new CarDao();
        carDao.update(carTo, fk);
    }

    public void removeCar(long id) {
        CarDao carDao = new CarDao();
        carDao.delete(id);
    }

    public CarTo show(long id) {
        CarDao carDao = new CarDao();
        return carDao.select(id);
    }

    public List<CarTo> showAllCars() {
        CarDao carDao = new CarDao();
        return carDao.select();
    }
}
