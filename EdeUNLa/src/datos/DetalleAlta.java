package datos;

public class DetalleAlta {

	private long idDetalleAlta;
	private String detalleConcepto;
	private String unidad;
	private boolean superaLimite;
	private double valor;
	
	public DetalleAlta() {}
	
	public DetalleAlta(String detalleConcepto, String unidad, boolean superaLimite, double valor) {
		super();
		this.detalleConcepto = detalleConcepto;
		this.unidad = unidad;
		this.superaLimite = superaLimite;
		this.valor = valor;
	}

	public long getIdDetalleAlta() {
		return idDetalleAlta;
	}

	protected void setIdDetalleAlta(long idDetalleAlta) {
		this.idDetalleAlta = idDetalleAlta;
	}

	public String getDetalleConcepto() {
		return detalleConcepto;
	}

	public void setDetalleConcepto(String detalleConcepto) {
		this.detalleConcepto = detalleConcepto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public boolean isSuperaLimite() {
		return superaLimite;
	}

	public void setSuperaLimite(boolean superaLimite) {
		this.superaLimite = superaLimite;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DetalleAlta [detalleConcepto=" + detalleConcepto + ", unidad=" + unidad + ", superaLimite="
				+ superaLimite + ", valor=" + valor + "]";
	}
	
}
