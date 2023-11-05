package pruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.cliente;
import modelo.cuenta;
import modelo.movimiento;
import modelo.rol;
import modelo.tipoCuenta;

public class test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		
        rol rol = new rol();
        rol.setDesc("titualar");
        rol.setActivo(true);

       

        manager.persist(rol);
        

        
        cliente cli = new cliente();
        cli.setApeMaterno("gutierrez");
        cli.setApePaterno("guzman");
        cli.setNom("nick");
        cli.setCuentas(new ArrayList());
        cli.setRoles(new ArrayList());

        
        cli.getRoles().add(rol);
        manager.persist(cli);

        
        cuenta cuent = new cuenta();
        cuent.setNumeroCuenta("455782456945");
        cuent.setSaldo(200000d);
        cuent.setActiva(true);

        tipoCuenta tipoCuent = new tipoCuenta();
        tipoCuent.setDesc("CUENTA SUELDO");
        tipoCuent.setMoneda("soles");

        movimiento movimiento = new movimiento();
        movimiento.setDesc("Deposito mensual");
        movimiento.setFecha(LocalDate.now());
        movimiento.setMonto(1500d);

        
        cuent.setTipoCuenta(tipoCuent);
        cuent.setCliente(cli);
        movimiento.setCuenta(cuent);

        
        manager.persist(cuent);
        manager.persist(tipoCuent);
        manager.persist(movimiento);

        tx.commit();

        List<cliente> lista = manager.createQuery("from cliente", cliente.class).getResultList();
        for (cliente c : lista) {
            System.out.println(c);
        }

	}

}
