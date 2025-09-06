package Tp2;

import java.time.LocalDate;
import java.util.ArrayList;


public class Recibo {

	private String nombreEmpleado;
	private String direccion;
	private LocalDate fechaEmision;
	private double sueldoBruto;
	private double sueldoNeto;
	private ArrayList<Concepto> conceptos;

	public Recibo(Empleado empleado) {
		this.nombreEmpleado = empleado.getNombre();
		this.direccion = empleado.getDireccion();
		this.fechaEmision = LocalDate.now();
		this.sueldoBruto = empleado.sueldoBruto();
		this.sueldoNeto = empleado.sueldoNeto();
		this.conceptos = new ArrayList<Concepto>();
	}
	public void agregarConcepto(Concepto concepto) {
		conceptos.add(concepto);
	}
	public void imprimirRecibo() {
		System.out.println("----------------------------------");
		System.out.println("Recibo de Haberes");
		System.out.println("Empleado: " + this.nombreEmpleado);
		System.out.println("Direccion: " + direccion);
		System.out.println("Fecha: " + fechaEmision);
		System.out.println("Sueldo Bruto: " + sueldoBruto);
		System.out.println("Sueldo Neto: " + sueldoNeto);
		System.out.println("Conceptos:");
		for (Concepto c : conceptos) {
			System.out.println(" - " + c.getDescripcion() + ": $" + c.getMonto());
		}
		System.out.println("----------------------------------");
	}
}	