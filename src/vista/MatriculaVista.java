package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class MatriculaVista {
		static final int MOSTRAR_MATRICULAS = 1;
		static final int ALUMNOS_MATRICULAS = 2;
		static final int SALIR = 0;

		public void menuMatriculas() {
			Scanner scan = new Scanner(System.in);
			int opcion;

			do {
				System.out.println("--Menu de matriculas--");
				System.out.println(MOSTRAR_MATRICULAS + " - listar todas");
				System.out.println(ALUMNOS_MATRICULAS + " - alumnos con matriculas");
				System.out.println(SALIR + " - salir");
				opcion = Integer.parseInt(scan.nextLine());
				switch (opcion) {
				case MOSTRAR_MATRICULAS:
					MatriculaModelo matriculaModelo = new MatriculaModelo();
					ArrayList<Matricula> matriculas = matriculaModelo.selectAll();
					this.mostrarMatriculas(matriculas);
					
					break;
				case ALUMNOS_MATRICULAS:
					AlumnoModelo alumnoModelo = new AlumnoModelo();
					ArrayList<Alumno> alumnos = alumnoModelo.selectAllConMatriculas();
					this.mostrarAlumnosConAsignaturas(alumnos);
					break;

				default:
					break;
				}

			} while (opcion != SALIR);

		}

	public void mostrarMatriculas(ArrayList<Matricula> matriculas) {
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
	private void mostrarAlumnosConAsignaturas(ArrayList<Alumno> alumnos){
		AlumnoModelo am = new AlumnoModelo();
		Iterator<Alumno> i = am.selectAll().iterator();
		while(i.hasNext()){
			Alumno alumno = i.next();
			mostrarAlumnoConAsignatura(alumno);
		}
	}

	private void mostrarAlumnoConAsignatura(Alumno alumno) {
		System.out.println("Nombre: " + alumno.getNombre() + "\nDni: " + alumno.getDni() + "\nMatricula: " + alumno.getMatriculas());
		
	}
}