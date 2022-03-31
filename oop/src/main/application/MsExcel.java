package main.application;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Macbook;

import java.util.List;

public class MsExcel implements Application{

    private Integer applicationId;
    private String marketPlace;
    private Integer cpuUsage;
    private Integer ramUsage;
    private Integer diskUsage;
    private List<Macbook> applicationInstalledMacbook;
    private List<DellNotebook> applicationInstalledDellNotebook;

    public void showApplicationInfo(){

    }
}
