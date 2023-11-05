package modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class movimiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "descripcion")
    private String desc;
	@Column(name = "fecha")
    private Date fecha;
	@Column(name = "monto")
    private double monto;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private cuenta cuenta;

	public void setFecha(LocalDate now) {
		LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.fecha = date;
		
	}

}
