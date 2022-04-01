package main.computer.laptop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MacbookTest extends Laptop {

    private String vender = "apple";
    private Integer display = 11;
    private Double weight = 1.5;

    public MacbookTest (String laptopId, String model){
        super(laptopId, model);
    }
}
