package datos;

import java.util.Set;

public class Inspector {

	private long idInspertor;
	private int nroLegajo;
	private int dni;
	private Set<Zona> lstZonas;
	private String nombre;
	private String apellido;

	public Inspector() {}

	public Inspector(int nroLegajo, int dni, Set<Zona> lstZonas, String nombre, String apellido) {
		this.nroLegajo = nroLegajo;
		this.dni = dni;
		this.setLstZonas(lstZonas);
		this.nombre = nombre;
		this.apellido = apellido;
	}



	public long getIdInspertor() {
		return idInspertor;
	}



	protected void setIdInspertor(long idInspertor) {
		this.idInspertor = idInspertor;
	}



	public int getNroLegajo() {
		return nroLegajo;
	}

	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Set<Zona> getLstZonas() {
		return lstZonas;
	}

	public void setLstZonas(Set<Zona> lstZonas) {
		this.lstZonas = lstZonas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Inspector [nroLegajo=" + nroLegajo + ", dni=" + dni + ", lstZonas=" + lstZonas + ", nombre=" + nombre
				+ ", apellido=" + apellido + "]";
	}

}
