package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	public ArrayList<Matricula> selectAll() {
		ArrayList<Matricula> listaMatriculas = new ArrayList<Matricula>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM matriculas");
			while (rs.next()) {
				Matricula m = new Matricula();
				m.setAlumno(AlumnoModelo.selectPorId(rs.getInt("id_alumno")));
				m.setAsignatura(AsignaturaModelo.selectPorId(rs.getInt("id_asignatura")));
				m.setFecha(rs.getDate("fecha"));
				listaMatriculas.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMatriculas;
	}
}
