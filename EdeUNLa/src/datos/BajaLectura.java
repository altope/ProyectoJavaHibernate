package datos;

public class BajaLectura extends Lectura{

	private int consumo;
	
	public BajaLectura() {}
	
	public BajaLectura(int consumo) {
		super();
		this.consumo = consumo;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}


	@Override
	public String toString() {
		return "BajaLectura [consumo=" + consumo + "]";
	}





}
