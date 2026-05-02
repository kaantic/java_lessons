// ========== ЗАДАНИЕ 1: Животные, коты, собаки, миска с едой ==========
abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    // Статистика
    protected static int animalCount = 0;
    protected static int dogCount = 0;
    protected static int catCount = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум " + runLimit + " м.)");
        }
    }

    public void swim(int distance) {
        if (swimLimit < 0) {
            System.out.println(name + " не умеет плавать");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум " + swimLimit + " м.)");
        }
    }

    public static void printCounts() {
        System.out.println("Всего животных: " + animalCount);
        System.out.println("Собак: " + dogCount);
        System.out.println("Котов: " + catCount);
    }
}
class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10); // бег 500 м, плавание 10 м
        dogCount++;
    }
}
class Cat extends Animal {
    private boolean isFull; // сытость

    public Cat(String name) {
        super(name, 200, -1); // бег 200 м, плавать не умеет
        this.isFull = false;
        catCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (isFull) {
            System.out.println(name + " уже сыт(а) и не хочет есть.");
            return;
        }
        if (bowl.decreaseFood(amount)) {
            isFull = true;
            System.out.println(name + " поел(а) " + amount + " еды из миски и теперь сыт(а).");
        } else {
            System.out.println(name + " не стал(а) есть, так как в миске недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}
class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        }
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

// ========== ЗАДАНИЕ 2: Геометрические фигуры с интерфейсом ==========

interface Shape {
    void setBorderColor(String color);
    void setFillColor(String color);
    String getBorderColor();
    String getFillColor();

    double getPerimeter();
    double getArea();

    default void printInfo() {
        System.out.println("Тип фигуры: " + this.getClass().getSimpleName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("-------------------------");
    }
}

class Circle implements Shape {
    private double radius;
    private String borderColor;
    private String fillColor;

    public Circle(double radius, String borderColor, String fillColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void setBorderColor(String color) { this.borderColor = color; }
    @Override
    public void setFillColor(String color) { this.fillColor = color; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String borderColor;
    private String fillColor;

    public Rectangle(double width, double height, String borderColor, String fillColor) {
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getPerimeter() { return 2 * (width + height); }
    @Override
    public double getArea() { return width * height; }
    @Override
    public void setBorderColor(String color) { this.borderColor = color; }
    @Override
    public void setFillColor(String color) { this.fillColor = color; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}

class Triangle implements Shape {
    private double sideA, sideB, sideC;
    private String borderColor;
    private String fillColor;

    public Triangle(double sideA, double sideB, double sideC, String borderColor, String fillColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getPerimeter() { return sideA + sideB + sideC; }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void setBorderColor(String color) { this.borderColor = color; }
    @Override
    public void setFillColor(String color) { this.fillColor = color; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}

public class Lesson_4 {
    public static void main(String[] args) {
        System.out.println("========== ЗАДАНИЕ 1 ==========\n");
        task1();

        System.out.println("\n\n========== ЗАДАНИЕ 2 ==========\n");
        task2();
    }

    // Задание 1: Животные, коты, миска
    public static void task1() {
        // Создаем собак и котов
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        // Проверка бега и плавания
        System.out.println("--- Проверка движений ---");
        dog1.run(150);
        dog1.run(600);
        cat1.run(100);
        cat1.run(250);
        dog2.swim(5);
        cat2.swim(3);

        // Подсчёт животных
        System.out.println("\n--- Статистика ---");
        Animal.printCounts();

        // Работа с миской
        Bowl bowl = new Bowl(30);
        Cat[] cats = {cat1, cat2, cat3};

        System.out.println("\n--- Коты кушают (в миске 30 еды, каждый просит 15) ---");
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println("\n--- Состояние сытости после первого кормления ---");
        for (Cat cat : cats) {
            System.out.println(cat.name + (cat.isFull() ? " сыт" : " голоден"));
        }

        System.out.println("\n--- Добавляем 20 еды в миску и кормим оставшихся голодных ---");
        bowl.addFood(20);
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 15);
            }
        }

        System.out.println("\n--- Итоговая сытость котов ---");
        for (Cat cat : cats) {
            System.out.println(cat.name + (cat.isFull() ? " сыт" : " голоден"));
        }
    }

    // Задание 2: геометрические фигуры
    public static void task2() {
        Shape[] shapes = {
                new Circle(5.0, "Черный", "Красный"),
                new Rectangle(4.0, 6.0, "Синий", "Желтый"),
                new Triangle(3.0, 4.0, 5.0, "Зеленый", "Оранжевый")
        };

        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}