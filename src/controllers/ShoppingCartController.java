package controllers;

import Utility.EmptyFileException;
import model.Customer;
import model.Employee;
import model.Product;
import model.User;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static controllers.SneakerController.scanner;

public class ShoppingCartController {
    private static final String CUSTOMER_FILE = "src/data/customers.csv";
    private static final String EMPLOYEE_FILE = "src/data/employees.csv";
    private static final String CART_FILE = "src/data/cart.csv";
    private static final String PRODUCT_FILE = "src/data/products.csv";
    private static final String USER_FILE = "src/data/users.csv";

    private List<Product> products;
    private List<Customer> customers;
    private List<Employee> employees;
    private List<Product> cart;
    public List<User> users;

    public ShoppingCartController() throws EmptyFileException {
        users = loadUsers();
        products = loadProducts();
        customers = loadCustomers();
        employees = loadEmployees();
        cart = new ArrayList<Product>();
    }

    public List<User> loadUsers() throws EmptyFileException {
        return FileUtil.readUserFromFile(USER_FILE);
    }

    public List<Product> loadProducts(){
       return FileUtil.readProductFromFile(PRODUCT_FILE);
    }
    public List<Customer> loadCustomers(){
        return FileUtil.readCustomerFromFile(CUSTOMER_FILE);
    }
    public List<Employee> loadEmployees(){
        return FileUtil.readEmployeeFromFile(EMPLOYEE_FILE);
    }


    public void displayShoppingCartMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(" ====================================");
            System.out.println("|         Shoping Cart Menu          |");
            System.out.println("|                                    |");
            System.out.println("| 1. Hiển thị danh sách sản phẩm     |");
            System.out.println("| 2. Thêm sản phẩm vào giỏ hàng      |");
            System.out.println("| 3. Hiển thị giỏ hàng               |");
            System.out.println("| 4. Thanh toán                      |");
            System.out.println("| 5. Trở về menu chính               |");
            System.out.println(" ====================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    calculateTotal();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }

    }
    private void displayProducts(){
        System.out.println("List of products: ");
        for (Product product : products){
            System.out.println(product);
        }
    }

    private void addProductToCart(){
        System.out.println("Nhập code của sảm phẩm muốn thêm vào giỏ hàng: ");
        String productCode = scanner.nextLine();
        Product selectedProduct = null;
        for (Product product : products){
            if(product.getCode().equals(productCode)){
                selectedProduct = product;
                break;
            }
        }
        if (selectedProduct != null){
            cart.add(selectedProduct);
            System.out.println("Sản phẩm "+selectedProduct+" đã được thêm vào giỏ hàng.");
            FileUtil.writeProductToFile(CART_FILE, cart);
        }else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    private void displayCart(){
        System.out.println("Nội dung giỏ hàng: ");

        if(cart.size() == 0){
            System.out.println("Giỏ hàng rỗng!");
        }else{
            for (Product cart1 : cart){
                System.out.println(cart1);
            }
        }

    }

    private void calculateTotal(){
        double total =  0;
        for (Product cart1 : cart){
            total += cart1.getPrice();
        }
        System.out.println("total price: " + total);
    }


}

