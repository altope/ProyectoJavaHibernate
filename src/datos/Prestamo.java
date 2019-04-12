package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import funciones.Funciones;

public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;
	private Set<Cuota> cuotas;

	public Prestamo() {
	} // CONSTRUCTOR VACIO SIEMPRE
	// CONSTRUCTOR

	public Prestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		this.setCuotas();
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setCuotas() {
		this.cuotas = new HashSet<Cuota>();
		this.cuotas.add(new Cuota(1, this));
		this.cuotas.add(new Cuota(2, this));
		this.cuotas.add(new Cuota(3, this));
	}

	public String toString() {
		String prestamo = "Prestamo: $ " + monto + "\nFecha: " + Funciones.traerFechaCorta(fecha) + "\nInteres: "
				+ interes + " % \nCant.de Cuotas: " + cantCuotas + "\nID Cliente: " + cliente.getIdCliente();
		return prestamo;
	}

	public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
}
