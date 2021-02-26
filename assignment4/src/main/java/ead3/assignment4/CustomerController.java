package ead3.assignment3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ead3.assignment3.Customer;
import ead3.assignment3.CustomerService;

//creating RestController
@RestController
public class CustomerController {
    //autowired the StudentService class
    @Autowired
    CustomerService customerService;

    //creating a get mapping that retrieves all the customers detail from the database
    @GetMapping("/customer")
    private List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/customer/{id}")
    private Customer getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/customer/{id}")
    private void deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/customer")
    private int saveCustomer(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
        return customer.getId();
    }

}
