package ir.moke.database.jdbc;

import ir.moke.database.jdbc.model.bl.CarManager;
import ir.moke.database.jdbc.model.bl.PersonManager;
import ir.moke.database.jdbc.model.to.CarTo;
import ir.moke.database.jdbc.model.to.PersonTo;
import org.flywaydb.core.Flyway;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainClass {
    public static void main(String[] args) {
        PersonTo personTo = new PersonTo(1, "mahdi", "Hosseini");
        CarTo carTo1 = new CarTo(1, "Benz", personTo);
        CarTo carTo2 = new CarTo(2, "BMW", personTo);
        CarTo carTo3 = new CarTo(3, "Toyota", personTo);
        CarTo carTo4 = new CarTo(4, "Mazda", personTo);

        List<CarTo> carToList = new ArrayList<>();
        carToList.add(carTo1);
        carToList.add(carTo2);
        carToList.add(carTo3);
        carToList.add(carTo4);

        PersonManager personManager = new PersonManager();
        personManager.registerPerson(personTo);

        CarManager carManager = new CarManager();
        carToList.forEach(carManager::registerCar);
    }
}
