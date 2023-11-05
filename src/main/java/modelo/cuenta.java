package modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class cuenta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "activa")
    private boolean activa;
	@Column(name = "numero_cuenta")
    private String numeroCuenta;
	@Column(name = "saldo")
    private double saldo;

    @OneToOne
    @JoinColumn(name = "id_tipo_cuenta")
    private tipoCuenta tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private cliente cliente;

    @OneToMany(mappedBy = "cuenta")
    private List<movimiento> movimientos;
}
