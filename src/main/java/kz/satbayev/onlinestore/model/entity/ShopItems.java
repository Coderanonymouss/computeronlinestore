package kz.satbayev.onlinestore.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",length = 200)
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne(fetch =FetchType.EAGER)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    private CoolerCategories coolerCategories;

    @ManyToOne(fetch = FetchType.EAGER)
    private MatrixCategories matrixCategories;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProcessorCategories processorCategories;

    @ManyToOne(fetch = FetchType.EAGER)
    private RAMCategories ramCategories;

    @ManyToOne(fetch = FetchType.EAGER)
    private VideoCardCategories videoCardCategories;
}
