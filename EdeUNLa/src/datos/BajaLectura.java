package datos;

import java.time.LocalDate;

public class BajaLectura extends Lectura{
	
	
	private int consumo;
	
	
public BajaLectura(Medidor medidor, LocalDate fecha, Inspector inspector) {
		super(medidor, fecha, inspector);
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
