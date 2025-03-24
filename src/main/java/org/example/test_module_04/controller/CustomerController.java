//package org.example.test_module_04.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.example.test_module_04.entity.Customer;
//import org.example.test_module_04.service.impl.CustomerService;
//import org.example.test_module_04.service.impl.TransactionService;
//import org.example.test_module_04.util.ValidationMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//
//@Controller
//@RequestMapping("/customers")
//public class CustomerController {
//    @Autowired
//    private CustomerService CustomerService;
//
////    @Autowired
////    private TransactionService transactionService;
//
//
//    @GetMapping("/list")
//    public String showList(Model model,
//                           @RequestParam(value = "name", defaultValue = "") String name,
//                           @RequestParam Map<String, String> search,
//                           @RequestParam(name = "page", defaultValue = "1") int page, HttpServletRequest request
//    ) {
//        try {
//
//            String url = request.getRequestURI();
//            Page<Customer> listCustomers = CustomerService.findByName(name, PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "code")));
//            search.remove("page");
//            String queryParams = search.entrySet().stream()
//                    .map(entry -> entry.getKey() + "=" + entry.getValue())
//                    .collect(Collectors.joining("&"));
////            model.addAttribute("page", page - 1);
//            model.addAttribute("url", url);
//            model.addAttribute("queryParams", queryParams);
////            model.addAttribute("message",null);
//            model.addAttribute("listCustomers", listCustomers);
//        } catch (Exception e) {
//            System.err.println("Error fetching Customers: " + e.getMessage());
//            model.addAttribute("errorMessage", "Gặp lỗi trong quá trình truy xuất database");
//            return "list";
//        }
//        return "list";
//    }
//
////
//
//    @GetMapping("/createView")
//    public String createCustomer(Model model,
//                                 @ModelAttribute("listErrorMes") Map<String, String> listErrorMes
//    ) {
//        if (listErrorMes == null || listErrorMes.isEmpty()) {
//            listErrorMes = new HashMap<>();
//        }
////        List<CustomerGroup> CustomerGroups = CustomerGroupService.getAll();
////        List<Supplier> suppliers = supplierService.getAll();
//        model.addAttribute("Customer", new Customer());
////        model.addAttribute("CustomerGroups", CustomerGroups);
////        model.addAttribute("suppliers", suppliers);
//        model.addAttribute("listErrorMes", listErrorMes);
//        return "create";
//
//    }
//
//    @PostMapping("/created")
//    public String createCustomer(
//            @Validated @ModelAttribute("Customer") Customer Customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasErrors()) {
//            System.out.println(">>>>>>>>>>>>>>" + bindingResult.getAllErrors());
//            Map<String, String> listErrorsMes = ValidationMessage.getErrorMes(bindingResult);
//            redirectAttributes.addFlashAttribute("listErrorMes", listErrorsMes);
//            return "redirect:/Customers/createView";
//        }
//        Customer.setCreatedAt(LocalDateTime.now());
//        CustomerService.save(Customer);
//        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
//        return "redirect:/Customers/list";
//    }
//
//}
//
//
//
//
