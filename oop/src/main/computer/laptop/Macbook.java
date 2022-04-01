package main.computer.laptop;

import main.user.User;

import java.util.List;

public class Macbook extends Laptop {

    private String vender = "apple";
    private Integer display = 11;
    private Double weight = 1.5;

    public Macbook (String laptopId, String model){
        super(laptopId, model);
    }

    public String getVender() {
        return vender;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }
}
