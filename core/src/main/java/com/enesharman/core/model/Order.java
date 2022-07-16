package com.enesharman.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address", columnDefinition = "varchar(100)")
    private String address;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @ManyToOne()
    @JoinColumn(name = "food_id")
    private Food food;
}
