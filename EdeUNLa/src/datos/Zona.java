package datos;

import java.util.Set;

public class Zona {

	private long idZona;
	private String nombre;
	private Set<Medidor> lstMedidores;

	public Zona() {}

	public Zona(String nombre, Set<Medidor> lstMedidores) {
		super();
		this.nombre = nombre;
		this.lstMedidores = lstMedidores;
	}

	public long getIdZona() {
		return idZona;
	}
	protected void setIdZona(long idZona) {
		this.idZona = idZona;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Medidor> getLstMedidores() {
		return lstMedidores;
	}
	public void setLstMedidores(Set<Medidor> lstMedidores) {
		this.lstMedidores = lstMedidores;
	}

	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nombre=" + nombre + ", lstMedidores=" + lstMedidores + "]";
	}

}
