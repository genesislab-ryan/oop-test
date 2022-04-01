package main.application;

public class MsExcel extends ApplicationInfo {

    private Integer applicationId = 1;
    private Integer cpuUsage = 1;
    private Integer ramUsage = 3;
    private Integer diskUsage = 20;
    private String applicationName = "Ms Excel";


    public MsExcel(Integer applicationId, String applicationName, String marketPlace){
        super(applicationId, applicationName, marketPlace);
    }

    @Override
    public void showApplicationInfo(){
        System.out.println("=================애플리케이션은 정보=============");
        System.out.println("애플리케이션 이름 : " + applicationName + "\n애플리케이션 ID : "
                + applicationId + "\nCPU 사용량 : " + cpuUsage + "\nRAM 사용량 : " + ramUsage + "Disk 사용량 : "  + diskUsage);
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
}
