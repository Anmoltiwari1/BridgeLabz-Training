import java.util.*;

// Base interface for meal plans
interface MealPlan {
    String getType();
    List<String> getIngredients();
    int getCalories();
}

class VegetarianMeal implements MealPlan {
    String name;
    List<String> ingredients;
    int calories;
    
    VegetarianMeal(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }
    
    public String getType() { return "Vegetarian"; }
    public List<String> getIngredients() { return ingredients; }
    public int getCalories() { return calories; }
    
    public String toString() { return name + " (" + calories + " cal)"; }
}

class VeganMeal implements MealPlan {
    String name;
    List<String> ingredients;
    int calories;
    
    VeganMeal(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }
    
    public String getType() { return "Vegan"; }
    public List<String> getIngredients() { return ingredients; }
    public int getCalories() { return calories; }
    
    public String toString() { return name + " (" + calories + " cal)"; }
}

class KetoMeal implements MealPlan {
    String name;
    List<String> ingredients;
    int calories;
    
    KetoMeal(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }
    
    public String getType() { return "Keto"; }
    public List<String> getIngredients() { return ingredients; }
    public int getCalories() { return calories; }
    
    public String toString() { return name + " (" + calories + " cal)"; }
}

class HighProteinMeal implements MealPlan {
    String name;
    List<String> ingredients;
    int calories;
    
    HighProteinMeal(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }
    
    public String getType() { return "High-Protein"; }
    public List<String> getIngredients() { return ingredients; }
    public int getCalories() { return calories; }
    
    public String toString() { return name + " (" + calories + " cal)"; }
}

// Generic meal class with bounded type parameter
class Meal<T extends MealPlan> {
    T mealPlan;
    String mealTime;
    
    Meal(T mealPlan, String mealTime) {
        this.mealPlan = mealPlan;
        this.mealTime = mealTime;
    }
    
    T getMealPlan() { return mealPlan; }
    String getMealTime() { return mealTime; }
    
    public String toString() {
        return mealTime + ": " + mealPlan;
    }
}

public class PersonalizedMealPlanGenerator {
    Map<String, List<MealPlan>> mealDatabase = new HashMap<>();
    
    PersonalizedMealPlanGenerator() {
        initializeMealDatabase();
    }
    
    void initializeMealDatabase() {
        // Vegetarian meals
        mealDatabase.put("Vegetarian", Arrays.asList(
            new VegetarianMeal("Veggie Pasta", Arrays.asList("pasta", "tomatoes", "cheese"), 450),
            new VegetarianMeal("Greek Salad", Arrays.asList("lettuce", "feta", "olives"), 320)
        ));
        
        // Vegan meals
        mealDatabase.put("Vegan", Arrays.asList(
            new VeganMeal("Quinoa Bowl", Arrays.asList("quinoa", "vegetables", "tahini"), 380),
            new VeganMeal("Lentil Soup", Arrays.asList("lentils", "carrots", "onions"), 290)
        ));
        
        // Keto meals
        mealDatabase.put("Keto", Arrays.asList(
            new KetoMeal("Salmon & Avocado", Arrays.asList("salmon", "avocado", "spinach"), 520),
            new KetoMeal("Chicken Salad", Arrays.asList("chicken", "lettuce", "olive oil"), 410)
        ));
        
        // High-Protein meals
        mealDatabase.put("High-Protein", Arrays.asList(
            new HighProteinMeal("Protein Smoothie", Arrays.asList("protein powder", "banana", "milk"), 350),
            new HighProteinMeal("Grilled Chicken", Arrays.asList("chicken breast", "broccoli"), 480)
        ));
    }
    
    // Generic method to validate and generate meal plan
    <T extends MealPlan> List<Meal<T>> generateMealPlan(Class<T> mealType, int targetCalories) {
        List<Meal<T>> dailyPlan = new ArrayList<>();
        String[] mealTimes = {"Breakfast", "Lunch", "Dinner"};
        
        String planType = getMealPlanType(mealType);
        List<MealPlan> availableMeals = mealDatabase.get(planType);
        
        if (availableMeals == null) {
            System.out.println("No meals available for " + planType);
            return dailyPlan;
        }
        
        Random rand = new Random();
        int currentCalories = 0;
        
        for (String mealTime : mealTimes) {
            if (currentCalories >= targetCalories) break;
            
            MealPlan selectedMeal = availableMeals.get(rand.nextInt(availableMeals.size()));
            dailyPlan.add(new Meal<>((T) selectedMeal, mealTime));
            currentCalories += selectedMeal.getCalories();
        }
        
        return dailyPlan;
    }
    
    String getMealPlanType(Class<?> mealType) {
        if (mealType == VegetarianMeal.class) return "Vegetarian";
        if (mealType == VeganMeal.class) return "Vegan";
        if (mealType == KetoMeal.class) return "Keto";
        if (mealType == HighProteinMeal.class) return "High-Protein";
        return "Unknown";
    }
    
    // Generic method to display meal plan
    <T extends MealPlan> void displayMealPlan(List<Meal<T>> mealPlan, String planName) {
        System.out.println("\n=== " + planName + " Meal Plan ===");
        int totalCalories = 0;
        
        for (Meal<T> meal : mealPlan) {
            System.out.println(meal);
            totalCalories += meal.getMealPlan().getCalories();
        }
        
        System.out.println("Total Calories: " + totalCalories);
    }
    
    public static void main(String[] args) {
        PersonalizedMealPlanGenerator generator = new PersonalizedMealPlanGenerator();
        
        // Generate different meal plans
        List<Meal<VegetarianMeal>> vegPlan = generator.generateMealPlan(VegetarianMeal.class, 1200);
        generator.displayMealPlan(vegPlan, "Vegetarian");
        
        List<Meal<VeganMeal>> veganPlan = generator.generateMealPlan(VeganMeal.class, 1000);
        generator.displayMealPlan(veganPlan, "Vegan");
        
        List<Meal<KetoMeal>> ketoPlan = generator.generateMealPlan(KetoMeal.class, 1400);
        generator.displayMealPlan(ketoPlan, "Keto");
        
        List<Meal<HighProteinMeal>> proteinPlan = generator.generateMealPlan(HighProteinMeal.class, 1300);
        generator.displayMealPlan(proteinPlan, "High-Protein");
    }
}