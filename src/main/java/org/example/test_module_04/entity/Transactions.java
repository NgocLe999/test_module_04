package org.example.test_module_04.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE transactions SET deleted_at = Now() WHERE id=?")
////@Where(clause = "deleted_at is null")
//@FilterDef(name = "notDeletedMGFilter")
//@Filter(name = "notDeletedMGFilter", condition = "deleted_at IS NULL")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Mã thuốc không được để trống")
    @Column(name = "date_transaction")
    private LocalDateTime dateTransaction;

    @NotBlank(message = "Loại dịch vụ không được để trống")
    @Column(name = "type_service")
    private String type;

    @NotBlank(message = "Giá thuê không được để trống")
    @Column(name = "price")
    private String price;

    @NotBlank(message = "Giá thuê không được để trống")
    @Column(name = "area")
    private String area;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
