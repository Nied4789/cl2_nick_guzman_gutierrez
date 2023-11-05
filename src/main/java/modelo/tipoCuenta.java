package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class tipoCuenta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "descripcion")
	
    private String desc;

	@Column(name = "moneda")
    private String moneda;

    @OneToOne(mappedBy = "tipoCuenta")
    private cuenta cuenta;
}
