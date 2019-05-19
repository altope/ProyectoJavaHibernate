package datos;

public class Cliente {

	private long idCliente;
	private DatosContacto datos;


	public Cliente() {}

	public Cliente(DatosContacto datos) {
		super();
		this.datos = datos;
	}

	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public DatosContacto getDatos() {
		return datos;
	}
	public void setDatos(DatosContacto datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", datos=" + datos + "]";
	}

}
