package main.computer.laptop;

import main.application.MsExcel;
import main.user.User;

import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

public class LaptopTest {

    private User macbookUser;
    private User dellNotebookUser;
    private Integer macUserId;
    private Integer dellUserId;
    private String password;
    private Macbook macbookTest;
    private DellNotebook dellNotebook;
    private MsExcel msExcel;

    @BeforeEach
    public void setUp() throws Exception{
        macbookUser = new User("tester", 1, "mockup", "000-0000-0000", "1990-12-12", "1234");
        dellNotebookUser = new User("tester", 4, "mockup", "000-0000-0000", "1990-12-12", "1234");

        macUserId = 1;
        dellUserId = 4;
        password = "1234";

        macbookTest = new Macbook("apple", "1a2b3c4d", "macbook air");
        macbookTest.setModelSpec(4, 8, 256); // 모델 스펙 정의 필수 (애플리케이션 설치 시)
        macbookTest.setRegisteredUser(macbookUser);

        dellNotebook = new DellNotebook("dell", "1a2b3c4d", "XPS");
        dellNotebook.setModelSpec(4, 8, 256); // 모델 스펙 정의 필수 (애플리케이션 설치 시)
        dellNotebook.setRegisteredUser(dellNotebookUser);

        msExcel = new MsExcel(1, "msExcel", "app store");
        msExcel.setApplicationCapacity(1, 3, 20);


    }

    @Test
    @DisplayName("시스템 시작하기 메소드 테스트")
    public void systemStartTest(){

        Exception exception = assertThrows(NullPointerException.class, ()->{
            macbookTest.systemStart(dellUserId, password).equals(true);
        });
        String expectedMessage = "Cannot invoke \"java.lang.Boolean.equals(Object)\" because the return value of \"main.computer.laptop.Macbook.systemStart(java.lang.Integer, String)\" is null";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);

        assertTrue("맥북 실행에 에러가 발생했습니다.", macbookTest.systemStart(macUserId, password));
        assertTrue("델 노트북 실행에 에러가 발생했습니다.", dellNotebook.systemStart(dellUserId, password));
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("시스템 종료하기 메소드 테스트")
    public void systemOffTest(){
        macbookTest.systemOff();
        assertFalse("맥북 종료에 에러가 발생했습니다", macbookTest.getSystemOnOff());
    }

    @Test
    @DisplayName("랩탑 유저 정보 초기화 메소드 테스트")
    public void initializeRegisteredUserTest(){

        macbookTest.initializeRegisteredUser(macUserId, password);
        dellNotebook.initializeRegisteredUser(dellUserId, password);

        assertNull("맥북의 유저 정보가 정상적으로 초기화 되지 않았습니다.", macbookTest.getRegisteredUser());
        assertNull("델 노트북의 유저 정보가 정상적으로 초기화 되지 않았습니다.", dellNotebook.getRegisteredUser());
    }

    @Test
    @DisplayName("랩탑 애플리케이션 설치 메소드 테스트")
    public void installApplicationTest(){
        macbookTest.installApplication(msExcel);
        dellNotebook.installApplication(msExcel);

        assertTrue("맥북에서 애플리케이션 설치에 에러가 발생했습니다.", macbookTest.getApplicationList().contains(msExcel)); // 애플리케이션 설치 여부 확인하기
        assertFalse("맥북 Disk의 남은 용량은 음수가 될 수 없습니다.", macbookTest.getDisk() < 0);

        assertTrue("델 노트북에서 애플리케이션 설치에 에러가 발생했습니다.", dellNotebook.getApplicationList().contains(msExcel)); // 애플리케이션 설치 여부 확인하기
        assertFalse("델 노트북 Disk의 남은 용량은 음수가 될 수 없습니다.", dellNotebook.getDisk() < 0);
    }

    @Test
    @DisplayName("랩탑 애플리케이션 삭제 메소드 테스트")
    public void deletionApplicationTest(){
        macbookTest.installApplication(msExcel);
        macbookTest.deleteApplication(msExcel);

        dellNotebook.installApplication(msExcel);
        dellNotebook.deleteApplication(msExcel);

        assertTrue("맥북에서 삭제하고자하는 애플리케이션이 제거되지 않았습니다.",  macbookTest.getApplicationList().isEmpty());
        assertEquals("맥북에서 삭제한 디스크 용량이 회복되지 않았습니다.", macbookTest.getDisk(), (Integer) 256);

        assertTrue("델 노트북에서 삭제하고자하는 애플리케이션이 제거되지 않았습니다.",  dellNotebook.getApplicationList().isEmpty());
        assertEquals("델 노트북에서 삭제한 디스크 용량이 회복되지 않았습니다.", dellNotebook.getDisk(), (Integer) 256);
    }

    @Test
    @DisplayName("랩탑 애플리케이션 종료 메소드 테스트")
    public void exitApplicationTest(){
        macbookTest.exitApplication(msExcel);
        dellNotebook.exitApplication(msExcel);

        assertNull("맥북에서 애플리케이션이 종료되지 않았습니다.", macbookTest.getRunningApplication());
        assertEquals(macbookTest.getCpu(), (Integer) 4);
        assertEquals(macbookTest.getRam(), (Integer) 8);

        assertNull("델 노트북에서 애플리케이션이 종료되지 않았습니다.", dellNotebook.getRunningApplication());
        assertEquals(dellNotebook.getCpu(), (Integer) 4);
        assertEquals(dellNotebook.getRam(), (Integer) 8);
    }

    @Test
    @DisplayName("랩탑 애플리케이션 실 메소드 테스트")
    public void runApplicationTest(){
        macbookTest.runApplication(msExcel);
        dellNotebook.runApplication(msExcel);

        assertNotNull("맥북에서 애플리케이션이 실행되지 않았습니다.", macbookTest.getRunningApplication());
        assertNotNull("델 노트북에서 애플리케이션이 실행되지 않습니다.", dellNotebook.getRunningApplication());

        assertEquals("맥북의 잔여 CPU가 잘못 표기되었습니다.", macbookTest.getCpu(), (Integer) 3);
        assertEquals("맥북의 잔여 RAM가 잘못 표기되었습니다.", macbookTest.getRam(), (Integer) 5);
        assertEquals("맥북의 잔여 Disk가 잘못 표기되었습니다.", macbookTest.getDisk(), (Integer) 236);

        assertEquals("델노트북의 잔여 CPU가 잘못 표기되었습니다.", dellNotebook.getCpu(), (Integer) 3);
        assertEquals("델노트북의 잔여 RAM가 잘못 표기되었습니다.", dellNotebook.getRam(), (Integer) 5);
        assertEquals("델노트북의 잔여 Disk가 잘못 표기되었습니다.", dellNotebook.getDisk(), (Integer) 236);
    }

    @Test
    @DisplayName("랩탑 유저 정보 등록 메소드 테스트")
    public void setRegisteredUserTest(){
        assertNotNull("현재 맥북에 등록된 유저 정보가 존재하지 않습니다.", macbookTest.getRegisteredUser());
        assertNotNull("현재 델 노트북에 등록된 유저 정보가 존재하지 않습니다.", dellNotebook.getRegisteredUser());
    }

    @Test
    @DisplayName("랩탑 모델 스펙 설정 메소드 테스트")
    public void setModelSpecTest(){
        Integer cpu = 8;
        Integer ram = 16;
        Integer disk = 512;

        macbookTest.setModelSpec(cpu, ram, disk);
        dellNotebook.setModelSpec(cpu, ram, disk);

        assertEquals(macbookTest.getCpu(), cpu);
        assertEquals(macbookTest.getRam(), ram);
        assertEquals(macbookTest.getDisk(), disk);

        assertEquals(dellNotebook.getCpu(), cpu);
        assertEquals(dellNotebook.getRam(), ram);
        assertEquals(dellNotebook.getDisk(), disk);
    }
}
