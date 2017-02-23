package modelo;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class CONECTAR {
	
	protected Connection cn;
	
    public CONECTAR() { 
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver"); //Driver MYSQL para Java

            String url = "jdbc:mysql://localhost/eskola";//Nombre de la BD

            cn = (Connection) DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("ERROR DE CONEXION");
		
		}
    }

}
