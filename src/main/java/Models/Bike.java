package Models;

import java.io.Serializable;
import java.util.Objects;

public class Bike implements Serializable {
    private String name;
    private String color;

    private String year;

    public Bike(){

    }



    public Bike(String name, String color, String year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Bike setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Bike setColor(String color) {
        this.color = color;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Bike setYear(String year) {
        this.year = year;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return name.equals(bike.name) && color.equals(bike.color) && year.equals(bike.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, year);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}






