package main;

import main.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ObjectOrientationProgramming {

    public static void main(String[] args) throws IOException {
        List<User> allRegisteredUserList = new ArrayList<>(); // 등록한 User 정보
        List<Object> allLaptopList = new ArrayList<>(); // 전체 노트북 리스트 (dell, macbook)
        HashMap<String, User> allRegisteredLaptopList = new HashMap<>(); // 등록된 노트북 : laptop ID, 유저 정보
        User currentUser = new User(null, null, null, null, null, null, new ArrayList<>());; // 현재 접속 중인 사용자 (초기화 값은 null)
        Boolean onOff = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("oop test 프로그램입니다.");
        while (onOff){
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

            String number = scanner.next();
            switch (number){
                case "1": // 사용자 객체 정보 입력
                    System.out.println("사용자 정보를 입력해주세요.");

                    System.out.println("이름 : ");
                    String userName = scanner.next();

                    System.out.println("ID : ");
                    String userId = scanner.next();

                    System.out.println("주소 : ");
                    String address = scanner.next();

                    System.out.println("전화번호 : ");
                    String phoneNumber = scanner.next();

                    System.out.println("생년월일 : ");
                    String birthDate = scanner.next();

                    System.out.println("비밀번호 : ");
                    String password = scanner.next();

                    User user = new User(userName, userId, address, phoneNumber, birthDate, password);
                    currentUser = user;
                    allRegisteredUserList.add(user);
                    user.showRegisteredUserInfo();
                    break;
                case "2": // 기존 사용자로 접속
                    while (true){
                        if (allRegisteredUserList.isEmpty()){
                            System.out.println("등록되어 있는 유저가 존재하지 않습니다.");
                            break;
                        }

                        System.out.println("ID를 입력해주세요 : ");
                        String id = scanner.next();

                        System.out.println("비밀번호를 입력해주세요 : ");
                        String userPassword = scanner.next();

                        for (User registeredUser : allRegisteredUserList){
                            if (registeredUser.getUserId() == id && registeredUser.getPassword() == userPassword){

                                System.out.println("환영합니다! " + registeredUser.getUserName() + "님!");
                                currentUser = registeredUser;
                                break;
                            }else{
                                System.out.println("일치하는 유저 정보가 존재하지 않습니다.");
                            }
                        }
                        break;
                    }
                case "3": // 사용자 정보 조회
                    if (currentUser.getUserId() == null){
                        System.out.println("로그인을 먼저 해주세요.");
                        break;
                    }else{
                        currentUser.showRegisteredUserInfo();
                        break;
                    }
                case "4": // 사용자 노트북 등록

                    if (currentUser.getUserId() == null){
                        System.out.println("노트북 등록 전, 로그인을 먼저 수행해주세요.");
                        break;
                    }

                    if (currentUser.getLaptopIdList() == null){
                        System.out.println("사용자의 노트북을 등록합니다. 노트북의 제조 번호를 입력해주세요.");

                        System.out.println("제조번호 : ");
                        String laptopId = scanner.next();
                        if (allRegisteredLaptopList.containsKey(laptopId)){
                            System.out.println("이미 다른 사용자에게 등록된 랩탑입니다. 제조번호를 확인해주세요. ");
                        }else{
                            System.out.println("노트북이 성공적으로 등록되었습니다. ");
                            allRegisteredLaptopList.put(laptopId, currentUser);
                            currentUser.getLaptopIdList().add(laptopId);
                        }
                    }else{
                        System.out.println("이미 등록된 노트북이 존재합니다.");
                    }
                    break;
                case "5": // 다른 사용자에게 노트북 양도하기

                    break;
                case "-1": // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    onOff = false;
                    break;
            }
        }
    }
}