package com.hasan;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @Column(name="OWNER_ID")
    private long id;

    @Column(name="name")
    private String name;

    @OneToMany
    @JoinColumn(name = "CAR_OWNER_ID", referencedColumnName = "OWNER_ID")
    private List<Car> cars;

    public Owner(long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
