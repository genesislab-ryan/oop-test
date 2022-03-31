package main.computer.laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Laptop {

    Integer display = 11;
    String vendor = "";
    String Model = "";
    Integer cpu = 0;
    Integer ram = 0;
    Integer disk = 0;
    List<Integer> applicationIdList = new ArrayList<>();
    Integer runningApplication = 0;
    boolean systemStart = false;
    Integer weight = 1;

    Boolean systemStart(Boolean on, String userId, String password);
    Boolean systemOff(boolean off);
    void showSystemInfo();
    List<Integer> installApplication(Integer applicationId);
    void deleteApplication(Integer applicationId);
    void runApplication(Integer applicationId);
    void exitApplication(Integer applicationId);
    void showSystemUsage();
    void InitializeRegisteredUser(String userId, String password);


}
