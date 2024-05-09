package com.example.product.orders.model.domain;

import com.example.product.orders.model.service.ServiceException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotBlank
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String name;

    @NotNull
    @Min(value = 0, message = "Quantity should be greater than 0")
    private Integer quantity;

    public ProductEntity(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void updateProduct(OrderEntity orderEntity) {
        if (this.quantity < orderEntity.getQuantityOrdered()) {
            throw new ServiceException("Don't have quantity product");
        }
        this.quantity = this.quantity - orderEntity.getQuantityOrdered();
    }
}
