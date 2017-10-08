package ir.moke.database.jdbc.model.to;

public class PersonTo {
    private long id ;
    private String name ;
    private String family ;

    public PersonTo(long id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
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

    @Override
    public String toString() {
        return "PersonTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
