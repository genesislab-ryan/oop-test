package main.application;

import main.computer.laptop.Laptop;

import java.util.List;


public class MsExcelTest implements Application {

    private Integer applicationId;
    private String marketPlace;
    private Integer cpuUsage;
    private Integer ramUsage;
    private Integer diskUsage;
    private List<Laptop> applicationInstalledLaptop;

    @Override
    public void showApplicationInfo(){

    }

    @Override
    public void exitApplicationFromLaptop(Laptop laptop){

    };

    @Override
    public void deleteApplicationFromLaptop(Laptop laptop){

    };

    @Override
    public void runApplicationFromLaptop(Laptop laptop){

    };
}
