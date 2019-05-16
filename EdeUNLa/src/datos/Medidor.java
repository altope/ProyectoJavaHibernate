package datos;

public class Medidor {
	
	private int nroSerie;
	private String categoria;
	private double energiaConsumida;
	private String direccion;
	private Cliente cliente;
	private boolean esBaja;
	
	
	
	public int getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getEnergiaConsumida() {
		return energiaConsumida;
	}
	public void setEnergiaConsumida(double energiaConsumida) {
		this.energiaConsumida = energiaConsumida;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public boolean isEsBaja() {
		return esBaja;
	}
	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}
	
	
	public Medidor(int nroSerie, String categoria, double energiaConsumida, String direccion, Cliente cliente,
			boolean esBaja) {
		this.nroSerie = nroSerie;
		this.categoria = categoria;
		this.energiaConsumida = energiaConsumida;
		this.direccion = direccion;
		this.cliente = cliente;
		this.esBaja = esBaja;
	}
	
	
	@Override
	public String toString() {
		return "Medidor [nroSerie=" + nroSerie + ", categoria=" + categoria + ", energiaConsumida=" + energiaConsumida
				+ ", direccion=" + direccion + ", cliente=" + cliente + ", esBaja=" + esBaja + "]";
	}
	
	
	

}
