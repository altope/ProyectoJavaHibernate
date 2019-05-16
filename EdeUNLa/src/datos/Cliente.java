package datos;

public class Cliente {
	
	private int idCliente;
	private Zona zona;
	private int dni;
	private String apellido;
	private String nombre;
	private DatosContacto datos;
	
	
	public Cliente(int idCliente, Zona zona, int dni, String apellido, String nombre, DatosContacto datos) {
		this.idCliente = idCliente;
		this.zona = zona;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.datos = datos;
	}
	
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DatosContacto getDatos() {
		return datos;
	}
	public void setDatos(DatosContacto datos) {
		this.datos = datos;
	}
	public int getIdCliente() {
		return idCliente;
	}
	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", zona=" + zona + ", dni=" + dni + ", apellido=" + apellido
				+ ", nombre=" + nombre + ", datos=" + datos + "]";
	}

}
