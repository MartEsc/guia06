package died.guia06;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {

	private Alumno a;
	private Curso c1;
	private Curso c2;
	@BeforeEach
	public void init() {
		 a = new Alumno("Juan",123);
		 c1 = new Curso(5,0);
		 c2 = new Curso(1,0);
	}
	@Test
	void testCreditosObtenidos() {
		int creds=0;
		a.getAprobados().add(c1);
		a.getAprobados().add(c2);
		creds=a.creditosObtenidos();
		assertEquals(6,creds);
	}

	@Test
	void testAprobar() {
		a.getCursando().add(c1);
		a.aprobar(c1);
		assertTrue(a.getAprobados().contains(c1));
		assertFalse(a.getCursando().contains(c1));
	}

	@Test
	void testInscripcionAceptada() {
		a.inscripcionAceptada(c1);
		assertTrue(a.getCursando().contains(c1));
	}

}
