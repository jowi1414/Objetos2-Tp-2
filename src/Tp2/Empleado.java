package Tp2;


import java.time.LocalDate;
import java.time.Period;
public abstract class Empleado {
	String nombre;
	String direccion;
	String estadoCivil;
	LocalDate fechaNac;
	double sueldoPagado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public LocalDate getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	int sueldoBasico;
	public int getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(int sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	LocalDate fechaActual = LocalDate.now();

	public int edad(LocalDate fechaNac) {

		return Period.between(fechaNac, fechaActual).getYears();

	}
	public abstract int sueldoBruto();

	public abstract double sueldoNeto();

	public abstract double retenciones();

	protected abstract void desgloceConceptosSueldoBruto(Recibo recibo, Empleado empleado);

	protected abstract void desgloceConceptosRetenciones(Recibo recibo, Empleado empleado);
}


