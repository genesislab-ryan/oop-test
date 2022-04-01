package main.computer.laptop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DellNotebookTest extends Laptop {

    private Integer display = 13;
    private String vender = "dell";
    private double weight = 1.8;

    public DellNotebookTest (String laptopId, String model){
        super(laptopId, model);
    }
}
