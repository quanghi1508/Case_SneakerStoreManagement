package controllers;

import Utility.EmptyFileException;
import model.*;
import utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SneakerController {
    private static final String CUSTOMER_FILE = "src/data/customers.csv";
    private static final String EMPLOYEE_FILE = "src/data/employees.csv";
    private static final String CART_FILE = "src/data/cart.csv";
    private static final String PRODUCT_FILE = "src/data/products.csv";
    private static final String USER_FILE = "src/data/users.csv";

    private List<Product> products;
    private List<Customer> customers;
    private List<Employee> employees;
    private List<Product> carts;
    public List<User> users;

    public SneakerController() throws EmptyFileException {
        products = loadProducts();
        employees = loadEmployees();
        customers = loadCustomers();
        users = loadUsers();
        carts = new ArrayList<Product>();
    }


    private List<User> loadUsers() throws EmptyFileException {

        return FileUtil.readUserFromFile(USER_FILE);
    }

    public List<Product> loadProducts() {
        return FileUtil.readProductFromFile(PRODUCT_FILE);
    }

    public List<Customer> loadCustomers() {
        return FileUtil.readCustomerFromFile(CUSTOMER_FILE);
    }

    public List<Employee> loadEmployees() {
        return FileUtil.readEmployeeFromFile(EMPLOYEE_FILE);
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
        FileUtil.writeUserToFile(USER_FILE, users);
        System.out.println("Đăng ký thành công!");
        return true;
    }

    public boolean login() {
        while (true) {
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


    public void displayMainMenu() {
        while (true) {
            System.out.println(" ============================================");
            System.out.println("|      Sneaker Store Management              |");
            System.out.println("|                                            |");
            System.out.println("| 1. Quản lí nhân viên                       |");
            System.out.println("| 2. Quản lí khách hàng                      |");
            System.out.println("| 3. Giỏ hàng                                |");
            System.out.println("| 4. Quản lí bán hàng                        |");
            System.out.println("| 5. Hiển thị danh sách sản phẩm và người mua|");
            System.out.println("| 6. Exit                                    |");
            System.out.println(" =============================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
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
                    saleManagement();
                    break;
                case 5:
                    displayProductCustomer();
                    break;
                    case 6:
                        return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    public void displayEmployeeManagement() {
        while (true) {
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
            switch (choice) {
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

    private void displayEmployee() {
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("Danh sách nhân viên rỗng!!!");
        }

    }

    private void addNewEmployee() {
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
            System.out.print("Enter Employee Birth Date (dd/MM/yyyy): \n");
            dateofbirth = scanner.nextLine();
            if (InputValidator.isValidDate(dateofbirth)) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter in dd/MM/yyyy.");
            }
        }
        String gender;
        while (true) {
            System.out.print("Enter Employee Gender (nam/nữ): \n");
            gender = scanner.nextLine();
            if (InputValidator.isValidGender(gender)) {
                break;
            } else {
                System.out.println("Invalid gender. Please enter 'nam' or 'nữ'.");
            }
        }
        String cccd;
        while (true) {
            System.out.print("Enter Employee CCCD (must start with 079 and have 12 digits): \n");
            cccd = scanner.nextLine();
            if (InputValidator.isValidCCCD(cccd)) {
                break;
            } else {
                System.out.println("Invalid CCCD format. Must start with 079 and have 12 digits.");
            }
        }
        String phone;
        while (true) {
            System.out.print("Enter Employee Phone Number (must start with 09 and have 10 digits): \n");
            phone = scanner.nextLine();
            if (InputValidator.isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Invalid phone number format. Must start with 09 and have 10 digits.");
            }
        }
        System.out.println("Vị trí: ");
        String position = scanner.nextLine();
        Employee newEmployee = new Employee(code, name, dateofbirth, gender, cccd, phone, position);
        employees.add(newEmployee);
        FileUtil.writeEmployeeToFile(EMPLOYEE_FILE, employees);
        System.out.println("Đăng ký thành công!");

    }

    private void deleteEmployees() {
        System.out.println("========== Xoá Nhân Viên =============");
        System.out.println("Nhập mã nhân viên muốn xóa: ");
        String code = scanner.nextLine();
        Employee employeeToDelete = null;
        for (Employee employee : employees) {
            if (employee.getCode().equals(code)) {
                employeeToDelete = employee;
                break;

            }
        }
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            System.out.println(employees);
            saveEmployees();
            System.out.println("Nhân viên với mã " + code + " đã được xóa!");

        } else {
            System.out.println("Không tìm thấy nhân viên với mã " + code);
        }

    }


    private void saveEmployees() {
        List<String> lines = new ArrayList<>();
        System.out.println(employees);
        for (Employee employee : employees) {
            lines.add(employee.convertData());
        }
        FileUtil.writeEmployeeToFile(EMPLOYEE_FILE, employees);
    }

    public void displayCustomerManagement() {
        while (true) {
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
            switch (choice) {
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

    private void displayCustomer() {
        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("Danh sách khách hàng rỗng!!!");
        }

    }

    private void addNewCustomer() {
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
            System.out.print("Số điện thoai (bắt đầu bằng 09 và có 10 số: \n");
            phone = scanner.nextLine();
            if (InputValidator.isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Định dạng số điện thoại không hợp lệ. Phải bắt đầu bằng 09 và có 10 chữ số.");
            }
        }
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        Customer newCustomer = new Customer(code, name, dateofbirth, gender, phone, address);
        customers.add(newCustomer);
        System.out.println(customers);
        FileUtil.writeCustomerToFile(CUSTOMER_FILE, customers);
        System.out.println("Khách với mã khách hàng là " + code + " đã được thêm thành công!");

    }

    private void deleteCustomer() {
        System.out.println("========== Xoá Khách Hàng =============");
        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String code = scanner.nextLine();
        Customer customerToDelete = null;
        for (Customer customer : customers) {
            if (customer.getCode().equals(code)) {
                customerToDelete = customer;
                break;

            }
        }
        if (customerToDelete != null) {
            employees.remove(customerToDelete);

            System.out.println("Nhân viên với mã " + code + " đã được xóa!");

        } else {
            System.out.println("Không tìm thấy nhân viên với mã " + code);
        }

    }


    private void saveCustomers() {
        List<String> lines = new ArrayList<>();
        for (Customer customer : customers) {
            lines.add(customer.convertData());
        }
        FileUtil.writeCustomerToFile(CUSTOMER_FILE, customers);
    }

    public List<User> getUsers() {
        return users;
    }

    public void saleManagement() {
        System.out.println("Product List:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        // Chọn sản phẩm
        System.out.print("Please choose a product (enter number): ");
        int productChoice = scanner.nextInt();
        Product selectedProduct = products.get(productChoice - 1);
        System.out.println("Customer List:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }

        // Chọn khách hàng
        System.out.print("Please choose a customer (enter number): ");
        int customerChoice = scanner.nextInt();
        Customer selectedCustomer = customers.get(customerChoice - 1);

        // Lưu sản phẩm và khách hàng vào file
        saveProductCustomer(selectedProduct, selectedCustomer, "src/data/sale.csv");
    }

    public static void saveProductCustomer(Product product, Customer customer, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(product.convertData() + "," + customer.convertData());
            writer.newLine();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayProductCustomer() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/sale.csv"))) {
            String line;
            System.out.println("Product and Customer List:");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 12) {  // Kiểm tra xem dòng có đủ 11 phần tử không
                    // Phân tích dữ liệu sản phẩm
                    String productId = data[0];
                    String productName = data[1];
                    String productSize = data[2];
                    String productQuantity = data[3];
                    String productCondition = data[4];
                    String productPrice = data[5];

                    // Phân tích dữ liệu khách hàng
                    String customerId = data[6];
                    String customerName = data[7];
                    String customerDob = data[8];
                    String customerGender = data[9];
                    String customerPhone = data[10];
                    String customerAddress = data[11];

                    // Hiển thị thông tin sản phẩm và khách hàng
                    System.out.println("Product: [code: " + productId + ", Name: " + productName + ", Size: " + productSize +
                            ", Quantity: " + productQuantity + ", Condition: " + productCondition + ", Price: " + productPrice + "]");
                    System.out.println("Customer: [ID: " + customerId + ", Name: " + customerName + ", DOB: " + customerDob +
                            ", Gender: " + customerGender + ", Phone: " + customerPhone + ", Address: " + customerAddress);
                    System.out.println();
                } else {
                    System.out.println("Malformed line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
