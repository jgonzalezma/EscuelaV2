package modelo;

import java.util.Date;

public class Matricula {
	private Alumno alumno; // id_alumno
	private Asignatura asignatura; // id_asignatura
	private Date fecha;

	public Matricula(Alumno alumno, Asignatura asignatura, Date fecha) {
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.fecha = fecha;
	}

	public Matricula() {

	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void mostrarMatriculas(){
		
	}
}
