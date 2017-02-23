
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import modelo.MODEL_ALUMNO;
import tablas.ALUMNO;

public class PRINCIPAL {

	final static int SELEC_TODOS = 1;
	final static int INSERTAR = 2;
	final static int BORRAR = 3;
	final static int MODIFICAR = 4;
	final static int SELEC_MENORES_18 = 5;
	final static int SELEC_INICIAL = 6;
	final static int MAYORES_65 = 7;
	final static int SALIR = 8;

	public static void main(String[] args) {

		MODEL_ALUMNO model_al = new MODEL_ALUMNO();
		ALUMNO alumno = new ALUMNO();
		ResultSet rs;
// menu principal
		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("\n\n\t\t\tMENU ALUMNOS\n");
			System.out.println("\t\t1.Mostrar todos los alumnos ");
			System.out.println("\t\t2.Insertar alumno nuevo");
			System.out.println("\t\t3.Borrar un alumno cuyo numero se pide por pantalla");
			System.out.println("\t\t4.Modificar el nombre de un alumno cuyo numero se pide por pantalla");
			System.out.println("\t\t5.Mostrar los alumnos menores de 18 anios");
			System.out.println("\t\t6.Mostrar los alumnos cuyo nombre empice por...");
			System.out.println("\t\t7.Modificar los alumnos mayores de 65 (-1)");
			System.out.println("\t\t8.SALIR");
			System.out.print("\n\n\tINTRODUCE UNA OPCION : ");

			opcion = Integer.parseInt(scan.nextLine()); // consumir el salto de
														// linea

			switch (opcion) {
			case MAYORES_65:
				try {
					model_al.modif_65();
				
				} catch (SQLException e) {
					System.out.println("ERROR AL MODIF MAYORES 65" + e.getMessage());
				}
				break;
			case SELEC_INICIAL:
				System.out.println("\t\tDATOS ALUMNO QUE EMPIEZAN POR");
				System.out.println("\tInicial : ");
				String inicial=scan.nextLine();
				
				try {
					rs = model_al.seleccionarInicial(inicial); // el ResultSet es como
														// un ArrayList
					// de objetos alumno, hay que recorrerlo

					while (rs.next()) {

						System.out.println("\n\tALUMNO: " + rs.getInt(1));
						System.out.println("\t\tnombre: " + rs.getString(2));
						System.out.println("\t\tapellido: " + rs.getString(3));
						System.out.println("\t\tedad: " + rs.getInt(4));
						System.out.println("------------------------------");
					}

				} catch (SQLException e) {
					System.out.println("ERROR AL SELECCIONAR ALUMNOS" + e.getMessage());
				}

				break;

			case SELEC_MENORES_18:
				// 5.Mostrar los alumnos menores de 18 anios

				try {
					rs = model_al.seleccionarMenores18(); // el ResultSet es
															// como un ArrayList
					// de objetos alumno, hay que recorrerlo

					while (rs.next()) {

						System.out.println("\n\tALUMNO: " + rs.getInt(1));
						System.out.println("\t\tnombre: " + rs.getString(2));
						System.out.println("\t\tapellido: " + rs.getString(3));
						System.out.println("\t\tedad: " + rs.getInt(4));
						System.out.println("------------------------------");
					}

				} catch (Exception e) {
					System.out.println("ERROR AL SELECCIONAR ALUMNOS" + e.getMessage());
				}

				break;
			case SELEC_TODOS:
				// 1.Mostrar todos los alumnos

				try {
					rs = model_al.seleccionarTodos(); // el ResultSet es como un
														// ArrayList
														// de objetos alumno,
														// hay que recorrerlo

					while (rs.next()) {

						System.out.println("\n\tALUMNO: " + rs.getInt(1));
						System.out.println("\t\tnombre: " + rs.getString(2));
						System.out.println("\t\tapellido: " + rs.getString(3));
						System.out.println("\t\tedad: " + rs.getInt(4));
						System.out.println("------------------------------");
					}

				} catch (SQLException e) {
					System.out.println("ERROR AL SELECCIONAR ALUMNOS" + e.getMessage());
				}

				break;

			case INSERTAR:
				// 2.Insertar alumno nuevo

				System.out.println("\t\tDATOS ALUMNO");
				System.out.println("\tNumero : ");
				alumno.setNumero(Integer.parseInt(scan.nextLine()));// para que
																	// consuma
																	// el return

				System.out.println("\tNombre : ");
				alumno.setNombre(scan.nextLine());

				System.out.println("\tApellido : ");
				alumno.setApellido(scan.nextLine());

				System.out.println("\tEdad : ");
				alumno.setEdad(Integer.parseInt(scan.nextLine()));// para que
																	// consuma
																	// el return

				try {
					model_al.insertar(alumno);
				} catch (Exception e) {
					System.out.println("ERROR AL INSERTAR ALUMNO");
				}

				break;
			case BORRAR:
				// 3.Borrar un alumno cuyo numero se pide por pantalla
				System.out.println("\t\tBORRAR ALUMNO POR NUMERO");
				System.out.println("\tNumero : ");

				int num_aux = Integer.parseInt(scan.nextLine());// para que
																// consuma el
																// return

				try {
					model_al.borrar(num_aux);
				} catch (Exception e) {

					System.out.println("ERROR AL BORRAR ALUMNO" + e.getMessage());
				}

				break;

			case MODIFICAR:
				// 4.Modificar el nombre de un alumno cuyo numero se pide por
				// pantalla

				System.out.println("\n\t\tDATOS ALUMNO A MODIFICAR");
				System.out.print("\tNumero : ");
				alumno.setNumero(Integer.parseInt(scan.nextLine()));// para que
																	// consuma
																	// el return

				System.out.print("\t Nuevo Nombre : ");
				alumno.setNombre(scan.nextLine());

				System.out.print("\tNuevo Apellido : ");
				alumno.setApellido(scan.nextLine());

				System.out.print("\tNuevo Edad : ");
				alumno.setEdad(Integer.parseInt(scan.nextLine()));// para que
																	// consuma
																	// el return

				try {
					model_al.modificar(alumno);
				} catch (Exception e) {
					System.out.println("ERROR AL MODIFICAR ALUMNO" + e.getMessage());
				}

				break;

			case SALIR:
				System.out.println("SALIENDO DE LA APLICACION");
				break;

			default:
				System.out.println("OPCION INCORRECTA");

			}

		} while (opcion != SALIR);
	}
}
