package main.computer.laptop;

import java.util.List;

public abstract class DellNotebook implements Laptop {
    private Integer display;
    private String vender = "dell";
    private String Model;
    private Integer cpu;
    private Integer ram;
    private Integer disk;
    List<Integer> applicationIdList;
    private Integer runningApplication;
    private boolean systemStart;
    private Integer weight;
}
