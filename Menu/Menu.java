package Menu;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Menu {
    private File mealsFile = new File("./Meals.csv");
    private ArrayList<String> meals;
    private Scanner scanner;

    public Menu() {
    }
}
