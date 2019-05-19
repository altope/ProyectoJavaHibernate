package negocio;

import java.util.Set;

import dao.ZonaDao;
import datos.Medidor;
import datos.Zona;

public class ZonaABM {


	private static ZonaABM instancia = null;//Patron Singleton
	
	protected ZonaABM() {}
	
	public static ZonaABM getInstance() {
		if(instancia==null) {
			instancia=new ZonaABM();
		}
		return instancia;
	}
	
	public int agregar(String nombre, Set<Medidor> lstMedidores) throws Exception{
		if(traer(nombre)!= null) {
			throw new Exception("ERROR: esta zona ya existe");
		}
		Zona z = new Zona(nombre, lstMedidores);
		return ZonaDao.getInstance().agregar(z);
	}
	
	public void modificar(Zona z) throws Exception{
		if(traer(z.getIdZona()) == null) {
			throw new Exception("ERROR: no existe una zona con ese id");
		}
		ZonaDao.getInstance().actualizar(z);
	}
	
	public void eliminar(int idZona) throws Exception{ 
		Zona z = ZonaDao.getInstance().traerZona(idZona);
		if(z == null) throw new Exception("ERROR: no existe la zona");
		ZonaDao.getInstance().eliminar(z);
	}
	
	public Zona traer(long idZona) {
		return ZonaDao.getInstance().traerZona(idZona);
	}
	
	public Zona traer(String nombre) {
		return ZonaDao.getInstance().traerZona(nombre);
	}
	
	
}
