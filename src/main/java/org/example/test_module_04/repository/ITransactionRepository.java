package org.example.test_module_04.repository;

import jakarta.transaction.Transaction;
import org.example.test_module_04.entity.Customer;
import org.example.test_module_04.entity.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transactions, Long> {

    Page<Transactions> findAll(Specification<Customer> spec, Pageable page);
}
