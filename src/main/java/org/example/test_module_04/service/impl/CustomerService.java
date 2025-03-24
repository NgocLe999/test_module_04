package org.example.test_module_04.service.impl;

import jakarta.persistence.EntityManager;
import org.example.test_module_04.entity.Customer;
import org.example.test_module_04.repository.ICustomerRepository;
import org.example.test_module_04.service.ICustomer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomer {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findByName(String name, PageRequest of) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer s) {

    }

    @Override
    public void update(long id, Customer s) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Customer findById(long id) {
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }
}
