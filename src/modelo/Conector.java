package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
	protected static Connection conexion;
	
	Conector(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD, Config.USERNAME, Config.PASSWORD);
		} catch (Exception e) {

		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}
