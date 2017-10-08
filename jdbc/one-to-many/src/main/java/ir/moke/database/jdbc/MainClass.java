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
        CarTo carTo1 = new CarTo(1, "Benz");
        CarTo carTo2 = new CarTo(2, "BMW");
        CarTo carTo3 = new CarTo(3, "Toyota");
        CarTo carTo4 = new CarTo(4, "Mazda");

        List<CarTo> carToList = new ArrayList<>();
        carToList.add(carTo1);
        carToList.add(carTo2);
        carToList.add(carTo3);
        carToList.add(carTo4);

        PersonTo person = new PersonTo(1, "sina", "mohammadi", carToList);

        PersonManager personManager = new PersonManager();
        personManager.registerPerson(person);

        CarManager carManager = new CarManager();
        carManager.removeCar(1);
        carManager.removeCar(2);
        carManager.removeCar(3);
        carManager.removeCar(4);
        carToList.forEach(e -> carManager.registerCar(e, 1));

        System.out.println(person.toString());
        carToList.forEach(e -> System.out.println(e.toString()));
    }
}
