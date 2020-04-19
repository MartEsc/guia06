package died.guia06;

public class ExcepcionNoTieneCreditos extends Exception {

	public ExcepcionNoTieneCreditos() {
		super("El alumno no tiene la cantidad de créditos requeridos para este curso");
	}
}
