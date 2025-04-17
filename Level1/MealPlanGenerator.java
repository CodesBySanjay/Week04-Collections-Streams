interface MealPlan {
    String getPlanName();
}

class VegetarianMeal implements MealPlan {
    private String name;

    public VegetarianMeal(String name) {
        this.name = name;
    }

    public String getPlanName() {
        return name;
    }
}

class VeganMeal implements MealPlan {
    private String name;

    public VeganMeal(String name) {
        this.name = name;
    }

    public String getPlanName() {
        return name;
    }
}

class KetoMeal implements MealPlan {
    private String name;

    public KetoMeal(String name) {
        this.name = name;
    }

    public String getPlanName() {
        return name;
    }
}

class HighProteinMeal implements MealPlan {
    private String name;

    public HighProteinMeal(String name) {
        this.name = name;
    }

    public String getPlanName() {
        return name;
    }
}

class Meal<T extends MealPlan> {
    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public T getPlan() {
        return plan;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generated Plan: " + meal.getPlan().getPlanName());
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal("Green Bowl"));
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal("Plant Power"));
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal("Keto Boost"));
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal("Protein Punch"));

        generateMealPlan(vegMeal);
        generateMealPlan(veganMeal);
        generateMealPlan(ketoMeal);
        generateMealPlan(proteinMeal);
    }
}