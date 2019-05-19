package datos;

public class DatosContacto {

	private long idContacto;
	private String telefono;
	private String movil;
	private String domicilio;
	private String email;
	private Cliente cliente;

	public DatosContacto() {}

	public DatosContacto(String telefono, String movil, String domicilio, String email, Cliente cliente) {
		this.telefono = telefono;
		this.movil = movil;
		this.domicilio = domicilio;
		this.email = email;
		this.cliente = cliente;
	}

	public long getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DatosContacto [idContacto=" + idContacto + ", telefono=" + telefono + ", movil=" + movil
				+ ", domicilio=" + domicilio + ", email=" + email + "]";
	}

}
