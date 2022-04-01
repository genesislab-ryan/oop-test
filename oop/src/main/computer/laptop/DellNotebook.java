package main.computer.laptop;

import main.user.User;

import java.util.List;

public class DellNotebook implements Laptop {
    private Integer display = 13;
    private String vender = "dell";
    private String laptopId;
    private String model;
    private Integer cpu;
    private Integer ram;
    private Integer disk;
    List<Integer> applicationIdList;
    private Integer runningApplicationId;
    private boolean systemStart;
    private double weight = 1.8;
    private User registeredUser;

    public DellNotebook(String laptopId, String model){
        this.laptopId = laptopId;
        this.model = model;
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
    public void showSystemUsage() {
        System.out.println("========== 시스템 사용량 정보 ==========");
        System.out.println("CPU 사용량 : " + cpu + "\nRAM 사용량 : " + ram + "\nDisk 사용량 : " + disk);
        System.out.println("====================================");
    };

    @Override
    public void initializeRegisteredUser(String userId, String password){
        if (registeredUser.getUserId() == userId && registeredUser.getPassword() == password){
            registeredUser = new User(null, null, null, null, null, null);
            System.out.println("노트북의 계정 정보가 초기화되었습니다.");
        }else{
            System.out.println("입력한 유저 정보와 노트북에 등록된 계정 정보와 일치하지 않습니다. 다시 시도해주세요.");
        }

    };

    public void setModelSpec(Integer cpu, Integer ram, Integer disk){
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
    }

    public User setRegisteredUser (User user){
        registeredUser = user;
        return registeredUser;
    }

    @Override
    public List<Integer> installApplication(Integer applicationId){
        applicationIdList.add(applicationId);
        return applicationIdList;
    };

    @Override
    public void deleteApplication(Integer applicationId) {

        if (!applicationIdList.contains(applicationId)){
            System.out.println("해당 애플리케이션은 현재 설치되어 있지 않습니다.");
        }else{
            applicationIdList.remove(applicationId);
            System.out.println("애플리케이션이 삭제되었습니다.");
            //TODO: 디스크 용량 회복시키는 코드 추가하기
        }

    };

    @Override
    public void runApplication(Integer applicationId) {
        if (!applicationIdList.contains(applicationId)){
            System.out.println("애플리케이션이 현재 설치되어 있지 않습니다. 애플리케이션을 설치 후, 실행합니다");
            applicationIdList.add(applicationId);
            runningApplicationId = applicationId;
        }
        if (runningApplicationId !=0) {
            System.out.println("현재 사용 중인 애플리케이션을 종료하고, 새로운 애플리케이션을 실행합니다.");
            runningApplicationId = applicationId;
            //TODO: 리소스 사용량 차감하는 로직 추가할 것
        }else{
            System.out.println("애플리케이션을 실행합니다.");
            runningApplicationId = applicationId;
            //TODO: 리소스 사용량 차감하는 로직 추가할 것
        }
    };

    @Override
    public void exitApplication(Integer applicationId) {
        if (runningApplicationId == 0){
            System.out.println("실행 중인 애플리케이션이 존재하지 않습니다.");
        }else{
            runningApplicationId = 0;
            System.out.println("애플리케이션을 종료합니다.");
            //TODO: cpu, ram 용량 회복시키는 코드 추가하기
        }
    };
}
