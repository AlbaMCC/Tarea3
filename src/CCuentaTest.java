
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CCuentaTest {
	CCuenta miCuenta = new CCuenta();

	@ParameterizedTest
	@CsvSource({"-10,1","-3,2","10,0"})
	@DisplayName("Caja Blanca - Ingresar")
	void testIngreso(double cant,int resul) {
		assertEquals(resul,miCuenta.ingresar(cant));
	}
	
	@ParameterizedTest
	@CsvSource({"-10","0"})
	@DisplayName("Caja Negra - Fallo al Retirar")
	void testRetirarFallo(int retirar) {
		miCuenta.dSaldo=10;
		double saldoInicial = miCuenta.dSaldo;
		miCuenta.retirar(retirar);
		assertEquals(saldoInicial,miCuenta.dSaldo);
	}
	
	@ParameterizedTest
	@CsvSource({"1","10"})
	@DisplayName("Caja Negra - Exito al Retirar")
	void testRetirarExito(int retirar) {
		miCuenta.dSaldo=10;
		double saldoInicial = miCuenta.dSaldo;
		miCuenta.retirar(retirar);
		assertEquals(saldoInicial-retirar,miCuenta.dSaldo);
	}
	
	@ParameterizedTest
	@CsvSource({"1","10"})
	@DisplayName("Caja Negra - Fallo al Retirar cuenta negativa")
	void testRetirarFalloCuentaNegativa(int retirar) {
		miCuenta.dSaldo=-10;
		double saldoInicial = miCuenta.dSaldo;
		miCuenta.retirar(retirar);
		assertEquals(saldoInicial,miCuenta.dSaldo);
	}
	
	@ParameterizedTest
	@CsvSource({"10","15"})
	@DisplayName("Caja Negra - Fallo al Retirar saldo insuficiente")
	void testRetirarFalloSaldoInsuficiente(int retirar) {
		miCuenta.dSaldo=8;
		double saldoInicial = miCuenta.dSaldo;
		miCuenta.retirar(retirar);
		assertEquals(saldoInicial,miCuenta.dSaldo);
	}
}
