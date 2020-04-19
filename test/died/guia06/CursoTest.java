package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private Alumno a;
	private Alumno b;
	private Curso c1;
	private Curso c2;
	private Curso c3;
	@BeforeEach
	public void init() {
		 a = new Alumno("Juan",1);
		 b = new Alumno("Cacho",2);
		 c1 = new Curso(5,0,3,"DIED");
		 c2 = new Curso(1,0,3,"Gestion de Datos");
		 c3 = new Curso(1,2,3,"Algebra");
	}
	
	@Test
	void testInscribir() {
		c1.inscribir(a);
		assertTrue(c1.getInscriptos().contains(a));
		c3.inscribir(b);
		assertFalse(c3.getInscriptos().contains(b));
	}

	@Test
	void testImprimirInscriptos() {
		System.setOut(new PrintStream(outContent));
		c1.inscribir(a);
		c1.inscribir(b);
		c1.imprimirInscriptos();
		assertEquals("Cacho" +System.getProperty("line.separator")+ "Juan" +System.getProperty("line.separator"),outContent.toString());
	}

	@Test
	void testImprimirInscriptosPorNro() {
		System.setOut(new PrintStream(outContent));
		c1.inscribir(a);
		c1.inscribir(b);
		c1.imprimirInscriptosPorNro();
		assertEquals("Juan" +System.getProperty("line.separator")+ "Cacho"+System.getProperty("line.separator"),outContent.toString());
	}

	@Test
	void testImprimirInscriptosPorCreditos() {
		System.setOut(new PrintStream(outContent));
		c1.inscribir(a);
		c1.inscribir(b);
		c2.inscribir(b);
		b.aprobar(c2);
		c1.imprimirInscriptosPorNro();
		assertEquals("Juan" + System.getProperty("line.separator") + "Cacho" + System.getProperty("line.separator"),outContent.toString());
	}
	
	

}
