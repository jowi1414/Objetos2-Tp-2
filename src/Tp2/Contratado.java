package Tp2;

public class Contratado extends Empleado {
	int numeroContrato;
	String medioDePago;
	int retencionGastAdmContr = 50;
	public int sueldoBruto() {
		return sueldoBasico;
	}
	public double sueldoNeto() {
		return sueldoBruto() - retencionGastAdmContr;
	}
	public double retenciones() {
		return retencionGastAdmContr;
	}
	@Override
	protected void desgloceConceptosSueldoBruto(Recibo recibo, Empleado empleado) {
        recibo.agregarConcepto(new Concepto("Sueldo Basico", sueldoBasico));
	}

	@Override
	protected void desgloceConceptosRetenciones(Recibo recibo, Empleado empleado) {
		recibo.agregarConcepto(new Concepto("Gastos Administrativos Contractuales", this.retenciones()));
	}
}
