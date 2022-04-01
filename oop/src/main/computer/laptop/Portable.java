package main.computer.laptop;
import main.user.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Laptop<T> {

    T systemStart(String userId, String password);

    void systemOff();

    void showLaptopInfo();

    T installApplication(Integer applicationId);

    void deleteApplication(Integer applicationId);

    void runApplication(Integer applicationId);

    void exitApplication(Integer applicationId);

    void showSystemUsage();

    void initializeRegisteredUser(String userId, String password);

}
