package main.user;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Laptop;
import main.computer.laptop.Macbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

class UserTest {

    String userName = "tester";
    Integer userId = 1;
    String address = "울릉도 동남쪽 뱃길따라 이백리";
    String phoneNumber = "010-1234-5678";
    String birthDate = "1999-12-12";
    String password = "1234";
    Macbook macbook = new Macbook("1a2b3c4d", "macbook air");
    DellNotebook dellNotebook = new DellNotebook("d4c3b2a1", "XPS");
    Integer userIdCount = 0;
    User user = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);

    @Test
    @DisplayName("생성한 유저 정보 가져오기")
    void registeredUserInfoTest() {

        assertEquals(user.getUserName(), "tester");
        assertEquals(user.getUserId(), (Integer)  1);
        assertEquals(user.getAddress(), "울릉도 동남쪽 뱃길따라 이백리");
        assertEquals(user.getBirthDate(), "1999-12-12");
        assertEquals(user.getPassword(), "1234");
    }

    @Test
    @DisplayName("잘못된 유저 정보 입력하기")
    void notRegisteredUserInfoTest(){
        assertNotEquals(user.getUserName(), "test");
        assertNotEquals(user.getUserId(), (Integer) 2);
        assertNotEquals(user.getAddress(), "독도 북서쪽 뱃길따라 이백리");
        assertNotEquals(user.getBirthDate(), "1999-01-01");
        assertNotEquals(user.getPassword(), "4321");
    }

    @Test
    @DisplayName("생성한 유저 정보에 노트북 등록하기")
    void registerMyLaptopTest() {
        User macbookUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        User dellNotebookUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        User allLaptopUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);

        macbookUser.registerMyLaptop(macbook);
        dellNotebookUser.registerMyLaptop(dellNotebook);
        allLaptopUser.registerMyLaptop(macbook);
        allLaptopUser.registerMyLaptop(dellNotebook);

        List<Laptop> macbookList = Arrays.asList(macbook);
        List<Laptop> dellNotebookList = Arrays.asList(dellNotebook);
        List<Laptop> allLaptopList = Arrays.asList(macbook, dellNotebook);

        assertEquals(macbookUser.getLaptopList(), macbookList); // 맥북만 등록되었을 때
        assertEquals(dellNotebookUser.getLaptopList(), dellNotebookList); // 델 노트북만 등록되었을 때
        assertEquals(allLaptopUser.getLaptopList(), allLaptopList); // 모든 종류의 노트북이 다 등록되었을 때

    }

    @Test
    @DisplayName("생성한 유저 정보에 등록안 된 노트북 입력하기")
    void notRegisterMyLaptopTest() {

        User macbookUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        User dellNotebookUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        User allLaptopUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);

        macbookUser.registerMyLaptop(macbook);
        dellNotebookUser.registerMyLaptop(dellNotebook);
        allLaptopUser.registerMyLaptop(macbook);
        allLaptopUser.registerMyLaptop(dellNotebook);

        List<Laptop> macbookList = Arrays.asList(macbook);
        List<Laptop> dellNotebookList = Arrays.asList(dellNotebook);
        List<Laptop> allLaptopList = Arrays.asList(macbook, dellNotebook);
        List<Laptop> emptyLaptopList = new ArrayList<>();

        assertNotEquals(macbookUser.getLaptopList(), emptyLaptopList);
        assertNotEquals(macbookUser.getLaptopList(), dellNotebookList);
        assertNotEquals(macbookUser.getLaptopList(), allLaptopList);

        assertNotEquals(dellNotebookUser.getLaptopList(), emptyLaptopList);
        assertNotEquals(dellNotebookUser.getLaptopList(), macbookList);
        assertNotEquals(dellNotebookUser.getLaptopList(), allLaptopList);

        assertNotEquals(allLaptopUser.getLaptopList(), emptyLaptopList);
        assertNotEquals(allLaptopUser.getLaptopList(), macbookList);
        assertNotEquals(allLaptopUser.getLaptopList(), dellNotebookList);

    }

    @Test
    @DisplayName("사용자 객체에 등록된 노트북 양도하기")
    void handOverLaptopTest() {
        List<Laptop> macbookList = new ArrayList<>(Arrays.asList(macbook));
        List<Laptop> dellNotebookList = new ArrayList<>(Arrays.asList(dellNotebook));
        List<Laptop> emptyLaptopList = new ArrayList<>();

        macbook.setRegisteredUser(user);
        dellNotebook.setRegisteredUser(user);

        macbook.initializeRegisteredUser(userId, password);
        macbookList.remove(macbook);

        dellNotebook.initializeRegisteredUser(userId, password);
        dellNotebookList.remove(dellNotebook);

        assertEquals(macbook.getRegisteredUser(), null);
        assertEquals(dellNotebook.getRegisteredUser(), null);

        assertEquals(macbookList, emptyLaptopList);
        assertEquals(dellNotebookList, emptyLaptopList);

    }


}