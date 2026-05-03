package com.gimnasio.gimnasio_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;
    private Boolean activo;

    @PrePersist
    public void init() {
        this.fechaRegistro = LocalDate.now();
        this.activo = true;
    }
}