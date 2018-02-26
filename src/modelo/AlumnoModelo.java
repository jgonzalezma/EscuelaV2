package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoModelo extends Conector {
	public ArrayList<Alumno> selectAll() {
		ArrayList<Alumno> ListaAlumnos = new ArrayList<Alumno>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
			while (rs.next()) {
				Alumno a = new Alumno(rs.getInt("id"), rs.getString("dni"), rs.getString("nombre"),
						rs.getString("email"));
				ListaAlumnos.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ListaAlumnos;

	}

	public static Alumno selectPorId(int id) {
		Alumno alumno = null;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos WHERE id = ('" + id + "')");
			rs.next();
			alumno = new Alumno(rs.getInt("id"), rs.getString("dni"), rs.getString("nombre"), rs.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alumno;
	}
	public ArrayList<Alumno> selectAllConMatriculas(){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		MatriculaModelo matriculaModelo = new MatriculaModelo();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos");
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));
				ArrayList<Matricula> matriculas = matriculaModelo.getMatriculaConAsignatura(alumno);
				alumno.setMatriculas(matriculas);

				alumnos.add(alumno);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	public ArrayList<Alumno> getAlumnosConAsignatura(Alumno alumno){
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		ArrayList <Alumno> alumnos = new ArrayList<Alumno>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from asignaturas where id = ?");
			pst.setInt(1, alumno.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				alumno = new Alumno();
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre("nombre");
				alumno.setEmail(rs.getString("email"));
				alumno.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("id_asignatura")));
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
}
