package negocio;

import java.time.LocalDate;
import java.util.Set;
import dao.FacturaDao;
import datos.Factura;
import datos.ItemFactura;

public class FacturaABM {

	private static FacturaABM instancia = null;//Patron Singleton
	
	protected FacturaABM() {}
	
	public static FacturaABM getInstance() {
		if(instancia==null) {
			instancia=new FacturaABM();
		}
		return instancia;
	}
	
	public int agregar(String cliente, LocalDate fecha, int nroMedidor, String observacion, Set<ItemFactura> item) throws Exception{
		/* aca habria una excepcion por si ya existe la factura pero no hay un traer que lo cumpla aun 
		if(traer()!= null) {
			throw new Exception("ERROR: ya existe esta factura");
		}*/
		Factura f = new Factura(cliente, fecha, nroMedidor, observacion, item);
		return FacturaDao.getInstance().agregar(f);
	}
	
	public void modificar(Factura f) throws Exception{
		if(traer(f.getIdFactura()) == null) {
			throw new Exception("ERROR: no existe una factura con ese id");
		}
		FacturaDao.getInstance().actualizar(f);
	}
	
	public void eliminar(int idFactura) throws Exception{ 
		Factura f = FacturaDao.getInstance().traerFactura(idFactura);
		if(f == null) throw new Exception("ERROR: no existe la factura");
		FacturaDao.getInstance().eliminar(f);
	}
	
	public Factura traer(int idFactura) {
		return FacturaDao.getInstance().traerFactura(idFactura);
	}
	// hay variaciones en los traer der factura para no traer listas
	
	
	
}
