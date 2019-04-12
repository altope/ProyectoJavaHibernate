package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traerCliente( long idCliente){
		Cliente c = dao.traerCliente(idCliente);
		return c;
	}
	
	public Cliente traerCliente( int dni){
		Cliente c = dao.traerCliente(dni);
		return c;
	}
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento)throws Exception{
		// consultar si existe un cliente con el mismo dni , si existe arrojar la Excepcion
		if(traerCliente(dni) != null){
			throw new Exception("Ya existe un cliente con este dni");
		}
		Cliente c = new Cliente(apellido, nombre, dni,fechaDeNacimiento);
		return dao.agregar(c);
	}
	
	public void modificar(Cliente c)throws Exception{
		/* implementar antes de actualizar que no exista un cliente con el 
		 * mismo documento a modificar y con el mismo id, lanzar la Exception */
		if(traerCliente(c.getDni()) != null){
			throw new Exception("No se puede modificar el Cliente. El dni ya existe");
		}
		dao.actualizar(c);
	}
	
	public void eliminar( long idCliente)throws Exception{ /*en este caso es física en gral. no se se
		aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga
		dependencias*/
		Cliente c = dao.traerCliente(idCliente);
		// Implementar que si es null que arroje la excepción la Excepción
		if(c==null){
			throw new Exception("No existe el cliente a eliminar"); 
		}
		dao.eliminar(c);
	}
	
	public List<Cliente> traerCliente(){ 
		return dao.traerCliente();
	}
	
	public Cliente traerClienteYPrestamos(long idCliente){
		return dao.traerClienteYPrestamos( idCliente );
	}
}








