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

import static org.junit.Assert.*;

public class MsExcelTest {

    private User user;
    private Integer userId;
    private String password;
    private Macbook macbookTest;
    private MsExcel msExcel;

    @Before
    public void setUp() throws Exception{

        user = new User("tester", 1, "mockup", "000-0000-0000", "1990-12-12", "1234");
        userId = 1;
        password = "1234";
        macbookTest = new Macbook("apple", "1a2b3c4d", "macbook air");
        macbookTest.setModelSpec(4, 8, 256); // 모델 스펙 정의 필수 (애플리케이션 설치 시)
        macbookTest.setRegisteredUser(user);

        msExcel = new MsExcel(1, "msExcel", "app store");
        msExcel.setApplicationCapacity(1, 3, 20);
    }

}
