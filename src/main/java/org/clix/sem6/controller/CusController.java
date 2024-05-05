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
        model.addAttribute("totalSalary", sCustomer.totalSalary());
        model.addAttribute("totalEmployees", sCustomer.totalEmployees());

        model.addAttribute("customer", new Customer());
        return "index"; //
    }


    // post a customer
    @PostMapping("/postcustomer")
    public String postCustomer(@ModelAttribute Customer customer, Model model) {
        Customer savedCustomer = sCustomer.postCustomer(customer);
        model.addAttribute("customer", savedCustomer);
        return "redirect:/"; // Redirige a la página principal después de guardar el cliente
    }

    // show form to create or edit a customer
    @GetMapping({"/edit/{id}"})
    public String showForm(@PathVariable(required = false) UUID id, Model model) {
        Customer customer = (id != null) ? sCustomer.getCustomerById(id) : new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("edit", true); // Add this line
        return "index";
    }


    // delete a customer by id
    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable UUID id) {
        sCustomer.deleteCustomerById(id);
        return "redirect:/";
    }


}
