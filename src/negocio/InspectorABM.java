package negocio;

import dao.InspectorDao;
import datos.Inspector;

public class InspectorABM {

	private static InspectorABM instancia = null;//Patron Singleton
	
	protected InspectorABM() {}
	
	public static InspectorABM getInstance() {
		if(instancia==null) {
			instancia=new InspectorABM();
		}
		return instancia;
	}
	
	public int agregar(String telefono, String movil, String domicilio, String email, Cliente cliente) throws Exception{
		if(traer(cliente)!= null) {
			throw new Exception("ERROR: este cliente ya tiene datos de contacto");
		}
		Inspector p = new Inspector(telefono, movil, domicilio, email, cliente);
		return InspectorDao.getInstance().agregar(p);
	}
	
	public void modificar(Inspector p) throws Exception{
		if(traer(p.getIdInspertor()) == null) {
			throw new Exception("ERROR: no existe un contacto con ese id");
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
	
	public Inspector traer(Inspector inspector) {
		return InspectorDao.getInstance().traerInspector(inspector);
	}
	
}
