package main.computer.laptop;
import main.user.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Laptop {

    Boolean systemStart(String userId, String password);

    void systemOff();

    void showLaptopInfo();

    List<Integer> installApplication(Integer applicationId);

    void deleteApplication(Integer applicationId);

    void runApplication(Integer applicationId);

    void exitApplication(Integer applicationId);

    void showSystemUsage();

    void InitializeRegisteredUser(String userId, String password);

}
