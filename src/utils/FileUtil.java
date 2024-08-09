package utils;

import Utility.EmptyFileException;
import model.Customer;
import model.Employee;
import model.Product;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeUserToFile(String fileName, List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : users) {
                writer.write(user.convertData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUserFromFile(String fileName) throws EmptyFileException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                isEmpty = false;
                User user = User.fromCSV(line);
                users.add(user);
            }
            if (isEmpty) {
                throw new EmptyFileException("The file " + fileName + " is empty.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public static void writeProductToFile(String fileName, List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : products) {
                writer.write(product.convertData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readProductFromFile(String fileName) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = Product.fromCSV(line);
                products.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeEmployeeToFile(String fileName, List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : employees) {
                writer.write(employee.convertData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = Employee.fromCSV(line);
                employees.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public static void writeCustomerToFile(String fileName, List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Customer customer : customers) {
                writer.write(customer.convertData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomerFromFile(String fileName) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Customer customer = Customer.fromCSV(line);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
