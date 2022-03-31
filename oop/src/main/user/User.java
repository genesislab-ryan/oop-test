package main.user;

import java.util.List;

public class User {

    private String userName;
    private Long userId;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String password;
    private List<String> LaptopList;

    public User (String userName, Long userId, String address, String phoneNumber, String birthDate, String password, List<String> laptopList) { // 생성자 초기화
        this.userName = userName;
        this.userId = userId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.password = password;
        this.LaptopList = laptopList;
    }

    public void showUserInfo (){
        System.out.println("생성된 유저의 이름은 " + userName + "이며, 아이디는 " + userId + "입니다. \n" +
                "그 외 기타 사용자 정보는 다음과 같습니다. \n" + "주소 : " + address + "\n" + "전화번호 : " + phoneNumber + "\n" +
                "생년월일 : " + birthDate + "\n" + "랩탑 목록 : " + LaptopList + "\n");
    }
}
