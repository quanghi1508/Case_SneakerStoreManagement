package controllers;

import model.*;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SneakerController {
    private static final String CUSTOMER_FILE  = "src/data/customers.csv";
    private static final String EMPLOYEE_FILE = "src/data/employees.csv";
    private static final String CART_FILE = "src/data/cart.csv";
    private static final String PRODUCT_FILE = "src/data/products.csv";
    private static final String USER_FILE = "src/data/users.csv";

    private List<Product> products;
    private List<Customer> customers;
    private List<Employee> employees;
    private List<Cart> carts;
    private List<User> users;

    public SneakerController() {
        products = loadProducts();
        customers = loadCustomers();
        employees = loadEmployees();
        users = loadUsers();
        carts = loadCarts();
    }

    private List<Cart> loadCarts() {
        List<Cart> carts = new ArrayList<>();
        List<String> lines = FileUtil.readFromFile(CART_FILE);
        for (String line : lines) {
            carts.add(Cart.fromCSV(line));
        }
        return carts;
    }

    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        List<String> lines = FileUtil.readFromFile(USER_FILE);
        System.out.println(lines);
        if (lines.size() != 0) {
            for (String line : lines) {
                users.add(User.fromCSV(line));
            }
            return users;
        }
        return users;
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
    ShoppingCartController shoppingcart = new ShoppingCartController();
    public static Scanner scanner = new Scanner(System.in);

    public boolean register() {
        System.out.println("========= Đăng ký =========");
        System.out.println("Tên: ");
        String name = scanner.nextLine();
        System.out.println("Ngày sinh: ");
        String dateofbirth = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Số diện thoại: ");
        String phone = scanner.nextLine();
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        User newUser = new User(name, dateofbirth, email, phone, username, password);
        users.add(newUser);
        System.out.println(users);
        FileUtil.writeToFile(USER_FILE, newUser.convertData());
        System.out.println("Đăng ký thành công!");
        return true;
    }
    public boolean login(){
        while(true) {
            System.out.println("========= Đăng nhập =========");
            System.out.println("Username:");
            String username = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Đăng nhập thành công!");
                    return true;
                }
            }
            System.out.println("Đăng nhập không thành công! Sai username hoặc password vui lòng đăng nhập lại!");
        }
    }


    public void displayMainMenu(){
        while (true){
            System.out.println(" ====================================");
            System.out.println("|      Sneaker Store Management      |");
            System.out.println("|                                    |");
            System.out.println("| 1. Quản lí nhân viên               |");
            System.out.println("| 2. Quản lí khách hàng              |");
            System.out.println("| 3. Quản lí sản phẩm                |");
            System.out.println("| 4. Exit                            |");
            System.out.println(" ====================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    displayEmployeeManagement();
                    break;
                case 2:
                    displayCustomerManagement();
                    break;
                case 3:
                    shoppingcart.displayShoppingCartMenu();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    public void displayEmployeeManagement(){
        while (true){
            System.out.println(" ====================================");
            System.out.println("|        Employee Management         |");
            System.out.println("|                                    |");
            System.out.println("| 1. Hiển thị danh sách nhân viên    |");
            System.out.println("| 2. Thêm mới nhân viên              |");
            System.out.println("| 3. Xóa nhân viên                   |");
            System.out.println("| 4. Trở về menu chính               |");
            System.out.println(" ====================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
    private void displayEmployee(){
        for (Employee employee : employees){
            System.out.println(employee);
        }

    }

    private void addNewEmployee(){
        System.out.println("========= Thêm Nhân Viên =========");
        System.out.println("Mã nhân viên: ");
        String code = scanner.nextLine();
        System.out.println("Tên: ");
        String name = scanner.nextLine();
        System.out.println("Ngày sinh: ");
        String dayofbirth = scanner.nextLine();
        System.out.println("Giời tính: ");
        String gender = scanner.nextLine();
        System.out.println("cccd: ");
        String cccd = scanner.nextLine();
        System.out.println("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.println("Vị trí: ");
        String position = scanner.nextLine();
        Employee newEmployee = new Employee( code,  name,  dayofbirth,  gender,  cccd,  phone,  position);
        employees.add(newEmployee);
        FileUtil.writeToFile(EMPLOYEE_FILE, newEmployee.convertData());
        System.out.println("Đăng ký thành công!");

    }

    public void displayCustomerManagement(){
        while (true){
            System.out.println(" ====================================");
            System.out.println("|        Customer Management         |");
            System.out.println("|                                    |");
            System.out.println("| 1. Hiển thị danh sách khách hàng   |");
            System.out.println("| 2. Thêm mới khách hàng             |");
            System.out.println("| 3. Xóa khách hàng                  |");
            System.out.println("| 4. Trở về menu chính               |");
            System.out.println(" ====================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}
