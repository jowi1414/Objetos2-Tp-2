package Tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
	String nombre;
	int cuit;
	double montoCaja;
	ArrayList <Empleado> empleados = new ArrayList<Empleado>(); 
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	ArrayList <Recibo> recibos = new ArrayList<Recibo>();
	public double getMontoCaja() {
		return montoCaja;
	}

	public void setMontoCaja(double montoCaja) {
		this.montoCaja = montoCaja;
	}




	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}


	public void liquidarSueldosA(ArrayList<Empleado> empleados) {
		for (Empleado i : empleados) {
			pagarSueldoA(i);
			this.generarRecibo(i);
		}
	}

	public void pagarSueldoA(Empleado empleado) {
		empleado.sueldoPagado = empleado.sueldoNeto();
		montoCaja -= empleado.sueldoNeto();
	}



	public void generarRecibo(Empleado empleado) {
		Recibo reciboHaberes = new Recibo(empleado);
		this.desgloceConceptos(reciboHaberes, empleado);
		recibos.add(reciboHaberes);
		reciboHaberes.imprimirRecibo();

	}

	private void desgloceConceptos(Recibo recibo, Empleado empleado) {
		empleado.desgloceConceptosSueldoBruto(recibo, empleado );
		empleado.desgloceConceptosRetenciones(recibo, empleado);
	}


	public double montoTotalNeto() {
		double montoNeto = 0;
		for (Empleado i : empleados) {
			montoNeto = montoNeto + i.sueldoNeto(); 
		}
		return montoNeto;
	}

	public int montoTotalBruto() {
		int montoBruto = 0;
		for (Empleado i : empleados) {
			montoBruto = montoBruto + i.sueldoBruto(); 
		}
		return montoBruto;
	}

	public double montoRetenciones() {
		double montoRetenciones = 0;
		for (Empleado i : empleados) {
			montoRetenciones = montoRetenciones + i.retenciones(); 
		}
		return montoRetenciones;
	}


}
