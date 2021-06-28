package com.example.bodeguinmicroinventario.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@ApiModel(description = "Informacion del producto")
@JsonPropertyOrder({"nombre","precio","stock"})
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= " Producto", uniqueConstraints = {@UniqueConstraint(name="producto_nombre_unique",
        columnNames="nombre")
})
@Entity
public class Producto {
    @Id
    @SequenceGenerator(name="producto_sequence",sequenceName = "producto_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_sequence")
    @Column(name="id",nullable = false)
    private Long id;

    @Column(name = "Nombre",nullable = false)
    private String nombre;

    /*@Column(name = "precio",nullable = false)
    private Integer precio;

    @Column(name = "stock",nullable = false)
    private Integer stock;*/

    @ManyToOne
    @JoinColumn(
            name="categoria_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey =@ForeignKey(
                    name= "categoria_producto_fk"
            )
    )
    private Categoria categoria;
    /*@OneToMany(
            mappedBy = "producto",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Inventario> Inventario= new ArrayList<>();*/
}
