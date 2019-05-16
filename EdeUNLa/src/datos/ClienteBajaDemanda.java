package datos;

public class ClienteBajaDemanda extends Cliente{
	
	
	private String cuil;
	private String apellido;
	private String nombre;
	
	
	public ClienteBajaDemanda(int idCliente, Zona zona, int dni, String apellido, String nombre, DatosContacto datos) {
		super(idCliente, zona, dni, apellido, nombre, datos);
	}


	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
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


	@Override
	public String toString() {
		return this.toString() + "ClienteBajaDemanda [cuil=" + cuil + ", apellido=" + apellido + ", nombre=" + nombre + "]";
	}
  
	
	
}
