package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public int creditosObtenidos() {
		int credObt = 0;
		for(Curso c: aprobados) {
			credObt += c.getCreditos();
		}
		return credObt;
	}
	
	public void aprobar(Curso c) {
		cursando.remove(c);
		aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}
	
	public boolean equals(Alumno a) {
		if(this.nroLibreta == a.nroLibreta) {
			return true;
		}
		else { return false;}
	}
	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}
}
