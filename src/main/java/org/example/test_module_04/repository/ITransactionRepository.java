package org.example.test_module_04.repository;

import jakarta.transaction.Transaction;
import org.example.test_module_04.entity.Customer;
import org.example.test_module_04.entity.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transactions, Long> {

    @Query(value = "SELECT * FROM transactions t WHERE t.customer.name LIKE %:name% AND t.type = :type", nativeQuery = true)
    List<Transactions> findTransactionsByCustomerNameAndType(@Param("name") String name, @Param("type") String type);
}
