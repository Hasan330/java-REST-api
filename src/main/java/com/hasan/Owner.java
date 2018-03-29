package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private  int age;

    @OneToMany
    @JoinColumn(name = "CAR_OWNER_ID", referencedColumnName = "id")
    private List<Car> cars = new ArrayList<>();


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

    public void setId(int id) {
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

    public void addCar(Car car){
        System.out.println("Adding car " + car.getBrand() + " " +  car.getModel() );
        this.cars.add(car);
    }

    public void printCars(){
        System.out.println("\n"+this.getName() + " has an id: " + this.getId() + " and owns the following cars:");
        this.getCars().forEach(x -> System.out.println(x.getBrand() + " " +  x.getModel()));
    }

    public void printTotalPayment(){
        //get all cars owned by that user
        List<Car> temp = new ArrayList<>();
        temp = this.getCars();

        //add all payments from those cars
        int totalUserPayment = 0;
        for(int i=0; i < temp.size(); i++){
            totalUserPayment += temp.get(i).getTotalCost();
        }

        //Print Outcome
        System.out.println("\nTotal money paid by " + this.getName() + " on all cars is: " + totalUserPayment);
    }
}
