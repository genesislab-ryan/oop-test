package main.user;

import java.util.List;

public class User {

    private String userName;
    private String userId;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String password;
    private List<String> LaptopIdList;

    public User (String userName, String userId, String address, String phoneNumber, String birthDate, String password) { // 생성자 초기화
        this.userName = userName;
        this.userId = userId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.password = password;
    }
    public String getUserName() {return userName;}

    public String getUserId() {return userId;}

    public String getPassword() {return password;}

    public List<String> getLaptopIdList() {
        return LaptopIdList;
    }

    public void setLaptopIdList(List<String> laptopIdList) {
        LaptopIdList = laptopIdList;
    }

    public void showRegisteredUserInfo (){
        System.out.println("======== 생성된 유저 정보는 다음과 같습니다 ==========");
        System.out.println("생성된 유저의 이름은 " + userName + "이며, 아이디는 " + userId + "입니다. \n" +
                "그 외 기타 사용자 정보는 다음과 같습니다. \n" + "주소 : " + address + "\n" + "전화번호 : " + phoneNumber + "\n" +
                "생년월일 : " + birthDate + "\n");
    }
}
