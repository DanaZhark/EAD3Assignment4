package ead3.assignment3;

import com.sun.security.ntlm.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class Assignment3Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Assignment3Application.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //initialize some scanner
        Scanner in = new Scanner(System.in);

        SalesManagement sale = context.getBean("sale", SalesManagement.class);

        while (true) {

            sale.fillList();
            sale.printInfo();


            System.out.println("- - - - - - BEAUTY SALON CINDERELLA - - - - - - ");
            System.out.print("- - Enter customer id : ");
            int customerId = in.nextInt();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - ");


            if (sale.checkCustId(customerId)) {
                DiscountRate.setTotalSum(0.0);

                int choice = -1;

                while (choice != 0) {
                    System.out.println("- - - Welcome, " + sale.custNameSurname(customerId) + "! - - -");
                    System.out.println("- - - What would you like? - - -");
                    System.out.println("- - - - - - SERVICES - - - - - -");
                    System.out.println("- - - - - HAIR STYLING - - - - -");
                    System.out.println("1. Wash and Cut   - - - - - - 10.00$");
                    System.out.println("2. Men's Haircut  - - - - - - 10.00$");
                    System.out.println("3. Children's Cut - - - - - - 10.00$");
                    System.out.println("- - - - - -  NAILS   - - - - - -");
                    System.out.println("4. Manicure       - - - - - - 10.00$");
                    System.out.println("5. Pedicure       - - - - - - 10.00$");
                    System.out.println("6. Design Art    - - - - - - 10.00$");
                    System.out.println("- - - - - - PRODUCTS - - - - - -");
                    System.out.println("7. Shampoo      - - - - - - - 10.00$");
                    System.out.println("8. Conditioner  - - - - - - - 10.00$");
                    System.out.println("9. Hair Dye     - - - - - - - 10.00$");
                    System.out.println("10. Hair Gel     - - - - - - - 10.00$");
                    System.out.println("0. Exit             - -");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - ");
                    DiscountRate.printTotalSum();

                    choice = in.nextInt();
                    in.nextLine();
                    switch (choice) {
                        case 1:
                            sale.addToBill(1, customerId);
                            break;
                        case 2:
                            sale.addToBill(2, customerId);
                            break;
                        case 3:
                            sale.addToBill(3, customerId);
                            break;
                        case 4:
                            sale.addToBill(4, customerId);
                            break;
                        case 5:
                            sale.addToBill(5, customerId);
                            break;
                        case 6:
                            sale.addToBill(6, customerId);
                            break;
                        case 7:
                            sale.addToBill(7, customerId);
                            break;
                        case 8:
                            sale.addToBill(8, customerId);
                            break;
                        case 9:
                            sale.addToBill(9, customerId);
                            break;
                        case 10:
                            sale.addToBill(10, customerId);
                            break;
                    }
                }
            } else {
                System.out.println("Sorry, there is no customer with that id. Try again.");
                System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            }

        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Spring Boot Application");
    }
}
