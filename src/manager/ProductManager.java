package manager;

import validation.Validate;
import model.Product;

import java.io.*;
import java.util.*;

public class ProductManager {
    public static final String PATH_NAME = "src/information/products.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Product> productList = new ArrayList<>();
    private static final Validate validate = new Validate();

    public static ArrayList<Product> getProductList() {
        return productList;
    }
   //Create product as object
    public static Product createProduct(){
        System.out.println("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        String price = enterPrice();
        String amount = enterAmount();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        return new Product(id,name,price,amount,description);
    }
    //Adding product to list
    public static void  addProduct(){
        Product product = createProduct();
        productList.add(product);
        writeFile(productList,PATH_NAME);
    }
    //Displaying product
    public static void displayProduct(){
        for (Product product:productList
             ) {
            System.out.println(product);
        }
    }
    //Edit Product
    public static void editProduct(String id) {
        Product products = null;
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                products = product;
            }
        }
        if (products != null) {
            int index = productList.indexOf(products);
            System.out.print("Enter product id: ");
            String productId = scanner.nextLine();
            products.setId(productId);
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            products.setName(name);
            System.out.print("Enter product price : ");
            String price = scanner.nextLine();
            products.setPrice(price);
            System.out.print("Enter product amount: ");
            String amount = scanner.nextLine();
            products.setAmount(amount);
            System.out.print("Enter product description: ");
            String description = scanner.nextLine();
            products.setDescription(description);
            productList.set(index, products);
            System.out.println("Sửa thành công !!!");
            writeFile(productList, PATH_NAME);
        }
    }
    //delete Product
    public static void deleteProduct(String product){
        Product products = null;
        for (Product c : productList) {
            if (c.getId().equals(product)) {
                products = c;
            }
        }
        productList.remove(products);
        System.out.println("Xóa thành công !!!");

    }

    //sort by id
    public static void sortById(){


    }

    // price validation
    private static String enterPrice() {
        String price;
        while (true) {
            System.out.print("Enter product price : ");
            String inputPrice = scanner.nextLine();
            if (!validate.validatePrice(inputPrice)) {
                System.out.println("Please use number only!!!");
            } else {
                price = inputPrice;
                break;
            }
        }
        return price;
    }
    //amount validation
    private static String enterAmount() {
        String amount;
        while (true) {
            System.out.print("Enter product amount : ");
            String inputAmount = scanner.nextLine();
            if (!validate.validateAmount(inputAmount)) {
                System.out.println("Please use number only!!!");
            } else {
                amount = inputAmount;
                break;
            }
        }
        return amount;
    }
    //Write file
    public static void writeFile(ArrayList<Product> Products, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Product Product : Products) {
                bufferedWriter.write(Product.getId() + "," +
                        Product.getName() + "," + Product.getPrice() + "," + Product.getAmount() + "," +
                        Product.getDescription() + "\n");
            }
            bufferedWriter.close();
            System.out.println("Ghi File Thành Công !!!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    //Read file
    public static ArrayList<Product> readFile(String path) {
        ArrayList<Product> Products = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                Products.add(new Product(strings[0], strings[1], strings[2], strings[3], strings[4]));
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return Products;
    }
}
