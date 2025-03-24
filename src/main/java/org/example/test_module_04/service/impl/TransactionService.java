package org.example.test_module_04.service.impl;

import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.example.test_module_04.entity.Transactions;
import org.example.test_module_04.repository.ITransactionRepository;
import org.example.test_module_04.service.ITransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransaction {

    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public List<Transactions> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Transactions s) {
        transactionRepository.save(s);
    }

    @Override
    public void update(long id, Transactions s) {

    }

    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);

    }

    @Override
    public Transactions findById(long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public List<Transactions> findByName(String name) {
        return List.of();
    }

    public List<Transactions> findByTypeAndCustomer(String type, String name) {
        return transactionRepository.findTransactionsByCustomerNameAndType(type, name);
    }
}
