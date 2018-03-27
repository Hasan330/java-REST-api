package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners3")
public class Owner {

    @Id
    @Column(name="OWNER_ID")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private long id;

    @Column(name="name")
    private String name;

    @OneToMany
    @JoinColumn(name = "CAR_OWNER_ID", referencedColumnName = "OWNER_ID")
//    private List<Car> cars;
    private List<Car> cars = new ArrayList<>();

    @Column(name = "age")
    private  int age;

    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        cars.forEach( car -> System.out.println("Setting cars to " + car.getBrand() + " " + car.getModel()));
        this.cars = cars;
    }

    public void addCar(Car cars){
        System.out.println("Adding car " + cars.getBrand() + " " +  cars.getModel() );
        this.cars.add(cars);
    }
}
