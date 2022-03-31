package main.user;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Macbook;

import java.util.List;

public class User {

    private String userName;
    private String userId;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String password;
    private List<String> laptopIdList;

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
        return laptopIdList;
    }

    public void setLaptopIdList(List<String> laptopIdList) {
        laptopIdList = laptopIdList;
    }

    public void showRegisteredUserInfo (){
        System.out.println("======== 생성된 유저 정보는 다음과 같습니다 ==========");
        System.out.println("생성된 유저의 이름은 " + userName + "이며, 아이디는 " + userId + "입니다. \n" +
                "그 외 기타 사용자 정보는 다음과 같습니다. \n" + "주소 : " + address + "\n" + "전화번호 : " + phoneNumber + "\n" +
                "생년월일 : " + birthDate + "\n");
    }

    public void registerMyLaptop(String laptopId){
        if (laptopIdList.contains(laptopId)){
            System.out.println("이미 소유하고 있는 랩탑입니다.");
        }else{
            laptopIdList.add(laptopId);
            System.out.println(userName + "님의 랩탑으로 등록되었습니다.");
        }
    }

    public void handOverLaptop(String laptopId, Macbook macbook){
        laptopIdList.remove(laptopId);
        macbook.initializeRegisteredUser(userId, password);
    }

    public void handOverLaptop(String laptopId, DellNotebook dellNotebook){
        laptopIdList.remove(laptopId);
        dellNotebook.initializeRegisteredUser(userId, password);
    }
}
