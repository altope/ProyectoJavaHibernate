package datos;

public class ItemFactura {

	private long idFactura;
	private String detalle;
	private double precioUnitario;
	private int cantidad;
	private String unidad;

	public ItemFactura() {}

	public ItemFactura(String detalle, double precioUnitario, int cantidad, String unidad) {
		this.detalle = detalle;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	public long getIdFactura() {
		return idFactura;
	}
	protected void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "ItemFacturacion [idFactura=" + idFactura + ", detalle=" + detalle + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", unidad=" + unidad + "]";
	}

}
