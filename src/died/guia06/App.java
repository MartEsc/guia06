package died.guia06;

public class App {

	public static void main(String[] args) {
		Alumno a1 = new Alumno("Juan",123);
		Alumno a2 = new Alumno("Pedro",122);
		Alumno a3 = new Alumno("Martin",120);
		Alumno a4 = new Alumno("Matias",125);
		Curso c1 = new Curso(1,0,3,"Algoritmos y Estructuras de Datos");
		Curso c2 = new Curso(5,1,4,"DIED");
		Curso c3 = new Curso(1,0,3,"Algebra");
		Curso c4 = new Curso(2,0,3,"Analisis de Sistemas");
		Curso c5 = new Curso(2,0,3,"Gestion de Datos");
		
		c1.inscribir(a1);
		c1.inscribir(a2);
		c1.inscribir(a3);
		c1.inscribir(a4);
		
		/*a4 no deberia poder inscribirse por cupo,la impresion por orden
		alfabetico deberia mostrar "Juan Martin Pedro"*/
		System.out.println("Alumnos del curso por orden alfabetico");
		c1.imprimirInscriptos();
		
		//La impresion por numero deberia mostrar Martin Pedro Juan
		System.out.println("Alumnos del curso c1 por nro de libreta");
		c1.imprimirInscriptosPorNro();
		
		a1.aprobar(c1);
		a3.aprobar(c1);
		c1.inscribir(a4);
		c2.inscribir(a1);
		c2.inscribir(a2);
		c2.inscribir(a3);
		//a2 no deberia poder inscribirse por creditos,solo juan y martin deberia estar en c2
		System.out.println("Alumnos del curso c2");
		c2.imprimirInscriptos();
		
		c3.inscribir(a1);
		c4.inscribir(a1);
		c5.inscribir(a1);
		c5.inscribir(a2);
		//a1 no deberia poder inscribirse en c5 porque ya esta en 3 cursos
		System.out.println("Alumnos de c3");
		c3.imprimirInscriptos();
		System.out.println("Alumnos de c4");
		c4.imprimirInscriptos();
		System.out.println("Alumnos de c5");
		c5.imprimirInscriptos();
		
		/*a1 deberia estar inscrito en c2, c3 y c4,son los cursos que deberia haber en su 
		lista de cursos*/
		for(Curso c : a1.getCursando()) {
			System.out.println(a1.getNombre() +" Esta en: "+c.getNombre());
		}
		a1.aprobar(c2);
		/*a1 aprobó c1 y c2, a2 no aprobó ningun curso, asi que deberian tener 6 creditos
		y 0 creditos respectivamente*/
		System.out.println("Creditos de a1: "+a1.creditosObtenidos());
		System.out.println("Creditos de a2: "+a2.creditosObtenidos());
		
	}
}
