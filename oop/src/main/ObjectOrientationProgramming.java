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
        HashMap<String, User> allRegisteredLaptopList = new HashMap<>(); // laptop ID, 유저 정보
        User currentUser = new User(null, null, null, null, null, null);; // 현재 접속 중인 사용자 (초기화 값은 null)
        Scanner scanner = new Scanner(System.in);
        System.out.println("oop test 프로그램입니다.");
        while (true){
            if (allRegisteredUserList.isEmpty()){ // 1. 등록된 유저가 존재하지 않을 경우
                System.out.println("생성되어 있는 유저 정보가 존재하지 않습니다. 사용자를 생성하시겠습니까? Y / N");
                String yesOrNo = scanner.next();
                if (yesOrNo.toLowerCase() == "n"){
                    System.out.println("생성된 유저 정보가 없으므로 프로그램을 종료합니다.");
                    break;
                }
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
            }else{ // 2. 이미 등록된 유저가 존재할 경우
                System.out.println("생성되어 있는 유저 정보가 존재합니다. 해당 유저로 접속하시겠습니까? Y / N");
                String yesOrNo = scanner.next();
                if (yesOrNo.toLowerCase() == "y"){
                    while (true){
                        System.out.println("ID를 입력해주세요 : ");
                        String userId = scanner.next();

                        System.out.println("비밀번호를 입력해주세요 : ");
                        String password = scanner.next();

                        for (User registeredUser : allRegisteredUserList){
                            if (registeredUser.getUserId() == userId && registeredUser.getPassword() == password){

                                System.out.println("환영합니다! " + registeredUser.getUserName() + "님!");
                                currentUser = registeredUser;
                                break;
                            }
                        }
                        if (currentUser.getUserId().equals(userId)){
                            break;
                        }
                    }
                }else{ // 3. 유저가 있지만 신규 유저를 생성할 경우
                    System.out.println("신규 유저를 생성합니다.");

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
                    user.showRegisteredUserInfo();
                    allRegisteredUserList.add(user);
                }
            }

            if (currentUser.getLaptopIdList().isEmpty()){
                System.out.println("사용자의 노트북을 등록합니다. 노트북의 제조 번호를 입력해주세요.");

                System.out.println("제조번호 : ");
                String laptopId = scanner.next();
                if (allRegisteredLaptopList.containsKey(laptopId)){
                    System.out.println("이미 다른 사용자에게 등록된 랩탑입니다. 제조번호를 확인해주세요. ");
                }else{
                    System.out.println("노트북이 성공적으로 등록되었습니다. ");
                    allRegisteredLaptopList.put(laptopId, currentUser);
                }


            }

        }


    }
}
