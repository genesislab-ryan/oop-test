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
    private Boolean applicationSystemOnOff;
    private List<Laptop> applicationInstalledLaptop;

    public ApplicationInfo(Integer applicationId, String applicationName, String marketPlace){
        this.applicationId = applicationId;
        this.applicationName = applicationName;
        this.marketPlace = marketPlace;
    }

    @Override
    public void showApplicationInfo(){
        System.out.println("=================애플리케이션은 정보=============");
        System.out.println("애플리케이션 이름 : " + applicationName + "\n애플리케이션 ID : "
                + applicationId + "\nCPU 사용량 : " + cpuUsage + "\nRAM 사용량 : " + ramUsage + "\nDisk 사용량 : "  + diskUsage);
        System.out.println("============================================");
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

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationCapacity(Integer cpu, Integer ram, Integer disk){
        this.cpuUsage = cpu;
        this.ramUsage = ram;
        this.diskUsage = disk;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public String getMarketPlace() {
        return marketPlace;
    }

    public List<Laptop> getApplicationInstalledLaptop() {
        return applicationInstalledLaptop;
    }

    public Boolean applicationOnOffCheck(Boolean systemOnOff){
        if (systemOnOff.equals(true)){
            applicationSystemOnOff = true;

        }
        else{
            applicationSystemOnOff = false;
            System.out.println("랩탑을 먼저 실행해주세요.");
        }

        return applicationSystemOnOff;
    }

}
