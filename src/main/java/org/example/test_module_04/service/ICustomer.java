package org.example.test_module_04.service;

import org.example.test_module_04.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ICustomer  extends IService<Customer> {
    Page<Customer> findByName(String name, PageRequest of);

}
