package main.computer.laptop;

import main.user.User;

import java.util.List;

public class Macbook extends Laptop {

    private String vender = "apple";
    private Integer display = 11;
    private Double weight = 1.5;

    public Macbook (String vender, String laptopId, String model){
        super(vender, laptopId, model);
    }

}
