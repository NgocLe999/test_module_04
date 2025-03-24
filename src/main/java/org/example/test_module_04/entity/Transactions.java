package org.example.test_module_04.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_transaction")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future(message = "Ngày hết hạn phải lớn hơn thời gian hiện tại")
    private LocalDate dateTransaction;

    @NotBlank(message = "Loại dịch vụ không được để trống")
    @Column(name = "type_service")
    private String type;

    @Column(name = "price")
    @NotNull(message = "Giá thuê không được để trống")
    @Min(value = 500000,message = "Đơn giá phải lớn hơn 500.000đ")
    private Integer price;

    @Column(name = "area")
    @NotNull(message = "Giá thuê không được để trống")
    @Min(value = 20,message = "Diện tích phải lớn hơn 20m2")
    private Integer area;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
