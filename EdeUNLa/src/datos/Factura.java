package datos;

import java.time.LocalDate;
import java.util.Set;

public class Factura {

	private long idFactura;
	private String cliente;
	private LocalDate fecha;
	private int nroMedidor;
	private String observacion;
	private Set<ItemFactura> item;

	public Factura() {}

	public Factura(String cliente, LocalDate fecha, int nroMedidor, String observacion,
			Set<ItemFactura> item) {
		this.cliente = cliente;
		this.fecha = fecha;
		this.nroMedidor = nroMedidor;
		this.observacion = observacion;
		this.setItem(item);
	}

	public long getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

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

	public Set<ItemFactura> getItem() {
		return item;
	}

	public void setItem(Set<ItemFactura> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", cliente=" + cliente + ", fecha=" + fecha + ", nroMedidor="
				+ nroMedidor + ", observacion=" + observacion + ", item=" + item + "]";
	}

}
