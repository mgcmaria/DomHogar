package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tablas.Cliente;
import tablas.Empleado;
import tablas.Proveedor;

public class AccesoDB {
	
	public static Connection conexion() {
		
		// Paso 1: Cargar el driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;

		// Paso 2: Establecer conexion con la base de datos
		try {
			con = DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/tfg_domhogar",
					"tfg_domhogar", "tfg_domhogar");			
		} catch (SQLException e) {			
			e.getMessage();
			return null;
		}		
		return  con;
	}

	public static void cerrarConexion(Connection conexion) {
		
		try {
			conexion.close();
		} catch (SQLException e) {
			e.getMessage();
			return;
		}		
	}	
	
	//DATOS EMPLEADOS

	public static ArrayList<Empleado> datosEmpleado(Connection conexion ) {

		ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();
		
		Empleado empleado;
		
		try {			

			Statement sentencia = conexion.createStatement(); // Creamos sentencia con Statement
			// Consulta SQL con resulset
			ResultSet rs = sentencia.executeQuery("SELECT * FROM EMPLEADO");

			// Mientras haya registros anadimos al ArrayList
			while (rs.next()) { 
				
				String nombre = rs.getString("NOMBRE");
				String apellidos = rs.getString("APELLIDOS");
				String email = rs.getString("EMAIL");
				String nif = rs.getString("NIF_EMPLEADO");
				String usuario = rs.getString("USUARIO");
				String contrasena = rs.getString("CONTRASENA");
				String perfil = rs.getString("PERFIL");
				int telefono = rs.getInt("TELEFONO");
				
				empleado = new Empleado(nombre, apellidos, email, nif, usuario, contrasena, perfil, telefono);
				
				lista_empleados.add(empleado);				
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}

		return lista_empleados;
	}

	public static String[][] obtenerMatrizEmpleados() {
		Connection conexion = AccesoDB.conexion();				
		
		ArrayList<Empleado> listaEmpleados = AccesoDB.datosEmpleado(conexion);
		
		String matrizInfo[][] = new String[listaEmpleados.size()][5];
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
			matrizInfo[i][0] = listaEmpleados.get(i).getNombre()+"";
			matrizInfo[i][1] = listaEmpleados.get(i).getApellidos()+"";
			matrizInfo[i][2] = listaEmpleados.get(i).getEmail()+"";
			matrizInfo[i][3] = listaEmpleados.get(i).getNif()+"";
			matrizInfo[i][4] = listaEmpleados.get(i).getTelefono()+"";
		}		
		return matrizInfo;
	}

	public static int insertarEmpleado(ArrayList<Empleado> nuevoEmpleado, Connection conexion) {
		
		int afectados = 0;
		
		try {
			//Almacenamos en un String la Sentencia SQL
			String sql = "INSERT INTO EMPLEADO (NIF_EMPLEADO, NOMBRE, APELLIDOS, "
					+ "TELEFONO, EMAIL, USUARIO, CONTRASENA, PERFIL) " 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			String nif = null;
			String nombre = null;
			String apellidos = null;
			int telefono = 0;
			String email = null;
			String usuario = null;
			String pass = null ;
			String perfil = null;
			
			for (Empleado empleado : nuevoEmpleado) {
				nif = empleado.getNif();
				nombre = empleado.getNombre();
				apellidos = empleado.getApellidos();
				telefono = empleado.getTelefono();
				email = empleado.getEmail();
				usuario = empleado.getUsuario();
				pass = empleado.getContrasena();
				perfil = empleado.getPerfil();
			}		
			
			//Con PreparedStatement recogemos los valores introducidos			
			PreparedStatement sentencia;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, nif);
			sentencia.setString(2, nombre);
			sentencia.setString(3, apellidos);
			sentencia.setInt(4, telefono);
			sentencia.setString(5, email);
			sentencia.setString(6, usuario);
			sentencia.setString(7, pass);
			sentencia.setString(8, perfil);
			
			afectados = sentencia.executeUpdate(); //Ejecutamos la inserci�n

		} catch (SQLException e) {
			e.getMessage();
		}
		return afectados;		
	}

	//DATOS PROVEEDORES
	
	public static ArrayList<Proveedor> datosProveedor(Connection conexion ) {

		ArrayList<Proveedor> lista_proveedores = new ArrayList<Proveedor>();
		
		Proveedor proveedor;
		
		try {			

			Statement sentencia = conexion.createStatement(); // Creamos sentencia con Statement
			// Consulta SQL con resulset
			ResultSet rs = sentencia.executeQuery("SELECT * FROM PROVEEDOR");

			// Mientras haya registros anadimos al ArrayList
			while (rs.next()) { 
				
				String codProveedor = rs.getString("CODPROVEEDOR");
				String nombreProveedor = rs.getString("NOMBREPROVEEDOR");
				String mail = rs.getString("MAIL");
				
				proveedor = new Proveedor(codProveedor, nombreProveedor, mail);
				
				lista_proveedores.add(proveedor);				
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}

		return lista_proveedores;
	}
	
	public static String[][] obtenerMatrizProveedores() {
		Connection conexion = AccesoDB.conexion();

		ArrayList<Proveedor> listaProveedores = AccesoDB.datosProveedor(conexion);

		String matrizInfoPr[][] = new String[listaProveedores.size()][3];

		for (int i = 0; i < listaProveedores.size(); i++) {
			matrizInfoPr[i][0] = listaProveedores.get(i).getCodproveedor() + "";
			matrizInfoPr[i][1] = listaProveedores.get(i).getNombreProveedor() + "";
			matrizInfoPr[i][2] = listaProveedores.get(i).getMail() + "";

		}
		return matrizInfoPr;
	}
	
	
	//DATOS CLIENTES
	public static ArrayList<Cliente> datosCliente(Connection conexion ) {

		ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
		
		Cliente cliente;
		
		try {			

			Statement sentencia = conexion.createStatement(); // Creamos sentencia con Statement
			// Consulta SQL con resulset
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE");

			// Mientras haya registros anadimos al ArrayList
			while (rs.next()) { 
				
				String dni_Cliente = rs.getString("DNI_CLIENTE");
				String nombre = rs.getString("NOMBRE");
				int telefono = rs.getInt("TELEFONO");
				String email = rs.getString("EMAIL");
				
				cliente = new Cliente(dni_Cliente, nombre, email, telefono);
				
				lista_clientes.add(cliente);				
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}

		return lista_clientes;
	}
	
	
	public static String[][] obtenerMatrizClientes() {
		Connection conexion = AccesoDB.conexion();

		ArrayList<Cliente> listaClientes = AccesoDB.datosCliente(conexion);

		String matrizInfoCliente[][] = new String[listaClientes.size()][4];

		for (int i = 0; i < listaClientes.size(); i++) {
			matrizInfoCliente[i][0] = listaClientes.get(i).getDni_Cliente() + "";
			matrizInfoCliente[i][1] = listaClientes.get(i).getNombre() + "";
			matrizInfoCliente[i][2] = listaClientes.get(i).getEmail() + "";
			matrizInfoCliente[i][3] = listaClientes.get(i).getTelefono() + "";

		}
		return matrizInfoCliente;
	}
	
	public static int insertarCliente(ArrayList<Cliente> nuevoCliente, Connection conexion) {

		int afectados = 0;

		try {
			// Almacenamos en un String la Sentencia SQL
			String sql = "INSERT INTO CLIENTE (DNI_CLIENTE, NOMBRE, EMAIL, TELEFONO) " + "VALUES (?, ?, ?, ?)";

			String dni = null;
			String nombre = null;
			String email = null;
			int telefono = 0;

			for (Cliente cliente : nuevoCliente) {
				dni = cliente.getDni_Cliente();
				nombre = cliente.getNombre();
				email = cliente.getEmail();
				telefono = cliente.getTelefono();
			}

			// Con PreparedStatement recogemos los valores introducidos
			PreparedStatement sentencia;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, dni);
			sentencia.setString(2, nombre);
			sentencia.setString(3, email);
			sentencia.setInt(4, telefono);

			afectados = sentencia.executeUpdate(); // Ejecutamos la inserci�n

		} catch (SQLException e) {
			e.getMessage();
		}
		return afectados;
	}
	
	public static int actualizarCliente(String dni, String campo, String nuevoDato, Connection conexion) {
		
		int afectados = 0;
		
		// Almacenamos en un String la Sentencia SQL
		String sql = "UPDATE CLIENTE SET " +campo+"= '"+nuevoDato+"' WHERE CODPROVEEDOR='"+dni+"';";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			afectados = sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afectados;
	}

	public static int borrarCliente(String dni, Connection conexion) {
	
		int afectados = 0;
		
		// Almacenamos en un String la Sentencia SQL
		String sql = "DELETE FROM CLIENTE WHERE DNI_CLIENTE='"+dni+"';";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			afectados = sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afectados;		
	}
	
	//DATOS COMPRAS	
	public static String[][] obtenerMatrizCompras() {
		
		Connection conexion = AccesoDB.conexion();

		ArrayList<String> listaCompras = AccesoDB.datosCompras(conexion);
		System.out.println(listaCompras.size());

		String matrizInfoCompras[][] = new String[listaCompras.size()][4];
		
		System.out.println(matrizInfoCompras.toString());

		for (int i = 0; i < listaCompras.size(); i++) {
			matrizInfoCompras[i][0] = listaCompras.get(i).toString() + "";
			matrizInfoCompras[i][1] = listaCompras.get(i).toString() + "";
			matrizInfoCompras[i][2] = listaCompras.get(i).toString() + "";
			matrizInfoCompras[i][3] = listaCompras.get(i).toString() + "";
			
			System.out.println(listaCompras.toString());
		}
		return matrizInfoCompras;		
	}
	
	

	private static ArrayList<String> datosCompras(Connection conexion) {
		
		ArrayList<String> lista_compras = new ArrayList<String>();
		
		try {			

			Statement sentencia = conexion.createStatement(); // Creamos sentencia con Statement
			// Consulta SQL con resulset
			ResultSet rs = sentencia.executeQuery("SELECT la.codproducto, pro.nombreProducto,pro.importeCompra, la.cantidad\r\n" + 
					"FROM LINEA_ALBARAN la \r\n" + 
					"JOIN PRODUCTO pro on la.codproducto = pro.cod_Producto ");

			// Mientras haya registros anadimos al ArrayList
			while (rs.next()) { 
				
				String cod_producto = rs.getString("codproducto");
				String nombre_producto = rs.getString("nombreProducto");
				String importe_compra = rs.getString("importeCompra");
				String cantidad = rs.getString("cantidad");
				
				lista_compras.add(cod_producto);
				lista_compras.add(nombre_producto);
				lista_compras.add(importe_compra);
				lista_compras.add(cantidad);
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}

		return lista_compras;
	}

	public static int actualizarEmpleado(String nif, String campo, String nuevoDato, Connection conexion) {
		
		int afectados = 0;
		
		// Almacenamos en un String la Sentencia SQL
		String sql = "UPDATE EMPLEADO SET " +campo+"= '"+nuevoDato+"' WHERE NIF_EMPLEADO='"+nif+"';";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			afectados = sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afectados;
	}

	public static int borrarEmpleado(String nif, Connection conexion) {
	
		int afectados = 0;
		
		// Almacenamos en un String la Sentencia SQL
		String sql = "DELETE FROM EMPLEADO WHERE NIF_EMPLEADO='"+nif+"';";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			afectados = sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afectados;		
	}
	
	public static int insertarProveedor(ArrayList<Proveedor> nuevoProveedor, Connection conexion) {

		int afectados = 0;

		try {
			// Almacenamos en un String la Sentencia SQL
			String sql = "INSERT INTO PROVEEDOR (CODPROVEEDOR, NOMBREPROVEEDOR, MAIL) " + "VALUES (?, ?, ?)";

			String codigo = null;
			String nombre = null;
			String mail = null;

			for (Proveedor proveedor : nuevoProveedor) {
				codigo = proveedor.getCodproveedor();
				nombre = proveedor.getNombreProveedor();
				mail = proveedor.getMail();
			}

			// Con PreparedStatement recogemos los valores introducidos
			PreparedStatement sentencia;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, codigo);
			sentencia.setString(2, nombre);
			sentencia.setString(3, mail);

			afectados = sentencia.executeUpdate(); // Ejecutamos la inserci�n

		} catch (SQLException e) {
			e.getMessage();
		}
		return afectados;
	}
	
	
	public static int actualizarProveedor(String cod, String campo, String nuevoDato, Connection conexion) {
		
		int afectados = 0;
		
		// Almacenamos en un String la Sentencia SQL
		String sql = "UPDATE PROVEEDOR SET " +campo+"= '"+nuevoDato+"' WHERE CODPROVEEDOR='"+cod+"';";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			afectados = sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afectados;
	}

	public static int borrarProveedor(String cod, Connection conexion) {
	
		int afectados = 0;
		
		// Almacenamos en un String la Sentencia SQL
		String sql = "DELETE FROM PROVEEDOR WHERE CODPROVEEDOR='"+cod+"';";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			afectados = sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afectados;		
	}

	public static Boolean exportarFicheroEmpleados(String user) {
		
		File f = new File("C:\\Users\\"+user+"\\empleados.csv");
		
		Connection conexion = AccesoDB.conexion();
		
		ArrayList<Empleado> lista_empleados = datosEmpleado(conexion);
		
		try {
			FileWriter ficheroEmp = new FileWriter(f);
			
			ficheroEmp.write("NIF,Nombre,Apellidos,Email,Telefono,Usuario,Contrase�a,Perfil");
			ficheroEmp.write("\n");
			
			for (Empleado empleado : lista_empleados) {
				
				ficheroEmp.write(empleado.getNif());
				ficheroEmp.write(",");
				ficheroEmp.write(empleado.getNombre());
				ficheroEmp.write(",");
				ficheroEmp.write(empleado.getApellidos());
				ficheroEmp.write(",");
				ficheroEmp.write(empleado.getEmail());
				ficheroEmp.write(",");
				ficheroEmp.write(Integer.toString(empleado.getTelefono()));
				ficheroEmp.write(",");
				ficheroEmp.write(empleado.getUsuario());
				ficheroEmp.write(",");
				ficheroEmp.write(empleado.getContrasena());
				ficheroEmp.write(",");
				ficheroEmp.write(empleado.getPerfil());
				ficheroEmp.write("\n");
			
			}
			
			ficheroEmp.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	

}
