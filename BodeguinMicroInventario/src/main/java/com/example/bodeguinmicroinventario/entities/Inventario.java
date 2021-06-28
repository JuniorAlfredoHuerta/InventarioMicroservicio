package com.example.bodeguinmicroinventario.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= " inventario", uniqueConstraints = {@UniqueConstraint(name="inventario_id_unique",
        columnNames="id")
})
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    @Id
    @SequenceGenerator(name="inventario_sequence",sequenceName = "inventario_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventario_sequence")
    @Column(name="id",nullable = false)
    private Long id;
    @Column(
            name="stock",
            nullable = false
    )
    private Integer stock;
    @Column(
            name="precio",
            nullable = false
    )
    private Integer precio;
    @ManyToOne
    @JoinColumn(
            name="productoid",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="productoIdFk"
            )
    )
    private Producto productoid;
    @Column(name = "bodegaid")
    private String bodegaid;



}
