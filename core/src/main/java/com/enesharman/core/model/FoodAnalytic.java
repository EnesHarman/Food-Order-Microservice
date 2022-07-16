package com.enesharman.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodAnalytic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "last_order_time")
    private LocalDateTime lastOrderTime;

    @OneToOne()
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "order_column")
    private int orderCount;
}
