package com.enesharman.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "picUrl", columnDefinition = "nvarchar(255)")
    private String picUrl;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToOne(mappedBy = "food")
    private FoodAnalytic foodAnalytic;

    @OneToMany(mappedBy = "food")
    private List<Order> orders;
}
