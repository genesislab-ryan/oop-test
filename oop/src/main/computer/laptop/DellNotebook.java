package main.computer.laptop;

public class DellNotebook extends Laptop {

    private Integer display = 13;
    private String vendor = "dell";
    private double weight = 1.8;

    public DellNotebook (String vendor, String laptopId, String model){
        super(vendor, laptopId, model);
    }

}
