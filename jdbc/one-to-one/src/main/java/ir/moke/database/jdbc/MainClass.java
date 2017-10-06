package ir.moke.database.jdbc;

import ir.moke.database.jdbc.model.bl.CarManager;
import ir.moke.database.jdbc.model.bl.PersonManager;
import ir.moke.database.jdbc.model.to.CarTo;
import ir.moke.database.jdbc.model.to.PersonTo;
import org.flywaydb.core.Flyway;

import java.util.Properties;

public class MainClass {
    public static void main(String[] args) {
        PersonTo personTo1 = new PersonTo(1, "sina", "mohammadi");
        PersonTo personTo2 = new PersonTo(2, "mahdi", "Hosseini");

        CarTo carTo1 = new CarTo(1, "Benz", personTo1);
        CarTo carTo2 = new CarTo(2, "BMW", personTo2);

        PersonManager personManager = new PersonManager();
//        personManager.registerPerson(personTo1);
//        personManager.registerPerson(personTo2);

        CarManager carManager = new CarManager();
//        carManager.registerCar(carTo1);
//        carManager.registerCar(carTo2);

        carManager.showAllCars().forEach(e -> {
            System.out.println(e);
            System.out.println(personManager.showPerson(e.getPersonTo().getId()));

        });
    }
}
