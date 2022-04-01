package main.application;

import main.computer.laptop.DellNotebook;
import main.computer.laptop.Macbook;

public interface Application {

    void showApplicationInfo();

    void subtractUsageFromLaptop(Macbook macbook);

    void addUsageFromLaptop(Macbook macbook);

    void subtractUsageFromLaptop(DellNotebook dellNotebook);

    void addUsageFromLaptop(DellNotebook dellNotebook);

}
