package main.user;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Laptop;
import main.computer.laptop.Macbook;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

class UserTest {

    private String userName;
    private Integer userId;
    private String address;
    private String phoneNumber;
    private String birthDate;
    private String password;
    private Macbook macbook;
    private DellNotebook dellNotebook;
    private Integer userIdCount = 0;
    private User user;
    private User macbookUser;
    private User dellNotebookUser;
    private User allLaptopUser;

    @Before
    public void setup() throws Exception{
        userName = "tester";
        userId = 1;
        address = "울릉도 동남쪽 뱃길따라 이백리";
        phoneNumber = "010-1234-5678";
        birthDate = "1999-12-12";
        password = "1234";
        macbook = new Macbook("apple", "1a2b3c4d", "macbook air");
        dellNotebook = new DellNotebook("dell", "d4c3b2a1", "XPS");
        userIdCount = 0;
        user = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        macbookUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        dellNotebookUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
        allLaptopUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);
    }

    @After
    public void teardown() throws Exception{

    }

    @Test
    @DisplayName("생성한 유저 정보 가져오기")
    public void registeredUserInfoTest() {

        assertEquals(user.getUserName(), "tester");
        assertEquals(user.getUserId(), (Integer)  1);
        assertEquals(user.getAddress(), "울릉도 동남쪽 뱃길따라 이백리");
        assertEquals(user.getBirthDate(), "1999-12-12");
        assertEquals(user.getPassword(), "1234");
    }

    @Test
    @DisplayName("생성한 유저 정보에 노트북 등록하기")
    public void registerMyLaptopTest() {

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
    public void notRegisterMyLaptopTest() {

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
    public void handOverLaptopTest() {
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