package org.clix.sem6.controller;

import org.clix.sem6.model.Customer;
import org.clix.sem6.service.SCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping
public class CusController {

    @Autowired
    private SCustomer sCustomer;

    // get all customers
    @GetMapping("/")
    public String getAllCustomers(Model model) {
        List<Customer> customers = sCustomer.getAllCustomers();
        model.addAttribute("customers", customers);
        return "index"; //
    }

    // get by Material Status "Married"
    @GetMapping("/married")
    public String getByMaterialStatusMarried(Model model) {
        List<Customer> customers = sCustomer.getByMaterialStatusMarried();
        model.addAttribute("customers", customers);
        return "married";
    }

    // get by Postal Code "05000"
    @GetMapping("/postalcode")
    public String getByPostalCode05000(Model model) {
        List<Customer> customers = sCustomer.getByPostalCode05000();
        model.addAttribute("customers", customers);
        return "postalcode";
    }

    // post a customer
    @PostMapping("/postcustomer")
    public String postCustomer(@ModelAttribute Customer customer, Model model) {
        Customer savedCustomer = sCustomer.postCustomer(customer);
        model.addAttribute("customer", savedCustomer);
        return "redirect:/"; // Redirige a la página principal después de guardar el cliente
    }

    // show form to create or edit a customer
    @GetMapping({"/create", "/edit/{id}"})
    public String showForm(@PathVariable(required = false) UUID id, Model model) {
        Customer customer = (id != null) ? sCustomer.getCustomerById(id) : new Customer();
        model.addAttribute("customer", customer);
        return "post";
    }


    // delete a customer by id
    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable UUID id) {
        sCustomer.deleteCustomerById(id);
        return "redirect:/";
    }


}
