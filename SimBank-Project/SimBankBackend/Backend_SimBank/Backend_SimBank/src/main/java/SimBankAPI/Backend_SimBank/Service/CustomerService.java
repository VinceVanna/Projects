package SimBankAPI.Backend_SimBank.Service;

import SimBankAPI.Backend_SimBank.Entity.Customer;
import SimBankAPI.Backend_SimBank.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer newCustomer){
        return customerRepository.save(newCustomer);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }
}
