package Menu;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Menu {
    private File mealsFile; // File contains all menu meals
    private Scanner scanner; // Used to scan meal files
    private ArrayList<Meal> mealsList; // List containing all meals

    // Create menu based off of a single meals file
    public Menu(File mealsFile) {
        this.mealsFile = mealsFile;
        this.mealsList = new ArrayList<Meal>(); // Create new list of meals.
        // Import all meals
        this.importMeals(this.mealsFile);
    }

    // Import meals from a file
    public void importMeals(File mealsFile) {
        try {
            // Create scanner for meals file
            scanner = new Scanner(mealsFile);
            // Read file
            while (scanner.hasNextLine()) {
                // Split line into meaningful sections (csv format)
                String[] mealProperties = scanner.nextLine().split(",");

                // Denote meal properties
                String mealName = mealProperties[0];
                String mealSize = mealProperties[1];
                String mealCalories = mealProperties[2].split(" ")[0]; // remove "Cal" from property (check csv)
                double mealPrice = Double.parseDouble(mealProperties[3]); // convert price from String to double

                // Create meal object based off of each property
                Meal meal = new Meal(mealName, mealSize, mealCalories, mealPrice);

                // Insert meal object into the meals list.
                mealsList.add(meal);
            }
        } catch (Exception e) {
            System.out.println("Meals @importMeals: " + e);
        }
    }

    // Get menu as String
    public String toString() {
        if (mealsList.isEmpty()) {
            return "There are no meals to display.";
        }
        // String to which we will append each meal
        String menuString = "---- Meals ----\n";

        // Iterate through mealslist
        for (Meal meal : mealsList) {
            // Append meal to string
            menuString += meal.getName() + ", $" + meal.getPrice() + "\n";
        }

        // Return result
        return menuString.trim() + "\n---- Meals ----";
    }
}
