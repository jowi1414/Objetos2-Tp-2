package Tp2;

public class PlantaPermanente extends Empleado {
	int	cantHijos;
	public int getCantHijos() {
		return cantHijos;
	}
	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}
	int antiguedad;
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	int asignacionHijo = 150;
	int asignacionConyugue = 100;
	int valorAntiguedad = 50;
	double retencionJubilacion = 0.15;
	int retencionHijo = 20 ;
	double retencionObraSocial = 0.10;
	
	protected int  asignacionPorHijo() {
		return asignacionHijo + this.cantHijos;  
	}
	protected int retencionPorHijo() {
		return retencionHijo * this.getCantHijos();
	}
	protected  int asignacionConyugue() {
		if (estadoCivil == "casado" || estadoCivil == "casada") {
			return asignacionConyugue; 	
		}
		else {
			asignacionConyugue = 0;
			return asignacionConyugue;
		}
	}
	public int sueldoBruto() {

		return sueldoBasico + this.salarioFamiliar();

	}

	public int salarioFamiliar() {
		return (this.getAsignacionHijo()  + this.asignacionConyugue() + (this.getAntiguedad() * valorAntiguedad));
	}
	
	public int getAsignacionHijo() {
		return asignacionHijo;
	}
	public double retenciones() {
		return retencionHijo + (this.sueldoBruto() * retencionJubilacion) + (this.sueldoBruto() * retencionObraSocial); 
	}
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	@Override
	protected void desgloceConceptosSueldoBruto(Recibo recibo, Empleado empleado) {
		
		recibo.agregarConcepto(new Concepto("Sueldo Basico", sueldoBasico));
        recibo.agregarConcepto(new Concepto("Sueldo Familiar", this.salarioFamiliar()));
        recibo.agregarConcepto(new Concepto("Antiguedad", antiguedad));
	}
	
	@Override
	protected void desgloceConceptosRetenciones(Recibo recibo, Empleado empleado) {

		
		recibo.agregarConcepto(new Concepto("Obra Social", (this.sueldoBruto() * retencionObraSocial)));
		recibo.agregarConcepto(new Concepto("Aportes Jubilatorios", (this.sueldoBruto() * retencionJubilacion)));
		recibo.agregarConcepto(new Concepto("Retencion Por Hijos", retencionHijo));
	}



}
