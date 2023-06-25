import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HW1_1 {
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double price;
    
    public HW1_1(String model, int ram, int hdd, String os, String color, double price) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getRam() {
        return ram;
    }
    
    public int getHdd() {
        return hdd;
    }
    
    public String getOs() {
        return os;
    }
    
    public String getColor() {
        return color;
    }
    
    public double getPrice() {
        return price;
    }
    
    public static void main(String[] args) {
        List<HW1_1> notebooks = new ArrayList<>();
        notebooks.add(new HW1_1("Lenovo IdeaPad", 8, 512, "Windows 10", "Черный", 50000));
        notebooks.add(new HW1_1("HP Pavilion", 16, 256, "Windows 10", "Серый", 60000));
        notebooks.add(new HW1_1("Dell Inspiron", 8, 256, "Windows 10", "Серебристый", 55000));
        notebooks.add(new HW1_1("Apple MacBook Air", 8, 512, "macOS", "Золотой", 80000));
        notebooks.add(new HW1_1("Asus VivoBook", 16, 512, "Windows 10", "Синий", 65000));
        
        Scanner scanner = new Scanner(System.in);
        
        Map<String, Object> filters = new HashMap<>();
        
        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        
        String filter1 = scanner.nextLine();
        
        switch (filter1) {
            case "1":
                System.out.print("Минимальный объем ОЗУ (в ГБ): ");
                int minRam = scanner.nextInt();
                scanner.nextLine();
                filters.put("ram", minRam);
                break;
            case "2":
                System.out.print("Минимальный объем ЖД (в ГБ): ");
                int minHdd = scanner.nextInt();
                scanner.nextLine();
                filters.put("hdd", minHdd);
                break;
            case "3":
                System.out.print("Операционная система: ");
                String os = scanner.nextLine();
                filters.put("os", os);
                break;
            case "4":
                System.out.print("Цвет: ");
                String color = scanner.nextLine();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }
        
        System.out.println("Результаты фильтрации:");
        
        for (HW1_1 notebook : notebooks) {
            if (filters.containsKey("ram") && notebook.getRam() < (int) filters.get("ram")) {
                continue;
            }
            
            if (filters.containsKey("hdd") && notebook.getHdd() < (int) filters.get("hdd")) {
                continue;
            }
            
            if (filters.containsKey("os") && !notebook.getOs().equals(filters.get("os"))) {
                continue;
            }
            
            if (filters.containsKey("color") && !notebook.getColor().equals(filters.get("color"))) {
                continue;
            }
            
            System.out.println(notebook.getModel() + " - " + notebook.getPrice());
        }
    }
}