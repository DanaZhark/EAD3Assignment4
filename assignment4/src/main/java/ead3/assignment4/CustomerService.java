package ead3.assignment3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ead3.assignment3.Customer;
import ead3.assignment3.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    //getting all customer records
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<Customer>();
        repository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    //getting a specific record
    public Customer getCustomerById(int id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Customer customer) {
        repository.save(customer);
    }

    //deleting a specific record
    public void delete(int id) {
        repository.deleteById(id);
    }
}
