package ir.moke.database.jdbc.model.to;

public class CarTo {
    private long id ;
    private String name ;

    public CarTo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CarTo() {

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
                '}';
    }
}
