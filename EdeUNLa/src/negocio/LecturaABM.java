package negocio;

import java.time.LocalDate;

import dao.LecturaDao;
import datos.Inspector;
import datos.Lectura;
import datos.Medidor;

public class LecturaABM {

	private static LecturaABM instancia = null;//Patron Singleton
	
	protected LecturaABM() {}
	
	public static LecturaABM getInstance() {
		if(instancia==null) {
			instancia=new LecturaABM();
		}
		return instancia;
	}
	
	public int agregar(Medidor medidor, LocalDate fecha, Inspector inspector) throws Exception{
		/* falta implementar los traer
		 if(traerLectura()!= null) {
			throw new Exception("ERROR: este cliente ya tiene datos de contacto");
		}
		*/
		Lectura l = new Lectura(medidor, fecha, inspector);
		return LecturaDao.getInstance().agregar(l);
	}
	
	public void modificar(Lectura l) throws Exception{
		/*falta implementar los traer
		 if(traer() == null) {
			throw new Exception("ERROR: no existe una lectura con ese ...");
		}*/
		LecturaDao.getInstance().actualizar(l);
	}
	
	public void eliminar(int idLectura) throws Exception{ 
		Lectura l = LecturaDao.getInstance().traerLectura();//falta el traer
		if(l == null) throw new Exception("ERROR: no existe la lectura");
		LecturaDao.getInstance().eliminar(l);
	}
	
	public Lectura traer(int idLectura) {
		return LecturaDao.getInstance().traerLectura(idLectura);
	}
	
 //faltan los demas traer que se necesiten
	
}
