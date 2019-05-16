package datos;

import java.time.LocalDate;

public class AltaLectura extends Lectura{
	
	
	private int consumoHoraValle;
	private int consumoHoraPico;
	private int consumoHoraResto;
	
	
public AltaLectura(Medidor medidor, LocalDate fecha, Inspector inspector) {
		super(medidor, fecha, inspector);
	}


public int getConsumoHoraValle() {
	return consumoHoraValle;
}

public void setConsumoHoraValle(int consumoHoraValle) {
	this.consumoHoraValle = consumoHoraValle;
}

public int getConsumoHoraPico() {
	return consumoHoraPico;
}

public void setConsumoHoraPico(int consumoHoraPico) {
	this.consumoHoraPico = consumoHoraPico;
}

public int getConsumoHoraResto() {
	return consumoHoraResto;
}

public void setConsumoHoraResto(int consumoHoraResto) {
	this.consumoHoraResto = consumoHoraResto;
}


@Override
public String toString() {
	return this.toString() + "AltaLectura [consumoHoraValle=" + consumoHoraValle + ", consumoHoraPico=" + consumoHoraPico
			+ ", consumoHoraResto=" + consumoHoraResto + "]";
}




}
