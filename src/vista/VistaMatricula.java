package vista;

import java.util.Iterator;

import modelo.*;

public class VistaMatricula {
	public void listarMatriculas() {
		MatriculaModelo mm = new MatriculaModelo();

		Iterator<Matricula> i = mm.selectAll().iterator();
		while (i.hasNext()) {
			Matricula matricula = i.next();
			mostrarMatricula(matricula);
		}
	}

	private void mostrarMatricula(Matricula matricula) {
		System.out.println("Info Alumno : " + "\nNombre : " + matricula.getAlumno().getNombre() + "\nDNI : "
				+ matricula.getAlumno().getDni() + "\nInfo Asignatura : " + "\nNombre : " + matricula.getAsignatura().getNombre() + "\nHoras : " + matricula.getAsignatura().getHoras());
	}
}
