package negocio;

import java.util.List;
import dao.DatosContactoDao;
import datos.Cliente;
import datos.DatosContacto;

public class DatosContactoABM {

	private static DatosContactoABM instancia = null;//Patron Singleton
	
	protected DatosContactoABM() {}
	
	public static DatosContactoABM getInstance() {
		if(instancia==null) {
			instancia=new DatosContactoABM();
		}
		return instancia;
	}
	
	public int agregar(String telefono, String movil, String domicilio, String email, Cliente cliente) throws Exception{
		if(traer(cliente)!= null) {
			throw new Exception("ERROR: este cliente ya tiene datos de contacto");
		}
		DatosContacto d= new DatosContacto(telefono, movil, domicilio, email, cliente);
		return DatosContactoDao.getInstance().agregar(d);
	}
	
	public void modificar(DatosContacto d) throws Exception{
		if(traer(d.getIdContacto()) == null) {
			throw new Exception("ERROR: no existe un contacto con ese id");
		}
		DatosContactoDao.getInstance().actualizar(d);
	}
	
	public void eliminar(int idContacto) throws Exception{ 
		DatosContacto d = DatosContactoDao.getInstance().traerDatosContacto(idContacto);
		if(d == null) throw new Exception("ERROR: no existe el cliente");
		DatosContactoDao.getInstance().eliminar(d);
	}
	
	public DatosContacto traer(int idContacto) {
		return DatosContactoDao.getInstance().traerDatosContacto(idContacto);
	}
	
	public DatosContacto traer(Cliente cliente) {
		return DatosContactoDao.getInstance().traerDatosContacto(cliente);
	}
	
}
