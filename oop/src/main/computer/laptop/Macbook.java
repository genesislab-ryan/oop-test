package main.computer.laptop;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.List;

public class Macbook implements Laptop {

    private Integer display = 13;
    private String vender = "apple";
    private String model;
    private Integer cpu;
    private Integer ram;
    private Integer disk;
    List<Integer> applicationIdList;
    private Integer runningApplication;
    private boolean systemStart;
    private Double weight = 1.5;

    public Macbook(){

    }

    @Override
    public Boolean systemStart(String userId, String password){
        systemStart = true;

        return systemStart;
    }

    @Override
    public void systemOff() {
        systemStart = false;
        System.out.println("노트북이 종료되었습니다.");
    };

    @Override
    public void showLaptopInfo() {

        String runningState = systemStart == true ? "실행" : "종료";
        System.out.println("========== 노트북 정보 ==========");
        System.out.println("제조사 : " + vender + "\n모델명 : " + model + "\n디스플레이 : " + display
                + "\n무게 : " + weight + "Kg" + "\n랩탑 실행 여부 : " + runningState);
        System.out.println("====================================");
    };

    @Override
    public List<Integer> installApplication(Integer applicationId){

    };

    @Override
    public void deleteApplication(Integer applicationId) {

    };

    @Override
    public void runApplication(Integer applicationId) {

    };

    @Override
    public void exitApplication(Integer applicationId) {

    };

    @Override
    public void showSystemUsage() {
        System.out.println("========== 시스템 사용량 정보 ==========");
        System.out.println("CPU 사용량 : " + cpu + "\nRAM 사용량 : " + ram + "\nDisk 사용량 : " + disk);
        System.out.println("====================================");
    };

    @Override
    public void InitializeRegisteredUser(String userId, String password){

    };

}
