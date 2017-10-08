package ir.moke.database.jdbc.model.to;

import java.util.List;

public class CarTo {
    private long id ;
    private String name ;
    private List<PersonsCars> personsCars ;

    public CarTo(long id, String name,List<PersonsCars> personsCars) {
        this.id = id;
        this.name = name;
        this.personsCars = personsCars;
    }

    public CarTo() {

    }

    public List<PersonsCars> getPersonsCars() {
        return personsCars;
    }

    public void setPersonsCars(List<PersonsCars> personsCars) {
        this.personsCars = personsCars;
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
                ", personsCars=" + personsCars +
                '}';
    }
}
