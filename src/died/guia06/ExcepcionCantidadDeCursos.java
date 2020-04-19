package died.guia06;

public class ExcepcionCantidadDeCursos extends Exception {
	public ExcepcionCantidadDeCursos() {
		super("El alumno ya tiene todas las materias del cursado regular");
	}
}
