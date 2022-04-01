package main;

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

        System.out.println("제조번호 : ");
        String laptopId = scanner.next();

        System.out.println("모델명 : ");
        String model = scanner.next();

        for(Map.Entry<Laptop, User> set : allRegisteredLaptopList.entrySet()){
            if (set.getKey().getLaptopId().equals(laptopId)){
                System.out.println("이미 다른 사용자에게 등록된 랩탑입니다. 제조번호를 확인해주세요.");
                return null;
            }
        }
        if (model.equals("macbook air") || model.equals("macbook pro")){
            Macbook macbook = new Macbook(laptopId, model);
            return macbook;
        }else{
            DellNotebook dellNotebook = new DellNotebook(laptopId, model);
            return dellNotebook;
        }
    }

    public static void main(String[] args) throws IOException {
        List<User> allRegisteredUserList = new ArrayList<>(); // 등록한 User 정보
        List<Laptop> allLaptopList = new ArrayList<>(); // 전체 노트북 리스트 (dell, macbook)
        HashMap<Laptop, User> allRegisteredLaptopList = new HashMap<>(); // 등록된 노트북 : laptop ID, 유저 정보
        User currentUser = null; // 현재 접속 중인 사용자 (초기화 값은 null)
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
                    }else{
                        currentUser.showRegisteredUserInfo();
                        break;
                    }
                case 4: // 사용자 노트북 등록
                    if (currentUser == null){ // condition currentUser.equals(null) always false
                        System.out.println("노트북 등록 전, 로그인을 먼저 수행해주세요.");
                        break;
                    }

                    if (currentUser.getLaptopList().isEmpty()){

                        Laptop notebook = registerLaptop(scanner, allRegisteredLaptopList);

                        allRegisteredLaptopList.put(notebook, currentUser);
                        currentUser.getLaptopList().add(notebook);
                    }else{
                        System.out.println("이미 등록된 노트북이 존재합니다.");
                    }
                    break;

                case 5: // 다른 사용자에게 노트북 양도하기

                    break;
                case 6: // 랩탑 실행

                    break;
                case 7: // 랩탑 종료

                    break;
                case 8: // 랩탑 시스템 정보 출력

                    break;
                case 9: // 랩탑 시스템 사용량 출력

                    break;
                case 10: // 랩탑에 설치된 애플리케이션 조회

                    break;
                case 11: // 신규 애플리케이션 설치

                    break;
                case 12: // 애플리케이션 실행

                    break;
                case 13: // 애플리케이션 종료

                    break;
                case 14: // 애플리케이션 삭제

                    break;
                case -1: // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    onOff = false;
                    break;

                default:
                    System.out.println("입력하신 명령 값이 존재하지 않습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}