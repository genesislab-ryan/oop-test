package main.application;

import main.computer.laptop.Laptop;

import java.util.List;

public abstract class ApplicationInfo implements Application{

    private Integer applicationId;
    private String applicationName;
    private String marketPlace;
    private Integer cpuUsage;
    private Integer ramUsage;
    private Integer diskUsage;
    private List<Laptop> applicationInstalledLaptop;

    public ApplicationInfo(Integer applicationId, String applicationName, String marketPlace){
        this.applicationId = applicationId;
        this.applicationName = applicationName;
        this.marketPlace = marketPlace;
    }

    public Integer getCpuUsage() {
        return cpuUsage;
    }

    public Integer getDiskUsage() {
        return diskUsage;
    }

    public Integer getRamUsage() {
        return ramUsage;
    }

    public List<Laptop> getApplicationInstalledLaptop() {
        return applicationInstalledLaptop;
    }
}
