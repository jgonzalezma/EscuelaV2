package modelo;

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
}
