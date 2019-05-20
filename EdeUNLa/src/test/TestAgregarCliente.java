package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;
import funciones.Funciones;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apellido = "Rivero";
		String nombre= "tu nombre" ;
		int documento=35000000;
		GregorianCalendar fechaDeNacimiento = new GregorianCalendar();//Funciones.traerFecha(1996, 10, 17); // tu fecha de nacimiento
		ClienteABM abm= new ClienteABM();
		/*try {*/
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
		/*}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/

		
	}

}
