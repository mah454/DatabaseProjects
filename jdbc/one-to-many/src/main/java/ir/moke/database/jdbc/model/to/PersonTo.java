package ir.moke.database.jdbc.model.to;

import java.util.List;

public class PersonTo {
    private long id ;
    private String name ;
    private String family ;
    private List<CarTo> carToList ;

    public PersonTo(long id, String name, String family,List<CarTo> carToList) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.carToList =  carToList ;
    }

    public PersonTo() {

    }

    public List<CarTo> getCarToList() {
        return carToList;
    }

    public void setCarToList(List<CarTo> carToList) {
        this.carToList = carToList;
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
                ", carToList=" + carToList +
                '}';
    }
}
