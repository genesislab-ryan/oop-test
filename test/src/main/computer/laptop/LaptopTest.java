package main.computer.laptop;

import main.application.ApplicationInfo;
import main.application.MsExcel;
import main.user.User;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LaptopTest {

    private List<ApplicationInfo> applicationList;
    private User user;
    private Integer userId;
    private String password;
    private Macbook macbookTest;
    private DellNotebook dellNotebooktest;
    private MsExcel msExcel;

    @BeforeEach
    public void setUp() throws Exception{
        msExcel = new MsExcel(1, "msExcel", "app store");
        user = new User("tester", 1, "mockup", "000-0000-0000", "1990-12-12", "1234");
        userId = 1;
        password = "1234";
        macbookTest = new Macbook("apple", "1a2b3c4d", "macbook air");
        dellNotebooktest = new DellNotebook("dell", "d4c3b2a1", "XPS");
        applicationList = new ArrayList<>(Arrays.asList());

        macbookTest.setRegisteredUser(user);
        dellNotebooktest.setRegisteredUser(user);
    }

    @AfterEach
    public void tearDown() throws Exception{

    }

    @Test
    @DisplayName("시스템 시작하기 메소드 테스트")
    public void systemStartTest(){
        assertTrue("맥북 실행에 에러가 발생했습니다.", macbookTest.systemStart(userId, password));
        assertTrue("델 노트북에 에러가 발생했습니다.", macbookTest.systemStart(userId, password));
    }

    @Test
    @DisplayName("시스템 종료하기 메소드 테스트")
    public void systemOffTest(){
        macbookTest.systemOff();
        dellNotebooktest.systemOff();

        assertFalse("맥북 종료에 에러가 발생했습니다", macbookTest.getSystemOnOff());
        assertFalse("델 노트북 종료에 에러가 발생했습니다", dellNotebooktest.getSystemOnOff());

    }

    @Test
    @DisplayName("랩탑 정보 출력 메소드 테스트")
    public void showLaptopInfoTest(){
        // void 반환에서 테스트 결과 통과하는 것 테스트 (mockup
    }

    @Test
    @DisplayName("랩탑 사용량 출력 메소드 테스트")
    public void showSystemUsageTest(){

    }

    @Test
    @DisplayName("랩탑 유저 정보 초기화 메소드 테스트")
    public void initializeRegisteredUserTest(){

        macbookTest.initializeRegisteredUser(userId, password);
        dellNotebooktest.initializeRegisteredUser(userId, password);

        assertNull("맥북의 유저 정보가 정상적으로 초기화 되지 않았습니다.", macbookTest.getRegisteredUser());
        assertNull("덱 노트북의 유저 정보가 정상적으로 초기화 되지 않았습니다. ", dellNotebooktest.getRegisteredUser());
    }

    @Test
    @DisplayName("랩탑 애플리케이션 설치 메소드 테스트")
    public void installApplicationTest(){

    }

    @Test
    @DisplayName("랩탑 애플리케이션 삭제 메소드 테스트")
    public void deletionApplicationTest(){

    }

    @Test
    @DisplayName("랩탑 애플리케이션 종료 메소드 테스트")
    public void exitApplicationTest(){

    }

    @Test
    @DisplayName("랩탑 애플리케이션 실 메소드 테스트")
    public void runApplicationTest(){

    }

    @Test
    @DisplayName("랩탑 유저 정보 등록 메소드 테스트")
    public void setRegisteredUserTest(){
        assertNotNull("현재 맥북에 등록된 유저 정보가 존재하지 않습니다.", macbookTest.getRegisteredUser());
        assertNotNull("현재 델 노트북에 등록된 유저 정보가 존재하지 않습니다.", dellNotebooktest.getRegisteredUser());
    }

    @Test
    @DisplayName("랩탑 모델 스펙 설정 메소드 테스트")
    public void setModelSpecTest(){

    }
}