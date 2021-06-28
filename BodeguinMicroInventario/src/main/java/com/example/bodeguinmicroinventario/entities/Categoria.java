package com.example.bodeguinmicroinventario.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@JsonPropertyOrder({"nombre","descripcion"})
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "categoria",uniqueConstraints = {@UniqueConstraint(name="cateogria_nombre_unique",columnNames = "nombre")})
public class Categoria {
    @Id
    @SequenceGenerator(name = "categoria_sequence",sequenceName = "categoria_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "categoria_sequence")
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="nombre",nullable = false,columnDefinition = "TEXT")
    private String nombre;
    @Column(name="descripcion",nullable = false,columnDefinition = "TEXT")
    private String descripcion;
    /*@OneToMany(
            mappedBy = "categoria",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )*/
    //private List<Producto> productos= new ArrayList<>();
}
