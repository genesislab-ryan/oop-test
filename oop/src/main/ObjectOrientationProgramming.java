package main;

import main.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectOrientationProgramming {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        System.out.println("oop test 툴입니다.");

        System.out.println("사용자 정보를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
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

        user.showRegisteredUserInfo();
    }
}
