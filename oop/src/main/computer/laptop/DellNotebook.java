package main.computer.laptop;

public class DellNotebook extends Laptop {

    private Integer display = 13;
    private String vender = "dell";
    private double weight = 1.8;

    public DellNotebook (String laptopId, String model){
        super(laptopId, model);
    }

}
