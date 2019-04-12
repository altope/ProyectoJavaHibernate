package negocio;

import dao.PrestamoDao;

import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();
	
	public Prestamo traerPrestamo( long idPrestamo) throws Exception{
	// Implementar : si no existe el prestamo lanzar la excepción
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if(p==null){
			throw new Exception("No existe el Prestamo solicitado");
		}
		return p;
	}
	
	/******   ALTA  ******/
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente)throws Exception{
		// consultar si existe un cliente con el mismo dni , si existe arrojar la Excepcion
		if(cliente == null){
			throw new Exception("No existe el cliente");
		}
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		
		return dao.agregar(p);
	}
	
	/******   MODIFICAR  PRESTAMO  ******/
	public void modificar(Prestamo p)throws Exception{
		if(p == null){
			throw new Exception("No existe el prestamo");
		}
		dao.actualizar(p);
	}
	
	public List<Prestamo> traerPrestamo(Cliente c) { 
		return dao.traerPrestamo(c);
	}

	public List<Prestamo> traerPrestamo() {
		return dao.traerPrestamo();
	}
	
	
	/** Pendiente implementar 
	 *  Alta   y   Modificar 
	 **/
	
}





