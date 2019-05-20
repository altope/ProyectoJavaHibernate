package test;

import java.time.LocalDate;

import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM prestamoABM = new PrestamoABM();
		ClienteABM clienteABM = new ClienteABM();
		try {
			prestamoABM.agregar(LocalDate.now(), 10.2, 10.2, 2, clienteABM.traerCliente(14000000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
