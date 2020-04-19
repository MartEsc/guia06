package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private Alumno a;
	private Alumno b;
	private Curso c1;
	private Curso c2;
	private Curso c3;
	private Curso c4;
	private Curso c5;
	@BeforeEach
	public void init() {
		 a = new Alumno("Juan",1);
		 b = new Alumno("Cacho",2);
		 c1 = new Curso(5,0,3,"DIED");
		 c2 = new Curso(1,0,3,"Gestion de Datos");
		 c3 = new Curso(1,2,3,"Algebra");
		 c4 = new Curso(1,0,1,"Analisis de Sistemas");
		 c5 = new Curso(1,0,3,"Analisis Matematico II");
	}
	
	@Test
	void testInscribir() {
		c1.inscribir(a);
		//verifica inscripcion exitosa
		assertTrue(c1.getInscriptos().contains(a));
		c3.inscribir(b);
		//verifica que falle si no se poseen los creditos necesarios
		assertFalse(c3.getInscriptos().contains(b));
		c2.inscribir(a);
		c4.inscribir(a);
		c5.inscribir(a);
		/*verifica que falle la inscripcion si el alumno ya esta inscrito 
		en el maximo de cursos*/
		assertFalse(c5.getInscriptos().contains(a));
		//verifica que falle la inscripcion si el cupo esta cubierto
		c4.inscribir(b);
		assertFalse(c4.getInscriptos().contains(b));
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
	
	@Test
	void testInscribirAlumnoCorrecto() throws ExcepcionNoHayCupo, ExcepcionNoTieneCreditos, ExcepcionCantidadDeCursos, RegistroAuditoriaException {
		c1.inscribirAlumno(a);
		assertTrue(c1.getInscriptos().contains(a));
		assertTrue(a.getCursando().contains(c1));
	}
	
	@Test
	void testInscribirAlumnoFallaCreditos() {
		Assertions.assertThrows( ExcepcionNoTieneCreditos.class,() -> c3.inscribirAlumno(a));
	}
	@Test
	void testInscribirAlumnoFallaCupo() {
		c4.inscribir(a);
		Assertions.assertThrows(ExcepcionNoHayCupo.class,() -> c4.inscribirAlumno(b));
	}
	@Test
	void testInscribirAlumnoFallaMaximoDeCursos() {
		c1.inscribir(a);
		c2.inscribir(a);
		c4.inscribir(a);
		Assertions.assertThrows(ExcepcionCantidadDeCursos.class,() -> c5.inscribirAlumno(a));
	}

}
