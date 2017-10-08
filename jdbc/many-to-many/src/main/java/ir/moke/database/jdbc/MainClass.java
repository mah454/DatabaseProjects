package ir.moke.database.jdbc;

import ir.moke.database.jdbc.model.dao.PersonsCarsDao;
import ir.moke.database.jdbc.model.to.CarTo;
import ir.moke.database.jdbc.model.to.PersonTo;
import ir.moke.database.jdbc.model.to.PersonsCars;

public class MainClass {
    public static void main(String[] args) {

        PersonTo personTo = new PersonTo(1, "mahdi", "Hosseini",null);
        PersonTo personTo2 = new PersonTo(2, "ali", "hosseini",null);
        CarTo carTo1 = new CarTo(1, "Benz", null);
        CarTo carTo2 = new CarTo(2, "BMW", null);
        CarTo carTo3 = new CarTo(3, "Toyota", null);
        CarTo carTo4 = new CarTo(4, "Mazda", null);


//        CarDao carDao = new CarDao() ;
//        carDao.insert(carTo4);

//        PersonDao personDao = new PersonDao() ;
//        personDao.insert(personTo);

        PersonsCars personsCars = new PersonsCars(5,1,4);
        PersonsCarsDao personsCarsDao = new PersonsCarsDao() ;
        personsCarsDao.insert(personsCars);

    }
}