package main.application;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Macbook;
import main.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.Assert.*;

public class ApplicationTest {

    private User macUser;
    private User dellNotebookUser;
    private Integer macUserId;
    private Integer dellUserId;
    private String password;
    private Macbook macbookTest;
    private DellNotebook dellNotebook;
    private MsExcel msExcel;

    @BeforeEach
    public void setUp() throws Exception{

        macUser = new User("tester", 1, "mockup", "000-0000-0000", "1990-12-12", "1234");
        dellNotebookUser = new User("tester", 4, "mockup", "000-0000-0000", "1990-12-12", "1234");

        macUserId = 1;
        dellUserId = 4;
        password = "1234";
        macbookTest = new Macbook("apple", "1a2b3c4d", "macbook air");
        macbookTest.setModelSpec(4, 8, 256); // 모델 스펙 정의 필수 (애플리케이션 설치 시)
        macbookTest.setRegisteredUser(macUser);

        dellNotebook = new DellNotebook("dell", "1a2b3c4d", "XPS");
        dellNotebook.setModelSpec(4, 8, 256); // 모델 스펙 정의 필수 (애플리케이션 설치 시)
        dellNotebook.setRegisteredUser(dellNotebookUser);

        msExcel = new MsExcel(1, "msExcel", "app store");
        msExcel.setApplicationCapacity(1, 3, 20);
    }

    @Test
    @DisplayName("랩탑 실행 상태에 따른 애플리케이션 실행 테스트")
    public void applicationSystemOnOffTest(){
        assertTrue(msExcel.applicationOnOffCheck(macbookTest.systemStart(macUserId, password)));
    }

}
