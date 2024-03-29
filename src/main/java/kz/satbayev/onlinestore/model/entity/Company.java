package kz.satbayev.onlinestore.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
