package main.user;

import main.computer.laptop.Laptop;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private Integer userId ;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String password;
    private List<Laptop> laptopList = new ArrayList<>();

    public User (String userName, Integer userId, String address, String phoneNumber, String birthDate, String password) { // 생성자 초기화
        this.userName = userName;
        this.userId = userId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.password = password;
    }

    public String getUserName() {return userName;}

    public Integer getUserId() {return userId;}

    public String getPassword() {return password;}

    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setLaptopList(Laptop laptop) {
        laptopList.add(laptop);
    }

    public void showRegisteredUserInfo (){
        System.out.println("======== 생성된 유저 정보는 다음과 같습니다 ==========");
        System.out.println("생성된 유저의 이름은 " + userName + "이며, 아이디는 " + userId + "입니다. \n" +
                "그 외 기타 사용자 정보는 다음과 같습니다. \n" + "주소 : " + address + "\n" + "전화번호 : " + phoneNumber + "\n" +
                "생년월일 : " + birthDate + "\n");
    }

    public void registerMyLaptop(Laptop laptop){
        if (laptopList.contains(laptop)){
            System.out.println("이미 소유하고 있는 랩탑입니다.");
        }else{
            laptopList.add(laptop);
            System.out.println(userName + "님의 랩탑으로 등록되었습니다.");
        }
    }

    public void handOverLaptop(Laptop laptop){
        laptopList.remove(laptop);
        laptop.initializeRegisteredUser(userId, password);
    }
}
