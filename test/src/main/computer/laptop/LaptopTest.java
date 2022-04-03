package main.computer.laptop;

import main.application.ApplicationInfo;
import main.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LaptopTest {

    private List<ApplicationInfo> applicationList;
    private User user;

    private Macbook macbookTest;
    private DellNotebook dellNotebooktest;

    @Before
    public void setUp() throws Exception{
        applicationList = new ArrayList<>();
        user = new User("tester", 1, "mockup", "000-0000-0000", "1990-12-12", "1234");
        macbookTest = new Macbook("apple", "1a2b3c4d", "macbook air");
        dellNotebooktest = new DellNotebook("dell", "d4c3b2a1", "XPS");
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    @DisplayName("시스템 시작하기 메소드 테스트")
    public void systemStartTest(){

    }

    @Test
    @DisplayName("시스템 종료하기 메소드 테스트")
    public void systemOffTest(){

    }

    @Test
    @DisplayName("랩탑 정보 출력 메소드 테스트")
    public void showLaptopInfoTest(){

    }

    @Test
    @DisplayName("랩탑 사용량 출력 메소드 테스트")
    public void showSystemUsageTest(){

    }

    @Test
    @DisplayName("랩탑 유저 정보 초기화 메소드 테스트")
    public void initializeRegisteredUserTest(){

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

    }

    @Test
    @DisplayName("랩탑 모델 스펙 설정 메소드 테스트")
    public void setModelSpecTest(){

    }
}
