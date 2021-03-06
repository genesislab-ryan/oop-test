package main;

import main.application.Application;
import main.application.ApplicationInfo;
import main.computer.laptop.DellNotebook;
import main.computer.laptop.Laptop;
import main.computer.laptop.Macbook;
import main.user.User;

import java.io.IOException;
import java.util.*;

public class ObjectOrientationProgramming {

    public static void messageInfo() {
        System.out.println("수행할 기능을 선택해주세요.");
        System.out.println("1 : 사용자 객체 정보 입력");
        System.out.println("2 : 기존 사용자로 접속");
        System.out.println("3 : 사용자 정보 조회");
        System.out.println("4 : 사용자 노트북 등록");
        System.out.println("5 : 사용자 노트북 양도");
        System.out.println("6 : 랩탑 실행");
        System.out.println("7 : 랩탑 종료");
        System.out.println("8 : 랩탑 시스템 정보 출력");
        System.out.println("9 : 랩탑 시스템 사용량 출력");
        System.out.println("10 : 랩탑에 설치된 애플리케이션 조회");
        System.out.println("11 : 신규 애플리케이션 설치");
        System.out.println("12 : 애플리케이션 실행");
        System.out.println("13 : 애플리케이션 종료");
        System.out.println("14 : 애플리케이션 삭제");
        System.out.println("-1 : 프로그램 종료");
    }

    public static User registerUserInfo(Scanner scanner, Integer userId){
        System.out.println("사용자 정보를 입력해주세요.");

        System.out.println("이름 : ");
        String userName = scanner.next();

        System.out.println("주소 : ");
        String address = scanner.next();

        System.out.println("전화번호 : ");
        String phoneNumber = scanner.next();

        System.out.println("생년월일 : ");
        String birthDate = scanner.next();

        System.out.println("비밀번호 : ");
        String password = scanner.next();

        User user = new User(userName, userId, address, phoneNumber, birthDate, password);

        return user;
    }

    public static User login (Scanner scanner, List<User> allRegisteredUserList){
        System.out.println("ID를 입력해주세요 : ");
        Integer id = scanner.nextInt();

        System.out.println("비밀번호를 입력해주세요 : ");
        String userPassword = scanner.next();

        for (User registeredUser : allRegisteredUserList){
            if (registeredUser.getUserId().equals(id) && registeredUser.getPassword().equals(userPassword)){

                System.out.println("환영합니다! " + registeredUser.getUserName() + "님!");
                return registeredUser;
            }else{
                System.out.println("일치하는 유저 정보가 존재하지 않습니다.");
            }
        }
        return null;
    }

    public static Laptop registerLaptop(Scanner scanner, HashMap<Laptop, User> allRegisteredLaptopList){
        System.out.println("사용자의 노트북을 등록합니다. 노트북의 제조 번호를 입력해주세요.");

        scanner.nextLine();

        System.out.println("제조번호 : ");
        String laptopId = scanner.nextLine();

        System.out.println("모델명 : ");
        String model = scanner.nextLine();

        for(Map.Entry<Laptop, User> set : allRegisteredLaptopList.entrySet()){
            if (set.getKey().getLaptopId().equals(laptopId)){
                System.out.println("이미 다른 사용자에게 등록된 랩탑입니다. 제조번호를 확인해주세요.");
                return null;
            }
        }

        if ("macbook air".equals(model) || "macbook pro".equals(model)){
            Macbook macbook = new Macbook("apple", laptopId, model);
            return setLaptopModelSpec(scanner, macbook);
        }else{
            DellNotebook dellNotebook = new DellNotebook("dell", laptopId, model);
            return setLaptopModelSpec(scanner, dellNotebook);
        }
    }

    public static Laptop setLaptopModelSpec(Scanner scanner, Laptop laptop){

        if (laptop.getModel().equals("macbook air") || laptop.getModel().equals("XPS")){
            System.out.println("Macbook air & XPS 기본 값은 cpu 4 GB, memory 8 GB, disk 256 GB 입니다.");
            laptop.setModelSpec(4, 8, 256);
        }else if (laptop.getModel().equals("macbook pro") || laptop.getModel().equals("Alienware")){
            System.out.println("Macbook pro & Alienware 기본 값은 cpu 4 GB, memory 16 GB, disk 256 GB 입니다.");
            laptop.setModelSpec(4, 16, 256);
        }

        System.out.println("스펙을 업그레이드 하시겠습니까? Y or N");
        String yesOrNo = scanner.next();
        if (yesOrNo.toLowerCase().equals("y")){
            while (true){
                System.out.println("CPU는 4 or 8 GB만 선택 가능합니다.");
                Integer cpu = scanner.nextInt();
                if (!cpu.equals(4) || !cpu.equals(8)){ // Condition '!cpu.equals(4) || !cpu.equals(8)' is always 'true'
                    System.out.println("CPU 값을 잘못 입력하셨습니댜. 다시 시도해주세요.");
                }

                System.out.println("RAM은 8 or 16 GB만 선택 가능합니다.");
                Integer ram = scanner.nextInt();
                if (!ram.equals(8) || !ram.equals(16)){
                    System.out.println("RAM 값을 잘못 입력하셨습니댜. 다시 시도해주세요.");
                }

                System.out.println("Disk는 256 or 512 GB만 선택 가능합니다.");
                Integer disk = scanner.nextInt();
                if (!disk.equals(256) || !disk.equals(512)){
                    System.out.println("DISK 값을 잘못 입력하셨습니댜. 다시 시도해주세요.");
                }
                laptop.setModelSpec(cpu, ram, disk);
                break;
            }
        }else{
            System.out.println("모델 스펙 업그레이드를 진행하지 않습니다.");
        }

        return laptop;
    }

    public static void handOverLaptop(Scanner scanner,List<User> allRegisteredUserList, User currentUser){
        scanner.nextLine();

        System.out.println("양도할 유저 : ");
        String userName = scanner.nextLine();

        System.out.println("양도할 노트북 모델 : ");
        String userLaptopId = scanner.nextLine();

        for (User handOverUser : allRegisteredUserList){
            if (handOverUser.getUserName().equals(userName)){
                for(Laptop currentUserLaptop : currentUser.getLaptopList()){
                    if (currentUserLaptop.getLaptopId().equals(userLaptopId)){
                        currentUser.handOverLaptop(currentUserLaptop, handOverUser);
                        break;
                    }
                }
            }
        }
    }

    public static Laptop startLaptop(Scanner scanner, User currentUser){
        System.out.println("랩탑을 실행합니다. 제조번호와 모델명을 입력해주세요. ");

        scanner.nextLine();

        System.out.println("제조번호 : ");
        String laptopId = scanner.nextLine();

        System.out.println("모델명 : ");
        String model = scanner.nextLine();

        for (Laptop laptop : currentUser.getLaptopList()){
            if (laptop.getLaptopId().equals(laptopId) && laptop.getModel().equals(model)){
                return laptop;
            }
        }
        return null;
    }

    public static Laptop showCurrentLaptopApplicationList(Laptop currentLaptop){
        if (currentLaptop.getSystemOnOff().equals(false)){
            System.out.println("랩탑이 켜져 있지 않습니다. 먼저 랩탑을 실행해주세요.");
            return null;
        }

        if (currentLaptop.getApplicationList() == null){
            System.out.println("랩탑에 설치되어 있는 애플리케이션이 존재하지 않습니다.");
            return null;
        }

        System.out.println("현재 랩탑에 설치되어 있는 애플리케이션 목록입니다.");
        for (Application application : currentLaptop.getApplicationList()){
            System.out.println(application);
        }
        return null;
    }

    public static ApplicationInfo installNewApplication(Scanner scanner, List<ApplicationInfo> allApplicationList){
        System.out.println("신규 애플리케이션을 설치합니다.");

        System.out.println("애플리케이션 이름 : ");
        String appName = scanner.nextLine();

        for (ApplicationInfo applicationInfo : allApplicationList){
            if (applicationInfo.getApplicationName().equals(appName)){
                return applicationInfo;
            }
        }
        return null;
    }

    public static ApplicationInfo runNewApplication(Scanner scanner, List<ApplicationInfo> allApplicationList){
        System.out.println("애플리케이션을 실행합니다.");

        System.out.println("애플리케이션 이름 : ");
        String runApp = scanner.nextLine();

        for (ApplicationInfo applicationInfo : allApplicationList){
            if (applicationInfo.getApplicationName().equals(runApp)){
                return applicationInfo;
            }
        }
        return null;
    }

    public static ApplicationInfo removeApplication(Scanner scanner, List<ApplicationInfo> allApplicationList){
        scanner.nextLine();

        System.out.println("삭제할 애플리케이션 이름을 입력해주세요. ");

        String applicationName = scanner.nextLine();

        for(ApplicationInfo applicationInfo : allApplicationList){
            if (applicationInfo.getApplicationName().equals(applicationName)){
                return applicationInfo;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        List<User> allRegisteredUserList = new ArrayList<>(); // 등록한 User 정보
        List<Laptop> allLaptopList = new ArrayList<>(); // 전체 노트북 리스트 (dell, macbook)
        List<ApplicationInfo> allApplicationList = new ArrayList<>();
        HashMap<Laptop, User> allRegisteredLaptopList = new HashMap<>(); // 등록된 노트북 : laptop ID, 유저 정보
        User currentUser = null; // 현재 접속 중인 사용자 (초기화 값은 null)
        Laptop currentLaptop = null;
        ApplicationInfo currentApplication = null;
        Integer userIdCount = 0;
        Boolean onOff = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("oop test 프로그램입니다.");
        while (onOff){

            messageInfo();

            Integer number = scanner.nextInt();

            switch (number){
                case 1: // 사용자 객체 정보 입력

                    currentUser = registerUserInfo(scanner, ++userIdCount);
                    allRegisteredUserList.add(currentUser);
                    currentUser.showRegisteredUserInfo();
                    break;

                case 2: // 기존 사용자로 접속

                    while (true){
                        if (allRegisteredUserList.isEmpty()){
                            System.out.println("등록되어 있는 유저가 존재하지 않습니다.");
                            break;
                        }
                        currentUser = login(scanner, allRegisteredUserList);
                        break;
                    }
                    break;

                case 3: // 사용자 정보 조회

                    if (currentUser == null){ // condition currentUser.equals(null) always false
                        System.out.println("로그인을 먼저 해주세요.");
                        break;
                    }

                    currentUser.showRegisteredUserInfo();
                    break;

                case 4: // 사용자 노트북 등록

                    if (currentUser == null){
                        System.out.println("노트북 등록 전, 로그인을 먼저 수행해주세요.");
                        break;
                    }

                    if (currentUser.getLaptopList().isEmpty()){

                        Laptop notebook = registerLaptop(scanner, allRegisteredLaptopList);

                        if (notebook == null) break; // 이미 다른 사용자에게 등록된 랩탑으로 null 을 반환했을 때

                        notebook.setRegisteredUser(currentUser);
                        allRegisteredLaptopList.put(notebook, currentUser);
                        allLaptopList.add(notebook);
                        currentUser.registerMyLaptop(notebook);

                    }else{
                        System.out.println("이미 등록된 노트북이 존재합니다.");
                    }
                    break;

                case 5: // 다른 사용자에게 노트북 양도하기

                    if (currentUser == null){
                        System.out.println("노트북 양도 수행 전, 로그인을 먼저 수행해주세요.");
                        break;
                    }
                    handOverLaptop(scanner, allRegisteredUserList, currentUser);
                    break;

                case 6: // 랩탑 실행

                    if (currentUser == null){
                        System.out.println("노트북 실행 전, 로그인을 먼저 수행해주세요.");
                        break;
                    }
                    currentLaptop = startLaptop(scanner, currentUser);

                    if (currentLaptop == null) break; // 사용자가 실행하고자 하는 랩탑 정보를 적절히 입력하지 못했을 때, switch 문 다시 시작

                    currentLaptop.systemStart(currentUser.getUserId(), currentUser.getPassword());

                    break;

                case 7: // 랩탑 종료

                    if (currentUser == null){
                        System.out.println("현재 접속 중인 사용자 정보가 없어 랩탑을 종료할 수 없습니다.");
                        break;
                    }

                    currentLaptop.systemOff();
                    currentLaptop = null;

                    break;

                case 8: // 랩탑 시스템 정보 출력

                    if (currentUser == null){
                        System.out.println("현재 실행 중인 랩탑이 존재하지 않습니다.");
                        break;
                    }

                    currentLaptop.showLaptopInfo();
                    break;

                case 9: // 랩탑 시스템 사용량 출력

                    if (currentUser == null){
                        System.out.println("현재 실행 중인 랩탑이 존재하지 않습니다.");
                        break;
                    }

                    currentLaptop.showSystemUsage();
                    break;

                case 10: // 랩탑에 설치된 애플리케이션 조회

                    showCurrentLaptopApplicationList(currentLaptop);
                    break;

                case 11: // 신규 애플리케이션 설치

                    if (currentLaptop == null){
                        System.out.println("현재 실행 중인 랩탑이 존재하지 않습니다.");
                        break;
                    }
                    currentLaptop.installApplication(installNewApplication(scanner, allApplicationList));
                    break;

                case 12: // 애플리케이션 실행
                    if (currentLaptop == null){
                        System.out.println("현재 실행 중인 랩탑이 존재하지 않습니다.");
                        break;
                    }
                    currentLaptop.runApplication(runNewApplication(scanner, allApplicationList));
                    break;

                case 13: // 애플리케이션 종료
                    if (currentLaptop == null){
                        System.out.println("실행 중인 랩탑이 없습니다.");
                        break;
                    }

                    currentLaptop.exitApplication(currentApplication);
                    break;

                case 14: // 애플리케이션 삭제
                    if (allApplicationList.isEmpty()){
                        System.out.println("삭제할 애플리케이션이 없습니다.");
                        break;
                    }
                    currentLaptop.deleteApplication(removeApplication(scanner, allApplicationList));
                    break;

                case -1: // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    onOff = false;
                    scanner.close();
                    break;

                default:
                    System.out.println("입력하신 명령 값이 존재하지 않습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}