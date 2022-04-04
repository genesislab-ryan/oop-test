package main.computer.laptop;

import main.application.ApplicationInfo;
import main.user.User;

import java.util.ArrayList;
import java.util.List;

public abstract class Laptop implements Portable {

    private String vendor;
    private Double weight = 1.5;
    private Integer display = 11;
    private String laptopId;
    private String model;
    private Integer cpu;
    private Integer ram;
    private Integer disk;
    List<ApplicationInfo> applicationList = new ArrayList<>();
    private ApplicationInfo runningApplication;
    private Boolean systemOnOff;
    private User registeredUser;

    public Laptop(String vendor, String laptopId, String model){
        this.vendor = vendor;
        this.laptopId = laptopId;
        this.model = model;
    }

    @Override
    public Boolean systemStart(Integer userId, String password){
        if (registeredUser.getUserId().equals(userId) && registeredUser.getPassword().equals(password)){
            systemOnOff = true;
            System.out.println("환영합니다. " + registeredUser.getUserName() + "님!");
        } else{
            System.out.println("입력하신 계정 정보가 일치하지 않습니다. 다시 시도해주세요");
        }
        return systemOnOff;
    }

    @Override
    public void systemOff() {
        systemOnOff = false;
        System.out.println("노트북이 종료되었습니다.");
    };

    @Override
    public void showLaptopInfo() {

        String runningState = systemOnOff == true ? "실행" : "종료";
        System.out.println("========== 노트북 정보 ==========");
        System.out.println("제조사 : " + vendor + "\n모델명 : " + model + "\n디스플레이 : " + display
                + "\n무게 : " + weight + "Kg" + "\n랩탑 실행 여부 : " + runningState);
        System.out.println("====================================");
    };

    @Override
    public void showSystemUsage() {
        System.out.println("========== 시스템 사용량 정보 ==========");
        System.out.println("CPU 사용량 : " + cpu + "\nRAM 사용량 : " + ram + "\nDisk 사용량 : " + disk);
        System.out.println("====================================");
    };

    @Override
    public void initializeRegisteredUser(Integer userId, String password){
        if (registeredUser.getUserId().equals(userId) && registeredUser.getPassword().equals(password)){
            registeredUser = null;
            System.out.println("노트북의 계정 정보가 초기화되었습니다.");
        }else{
            System.out.println("입력한 유저 정보와 노트북에 등록된 계정 정보와 일치하지 않습니다. 다시 시도해주세요.");
        }

    };

    @Override
    public List<ApplicationInfo> installApplication(ApplicationInfo application){
        applicationList.add(application);

        if (this.disk - application.getDiskUsage() < 0){
            System.out.println("Disk 용량이 부족하여 애플리케이션을 설치할 수 없습니다. ");
        }else{
            this.disk -= application.getDiskUsage();
            System.out.println("애플리케이션이 설치되었습니다.");
        }

        return applicationList;
    };

    @Override
    public void deleteApplication(ApplicationInfo application) {

        if (!applicationList.contains(application)){
            System.out.println("해당 애플리케이션은 현재 설치되어 있지 않습니다.");
        }else{
            applicationList.remove(application);
            this.disk += application.getDiskUsage();
            System.out.println("애플리케이션이 삭제되었습니다.");
        }

    };

    @Override
    public void exitApplication(ApplicationInfo application) {
        if (runningApplication == null || application == null){
            System.out.println("실행 중인 애플리케이션이 존재하지 않습니다.");
        }else{
            runningApplication = null;
            this.ram += application.getRamUsage();
            this.cpu += application.getCpuUsage();
            System.out.println("애플리케이션을 종료합니다.");
        }
    };

    @Override
    public void runApplication(ApplicationInfo application) {
        if (!applicationList.contains(application)){
            System.out.println("애플리케이션이 현재 설치되어 있지 않습니다. 애플리케이션을 설치 후, 실행합니다");
            installApplication(application);
            this.ram -= application.getRamUsage();
            this.cpu -= application.getCpuUsage();
            runningApplication = application;

        }else if (runningApplication != null) {
            System.out.println("현재 사용 중인 애플리케이션을 종료하고, 새로운 애플리케이션을 실행합니다.");
            exitApplication(application);
            this.ram -= application.getRamUsage();
            this.cpu -= application.getCpuUsage();
            runningApplication = application;

        }else{
            System.out.println("애플리케이션을 실행합니다.");
            this.ram -= application.getRamUsage();
            this.cpu -= application.getCpuUsage();
            runningApplication = application;
        }

    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    @Override
    public User setRegisteredUser (User user){
        registeredUser = user;
        System.out.println("유저 정보가 성공적으로 등록되었습니다.");
        return registeredUser;
    }

    @Override
    public void setModelSpec(Integer cpu, Integer ram, Integer disk){
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public String getModel() {
        return model;
    }

    public Boolean getSystemOnOff(){
        return systemOnOff;
    }

    public List<ApplicationInfo> getApplicationList() {
        return applicationList;
    }

    public String getVendor() {
        return vendor;
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

    public ApplicationInfo getRunningApplication() {
        return runningApplication;
    }

    public void setRunningApplication(ApplicationInfo runningApplication) {
        this.runningApplication = runningApplication;
    }

    public Integer getCpu() {
        return cpu;
    }

    public Integer getDisk() {
        return disk;
    }

    public Integer getRam() { return ram;}

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public void setDisk(Integer disk) {
        this.disk = disk;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }
}
