package datos;

import java.util.Set;

public class TarifaBaja extends Tarifa{

	private Set<DetalleBaja> listDetalle;

	public TarifaBaja() {}
	
	public TarifaBaja(String servicio, Set<DetalleBaja> listDetalle) {
		super(servicio);
		this.listDetalle = listDetalle;
	}

	public Set<DetalleBaja> getListDetalle() {
		return listDetalle;
	}

	public void setListDetalle(Set<DetalleBaja> listDetalle) {
		this.listDetalle = listDetalle;
	}
	
}
