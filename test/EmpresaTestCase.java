import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tp2.*;

class EmpresaTestCase {
	private Empresa empresa;
	private PlantaTemporaria omar;
	private PlantaPermanente jose;
	
	@BeforeEach
	public void setUp() throws Exception {
		// armado de parametros de prueba
		//  int sueldoBasico = 100 , LocalDate fechaNac =LocalDate.of(2020, 9, 02) , int cantHorasExtras = 5
		empresa = new Empresa();
		omar = new PlantaTemporaria();
		omar.setNombre("omar");
		omar.setDireccion("blanco Encalada 1930");
		omar.setSueldoBasico(100);
		omar.setFechaNac(LocalDate.of(2020, 9, 02));
		omar.setCantHorasExtras(5);
		jose = new PlantaPermanente();
		jose.setNombre("jose");
		jose.setDireccion("blanco encalada 1933");
		jose.setSueldoBasico(500);
		jose.setEstadoCivil("soltero");
		jose.setCantHijos(1);
		jose.setAntiguedad(30);
		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(omar);
		empresa.setMontoCaja(empresa.montoTotalNeto());
		
	}		
		//Ejecucion de test
		@Test
		void testEmpresa() {
		assertEquals(300,omar.sueldoBruto());
		assertEquals(2150,jose.sueldoBruto());
		assertEquals(2450,empresa.montoTotalBruto());
		empresa.liquidarSueldosA(empresa.getEmpleados());
		assertEquals(0, empresa.getMontoCaja());
		}
	
}
