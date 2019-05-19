package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.DatosContacto;

public class ClienteABM {
	private static ClienteABM instancia = null;//Patron Singleton
	
	protected ClienteABM() {}
	
	public static ClienteABM getInstance() {
		if(instancia==null) {
			instancia=new ClienteABM();
		}
		return instancia;
	}
	
	public int agregar(DatosContacto datos) throws Exception{
		Cliente c= new Cliente(datos);
		return ClienteDao.getInstance().agregar(c);
	}
	
	public void modificar(Cliente c) throws Exception{
		if(traer(c.getIdCliente()) == null) {
			throw new Exception("ERROR: no existe un cliente con ese id");
		}
		ClienteDao.getInstance().actualizar(c);
	}
	
	public void eliminar(long idCliente) throws Exception{ 
		Cliente c= ClienteDao.getInstance().traer(idCliente);
		if(c == null) throw new Exception("ERROR: no existe el cliente");
		ClienteDao.getInstance().eliminar(c);
	}
	
	public Cliente traer(long idCliente) {
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	public List<Cliente> traer(){
		return ClienteDao.getInstance().traer();
	}
}
