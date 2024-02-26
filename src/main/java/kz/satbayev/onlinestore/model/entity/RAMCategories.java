    package kz.satbayev.onlinestore.model.entity;


    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import javax.persistence.*;

    @Entity
    @Table(name = "t_rams")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class RAMCategories {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "price")
        private Long price;

    }
