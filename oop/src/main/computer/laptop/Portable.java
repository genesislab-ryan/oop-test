package main.computer.laptop;

import main.application.Application;
import main.application.ApplicationInfo;
import main.user.User;

public interface Portable<T> {

    T systemStart(Integer userId, String password);

    void systemOff();

    void showLaptopInfo();

    T installApplication(ApplicationInfo applicationId);

    void deleteApplication(ApplicationInfo applicationId);

    void runApplication(ApplicationInfo applicationId);

    void exitApplication(ApplicationInfo applicationId);

    void showSystemUsage();

    void initializeRegisteredUser(Integer userId, String password);

    T setRegisteredUser (User user);

    void setModelSpec(Integer cpu, Integer ram, Integer disk);

}
