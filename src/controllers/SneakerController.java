package controllers;

import java.util.Scanner;

public class SneakerController {
    public static Scanner scanner = new Scanner(System.in);
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
                    displayProductManagement();
                    break;
                case 4:
                    System.out.println("Cảm ơn vì đã sử dụng ứng dụng");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    private void displayEmployeeManagement(){
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

    private void displayCustomerManagement(){
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

    private void displayProductManagement(){
        
    }
}
