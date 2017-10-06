package ir.moke.database.jdbc.model.bl;

import ir.moke.database.jdbc.model.dao.PersonDao;
import ir.moke.database.jdbc.model.to.PersonTo;

import java.util.List;

public class PersonManager {
    public void registerPerson(PersonTo personTo) {
        PersonDao personDao = new PersonDao();
        personDao.insert(personTo);
    }

    public void modifyPerson(PersonTo personTo) {
        PersonDao personDao = new PersonDao();
        personDao.update(personTo);
    }

    public void removePerson(long id) {
        PersonDao personDao = new PersonDao();
        personDao.delete(id);
    }

    public PersonTo showPerson(long id) {
        PersonDao personDao = new PersonDao();
        return personDao.select(id);
    }

    public List<PersonTo> showAllPersons() {
        PersonDao personDao = new PersonDao();
        return personDao.select();
    }
}
