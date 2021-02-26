package ead3.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SalesManagement {
    static List<Customer> customers = new ArrayList<>();
    static List<Services> services = new ArrayList<>();
    static List<Products> products = new ArrayList<>();

    @Autowired
    CustomerService customerService;


    public void fillList() {
        //autowired the StudentService class
        for (Customer customer : customerService.getAllCustomer()) {
            customers.add(customer);
        }
//        for(int i = 1; i < customerService.getAllCustomer().size(); i++){
//            customers.add(customerService.getAllCustomer().get(i));
//        }
    }

    public static boolean checkCustId(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    public static String custNameSurname(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                String str = customers.get(i).getFirst_name() + " " + customers.get(i).getLast_name();
                return str;
            }
        }
        return null;
    }

    public static void addToBill(int choice, int custId) {
        if (choice < 7) {
            for (int i = 0; i < services.size(); i++) {
                if (choice == services.get(i).getId()) {
                    if (customers.get(custId - 1).getMembership().isEmpty())
                        DiscountRate.setTotalSum(DiscountRate.getTotalSum() + services.get(i).getPrice());
                    else
                        DiscountRate.discountService(services.get(i).getPrice(), customers.get(custId - 1).getMembership());

                }
            }
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            if (choice == products.get(i).getId()) {
                if (customers.get(custId - 1).getMembership().equals(""))
                    DiscountRate.setTotalSum(DiscountRate.getTotalSum() + products.get(i).getPrice());
                else
                    DiscountRate.discountProduct(products.get(i).getPrice());

            }
        }
    }


    public static List<Customer> getCustomers() {
        return customers;
    }

    public void printInfo() {
        System.out.println(customers);
    }

    public void setCustomers(List<Customer> customers) {
        SalesManagement.customers = customers;
    }

    public void setServices(List<Services> services) {
        SalesManagement.services = services;
    }

    public void setProducts(List<Products> products) {
        SalesManagement.products = products;
    }
}
