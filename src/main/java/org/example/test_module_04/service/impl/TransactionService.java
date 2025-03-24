package org.example.test_module_04.service.impl;

import org.example.test_module_04.entity.Transactions;
import org.example.test_module_04.repository.ITransactionRepository;
import org.example.test_module_04.service.ITransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public void save(Transactions s) {
        transactionRepository.save(s);
    }

    @Override
    public void update(long id, Transactions s) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Transactions findById(long id) {
        return null;
    }

    @Override
    public List<Transactions> findByName(String name) {
        return List.of();
    }
}
