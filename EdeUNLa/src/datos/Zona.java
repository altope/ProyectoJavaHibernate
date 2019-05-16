package datos;

import java.util.Set;

public class Zona {
	
	private int idZona;
	private String nombre;
	private Set<Medidor> lstMedidores;
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
	public int getIdZona() {
		return idZona;
	}
	protected void setIdZona(int idZona) {
		this.idZona = idZona;
	}
	
	public Zona(int idZona, String nombre, Set<Medidor> lstMedidores) {
		super();
		this.idZona = idZona;
		this.nombre = nombre;
		this.lstMedidores = lstMedidores;
	}
	
	
	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nombre=" + nombre + ", lstMedidores=" + lstMedidores + "]";
	}
	
	
	
	
}
