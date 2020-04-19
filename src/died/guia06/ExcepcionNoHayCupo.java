package died.guia06;

public class ExcepcionNoHayCupo extends Exception {
	public ExcepcionNoHayCupo () {
		super("No hay cupo en el curso,no se puede inscribir al alumno");
	}
}
