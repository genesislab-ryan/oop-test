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
    private MsExcel msExcelforMac;
    private MsExcel msExcelforDell;

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

        msExcelforMac = new MsExcel(1, "msExcel", "app store");
        msExcelforMac.setApplicationCapacity(1, 3, 20);

        msExcelforDell = new MsExcel(1, "msExcel", "app market");
        msExcelforDell.setApplicationCapacity(1, 3, 20);

        macbookTest.installApplication(msExcelforMac);
        dellNotebook.installApplication(msExcelforDell);
    }

    @Test
    @DisplayName("랩탑 실행 상태에 따른 애플리케이션 실행 테스트")
    public void applicationSystemOnOffTest(){
        assertTrue(msExcelforMac.applicationOnOffCheck(macbookTest.systemStart(macUserId, password)));
        assertTrue(msExcelforDell.applicationOnOffCheck(dellNotebook.systemStart(dellUserId, password)));
    }

    @Test
    @DisplayName("애플리케이션 설치한 유저 정보 확인 메소드 테스트")
    public void addInstalledApplicationUser(){
        msExcelforMac.addInstalledApplicationUser(macbookTest);
        msExcelforDell.addInstalledApplicationUser(dellNotebook);

        assertTrue(msExcelforMac.getRegistertedUserList().contains(macUser));
        assertTrue(msExcelforDell.getRegistertedUserList().contains(dellNotebookUser));
    }



    @Test
    @DisplayName("애플리케이션 랩탑 사용량 메소드 설정 테스트")
    public void setApplicationUsageTest(){
        Integer cpu = 2;
        Integer ram = 5;
        Integer disk = 60;

        msExcelforMac.setApplicationCapacity(cpu, ram, disk);
        msExcelforDell.setApplicationCapacity(cpu, ram, disk);

        assertEquals(msExcelforMac.getCpuUsage(), cpu);
        assertEquals(msExcelforMac.getRamUsage(), ram);
        assertEquals(msExcelforMac.getDiskUsage(), disk);

        assertEquals(msExcelforDell.getCpuUsage(), cpu);
        assertEquals(msExcelforDell.getRamUsage(), ram);
        assertEquals(msExcelforDell.getDiskUsage(), disk);
    }
}
