package main.user;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Laptop;
import main.computer.laptop.Macbook;
import org.junit.jupiter.api.*;

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
    private User allLaptopUser;

    @BeforeEach
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
        allLaptopUser = new User(userName, ++userIdCount, address, phoneNumber, birthDate, password);

    }

    @Test
    @DisplayName("생성한 유저 정보에 노트북 등록하기")
    public void registerMyLaptopTest() {

        user.registerMyLaptop(macbook);
        user.registerMyLaptop(macbook); // 중복 등록 방지 로직이 수행되는지 확인하기 위한 코드

        allLaptopUser.registerMyLaptop(macbook);
        allLaptopUser.registerMyLaptop(macbook);
        allLaptopUser.registerMyLaptop(dellNotebook);

        List<Laptop> macbookList = Arrays.asList(macbook);
        List<Laptop> allLaptopList = Arrays.asList(macbook, dellNotebook);

        assertEquals(user.getLaptopList(), macbookList); // 맥북만 등록되었을 때
        assertEquals(user.getLaptopList().size(), macbookList.size()); // 동일 맥북 등록 여부 확인 (동일 노트북 추가 로직 실행 시, )

        assertEquals(allLaptopUser.getLaptopList(), allLaptopList); // 모든 종류의 노트북이 다 등록되었을 때
        assertEquals(allLaptopUser.getLaptopList().size(), allLaptopList.size());

    }

    @Test
    @DisplayName("사용자 객체에 등록된 노트북 양도하기")
    public void handOverLaptopTest() {
        List<Laptop> macbookList = new ArrayList<>(Arrays.asList(macbook));
        List<Laptop> dellNotebookList = new ArrayList<>(Arrays.asList(dellNotebook));
        List<Laptop> emptyLaptopList = new ArrayList<>();

        User handOverUser = new User("handOver", 3, "백령도 앞바다", "000-0000-0000", "1231", "1234");

        macbook.setRegisteredUser(user);
        dellNotebook.setRegisteredUser(user);

        macbook.initializeRegisteredUser(userId, password);
        macbookList.remove(macbook);

        dellNotebook.initializeRegisteredUser(userId, password);
        dellNotebookList.remove(dellNotebook);

        // 양도하는 유저에 대한 함수 코드 구현
        handOverUser.registerMyLaptop(macbook);
        handOverUser.registerMyLaptop(dellNotebook);

        assertEquals(macbook.getRegisteredUser(), null);
        assertEquals(dellNotebook.getRegisteredUser(), null);

        assertEquals(macbookList, emptyLaptopList);
        assertEquals(dellNotebookList, emptyLaptopList);
        assertTrue(handOverUser.getLaptopList().contains(macbook));
    }

}