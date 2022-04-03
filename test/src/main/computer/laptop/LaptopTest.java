package main.computer.laptop;

import main.application.ApplicationInfo;
import main.user.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
}
