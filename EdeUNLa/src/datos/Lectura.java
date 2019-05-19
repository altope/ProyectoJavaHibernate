package datos;

import java.time.LocalDate;

public class Lectura {

	private long idLectura;
	private Medidor medidor;
	private LocalDate fecha;
	private Inspector inspector;

	public Lectura() {}

	public Lectura(Medidor medidor, LocalDate fecha, Inspector inspector) {
		this.medidor = medidor;
		this.fecha = fecha;
		this.inspector = inspector;
	}



	public long getIdLectura() {
		return idLectura;
	}

	protected void setIdLectura(long idLectura) {
		this.idLectura = idLectura;
	}

	public Medidor getMedidor() {
		return medidor;
	}
	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Inspector getInspector() {
		return inspector;
	}
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	@Override
	public String toString() {
		return "Lectura [medidor=" + medidor + ", fecha=" + fecha + ", inspector=" + inspector + "]";
	}

}
