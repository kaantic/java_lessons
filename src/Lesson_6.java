import java.util.*;

public class Lesson_6 {

    public static void main(String[] args) {
        System.out.println("=== Задание 1: Студенты ===");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "Группа 1", 1, new int[]{5, 4, 5, 4}));
        students.add(new Student("Петров", "Группа 1", 1, new int[]{3, 2, 3, 2}));
        students.add(new Student("Сидоров", "Группа 2", 2, new int[]{4, 4, 5, 5}));
        students.add(new Student("Баранов", "Группа 2", 2, new int[]{2, 3, 2, 2}));
        students.add(new Student("Смирнов", "Группа 1", 1, new int[]{5, 5, 5, 5}));

        System.out.println("Список студентов до обработки:");
        for (Student s : students) System.out.println(s);

        removeBadStudents(students);
        System.out.println("\nПосле удаления студентов со средним баллом < 3:");
        for (Student s : students) System.out.println(s);

        promoteStudents(students);
        System.out.println("\nПосле перевода на следующий курс:");
        for (Student s : students) System.out.println(s);

        Set<Student> studentSet = new HashSet<>(students);
        System.out.println("\nСтуденты на 2 курсе:");
        printStudents(studentSet, 2);

        System.out.println("\n=== Задание 2: Телефонный справочник ===");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7 909-888-22-33");
        phoneBook.add("Петров", "+7 915-889-98-22");
        phoneBook.add("Иванов", "+7 915-434-23-11");
        phoneBook.add("Сидоров", "+7 945-811-92-23");
        phoneBook.add("Иванов", "+7 915-125-13-31");

        System.out.println("Номера Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера Петрова: " + phoneBook.get("Петров"));
        System.out.println("Номера Сидорова: " + phoneBook.get("Сидоров"));
        System.out.println("Номера Баранова (нет): " + phoneBook.get("Баранов"));
    }

    public static void removeBadStudents(List<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3);
    }

    public static void promoteStudents(List<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}

class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() { return name; }
    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public double getAverageGrade() {
        if (grades.length == 0) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.length;
    }

    @Override
    public String toString() {
        return String.format("%s [%s, курс %d, средний балл %.2f]",
                name, group, course, getAverageGrade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}

class PhoneBook {
    private final Map<String, List<String>> phoneMap = new HashMap<>();

    public void add(String lastName, String phone) {
        phoneMap.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phone);
    }

    public List<String> get(String lastName) {
        return phoneMap.getOrDefault(lastName, Collections.emptyList());
    }
}