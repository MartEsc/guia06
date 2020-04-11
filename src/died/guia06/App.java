package died.guia06;

public class App {

	public static void main(String[] args) {
		Alumno a1 = new Alumno("Juan",123);
		Alumno a2 = new Alumno("Pedro",122);
		Curso c1 = new Curso(1,0,3);
		Curso c2 = new Curso(1,0,3);
		c1.inscribir(a1);
		c1.inscribir(a2);
		c1.imprimirInscriptos();
		System.out.println("--------");
		c1.imprimirInscriptosPorNro();
		System.out.println("--------");
		a1.aprobar(c2);
		c1.imprimirInscriptosPorCreditos();
		System.out.println("EL ALUMNO :"+a1.getNombre() + " OBTUVO");
		System.out.println(a1.creditosObtenidos()+ " CREDIITOS");
		
		System.out.println("EL ALUMNO :"+a2.getNombre() + " OBTUVO");
		System.out.println(a2.creditosObtenidos()+ " CREDIITOS");
	
		
	}
}
