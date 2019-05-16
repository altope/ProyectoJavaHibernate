package datos;

public class ClienteAltaDemanda extends Cliente{
	
	
	private String cuil;
	private String razonSocial;
	private int potencia;
	private String tension;
	
	
	
	public ClienteAltaDemanda(int idCliente, Zona zona, int dni, String apellido, String nombre, DatosContacto datos) {
		super(idCliente, zona, dni, apellido, nombre, datos);
	}



	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getTension() {
		return tension;
	}

	public void setTension(String tension) {
		this.tension = tension;
	}


	@Override
	public String toString() {
		return this.toString() +"ClienteAltaDemanda [cuil=" + cuil + ", razonSocial=" + razonSocial + ", potencia=" + potencia
				+ ", tension=" + tension + "]";
	}
	
	
	
	

}
