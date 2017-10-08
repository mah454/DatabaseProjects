package ir.moke.database.jdbc.model.to;

public class CarTo {
    private long id ;
    private String name ;
    private PersonTo personTo ;

    public CarTo(long id, String name , PersonTo personTo) {
        this.id = id;
        this.name = name;
        this.personTo = personTo ;
    }

    public CarTo() {

    }

    public PersonTo getPersonTo() {
        return personTo;
    }

    public void setPersonTo(PersonTo personTo) {
        this.personTo = personTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personTo=" + personTo +
                '}';
    }
}
