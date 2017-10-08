package ir.moke.database.jdbc.model.to;

public class PersonsCars {
    private long personId;
    private long carId;
    private long id;

    public PersonsCars() {
    }

    public PersonsCars(long id, long personId, long carId) {
        this.id = id;
        this.personId = personId;
        this.carId = carId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
