package modelo;

import java.sql.PreparedStatement;
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
	public ArrayList<Matricula> getMatriculaConAsignatura(Alumno alumno){
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		ArrayList <Matricula> matriculas = new ArrayList<Matricula>();
		Matricula matricula;
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from matriculas where id_alumno =?");
			pst.setInt(1, alumno.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				matricula = new Matricula();
				matricula.setFecha(rs.getDate("fecha"));
				matricula.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("id_asignatura")));
				matriculas.add(matricula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return matriculas;
	}
	
}