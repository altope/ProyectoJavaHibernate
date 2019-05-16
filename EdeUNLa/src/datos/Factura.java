package datos;

import java.time.LocalDate;
import java.util.Set;

public class Factura {

	private int idFactura;
	private String cliente;
	private LocalDate fecha;
	private int nroMedidor;
	private String observacion;
	private Set<ItemFacturacion> item;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNroMedidor() {
		return nroMedidor;
	}

	public void setNroMedidor(int nroMedidor) {
		this.nroMedidor = nroMedidor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Set<ItemFacturacion> getItem() {
		return item;
	}

	public void setItem(Set<ItemFacturacion> item) {
		this.item = item;
	}

	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Factura(int idFactura, String cliente, LocalDate fecha, int nroMedidor, String observacion,
			Set<ItemFacturacion> item) {
		this.idFactura = idFactura;
		this.cliente = cliente;
		this.fecha = fecha;
		this.nroMedidor = nroMedidor;
		this.observacion = observacion;
		this.item = item;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", cliente=" + cliente + ", fecha=" + fecha + ", nroMedidor="
				+ nroMedidor + ", observacion=" + observacion + ", item=" + item + "]";
	}

}
