package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AsignaturaModelo extends Conector {
	public ArrayList<Asignatura> selectAll() {
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM asignaturas");
			while (rs.next()) {
				Asignatura a = new Asignatura(rs.getInt("id"), rs.getString("nombre"), rs.getInt("horas"));
				listaAsignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaAsignaturas;

	}

	public static Asignatura selectPorId(int id) {
		Asignatura asignatura = null;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM asignaturas WHERE id = ('" + id + "')");
			rs.next();
			asignatura = new Asignatura(rs.getInt("id"), rs.getString("nombre"), rs.getInt("horas"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return asignatura;

	}
	public Asignatura getAsignatura(int id_asignatura) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from asignaturas where id = ?");
			pst.setInt(1, id_asignatura);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				
				return asignatura;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
