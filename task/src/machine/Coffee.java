package machine;

public enum Coffee {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cost;

    Coffee(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    public int getWater() {
        return this.water;
    }

    public int getMilk() {
        return this.milk;
    }

    public int getCoffeeBeans() {
        return this.coffeeBeans;
    }

    public int getCost() {
        return this.cost;
    }
}
