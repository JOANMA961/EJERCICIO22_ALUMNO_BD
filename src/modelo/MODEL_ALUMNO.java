package modelo;

import com.mysql.jdbc.Connection;
import tablas.ALUMNO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MODEL_ALUMNO extends CONECTAR {

	public MODEL_ALUMNO() {
		super();
	}

	public ResultSet seleccionarTodos() throws SQLException {

		Statement st = cn.createStatement();
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS ");

			return rs;
			
		} catch (Exception e) {
			throw e;
		}

	}
	public ResultSet seleccionarInicial(String inicial) throws SQLException {

		try {
			PreparedStatement pst = cn.prepareStatement("SELECT NOMBRE, APELLIDO FROM ALUMNOS "
					+ "WHERE NOMBRE LIKE ?");

			pst.setString(1, inicial+"%");
			

			ResultSet rs=pst.executeQuery(); // EJECUTA

			System.out.println("pst");
			return rs;

		} catch (Exception e) {
			throw e;
		}

	}
	public void insertar(ALUMNO alumno) throws SQLException {

		// escribir la instruccion INSERT
		try {
			PreparedStatement pst = cn.prepareStatement("INSERT INTO ALUMNOS VALUES (?,?,?,?)");

			pst.setInt(1, alumno.getNumero()); // primera ???????????
			pst.setString(2, alumno.getNombre()); // segunda ???????????
			pst.setString(3, alumno.getApellido()); // tercera ???????????
			pst.setInt(4, alumno.getEdad()); // cuarto ???????????

			pst.execute(); // EJECUTA

			System.out.println("ALUMNO INSERTADO CON EXITO");

		} catch (SQLException ex) {
			throw ex;
		}

	}

	public void borrar(int num) throws Exception {
		
	try{	
		PreparedStatement pst=cn.prepareStatement("DELETE FROM ALUMNOS WHERE NUMERO = ?");
		
		pst.setInt(1, num);
		pst.execute();

		if (pst.getUpdateCount()==0){ //no ha borrado nada
			System.out.println("ALUMNO NO EXISTE");
		}else{
			System.out.println("ALUMNO BORRADO CON EXITO");
		}
		
	} catch (SQLException ex) {
		throw ex;
	}
		
	}
	
	public void modificar(ALUMNO alumno) throws SQLException{
		
		try {
			PreparedStatement pst=cn.prepareStatement("UPDATE ALUMNOS SET nombre=?,apellido=?,edad=?"
					+ " WHERE NUMERO=?" );
		
			pst.setString(1,alumno.getNombre());
			pst.setString(2,alumno.getApellido());
			pst.setInt(3, alumno.getEdad());
			pst.setInt(4, alumno.getNumero());
			
			System.out.println(pst);
			pst.execute();

			if (pst.getUpdateCount()==0){ //no ha modificado nada
				System.out.println("ALUMNO NO EXISTE");
			}else{
				System.out.println("ALUMNO MODIFICADO CON EXITO");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		
	}

	public void modif_65() throws SQLException {
		
		try {
			Statement st=cn.createStatement();
			
			int num_filas=st.executeUpdate("UPDATE alumnos set edad=-1 where edad>65");
			
			if (num_filas ==0){
				System.out.println("\tNO HAY ALUMNOS MAYORES DE 65");
			}else {
				System.out.println("\tALUMNOS MAYORES DE 65 MODIFICADOS CORRECTAMENTE");
			}

		} catch (SQLException e) {
			throw e;
		}
		
		
	}

	public ResultSet seleccionarMenores18() throws Exception{
	    
	    
	    try {
	        Statement st=cn.createStatement();
	        
	        ResultSet rs=st.executeQuery("SELECT * from ALUMNOS where edad>18");      //ejecutar
	        return rs;
	        
	    } catch (Exception ex) {
	        throw ex;
	    }
	    
	}
		
}