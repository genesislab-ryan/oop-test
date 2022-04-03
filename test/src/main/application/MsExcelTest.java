package main.application;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Laptop;
import main.computer.laptop.Macbook;
import main.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class MsExcelTest {

    private Integer applicationId;
    private String marketPlace;
    private Integer cpuUsage;
    private Integer ramUsage;
    private Integer diskUsage;
    private List<Laptop> applicationInstalledLaptop;

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    @DisplayName("애플리케이션 정보 출력 테스트")
    public void showApplicationInfoTest(){

    }

}
