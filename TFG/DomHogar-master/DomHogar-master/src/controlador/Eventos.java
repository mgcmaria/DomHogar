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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
						//ventana.getNombreApp().setBounds(0, 15, 1200, 40);
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
						//ventana.getNombreApp().setBounds(0, 15, 1200, 40);
						ventana.getPanelIzq().setVisible(true);
						ventana.getPanelDer().setVisible(true); 
						ventana.getBotonHR().setVisible(true);
						return;
					
					}
					
					else {
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

	//EVENTOS RAT�N CLICKADO
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//BOT�N SALIR
		if (e.getSource()==ventana.getBotonExitInit()) {
			// Pasamos como argumento la conexion a cerrar.
			AccesoDB.cerrarConexion(conexion); 
			//Cerramos la aplicacion
			System.exit(0);
		}
		
		//BOT�N RRHH
		else if (e.getSource()==ventana.getBotonHR()) {
			//Mostramos los paneles de recursos
			ventana.getPanelEmpleado().setVisible(true);
			ventana.getSubPanelEmpInsertar().setVisible(true);
			//Ocultamos el resto
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);

		}
		
		//BOT�N A�ADIR OK RRHH
		else if (e.getSource() == ventana.getBotonInsertFinal()) {
			
			ArrayList<Empleado> nuevoEmpleado = new ArrayList<Empleado>();
			
			//Recogemos los datos del nuevo empleado
			String nombre = ventana.getInsertNomEmpl().getText();
			String apellidos = ventana.getInsertApelEmpl().getText();
			String nif = ventana.getInsertNIFEmp().getText();
			int telefono = Integer.parseInt(ventana.getInsertPhoneEmp().getText());
			String email = ventana.getInsertEmailEmp().getText();
			String user = ventana.getInsertUserEmp().getText();
			String pass = ventana.getInsertPassEmp().getText();
			String perfil = ventana.getInsertPerfilEmp().getText();
			
			Empleado emp = new Empleado(nombre, apellidos, email, nif, user, pass, perfil, telefono);
			
			nuevoEmpleado.add(emp);
			
			int afectados = AccesoDB.insertarEmpleado(nuevoEmpleado, conexion);
			
			if(afectados == 0) {
				ventana.getResulInsertEmp().setText("Error al insertar empleado");
			} else {
				ventana.getResulInsertEmp().setText("Empleado insertado");
				AccesoDB.obtenerMatrizEmpleados();
			}
		}
		
		//BOT�N COMPRAS
		else if(e.getSource()==ventana.getBotonPurchases()) {
			
			//Mostramos
			ventana.getPanelCompras().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
		}
		
		
		//BOT�N VENTAS
		else if(e.getSource()==ventana.getBotonSales()) {
			
			//Mostramos
			ventana.getPanelVentas().setVisible(true);
			
			//Ocultamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			
		}
		
		//BOT�N PROVEEDORES
		else if(e.getSource()==ventana.getBotonSuppliers()) {
			
			//Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getSubPanelInsProv().setVisible(true);
			ventana.getPanelBotonesProv().setVisible(true);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			
			//Oculatamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);			
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);

			
		}
		
		//OPCI�N INSERTAR PROVEEDORES
		else if(e.getSource()==ventana.getBotonInsertProveedor()) {
			
			//Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getPanelBotonesProv().setVisible(true);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(true);

			
			//Oculatamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
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
			
			//Recogemos los datos del nuevo empleado
			String codigo = ventana.getInsertCodProv().getText();
			String nombre = ventana.getInsertNomProv().getText();
			String mail = ventana.getInsertContProv().getText();

			
			Proveedor prov = new Proveedor(codigo, nombre, mail);
			
			nuevoProveedor.add(prov);
			
			int afectados = AccesoDB.insertarProveedor(nuevoProveedor, conexion);
			
			if(afectados == 0) {
				ventana.getResulInsertProv().setText("Error adding supplier");
			} else {
				ventana.getResulInsertProv().setText("Supplier added");
				AccesoDB.obtenerMatrizProveedores();
			}
		}
		
		//OPCI�N ACTUALIZAR PROVEEDOR
		else if(e.getSource()==ventana.getBotonActualizarProveedor()) {
			
			//Mostramos los paneles de Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(true);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(true);

			//Oculatamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);			
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			
		}
		
		//OPCI�N BORRAR PROVEEDOR
		else if(e.getSource()==ventana.getBotonBorrarProveedor()) {
			
			//Proveedores
			ventana.getPanelProveedores().setVisible(true);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(true);
			ventana.getPanelBotonesProv().setVisible(true);

			//Oculatamos el resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);			
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			
		}
		
		//BOT�N CLIENTES
		else if(e.getSource()==ventana.getBotonCustomers()) {
			
			//Clientes
			ventana.getPanelClientes().setVisible(true);
			
			//Resto
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			
		}
		
		//BOT�N SERVICIOS
		else if(e.getSource()==ventana.getBotonServices()) {
			
			//Servicios
			ventana.getPanelServicios().setVisible(true);
			
			//Otros
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			
		}
		
		//BOT�N STOCK
		else if(e.getSource()==ventana.getBotonStock()) {
			
			//Stock
			ventana.getPanelAlmacen().setVisible(true);
			
			//Otros
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
	
		}
		
		//VOLVER ATR�S
		else if(e.getSource()==ventana.getImageLogo()) {
			
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(true);
			ventana.getImagenInicio().setVisible(true);
			
			
		}
		
	}

	//EVENTOS ENTRADA RAT�N
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==ventana.getBotonLogin()) {
			
			 ventana.getBotonLogin().setIcon(new ImageIcon("imagenes/login hover.png"));
			 ventana.getBotonLogin().setBackground(Color.WHITE);
			 
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
	}

	//EVENTOS SALIDA RAT�N
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
		
	}

	//EVENTOS RAT�N PRESIONADO
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
	}

	//EVENTOS RAT�N LIBERADO
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
	}	
}

