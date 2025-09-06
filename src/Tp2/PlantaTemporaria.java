package Tp2;

import java.util.Date;

public class PlantaTemporaria extends Empleado {


	Date fechaFinDesignacion;
	int cantHorasExtras;
	public void setCantHorasExtras(int cantHorasExtras) {
		this.cantHorasExtras = cantHorasExtras;
	}
	int valorHorasExtra = 40;
	double retencionJubilacion = 0.10;
	double retencionObraSocial = 0.10;
	int retencionPorEdad = 25;
	protected int retencionEdad() {
		if (edad(fechaNac) > 50) {
			return retencionPorEdad;
		}
		else {
			retencionPorEdad = 0;
			return retencionPorEdad;
		}

	}
	public int sueldoBruto() {

		return sueldoBasico + (cantHorasExtras * valorHorasExtra);

	}


	public double retenciones() {
		return (this.sueldoBruto() * retencionJubilacion) + (this.sueldoBruto() * retencionObraSocial) + this.retencionEdad() + cantHorasExtras * 40; 
	}
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	@Override
	protected void desgloceConceptosSueldoBruto(Recibo recibo, Empleado empleado) {
		    
		
        recibo.agregarConcepto(new Concepto("Sueldo Basico", sueldoBasico));
        recibo.agregarConcepto(new Concepto("Horas Extras", (cantHorasExtras * valorHorasExtra)));
	}
	@Override
	protected void desgloceConceptosRetenciones(Recibo recibo, Empleado empleado) {
		
		
		recibo.agregarConcepto(new Concepto("Obra Social", (this.sueldoBruto() * retencionObraSocial)));
		recibo.agregarConcepto(new Concepto("Aportes Jubilatorios", this.sueldoBruto() * retencionJubilacion));
	}


}