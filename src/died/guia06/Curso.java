package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer creditos, Integer creditosRequeridos,Integer cupoMax,String nom) {
		super();
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.cupo=cupoMax;
		this.nombre=nom;

	}

	public int getCreditos() {
		return creditos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Alumno> getInscriptos() {
		return this.inscriptos;
	}
	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		if(this.inscriptos.size()<this.cupo &&
		   this.creditosRequeridos <= a.creditosObtenidos() &&
		   a.getCursando().size()<3) {
		try{
			log.registrar(this, "inscribir ",a.toString());
			a.inscripcionAceptada(this);
			this.inscriptos.add(a);
			return true;	
		}
		catch(IOException e) {
			System.out.println("No se pudo inscribir al alumno");
		}}
		return false;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			Collections.sort(this.inscriptos);
			for(Alumno a : this.inscriptos) {
				System.out.println(a.getNombre());
			}
		} catch (IOException e) {
			System.out.println("No se pudo imprimir el listado de inscriptos");
		}
	}
	
	public void imprimirInscriptosPorNro() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			inscriptos.sort(new ComparaAlumnoLibreta());
			for(Alumno a : this.inscriptos) {
				System.out.println(a.getNombre());
			}
		} catch (IOException e) {
			System.out.println("No se pudo imprimir el listado de inscriptos");
		}
	}
	
	public void imprimirInscriptosPorCreditos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			inscriptos.sort(new ComparaAlumnoCreditos());
			for(Alumno a : this.inscriptos) {
				System.out.println(a.getNombre());
			}
		} catch (IOException e) {
			System.out.println("No se pudo imprimir el listado de inscriptos");
		}
	}
	
	public void quitarAlumno(Alumno a) {
		this.inscriptos.remove(a);
	}
	
	public void inscribirAlumno(Alumno a) throws ExcepcionNoHayCupo,ExcepcionNoTieneCreditos,ExcepcionCantidadDeCursos,RegistroAuditoriaException {
		if(this.inscriptos.size()<this.cupo) {
			if(this.creditosRequeridos<= a.creditosObtenidos()) {
				if(a.getCursando().size()<3) {
					try{
						log.registrar(this, "inscribir ",a.toString());
						a.inscripcionAceptada(this);
						this.inscriptos.add(a);
							
					}
					catch(IOException e) {
						throw new RegistroAuditoriaException();
					}
				}
				else {
					throw new ExcepcionCantidadDeCursos();
				}
			}
			else {
				throw new ExcepcionNoTieneCreditos();
			}
		}
		else {
			throw new ExcepcionNoHayCupo();
		}
			
	}


}
