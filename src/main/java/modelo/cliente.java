package modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "apellido_materno")
    private String apeMaterno;

    @Column(name = "apellido_paterno")
    private String apePaterno;

    @Column(name = "nombres")
    private String nom;

    @OneToMany(mappedBy = "cliente")
    private List<cuenta> cuentas;

    @ManyToMany
    @JoinTable(
        name = "cliente_rol",
        joinColumns = @JoinColumn(name = "id_cliente"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<rol> roles;

	@Override
	public String toString() {
		return "cliente [id=" + id + ", apeMaterno=" + apeMaterno + ", apePaterno=" + apePaterno + ", nombres="
				+ nom + ", cuentas=" + cuentas + ", roles=" + roles + "]";
	}
    
    

}
