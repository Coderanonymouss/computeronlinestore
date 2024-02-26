package kz.satbayev.onlinestore.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_coolers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CoolerCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;

}
