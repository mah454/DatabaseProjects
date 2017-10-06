package ir.moke.database.jdbc;

import ir.moke.database.jdbc.model.bl.PersonManager;
import ir.moke.database.jdbc.model.to.PersonTo;

public class MainClass {
    public static void main(String[] args) {
        PersonTo personTo1 = new PersonTo();
        personTo1.setId(1);
        personTo1.setName("sina");
        personTo1.setFamily("XXX");

        PersonTo personTo2 = new PersonTo();
        personTo2.setId(2);
        personTo2.setName("ali");
        personTo2.setFamily("yyy");
        PersonManager personManager = new PersonManager();
        personManager.registerPerson(personTo1);
        personManager.registerPerson(personTo2);
    }
}
