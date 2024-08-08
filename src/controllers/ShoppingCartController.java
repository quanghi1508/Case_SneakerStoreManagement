package controllers;

import model.Cart;
import model.Customer;
import model.Employee;
import model.Product;
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

    private List<Product> products;
    private List<Customer> customers;
    private List<Employee> employees;
    private List<Cart> cart;

    public ShoppingCartController() {
        products = loadProducts();
        customers = loadCustomers();
        employees = loadEmployees();
        cart = new ArrayList<>();
    }

    public List<Product> loadProducts(){
        List<Product> products = new ArrayList<>();
        List<String> lines = FileUtil.readFromFile(PRODUCT_FILE);
        for(String line : lines){
            products.add(Product.fromCSV(line));
        }
        return products;
    }
    public List<Customer> loadCustomers(){
        List<Customer> customers = new ArrayList<>();
        List<String> lines = FileUtil.readFromFile(CUSTOMER_FILE);
        for(String line : lines){
            customers.add(Customer.fromCSV(line));
        }
        return customers;
    }
    public List<Employee> loadEmployees(){
        List<Employee> employees = new ArrayList<>();
        List<String> lines = FileUtil.readFromFile(EMPLOYEE_FILE);
        for(String line : lines){
            employees.add(Employee.fromCSV(line));
        }
        return employees;
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
//                    addProductToCart();
                    break;
                case 3:
//                    displayCart();
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

//    private void addProductToCart(){
//        System.out.println("Nhập code của sảm phẩm muốn thêm vào giỏ hàng: ");
//        String productCode = scanner.nextLine();
//        Product selectedProduct = null;
//        for (Product product : products){
//            if(product.getCode().equals(productCode)){
//                selectedProduct = product;
//                break;
//            }
//        }
//        if (selectedProduct != null){
//            cart.add(selectedProduct);
//            System.out.println("Sản phẩm "+selectedProduct+" đã được thêm vào giỏ hàng.");
//            FileUtil.writeToFile(CART_FILE, selectedProduct.convertData());
//        }else {
//            System.out.println("Không tìm thấy sản phẩm!");
//        }
//    }

//    private void displayCart(){
//        System.out.println("Nội dung giỏ hàng: ");
//        FileUtil.readFromFile(cart.toString());
//        if(cart.size() == 0){
//            System.out.println("Giỏ hàng rỗng!");
//        }else{
//            for (Cart cart1 : cart){
//                System.out.println();
//            }
//        }
//
//    }

    private void calculateTotal(){
        double total =  0;
        for (Cart cart1 : cart){
            total += cart1.getPrice();
        }
        System.out.println("total price: " + total);
    }


}

