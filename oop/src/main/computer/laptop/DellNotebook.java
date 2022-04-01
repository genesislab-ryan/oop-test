package main.computer.laptop;

public class DellNotebook extends Laptop {

    private Integer display = 13;
    private String vender = "dell";
    private double weight = 1.8;

    public DellNotebook (String laptopId, String model){
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
