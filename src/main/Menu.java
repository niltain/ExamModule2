package main;

import manager.ProductManager;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void menuMain() {
        int choice;
        do {
            System.out.println();
            System.out.println("___Product Manager___");
            System.out.println("|1. Display Products ");
            System.out.println("|2. Add new Products ");
            System.out.println("|3. Edit Product ");
            System.out.println("|4. Delete Product ");
            System.out.println("|5. Sort Product");
            System.out.println("|6. Display highest product");
            System.out.println("|7. Write to file ");
            System.out.println("|8. Read from file ");
            System.out.println("|9. Exit ");
            System.out.print("Please make a choice : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManager.displayProduct();
                    break;
                case 2:
                   ProductManager.addProduct();
                    break;
                case 3:
                    System.out.print("Enter product ID:");
                    String s = scanner.nextLine();
                    ProductManager.editProduct(s);
                    System.out.println(s);
                    break;
                case 4:
                    System.out.print("Enter product ID: ");
                    String s1 = scanner.nextLine();
                   ProductManager.deleteProduct(s1);
                    System.out.println(s1);
                    break;
//                case 5:
//                    System.out.print("Nhập tên tìm kiếm: ");
//                    scanner.nextLine();
//                    String name = scanner.nextLine();
//                    ArrayList<Product> s2 =ProductManager.searchProduct(name);
//                    System.out.println(s2);
//                    break;
                case 7:
                   ProductManager.writeFile(ProductManager.getProductList(),ProductManager.PATH_NAME);
                    break;
                case 8:
                    ArrayList<Product> Product =ProductManager.readFile(ProductManager.PATH_NAME);
                    Product.forEach(System.out::println);
                    break;
                case 9:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}

