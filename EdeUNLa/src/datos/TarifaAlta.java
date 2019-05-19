package datos;

import java.util.Set;

public class TarifaAlta extends Tarifa{

	private String tensionContratada;
	private int limite;
	private Set<DetalleAlta> listDetalle;
	
	public TarifaAlta() {}
	
	public TarifaAlta(String tensionContratada, int limite, Set<DetalleAlta> listDetalle) {
		super();
		this.tensionContratada = tensionContratada;
		this.limite = limite;
		this.listDetalle = listDetalle;
	}

	public String getTensionContratada() {
		return tensionContratada;
	}

	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public Set<DetalleAlta> getListDetalle() {
		return listDetalle;
	}

	public void setListDetalle(Set<DetalleAlta> listDetalle) {
		this.listDetalle = listDetalle;
	}

	@Override
	public String toString() {
		return "TarifaAlta [tensionContratada=" + tensionContratada + ", limite=" + limite + ", listDetalle="
				+ listDetalle + "]";
	}
	
}
