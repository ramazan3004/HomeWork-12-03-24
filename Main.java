import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Lenovo", 8, 512, "Windows 10", "Black"));
        laptops.add(new Laptop("HP", 16, 1024, "Windows 10", "Silver"));
        laptops.add(new Laptop("Dell", 12, 256, "Ubuntu", "Gray"));

        Scanner scanner = new Scanner(System.in);

        Map<String, String> filters = new HashMap<>();
        System.out.println("Выберите критерий для фильтрации: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Введите минимальное значение ОЗУ: ");
                int minRAM = scanner.nextInt();
                filters.put("RAM", String.valueOf(minRAM));
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД: ");
                int minStorageSize = scanner.nextInt();
                filters.put("StorageSize", String.valueOf(minStorageSize));
                break;
            case 3:
                System.out.print("Введите требуемую операционную систему: ");
                String os = scanner.nextLine();
                filters.put("OperatingSystem", os);
                break;
            case 4:
                System.out.print("Введите требуемый цвет: ");
                String color = scanner.nextLine();
                filters.put("Color", color);
                break;
            default:
                System.out.println("Некорректный выбор.");
        }

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : laptops) {
            boolean match = true;
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case "RAM":
                        if (laptop.getRAM() < Integer.parseInt(entry.getValue())) {
                            match = false;
                        }
                        break;
                    case "StorageSize":
                        if (laptop.getStorageSize() < Integer.parseInt(entry.getValue())) {
                            match = false;
                        }
                        break;
                    case "OperatingSystem":
                        if (!laptop.getOperatingSystem().equals(entry.getValue())) {
                            match = false;
                        }
                        break;
                    case "Color":
                        if (!laptop.getColor().equals(entry.getValue())) {
                            match = false;
                        }
                        break;
                }
            }
            if (match) {
                System.out.println("Бренд: " + laptop.getBrand() + ", ОЗУ: " + laptop.getRAM()
                        + ", Объем жесткого диска: " + laptop.getStorageSize()
                        + ", ОС: " + laptop.getOperatingSystem() + ", Цвет: " + laptop.getColor());
            }
        }

        scanner.close();
    }
}