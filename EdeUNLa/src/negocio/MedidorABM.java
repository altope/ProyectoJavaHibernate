package negocio;


import dao.MedidorDao;
import datos.Cliente;
import datos.Medidor;

public class MedidorABM {


	private static MedidorABM instancia = null;//Patron Singleton
	
	protected MedidorABM() {}
	
	public static MedidorABM getInstance() {
		if(instancia==null) {
			instancia=new MedidorABM();
		}
		return instancia;
	}
	
	public int agregar(int nroSerie, String categoria, double energiaConsumida, String direccion, Cliente cliente, boolean esBaja) throws Exception{
		if(traer(cliente)!= null) {
			throw new Exception("ERROR: este cliente ya tiene datos de contacto");
		}
		Medidor m = new Medidor(nroSerie, categoria, energiaConsumida, direccion, cliente, esBaja);
		return MedidorDao.getInstance().agregar(m);
	}
	
	public void modificar(Medidor m) throws Exception{
		if(traer(m.getIdMedidor()) == null) {
			throw new Exception("ERROR: no existe un medidor con ese id");
		}
		MedidorDao.getInstance().actualizar(m);
	}
	
	public void eliminar(long idMedidor) throws Exception{ 
		Medidor m = MedidorDao.getInstance().traerMedidor(idMedidor);
		if(m == null) throw new Exception("ERROR: no existe el medidor");
		MedidorDao.getInstance().eliminar(m);
	}
	
	public Medidor traer(long idMedidor) {
		return MedidorDao.getInstance().traerMedidor(idMedidor);
	}
	
	public Medidor traer(Cliente cliente) {
		return MedidorDao.getInstance().traerMedidor(cliente);
	}
	
	public Medidor traer() {
		return MedidorDao.getInstance().traerMedidores();
	}
	
}
