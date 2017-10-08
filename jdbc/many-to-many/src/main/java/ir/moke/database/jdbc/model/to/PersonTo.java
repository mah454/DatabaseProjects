package ir.moke.database.jdbc.model.to;

import java.util.List;

public class PersonTo {
    private long id;
    private String name;
    private String family;
    private List<PersonsCars> personsCars;

    public PersonTo(long id, String name, String family, List<PersonsCars> personsCars) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.personsCars = personsCars;
    }

    public PersonTo() {

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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<PersonsCars> getPersonsCars() {
        return personsCars;
    }

    public void setPersonsCars(List<PersonsCars> personsCars) {
        this.personsCars = personsCars;
    }

    @Override
    public String toString() {
        return "PersonTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", personsCars=" + personsCars +
                '}';
    }
}
