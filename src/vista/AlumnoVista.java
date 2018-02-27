package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Matricula;
import modelo.MatriculaModelo;

public class AlumnoVista {
	static final int LISTAR_ALUMNOS_CON_ASIGNATURA = 1;
	static final int LISTAR_ALUMNOS_CON_PROVINCIA = 2;
	static final int SALIR = 0;
	
	public void menuAlumnos(){
		int opcion;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("---MENU---");
			System.out.println(LISTAR_ALUMNOS_CON_ASIGNATURA + "- Listar alumnos con asignatura");
			System.out.println(LISTAR_ALUMNOS_CON_PROVINCIA + "- Listar alumnos con provincia");
			System.out.println(SALIR + "- Salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case LISTAR_ALUMNOS_CON_ASIGNATURA:
				AlumnoModelo am = new AlumnoModelo();
				ArrayList<Alumno> alumnos = am.selectAll();
				this.mostrarAlumnosAsignaturas(alumnos);
				break;
			case LISTAR_ALUMNOS_CON_PROVINCIA:
				
				break;
			case SALIR:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opcion mal");
				break;
			}
	
			
			
		} while (opcion != SALIR);
	}

	private void mostrarAlumnosAsignaturas(ArrayList<Alumno> alumnos) {
		AlumnoModelo am = new AlumnoModelo();
		Iterator<Alumno> i = am.selectAll().iterator();
		while(i.hasNext()){
			Alumno alumno = i.next();
			mostrarAlumnoAsignatura(alumno);
		}
		
	}
	private void mostrarAlumnoAsignatura(Alumno alumno) {
		System.out.println("Nombre: " + alumno.getNombre() + "\nAsignatura: " + alumno.getMatriculas());
	}
}
