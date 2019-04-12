package datos;

import java.time.LocalDate;

import funciones.Funciones;

public class Cuota {
	private long idCuota;
	private int nroCuota;
	private LocalDate fechaDeVencimiento; 
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private LocalDate fechaDePago;
	private double punitorios;
	private Prestamo prestamo;
	
	public Cuota() {
		super();
	}

	public Cuota(int nroCuota, Prestamo prestamo) {
		super();
		this.setNroCuota(nroCuota);
		this.setPrestamo(prestamo);
	}
	
	public Cuota(int nroCuota, LocalDate fechaDeVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios) {
		super();
		this.setNroCuota(nroCuota);
		this.fechaDeVencimiento = fechaDeVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesCuota = interesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
	}


	public LocalDate getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(double interesCuota) {
		this.interesCuota = interesCuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}

	@Override
	public String toString() {
		return "Cuota [nroCuota=" + nroCuota + ", fechaDeVencimiento=" + Funciones.traerFechaCorta(fechaDeVencimiento) + ", saldoPendiente="
				+ saldoPendiente + ", amortizacion=" + amortizacion + ", interesCuota=" + interesCuota + ", cuota="
				+ cuota + ", deuda=" + deuda + ", cancelada=" + cancelada + ", fechaDePago=" + Funciones.traerFechaCorta(fechaDePago)
				+ ", punitorios=" + punitorios + "]";
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public long getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}
	
	
	
	

}// end class
