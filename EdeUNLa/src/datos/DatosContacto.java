package datos;

public class DatosContacto {

	private int idContacto;
	private String telefono;
	private String movil;
	private String domicilio;
	private String email;

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

	public int getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public DatosContacto(int idContacto, String telefono, String movil, String domicilio, String email) {
		this.idContacto = idContacto;
		this.telefono = telefono;
		this.movil = movil;
		this.domicilio = domicilio;
		this.email = email;
	}

	@Override
	public String toString() {
		return "DatosContacto [idContacto=" + idContacto + ", telefono=" + telefono + ", movil=" + movil
				+ ", domicilio=" + domicilio + ", email=" + email + "]";
	}

}
