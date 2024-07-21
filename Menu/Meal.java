package Menu;

// This class represents a meal with its properties.
// It is likely used most in conjunction with the Menu class.
public class Meal {
    private String name; // Name of the meal, e.g. Big Mac (Exclude "meal")
    private String size; // Size of drink and fries. e.g. Medium
    private String calories; // Calories, e.g. 910-1150
    private double price; // Price of the meal, e.g. 9.59

    public Meal(String name, String size, String calories, double price) {
        this.name = name;
        this.size = size;
        this.calories = calories;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return this.size + " " + this.name + " Meal, " + this.calories + " Cal, $" + this.price;
    }
}
