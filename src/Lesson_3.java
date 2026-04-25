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

        for (Product p : productsArray) {
            p.displayInfo();
        }
        // 2. Демонстрация работы класса Park и внутреннего класса Attraction
        Park park = new Park();
        park.showAttractions();
        // Альтернативная демонстрация: создаём аттракцион напрямую через внутренний класс
        System.out.println("=== Создание отдельного аттракциона ===");
        Park.Attraction singleAttraction = park.new Attraction("Цепочная карусель", "09:00-19:00", 150);
        singleAttraction.displayInfo();
    }
}
class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isBooked;

    public Product(String name, String productionDate, String manufacturer,
                   String country, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }
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
class Park {
    class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }
        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost + " руб.");
            System.out.println("-----------------------------");
        }
    }

    // Метод для демонстрации нескольких аттракционов
    public void showAttractions() {
        Attraction[] attractions = new Attraction[3];
        attractions[0] = new Attraction("Колесо обозрения", "10:00-22:00", 300);
        attractions[1] = new Attraction("Американские горки", "11:00-21:00", 500);
        attractions[2] = new Attraction("Комната страха", "12:00-20:00", 250);

        System.out.println("\n=== Аттракционы парка ===");
        for (Attraction a : attractions) {
            a.displayInfo();
        }
    }
}