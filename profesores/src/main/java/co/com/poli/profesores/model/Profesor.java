package co.com.poli.profesores.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Column(name="documento_id")
    @Id
    private String documento;
    @Column(name="tipo_documento")
    private String tipoDocumento;
    @Column(name="nombre")
    private String nombre;
    @Column(name="email")
    private String email;
    @Column(name="telefono")
    private String telefono;

}
