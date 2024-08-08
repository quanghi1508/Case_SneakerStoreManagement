package controllers;

import java.util.Scanner;

public class DisplayAccountMenu {
    public static Scanner scanner = new Scanner(System.in);
    SneakerController sneekercontroller = new SneakerController();

        public void displayAccountMenu(){
            while(true){
                System.out.println(" ====================================");
                System.out.println("|      Sneaker Store Management      |");
                System.out.println("|                                    |");
                System.out.println("| 1. Đăng ký                         |");
                System.out.println("| 2. Đăng nhập                       |");
                System.out.println("| 3. Exit                            |");
                System.out.println(" ====================================");
                System.out.print("Choose a option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1:
                        if(sneekercontroller.register()){
                            sneekercontroller.displayMainMenu();
                        }
                        break;
                    case 2:
                        if(sneekercontroller.login()){
                            sneekercontroller.displayMainMenu();
                        }
                        break;
                    case 3:
                        System.out.println("Cảm ơn vì đã sử dụng ứng dụng");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                }
            }
        }
    }

