import java.util.*;
public class escuela{
	private Vector<departamento> departamentos;
	private Vector<estudiante> estudiante;

}

class departamento{
	private Vector<curso> cursos;
	private Vector<profesor> profesores;
	private profesor jefe;
}

class estudiante{
	
	private int matricula;
	private Vector<curso> cursos;
}

class curso{
	private Vector<estudiante> estudiantes;

	private Vector<profesor> profesores;
}

class profesor{
	private Vector<curso> cursos;
	private char[] nombre;
}