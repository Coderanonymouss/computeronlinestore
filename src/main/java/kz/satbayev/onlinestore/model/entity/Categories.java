package kz.satbayev.onlinestore.model.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToOne(fetch = FetchType.EAGER)
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

    @Column(name = "price")
    private Long price;
}