package SimBankAPI.Backend_SimBank.Controller;

import SimBankAPI.Backend_SimBank.Entity.Customer;
import SimBankAPI.Backend_SimBank.Repository.CustomerRepository;
import SimBankAPI.Backend_SimBank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/SimBank/Customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping("/getAllCustomers")
    public ResponseEntity getAllCustomers(){
        return ResponseEntity.ok(this.customerRepository.findAll());
    }

    @GetMapping("/getCustomerByID/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/NewCustomer")
    public Customer saveNewCustomer(@RequestBody Customer newCustomer) throws NoSuchAlgorithmException {

        //MessageDigest md = MessageDigest.getInstance("SHA-256");
        //byte hash[] = md.digest(newCustomer.getHashPassword().getBytes(StandardCharsets.UTF_8));
        //System.out.println(hash[])

        //newCustomer.setHashPassword(hash);
        newCustomer.setCreatedAt(LocalDateTime.now());
        newCustomer.setUpdatedAt(LocalDateTime.now());
        return customerService.saveCustomer(newCustomer);
    }

    @PutMapping("/UpdateCustomer/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        Customer oldCustomer = customerRepository.findById(id).get();
        oldCustomer.setFirstName(customer.getFirstName());
        oldCustomer.setLastName(customer.getLastName());
        oldCustomer.setUsername(customer.getUsername());
        oldCustomer.setHashPassword(customer.getHashPassword());
        oldCustomer.setStreetName(customer.getStreetName());
        oldCustomer.setCityName(customer.getCityName());
        oldCustomer.setStateName(customer.getStateName());
        oldCustomer.setPhoneNumber(customer.getPhoneNumber());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setUpdatedAt(LocalDateTime.now());
        return customerService.saveCustomer(oldCustomer);
    }

    @DeleteMapping("/DeleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        Customer customer = customerRepository.findById(id).get();
        customerService.deleteCustomer(customer);
        return "Removed Customer";
    }


    @CrossOrigin
    @PostMapping("/login")
    public String customerLogin(@RequestBody Customer customer){

        List<Customer> customerList = this.customerRepository.findAll();

        int i = 0;

        while( i < customerList.size()){

            if(((customerList.get(i).getUsername().equals(customer.getUsername())) && (customerList.get(i).getHashPassword().equals(customer.getHashPassword()))) == true){
                return "Logged In";
            }else if(((customerList.get(i).getUsername().equals(customer.getUsername())) && (customerList.get(i).getHashPassword().equals(customer.getHashPassword()))) == false){
                i++;
            }
        }
        return "The username or password do not match, please try again";
    }
}
