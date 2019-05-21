package negocio;

import java.util.Set;

import dao.InspectorDao;
import datos.Inspector;
import datos.Zona;

public class InspectorABM {

	private static InspectorABM instancia = null;//Patron Singleton
	
	protected InspectorABM() {}
	
	public static InspectorABM getInstance() {
		if(instancia==null) {
			instancia=new InspectorABM();
		}
		return instancia;
	}
	
	public int agregar(int nroLegajo, int dni, Set<Zona> lstZonas, String nombre, String apellido) throws Exception{
		/*if(traer()!= null) {
			throw new Exception("ERROR: este cliente ya tiene datos de contacto");
		}*/
		Inspector p = new Inspector(nroLegajo, dni, lstZonas, nombre, apellido);
		return InspectorDao.getInstance().agregar(p);
	}
	
	public void modificar(Inspector p) throws Exception{
		if(traer(p.getIdInspertor()) == null) {
			throw new Exception("ERROR: no existe un inspector con ese id");
		}
		InspectorDao.getInstance().actualizar(p);
	}
	
	public void eliminar(long idInspector) throws Exception{ 
		Inspector p = InspectorDao.getInstance().traerInspector(idInspector);
		if(p == null) throw new Exception("ERROR: no existe el inspector");
		InspectorDao.getInstance().eliminar(p);
	}
	
	public Inspector traer(long idInspector) {
		return InspectorDao.getInstance().traerInspector(idInspector);
	}
	
	
}
