// Главный класс для демонстрации
public class Lesson_3 {
    public static void main(String[] args) {
        // 1. Демонстрация работы класса Product
        System.out.println("=== Товары ===");
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "10.03.2025",
                "Apple Inc.", "USA", 7999, false);
        productsArray[2] = new Product("Xiaomi Mi Band 9", "20.01.2025",
                "Xiaomi", "China", 49, true);
        productsArray[3] = new Product("Sony WH-1000XM6", "05.02.2025",
                "Sony", "Japan", 349, false);
        productsArray[4] = new Product("Dyson V15 Detect", "15.03.2025",
                "Dyson", "UK", 599, true);

        // Выводим информацию о каждом товаре
        for (Product p : productsArray) {
            p.displayInfo();
        }
        //атракцион
    }
}
// Класс Товар
class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isBooked; // состояние бронирования покупателем

    // Конструктор
    public Product(String name, String productionDate, String manufacturer,
                   String country, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }

    // Метод для вывода информации об объекте
    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Забронирован: " + (isBooked ? "Да" : "Нет"));
        System.out.println("-----------------------------");
    }
}
