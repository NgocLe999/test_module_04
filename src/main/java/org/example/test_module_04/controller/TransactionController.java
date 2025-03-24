package org.example.test_module_04.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.example.test_module_04.entity.Customer;
import org.example.test_module_04.entity.Transactions;
import org.example.test_module_04.service.impl.CustomerService;
import org.example.test_module_04.service.impl.TransactionService;
import org.example.test_module_04.util.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(name = "page", defaultValue = "1") int page, HttpServletRequest request
    ) {
        try {
            List<Transactions>listTransaction = transactionService.getAll();
            model.addAttribute("listTransaction", listTransaction);
        } catch (Exception e) {
            System.err.println("Error fetching Customers: " + e.getMessage());
            model.addAttribute("errorMessage", "Gặp lỗi trong quá trình truy xuất database");
            return "list";
        }
        return "list";
    }


   @GetMapping("/createView")
    public String createCustomer(Model model,
                                 @ModelAttribute("listErrorMes") Map<String, String> listErrorMes
    ) {
        if (listErrorMes == null || listErrorMes.isEmpty()) {
            listErrorMes = new HashMap<>();
        }

        List<Customer> customers = customerService.getAll();
        model.addAttribute("transactions", new Transactions());
        model.addAttribute("customers",customers);
        model.addAttribute("listErrorMes", listErrorMes);
        return "create";

    }


    @PostMapping("/created")
    public String createCustomer(
            @Validated @ModelAttribute("transactions") Transactions trans, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> listErrorsMes = ValidationMessage.getErrorMes(bindingResult);
            redirectAttributes.addFlashAttribute("listErrorMes", listErrorsMes);
            return "redirect:/trans/createView";
        }
        trans.setDateTransaction(String.valueOf(LocalDateTime.now()));
        transactionService.save(trans);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/trans/list";
    }

    @GetMapping(value = "/details/{id}")
    public String showView(Model model, @PathVariable("id") long id) {
        try {
            Transactions trans = transactionService.findById(id);
            if (trans == null) {
                model.addAttribute("message", "Thuốc không tồn tại trên hệ thống");
            }
            model.addAttribute("trans", trans);
        } catch (Exception e) {
            System.err.println("Error fetching medicines: " + e.getMessage());
            model.addAttribute("errorMessage", "Gặp lỗi trong quá trình truy xuất database");
        }
        return "details";
    }

}
