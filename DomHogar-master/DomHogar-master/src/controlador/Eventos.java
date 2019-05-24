package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import tablas.Empleado;
import tablas.Proveedor;
import vista.Ventana;

public class Eventos implements ActionListener, MouseListener {
	
	private Ventana ventana;
	Connection conexion;

	public Eventos(Ventana ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Abrimos la conexion con la BBDD
		conexion = AccesoDB.conexion();				
		if (conexion == null)
		return;	
		
		//Evento LOGIN
		if (e.getSource() == ventana.getBotonLogin()) {
			
			//Creamos un ArrayList donde recogeremos el usuario y la contraseña de las tablas
			ArrayList<Empleado> lista_usuarios = new ArrayList<Empleado>();
			
			//Accedemos a la BBDD para recoger los datos del usuario y la contasena
			lista_usuarios = AccesoDB.datosEmpleado(conexion);
			
			//Recogemos los valores que introducimos en las cajas de texto
			String usuario = ventana.getCajaUser().getText();
			
			// Para recoger el password se regoje en una secuencia de chars
			char contrasenaArray[] = ventana.getCajaPass().getPassword();
			
			//Ahora lo pasamos a un String
			String contrasena = new String (contrasenaArray);
			
			if(usuario.equals("") && contrasena.equals("")) {
				ventana.getEtiquetaResulLogin().setText("Please, enter user and password");
			} else if(usuario.equals("")) {
				ventana.getEtiquetaResulLogin().setText("Please, enter user");
			} else if (contrasena.equals("")) {
				ventana.getEtiquetaResulLogin().setText("Please, enter password");
			} else {
				for (Empleado lista : lista_usuarios) {
					
					if(lista.getUsuario().equalsIgnoreCase(usuario) && lista.getContrasena().equalsIgnoreCase(contrasena) && lista.getPerfil().equalsIgnoreCase("general")) {
						//Ocultamos componentes de la pantalla de Login
						ventana.getImagenLogin().setVisible(false);
						ventana.getEtiquetaUser().setVisible(false);
						ventana.getEtiquetaPass().setVisible(false);
						ventana.getCajaUser().setVisible(false);
						ventana.getCajaPass().setVisible(false);
						ventana.getEtiquetaResulLogin().setVisible(false);
						ventana.getBotonLogin().setVisible(false);
						ventana.getBotonExit().setVisible(false);
						//Mostramos los componentes de la aplicacion y redimensionamos la pantalla
						ventana.setSize(1180,700);
						ventana.setResizable(false);
						ventana.setLayout(null);
						ventana.setLocationRelativeTo(null);
						ventana.getImagenInicio().setVisible(true);
						ventana.getPanelIzq().setVisible(true);
						ventana.getPanelDer().setVisible(true); 
						ventana.getBotonHR().setVisible(false);
						return;
					} 
					
					else if(lista.getUsuario().equalsIgnoreCase(usuario) && lista.getContrasena().equalsIgnoreCase(contrasena) && lista.getPerfil().equalsIgnoreCase("administrador")) {
						//Ocultamos componentes de la pantalla de Login
						ventana.getImagenLogin().setVisible(false);
						ventana.getEtiquetaUser().setVisible(false);
						ventana.getEtiquetaPass().setVisible(false);
						ventana.getCajaUser().setVisible(false);
						ventana.getCajaPass().setVisible(false);
						ventana.getEtiquetaResulLogin().setVisible(false);
						ventana.getBotonLogin().setVisible(false);
						ventana.getBotonExit().setVisible(false);
						//Mostramos los componentes de la aplicacion y redimensionamos la pantalla
						ventana.setSize(1180,700);
						ventana.setResizable(false);
						ventana.setLayout(null);
						ventana.setLocationRelativeTo(null);
						ventana.getImagenInicio().setVisible(true);
						ventana.getPanelIzq().setVisible(true);
						ventana.getPanelDer().setVisible(true); 
						ventana.getBotonHR().setVisible(true);
						return;					
					} else {
						ventana.getEtiquetaResulLogin().setText("Incorrect user and/or password");
					}
				}
			}			
			//Ponemos foco en el usuario
			ventana.getCajaUser().requestFocus();
			return;			
		}	
		
		if (e.getSource() == ventana.getBotonExit()) {
			
			// Pasamos como argumento la conexion a cerrar.
			AccesoDB.cerrarConexion(conexion); 
			//Cerramos la aplicacion
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==ventana.getBotonExitInit()) {
			// Pasamos como argumento la conexion a cerrar.
			AccesoDB.cerrarConexion(conexion); 
			//Cerramos la aplicacion
			System.exit(0);
		}
		else if (e.getSource()==ventana.getBotonHR()) {
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getInsertNomEmpl().setText("");
			ventana.getInsertApelEmpl().setText("");
			ventana.getInsertNIFEmp().setText("");
			ventana.getInsertPhoneEmp().setText("");
			ventana.getInsertEmailEmp().setText("");
			ventana.getInsertUserEmp().setText("");
			ventana.getInsertPassEmp().setText("");
			ventana.getInsertPerfilEmp().setText("");
			ventana.getResulInsertEmp().setText("");
			
			//Mostramos los paneles de recursos
			ventana.getPanelEmpleado().setVisible(true);
			ventana.getSubPanelEmpInsertar().setVisible(true);
			ventana.getSubPanelBotonesEmp().setVisible(true);
			
			//Ocultamos el resto
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);

		}
		
		else if (e.getSource() == ventana.getBotonInsertEmpFinal()) {
			
			if(ventana.getInsertNomEmpl().getText().isEmpty() || ventana.getInsertApelEmpl().getText().isEmpty() ||
					ventana.getInsertNIFEmp().getText().isEmpty() || ventana.getInsertPhoneEmp().getText().isEmpty() ||
					ventana.getInsertEmailEmp().getText().isEmpty() || ventana.getInsertUserEmp().getText().isEmpty() ||
					ventana.getInsertPassEmp().getText().isEmpty() || ventana.getInsertPerfilEmp().getText().isEmpty())
			{
				ventana.getResulInsertEmp().setForeground(Color.RED);
				ventana.getResulInsertEmp().setText("Please, enter all the items");
				
			} else {
				//Limpiamos la etiqueta de resultado final y devolvemos el color
				ventana.getResulInsertEmp().setText("");
				ventana.getResulInsertEmp().setForeground(new Color(0,157,233));
				
				ArrayList<Empleado> nuevoEmpleado = new ArrayList<Empleado>();
				
				//Recogemos los datos del nuevo empleado
				String nombre = ventana.getInsertNomEmpl().getText();
				String apellidos = ventana.getInsertApelEmpl().getText();
				String nif = ventana.getInsertNIFEmp().getText();
				int telefono = Integer.parseInt(ventana.getInsertPhoneEmp().getText());
				String email = ventana.getInsertPhoneEmp().getText();
				String user = ventana.getInsertUserEmp().getText();
				String pass = ventana.getInsertPassEmp().getText();
				String perfil = ventana.getInsertPassEmp().getText();
				
				Empleado emp = new Empleado(nombre, apellidos, email, nif, user, pass, perfil, telefono);
				
				nuevoEmpleado.add(emp);
				
				int afectados = AccesoDB.insertarEmpleado(nuevoEmpleado, conexion);
				
				if(afectados == 0) {
					ventana.getResulInsertEmp().setText("Error to insert employee");
				} else {
					ventana.getResulInsertEmp().setText("Employee insert");
					
					//COMPROBACIONES QUE FALTAN PARA ACTUALIZAR LA JTABLE
					AccesoDB.cerrarConexion(conexion);
					conexion = AccesoDB.conexion();
					AccesoDB.obtenerMatrizEmpleados();
					ventana.getPanelEmpleado().updateUI();
					ventana.getTablaEmpleados().updateUI();
				}
			}			
		}
		
		else if(e.getSource() == ventana.getBotonActualizarEmpleado()) {
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getInsertNIFUpdateEmp().setText("");
			ventana.getInsertNewDataEmp().setText("");
			ventana.getResultUpdateEmp().setText("");
			
			//Ocultamos los paneles de Insert y delete
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelEmpUpdate().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonUpdateEmpFinal()) {
			
			if(ventana.getInsertNIFUpdateEmp().getText().isEmpty() || ventana.getInsertNewDataEmp().getText().isEmpty()) {
				ventana.getResultUpdateEmp().setForeground(Color.RED);
				ventana.getResultUpdateEmp().setText("Please, enter all the items");
			} else {
				//Limpiamos la etiqueta de resultado final y devolvemos el color
				ventana.getResultUpdateEmp().setText("");
				ventana.getResultUpdateEmp().setForeground(new Color(0,157,233));
				
				//Recogemos los datos que queremos actualizar
				String nif = ventana.getInsertNIFUpdateEmp().getText();
				String campo = ventana.getComboUpdateEmp().getSelectedItem().toString();
				String nuevoDato = ventana.getInsertNewDataEmp().getText();
				
				int afectados = AccesoDB.actualizarEmpleado(nif,campo,nuevoDato, conexion);
				
				if(afectados == 0) {
					ventana.getResultUpdateEmp().setText("Error to update employee");
				} else {
					ventana.getResultUpdateEmp().setText("Employee update");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonBorrarEmpleado()) {
			
			//Limpiamos etiquetas rellenas
			ventana.getInsertNIFDeleteEmp().setText("");
			ventana.getResulBusquedaEmp().setText("");
			ventana.getResulDeleteEmp().setText("");
			
			//Ocultamos los paneles de insert y update empleado as� como el bot�n delete
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getBotonDeleteEmpFinal().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelEmpDelete().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonSearchEmp()) {
			
			//Recogemos el nif para buscar el empleado
			String nif = ventana.getInsertNIFDeleteEmp().getText();
			
			ArrayList<Empleado> listaE = AccesoDB.datosEmpleado(conexion);
			
			for (Empleado empleado : listaE) {
				
				if(empleado.getNif().equalsIgnoreCase(nif)) {
					ventana.getResulBusquedaEmp().setText("The employee: | "+ empleado.getNombre()
					+" "+empleado.getApellidos()+" | , will be deleted.");
					ventana.getBotonDeleteEmpFinal().setVisible(true);
					return;
				} else {
					ventana.getResulBusquedaEmp().setText("Employee doesn't exist");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonDeleteEmpFinal()) {
			
			//Recogemos el nif para buscar el empleado
			String nif = ventana.getInsertNIFDeleteEmp().getText();
			
			int afectados = AccesoDB.borrarEmpleado(nif, conexion);
			
			if(afectados == 0) {
				ventana.getResulDeleteEmp().setText("Error to delete employee");
			} else {
				ventana.getResulDeleteEmp().setText("Employee delete");
			}
		}
		
		else if(e.getSource()==ventana.getBotonPurchases()) {
			
			//Mostramos paneles de compras
			ventana.getPanelCompras().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);			
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
		}		
		
		else if(e.getSource()==ventana.getBotonSales()) {
			
			//Mostramos el panel de ventas
			ventana.getPanelVentas().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);			
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			
		}
		
		else if(e.getSource()==ventana.getBotonSuppliers()) {
			
			//Mostramos los paneles de Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getSubPanelInsProv().setVisible(true);
			ventana.getPanelBotonesProv().setVisible(true);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);			
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			
		}
		
		//OPCI�N INSERTAR PROVEEDORES
		else if (e.getSource() == ventana.getBotonInsertProveedor()) {

			// Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getPanelBotonesProv().setVisible(true);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(true);

			// Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);

		}
		
		//BOT�N INSERTAR PROVEEDOR OK
		else if (e.getSource() == ventana.getBotonInsertProvOk()) {

			ArrayList<Proveedor> nuevoProveedor = new ArrayList<Proveedor>();

			// Recogemos los datos del nuevo empleado
			String codigo = ventana.getInsertCodProv().getText();
			String nombre = ventana.getInsertNomProv().getText();
			String mail = ventana.getInsertContProv().getText();

			Proveedor prov = new Proveedor(codigo, nombre, mail);

			nuevoProveedor.add(prov);

			int afectados = AccesoDB.insertarProveedor(nuevoProveedor, conexion);

			if (afectados == 0) {
				ventana.getResulInsertProv().setText("Error adding supplier");
			} else {
				ventana.getResulInsertProv().setText("Supplier added");
				AccesoDB.obtenerMatrizProveedores();
			}
		}
		
		//OPCI�N ACTUALIZAR PROVEEDOR
		else if (e.getSource() == ventana.getBotonActualizarProveedor()) {

			// Mostramos los paneles de Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(true);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(true);

			// Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);

		}
		
		//OPCI�N BORRAR PROVEEDOR
		else if (e.getSource() == ventana.getBotonBorrarProveedor()) {

			// Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(true);
			ventana.getPanelBotonesProv().setVisible(true);

			// Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);

		}
		
		else if(e.getSource()==ventana.getBotonCustomers()) {
			
			//Mostramos panel de clientes
			ventana.getPanelClientes().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);			
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			
		}
		
		else if(e.getSource()==ventana.getBotonServices()) {
			
			//Mostramos panel Servicios
			ventana.getPanelServicios().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);		
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			
		}
		
		else if(e.getSource()==ventana.getBotonStock()) {
			
			//Mostramos panel de Stock
			ventana.getPanelAlmacen().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);			
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			
		}	
		
		//Atr�s
		else if(e.getSource()==ventana.getImageLogo()) {
			
			//Mostramos la imagen de Inicio
			ventana.getImagenInicio().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
					
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==ventana.getBotonLogin()) {			
			 ventana.getBotonLogin().setIcon(new ImageIcon("imagenes/login hover.png"));			 
		}
		else if (e.getSource()==ventana.getBotonExit()) {
			ventana.getBotonExit().setIcon(new ImageIcon("imagenes/exit_login_hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonPurchases()) {
			ventana.getBotonPurchases().setIcon(new ImageIcon("img/purchases hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonSales()) {
			ventana.getBotonSales().setIcon(new ImageIcon("img/sales hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonSuppliers()) {
			ventana.getBotonSuppliers().setIcon(new ImageIcon("img/suppliers hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonCustomers()) {
			ventana.getBotonCustomers().setIcon(new ImageIcon("img/customers hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonServices()) {
			ventana.getBotonServices().setIcon(new ImageIcon("img/services hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonStock()) {
			ventana.getBotonStock().setIcon(new ImageIcon("img/stock hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonHR()) {
			ventana.getBotonHR().setIcon(new ImageIcon("img/human resources hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonUser()) {
			ventana.getBotonUser().setIcon(new ImageIcon("img/boton_user hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonLogout()) {
			ventana.getBotonLogout().setIcon(new ImageIcon("img/logout hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonExitInit()) {
			ventana.getBotonExitInit().setIcon(new ImageIcon("img/exit hover.png"));
		}
		
		else if (e.getSource()==ventana.getBotonInsertEmpFinal()) {
			Image imgBotonInsertFinal = new ImageIcon("img\\insert hover.png").getImage();
			ventana.getBotonInsertEmpFinal().setIcon(new ImageIcon(imgBotonInsertFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonActualizarEmpleado()) {
			Image imgBotonUpdateEmpleado = new ImageIcon("img\\update employee hover.png").getImage();
			ventana.getBotonActualizarEmpleado().setIcon(new ImageIcon(imgBotonUpdateEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonBorrarEmpleado()) {
			Image imgBotonDeleteEmpleado = new ImageIcon("img\\delete employee hover.png").getImage();
			ventana.getBotonBorrarEmpleado().setIcon(new ImageIcon(imgBotonDeleteEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonExpEmplFichero()) {
			Image imgBotonExportEmpleado = new ImageIcon("img\\export to file hover.png").getImage();
			ventana.getBotonExpEmplFichero().setIcon(new ImageIcon(imgBotonExportEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}	
		else if (e.getSource()==ventana.getBotonUpdateEmpFinal()) {
			Image imgBotonUpdateFinal = new ImageIcon("img\\update hover.png").getImage();
			ventana.getBotonUpdateEmpFinal().setIcon(new ImageIcon(imgBotonUpdateFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonSearchEmp()) {
			Image imgBotonSearchEmp = new ImageIcon("img\\search hover.png").getImage();
			ventana.getBotonSearchEmp().setIcon(new ImageIcon(imgBotonSearchEmp.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}	
		else if (e.getSource()==ventana.getBotonDeleteEmpFinal()) {
			Image imgBotonDeleteEmpFinal = new ImageIcon("img\\delete hover.png").getImage();
			ventana.getBotonDeleteEmpFinal().setIcon(new ImageIcon(imgBotonDeleteEmpFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==ventana.getBotonLogin()) {
			 ventana.getBotonLogin().setIcon(new ImageIcon("imagenes/login.png"));
		}
		else if (e.getSource()==ventana.getBotonExit()) {
			ventana.getBotonExit().setIcon(new ImageIcon("imagenes/exit_login.png"));
		}		
		else if (e.getSource()==ventana.getBotonPurchases()) {
			ventana.getBotonPurchases().setIcon(new ImageIcon("img/purchases.png"));
		}		
		else if (e.getSource()==ventana.getBotonSales()) {
			ventana.getBotonSales().setIcon(new ImageIcon("img/sales.png"));
		}		
		else if (e.getSource()==ventana.getBotonSuppliers()) {
			ventana.getBotonSuppliers().setIcon(new ImageIcon("img/suppliers.png"));
		}		
		else if (e.getSource()==ventana.getBotonCustomers()) {
			ventana.getBotonCustomers().setIcon(new ImageIcon("img/customers.png"));
		}		
		else if (e.getSource()==ventana.getBotonServices()) {
			ventana.getBotonServices().setIcon(new ImageIcon("img/services.png"));
		}		
		else if (e.getSource()==ventana.getBotonStock()) {
			ventana.getBotonStock().setIcon(new ImageIcon("img/stock.png"));
		}		
		else if (e.getSource()==ventana.getBotonHR()) {
			ventana.getBotonHR().setIcon(new ImageIcon("img/human resources.png"));
		}
		else if (e.getSource()==ventana.getBotonUser()) {
			ventana.getBotonUser().setIcon(new ImageIcon("img/boton_user.png"));
		}		
		else if (e.getSource()==ventana.getBotonLogout()) {
			ventana.getBotonLogout().setIcon(new ImageIcon("img/logout.png"));
		}		
		else if (e.getSource()==ventana.getBotonExitInit()) {
			ventana.getBotonExitInit().setIcon(new ImageIcon("img/exit.png"));
		}		
		else if (e.getSource()==ventana.getBotonInsertEmpFinal()) {
			Image imgBotonInsertFinal = new ImageIcon("img\\insert.png").getImage();
			ventana.getBotonInsertEmpFinal().setIcon(new ImageIcon(imgBotonInsertFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonActualizarEmpleado()) {
			Image imgBotonUpdateEmpleado = new ImageIcon("img\\update employee.png").getImage();
			ventana.getBotonActualizarEmpleado().setIcon(new ImageIcon(imgBotonUpdateEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonBorrarEmpleado()) {
			Image imgBotonDeleteEmpleado = new ImageIcon("img\\delete employee.png").getImage();
			ventana.getBotonBorrarEmpleado().setIcon(new ImageIcon(imgBotonDeleteEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonExpEmplFichero()) {
			Image imgBotonExportEmpleado = new ImageIcon("img\\export to file.png").getImage();
			ventana.getBotonExpEmplFichero().setIcon(new ImageIcon(imgBotonExportEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonUpdateEmpFinal()) {
			Image imgBotonUpdateFinal = new ImageIcon("img\\update.png").getImage();
			ventana.getBotonUpdateEmpFinal().setIcon(new ImageIcon(imgBotonUpdateFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonSearchEmp()) {
			Image imgBotonSearchEmp = new ImageIcon("img\\search.png").getImage();
			ventana.getBotonSearchEmp().setIcon(new ImageIcon(imgBotonSearchEmp.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonDeleteEmpFinal()) {
			Image imgBotonDeleteEmpFinal = new ImageIcon("img\\delete.png").getImage();
			ventana.getBotonDeleteEmpFinal().setIcon(new ImageIcon(imgBotonDeleteEmpFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==ventana.getBotonLogin()) {			
			 ventana.getBotonLogin().setIcon(new ImageIcon("imagenes/login press.png"));	
			 ventana.getBotonLogin().setContentAreaFilled(false);			
		}
		else if (e.getSource()==ventana.getBotonExit()) {
			
			ventana.getBotonExit().setIcon(new ImageIcon("imagenes/exit login press.png"));
			ventana.getBotonExit().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonPurchases()) {
			
			ventana.getBotonPurchases().setIcon(new ImageIcon("img/purchases press.png"));
			ventana.getBotonPurchases().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonSales()) {
			ventana.getBotonSales().setIcon(new ImageIcon("img/sales press.png"));			
			ventana.getBotonSales().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonSuppliers()) {
			ventana.getBotonSuppliers().setIcon(new ImageIcon("img/suppliers press.png"));			
			ventana.getBotonSuppliers().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonCustomers()) {
			ventana.getBotonCustomers().setIcon(new ImageIcon("img/customers press.png"));			
			ventana.getBotonCustomers().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonServices()) {
			ventana.getBotonServices().setIcon(new ImageIcon("img/services press.png"));			
			ventana.getBotonServices().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonStock()) {
			ventana.getBotonStock().setIcon(new ImageIcon("img/stock press.png"));			
			ventana.getBotonStock().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonHR()) {
			ventana.getBotonHR().setIcon(new ImageIcon("img/human resources press.png"));			
			ventana.getBotonHR().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonUser()) {
			ventana.getBotonUser().setIcon(new ImageIcon("img/boton_user press.png"));			
			ventana.getBotonUser().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonLogout()) {
			ventana.getBotonLogout().setIcon(new ImageIcon("img/logout press.png"));			
			ventana.getBotonLogout().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonExitInit()) {
			ventana.getBotonExitInit().setIcon(new ImageIcon("img/exit press.png"));			
			ventana.getBotonExitInit().setContentAreaFilled(false);
		}		
		else if (e.getSource()==ventana.getBotonInsertEmpFinal()) {
			Image imgBotonInsertFinal = new ImageIcon("img\\insert press.png").getImage();
			ventana.getBotonInsertEmpFinal().setIcon(new ImageIcon(imgBotonInsertFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonInsertEmpFinal().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonActualizarEmpleado()) {
			Image imgBotonUpdateEmpleado = new ImageIcon("img\\update employee press.png").getImage();
			ventana.getBotonActualizarEmpleado().setIcon(new ImageIcon(imgBotonUpdateEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
			ventana.getBotonActualizarEmpleado().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonBorrarEmpleado()) {
			Image imgBotonDeleteEmpleado = new ImageIcon("img\\delete employee press.png").getImage();
			ventana.getBotonBorrarEmpleado().setIcon(new ImageIcon(imgBotonDeleteEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
			ventana.getBotonBorrarEmpleado().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonExpEmplFichero()) {
			Image imgBotonExportEmpleado = new ImageIcon("img\\export to file press.png").getImage();
			ventana.getBotonExpEmplFichero().setIcon(new ImageIcon(imgBotonExportEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
			ventana.getBotonExpEmplFichero().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonUpdateEmpFinal()) {
			Image imgBotonUpdateFinal = new ImageIcon("img\\update press.png").getImage();
			ventana.getBotonUpdateEmpFinal().setIcon(new ImageIcon(imgBotonUpdateFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonUpdateEmpFinal().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonSearchEmp()) {
			Image imgBotonSearchEmp = new ImageIcon("img\\search press.png").getImage();
			ventana.getBotonSearchEmp().setIcon(new ImageIcon(imgBotonSearchEmp.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonSearchEmp().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonDeleteEmpFinal()) {
			Image imgBotonDeleteEmpFinal = new ImageIcon("img\\delete press.png").getImage();
			ventana.getBotonDeleteEmpFinal().setIcon(new ImageIcon(imgBotonDeleteEmpFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonDeleteEmpFinal().setContentAreaFilled(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==ventana.getBotonLogin()) {
			 ventana.getBotonLogin().setIcon(new ImageIcon("imagenes/login.png"));
		}
		else if (e.getSource()==ventana.getBotonExit()) {
			ventana.getBotonExit().setIcon(new ImageIcon("imagenes/exit_login.png"));
		}		
		else if (e.getSource()==ventana.getBotonPurchases()) {
			ventana.getBotonPurchases().setIcon(new ImageIcon("img/purchases.png"));
		}		
		else if (e.getSource()==ventana.getBotonSales()) {
			ventana.getBotonSales().setIcon(new ImageIcon("img/sales.png"));
		}		
		else if (e.getSource()==ventana.getBotonSuppliers()) {
			ventana.getBotonSuppliers().setIcon(new ImageIcon("img/suppliers.png"));
		}		
		else if (e.getSource()==ventana.getBotonCustomers()) {
			ventana.getBotonCustomers().setIcon(new ImageIcon("img/customers.png"));
		}		
		else if (e.getSource()==ventana.getBotonServices()) {
			ventana.getBotonServices().setIcon(new ImageIcon("img/services.png"));
		}		
		else if (e.getSource()==ventana.getBotonStock()) {
			ventana.getBotonStock().setIcon(new ImageIcon("img/stock.png"));
		}		
		else if (e.getSource()==ventana.getBotonHR()) {
			ventana.getBotonHR().setIcon(new ImageIcon("img/human resources.png"));
		}		
		else if (e.getSource()==ventana.getBotonUser()) {
			ventana.getBotonUser().setIcon(new ImageIcon("img/boton_user.png"));
		}		
		else if (e.getSource()==ventana.getBotonLogout()) {
			ventana.getBotonLogout().setIcon(new ImageIcon("img/logout.png"));
		}		
		else if (e.getSource()==ventana.getBotonExitInit()) {
			ventana.getBotonExitInit().setIcon(new ImageIcon("img/exit.png"));
		}		
		else if (e.getSource()==ventana.getBotonInsertEmpFinal()) {
			Image imgBotonInsertFinal = new ImageIcon("img\\insert.png").getImage();
			ventana.getBotonInsertEmpFinal().setIcon(new ImageIcon(imgBotonInsertFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonActualizarEmpleado()) {
			Image imgBotonUpdateEmpleado = new ImageIcon("img\\update employee.png").getImage();
			ventana.getBotonActualizarEmpleado().setIcon(new ImageIcon(imgBotonUpdateEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonBorrarEmpleado()) {
			Image imgBotonDeleteEmpleado = new ImageIcon("img\\delete employee.png").getImage();
			ventana.getBotonBorrarEmpleado().setIcon(new ImageIcon(imgBotonDeleteEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonExpEmplFichero()) {
			Image imgBotonExportEmpleado = new ImageIcon("img\\export to file.png").getImage();
			ventana.getBotonExpEmplFichero().setIcon(new ImageIcon(imgBotonExportEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonUpdateEmpFinal()) {
			Image imgBotonUpdateFinal = new ImageIcon("img\\update.png").getImage();
			ventana.getBotonUpdateEmpFinal().setIcon(new ImageIcon(imgBotonUpdateFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonSearchEmp()) {
			Image imgBotonSearchEmp = new ImageIcon("img\\search.png").getImage();
			ventana.getBotonSearchEmp().setIcon(new ImageIcon(imgBotonSearchEmp.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonDeleteEmpFinal()) {
			Image imgBotonDeleteEmpFinal = new ImageIcon("img\\delete.png").getImage();
			ventana.getBotonDeleteEmpFinal().setIcon(new ImageIcon(imgBotonDeleteEmpFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
	}	
}

