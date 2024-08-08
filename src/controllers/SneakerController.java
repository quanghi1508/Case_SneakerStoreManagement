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
    private List<Product> carts;
    private List<User> users;

    public SneakerController() {
        products = loadProducts();
        customers = loadCustomers();
        employees = loadEmployees();
        users = loadUsers();
        carts = new ArrayList<Product>();
    }


    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        List<String> lines = FileUtil.readFromFile(USER_FILE);
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
        String dateofbirth;
        while (true) {
            System.out.print("Ngày sinh (dd/MM/yyyy): \n");
            dateofbirth = scanner.nextLine();
            if (InputValidator.isValidDate(dateofbirth)) {
                break;
            } else {
                System.out.println("Sai định dạng. Vui lòng nhập đúng định dạng dd/MM/yyyy.");
            }
        }
        String email;
        while (true) {
            System.out.print("Email: \n");
            email = scanner.nextLine();
            if (InputValidator.isValidEmail(email)) {
                break;
            } else {
                System.out.println("Định dạng email không hợp lệ. Phải chứa '@' và tên miền hợp lệ.");
            }
        }
        String phone;
        while (true) {
            System.out.print("Số điện thoại (bắt đầu bằng 09 tối đa 10 số): \n");
            phone = scanner.nextLine();
            if (InputValidator.isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Sai định dạng! Vui lòng nhập đúng định dạng bắt đầu bằng 09 tối đa 10 số: ");
            }
        }
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        User newUser = new User(name, dateofbirth, email, phone, username, password);
        users.add(newUser);
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
                    deleteEmployees();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
    private void displayEmployee(){
        if(employees.size() != 0){
            for (Employee employee : employees){
                System.out.println(employee);
        }
        }else{
            System.out.println("Danh sách nhân viên rỗng!!!");
        }

    }
    private void addNewEmployee(){
        System.out.println("========= Thêm Nhân Viên =========");
        String code;
        while (true) {
            System.out.print("Mã nhân viên (NV-XXX): \n");
            code = scanner.nextLine();
            if (InputValidator.isValidEmployeeID(code)) {
                break;
            } else {
                System.out.println("Định dạng ID không hợp lệ. Phải là NV-XXX trong đó XXX là chữ số.");
            }
        }
        System.out.println("Tên: ");
        String name = scanner.nextLine();
        String dateofbirth;
        while (true) {
            System.out.print("Enter Employee Birth Date (dd/MM/yyyy): ");
            dateofbirth = scanner.nextLine();
            if (InputValidator.isValidDate(dateofbirth)) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter in dd/MM/yyyy.");
            }
        }
        String gender;
        while (true) {
            System.out.print("Enter Employee Gender (nam/nữ): ");
            gender = scanner.nextLine();
            if (InputValidator.isValidGender(gender)) {
                break;
            } else {
                System.out.println("Invalid gender. Please enter 'nam' or 'nữ'.");
            }
        }
        String cccd;
        while (true) {
            System.out.print("Enter Employee CCCD (must start with 079 and have 12 digits): ");
            cccd = scanner.nextLine();
            if (InputValidator.isValidCCCD(cccd)) {
                break;
            } else {
                System.out.println("Invalid CCCD format. Must start with 079 and have 12 digits.");
            }
        }
        String phone;
        while (true) {
            System.out.print("Enter Employee Phone Number (must start with 09 and have 10 digits): ");
            phone = scanner.nextLine();
            if (InputValidator.isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Invalid phone number format. Must start with 09 and have 10 digits.");
            }
        }
        System.out.println("Vị trí: ");
        String position = scanner.nextLine();
        Employee newEmployee = new Employee( code,  name,  dateofbirth,  gender,  cccd,  phone,  position);
        employees.add(newEmployee);
        FileUtil.writeToFile(EMPLOYEE_FILE, newEmployee.convertData());
        System.out.println("Đăng ký thành công!");

    }
    private void deleteEmployees(){
        System.out.println("========== Xoá Nhân Viên =============");
        System.out.println("Nhập mã nhân viên muốn xóa: ");
        String code = scanner.nextLine();
        Employee employeeToDelete = null;
        for( Employee employee : employees){
            if (employee.getCode().equals(code)){
                employeeToDelete = employee;
                break;

            }
        }
        if(employeeToDelete != null){
            employees.remove(employeeToDelete);
            saveEmployees();
            System.out.println("Nhân viên với mã "+code+" đã được xóa!");

        }else {
            System.out.println("Không tìm thấy nhân viên với mã "+code);
        }

    }


    private void saveEmployees() {
        List<String> lines = new ArrayList<>();
        for (Employee employee : employees) {
            lines.add(employee.convertData());
        }
        FileUtil.writeToFile(EMPLOYEE_FILE, String.valueOf(lines));
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
                    displayCustomer();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    private void displayCustomer(){
        if(customers.size() != 0){
            for (Customer customer : customers){
                System.out.println(customer);
            }
        }else{
            System.out.println("Danh sách khách hàng rỗng!!!");
        }

    }

    private void addNewCustomer(){
        System.out.println("========= Thêm Khách Hàng =========");
        String code;
        while (true) {
            System.out.print("Mã khách hàng (KH-XXX): \n");
            code = scanner.nextLine();
            if (InputValidator.isValidCustomerCode(code)) {
                break;
            } else {
                System.out.println("Định dạng ID không hợp lệ. Phải là NV-XXX trong đó XXX là chữ số.");
            }
        }
        System.out.println("Tên: ");
        String name = scanner.nextLine();
        String dateofbirth;
        while (true) {
            System.out.print("Ngày sinh (dd/MM/yyyy): \n");
            dateofbirth = scanner.nextLine();
            if (InputValidator.isValidDate(dateofbirth)) {
                break;
            } else {
                System.out.println("Định dạng ngày tháng hợp lệ. Vui lòng nhập dd/MM/yyyy.");
            }
        }
        String gender;
        while (true) {
            System.out.print("Giới tính (nam/nữ): \n");
            gender = scanner.nextLine();
            if (InputValidator.isValidGender(gender)) {
                break;
            } else {
                System.out.println("Giới tính không phù hợp. Vui lòng nhập 'nam' hoặc 'nữ'.");
            }
        }
        String phone;
        while (true) {
            System.out.print("Số điện thoai (bắt đầu bằng 09 và có 10 số: ");
            phone = scanner.nextLine();
            if (InputValidator.isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Định dạng số điện thoại không hợp lệ. Phải bắt đầu bằng 09 và có 10 chữ số.");
            }
        }
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        Customer newCustomer = new Customer( code,  name,  dateofbirth,  gender,  phone,  address);
        customers.add(newCustomer);
        FileUtil.writeToFile(CUSTOMER_FILE, newCustomer.convertData());
        System.out.println("Khách với mã khách hàng là "+code+" đã được thêm thành công!");

    }
    private void deleteCustomer(){
        System.out.println("========== Xoá Khách Hàng =============");
        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String code = scanner.nextLine();
        Customer customerToDelete = null;
        for(Customer customer : customers){
            if (customer.getCode().equals(code)){
                customerToDelete = customer;
                break;

            }
        }
        if(customerToDelete != null){
            employees.remove(customerToDelete);

            System.out.println("Nhân viên với mã "+code+" đã được xóa!");

        }else {
            System.out.println("Không tìm thấy nhân viên với mã "+code);
        }

    }


    private void saveCustomers() {
        List<String> lines = new ArrayList<>();
        for (Customer customer : customers) {
            lines.add(customer.convertData());
        }
        FileUtil.writeToFile(CUSTOMER_FILE, lines.toString());
    }

}
