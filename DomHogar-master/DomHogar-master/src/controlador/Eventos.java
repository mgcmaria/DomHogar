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

import tablas.Cliente;
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
		
		//BOT�N LOGOUT
		else if(e.getSource()==ventana.getBotonLogout()) {
			
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelIzq().setVisible(false);
			ventana.getPanelDer().setVisible(false); 
			ventana.getBotonHR().setVisible(false);
			ventana.getPanelEmpleado().setVisible(false);
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelBotonesEmp().setVisible(false);
			ventana.getImagenInicio().setVisible(false);
			ventana.getPanelCompras().setVisible(false);
			ventana.getPanelVentas().setVisible(false);
			ventana.getPanelProveedores().setVisible(false);
			ventana.getPanelClientes().setVisible(false);
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelEmpExport().setVisible(false);
			ventana.getBotonDeleteEmpFinal().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);

			
			ventana.setSize(400,520);
			ventana.setResizable(false);
			ventana.setLayout(null);
			ventana.setLocationRelativeTo(null);
			ventana.getImagenLogin().setVisible(true);
			ventana.getEtiquetaUser().setVisible(true);
			ventana.getEtiquetaPass().setVisible(true);
			ventana.getCajaUser().setVisible(true);
			ventana.getCajaPass().setVisible(true);
			ventana.getEtiquetaResulLogin().setVisible(true);
			ventana.getBotonLogin().setVisible(true);
			ventana.getBotonExit().setVisible(true);
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getCajaUser().setText("");
			ventana.getCajaPass().setText("");
			ventana.getCajaUser().requestFocus();
			ventana.getEtiquetaResulLogin().setText("");

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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelEmpExport().setVisible(false);
			ventana.getBotonDeleteEmpFinal().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);

		}
		
		else if (e.getSource() == ventana.getBotonInsertEmpFinal()) {
			
			if(ventana.getInsertNomEmpl().getText().isEmpty() || ventana.getInsertApelEmpl().getText().isEmpty() ||
					ventana.getInsertNIFEmp().getText().isEmpty() || ventana.getInsertPhoneEmp().getText().isEmpty() ||
					ventana.getInsertEmailEmp().getText().isEmpty() || ventana.getInsertUserEmp().getText().isEmpty() ||
					ventana.getInsertPassEmp().getText().isEmpty() || ventana.getInsertPerfilEmp().getText().isEmpty())
			{
				ventana.getResulInsertEmp().setText("Please, enter all the items");
				
			} else {
				//Limpiamos la etiqueta de resultado final
				ventana.getResulInsertEmp().setText("");
				
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
					ventana.getResulInsertEmp().setText("Error adding new employee");
				} else {
					ventana.getResulInsertEmp().setText("Employee added");
					
					
					//COMPROBACIONES QUE FALTAN PARA ACTUALIZAR LA JTABLE
				
				}
			}			
		}
		
		else if(e.getSource() == ventana.getBotonActualizarEmpleado()) {
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getInsertNIFUpdateEmp().setText("");
			ventana.getInsertNewDataEmp().setText("");
			ventana.getResultUpdateEmp().setText("");
			
			//Ocultamos los paneles de Insert, delete, export
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			ventana.getSubPanelEmpExport().setVisible(false);
			ventana.getBotonDeleteEmpFinal().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelEmpUpdate().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonUpdateEmpFinal()) {
			
			if(ventana.getInsertNIFUpdateEmp().getText().isEmpty() || ventana.getInsertNewDataEmp().getText().isEmpty()) {
				ventana.getResultUpdateEmp().setText("Please, enter all the fields");
			} else {
				//Limpiamos la etiqueta de resultado final
				ventana.getResultUpdateEmp().setText("");
				
				//Recogemos los datos que queremos actualizar
				String nif = ventana.getInsertNIFUpdateEmp().getText();
				String campo = ventana.getComboUpdateEmp().getSelectedItem().toString();
				String nuevoDato = ventana.getInsertNewDataEmp().getText();
				
				int afectados = AccesoDB.actualizarEmpleado(nif,campo,nuevoDato, conexion);
				
				if(afectados == 0) {
					ventana.getResultUpdateEmp().setText("Error updating employee");
				} else {
					ventana.getResultUpdateEmp().setText("Employee updated");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonBorrarEmpleado()) {
			
			//Limpiamos etiquetas rellenas
			ventana.getInsertNIFDeleteEmp().setText("");
			ventana.getResulBusquedaEmp().setText("");
			ventana.getResulDeleteEmp().setText("");
			
			//Ocultamos los paneles de insert y update empleado, boton delete y export
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getBotonDeleteEmpFinal().setVisible(false);
			ventana.getSubPanelEmpExport().setVisible(false);
			
			//Mostramos el panel de Borrar
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
				ventana.getResulDeleteEmp().setText("Error deleting employee");
			} else {
				ventana.getResulDeleteEmp().setText("Employee deleted");
			}
		}
		
		else if(e.getSource() == ventana.getBotonExpEmplFichero()) {
			
			//Limpiamos la etiqueta de la ruta si estuviera rellena
			ventana.getInsertRutaExportEmp().setText("");
			
			//Ocultamos los paneles de insert, update empleado y boton delete
			ventana.getSubPanelEmpInsertar().setVisible(false);
			ventana.getSubPanelEmpUpdate().setVisible(false);
			ventana.getBotonDeleteEmpFinal().setVisible(false);
			ventana.getSubPanelEmpDelete().setVisible(false);
			
			//Mostramos el panel de Export
			ventana.getSubPanelEmpExport().setVisible(true);
			
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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			
		}
		
		else if(e.getSource()==ventana.getBotonSuppliers()) {
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getInsertCodProv().setText("");
			ventana.getInsertNomProv().setText("");
			ventana.getInsertContProv().setText("");
			ventana.getResulInsertProv().setText("");
			
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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			
		}
		
		
		//BOT�N INSERTAR PROVEEDOR 
		else if (e.getSource() == ventana.getBotonInsertProvOk()) {

			if(ventana.getInsertCodProv().getText().isEmpty() || ventana.getInsertNomProv().getText().isEmpty() ||
					ventana.getInsertContProv().getText().isEmpty())
			{
				ventana.getResulInsertProv().setForeground(Color.GRAY);
				ventana.getResulInsertProv().setText("Please, enter all the fields");
				
			} else {
				//Limpiamos la etiqueta de resultado final y devolvemos el color
				ventana.getResulInsertProv().setText("");
				ventana.getResulInsertProv().setForeground(new Color(0,157,233));
				
				
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
				//AccesoDB.obtenerMatrizProveedores();
				//ventana.repaint();
			}
		}
			
		}
		
		else if(e.getSource() == ventana.getBotonActualizarProveedor()) {
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getInsertCODUpdateProv().setText("");
			ventana.getInsertNewDataProv().setText("");
			ventana.getResultUpdateProv().setText("");
			
			//Ocultamos los paneles de Insert y delete
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelEditProv().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonUpdateFinalPr()) {
			
			if(ventana.getInsertCODUpdateProv().getText().isEmpty() || ventana.getInsertNewDataProv().getText().isEmpty()) {
				ventana.getResultUpdateProv().setForeground(Color.RED);
				ventana.getResultUpdateProv().setText("Please, enter all the items");
			} else {
				//Limpiamos la etiqueta de resultado final y devolvemos el color
				ventana.getResultUpdateProv().setText("");
				ventana.getResultUpdateProv().setForeground(new Color(0,157,233));
				
				//Recogemos los datos que queremos actualizar
				String cod = ventana.getInsertCODUpdateProv().getText();
				String campo = ventana.getComboUpdateProv().getSelectedItem().toString();
				String nuevoDato = ventana.getInsertNewDataProv().getText();
				
				int afectados = AccesoDB.actualizarProveedor(cod, campo, nuevoDato, conexion);
				
				if(afectados == 0) {
					ventana.getResultUpdateProv().setText("Error to update supplier");
				} else {
					ventana.getResultUpdateProv().setText("Supplier updated");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonBorrarProveedor()) {
			
			//Limpiamos etiquetas rellenas
			ventana.getInsertCODDeleteProv().setText("");
			ventana.getResulBusquedaProv().setText("");
			ventana.getResulDeleteProv().setText("");
			
			//Ocultamos los paneles de insert y update empleado as� como el bot�n delete
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getBotonDeleteProvFinal().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelElimProv().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonSearchProv()) {
			
			//Recogemos el nif para buscar el empleado
			String cod = ventana.getInsertCODDeleteProv().getText();
			
			ArrayList<Proveedor> listaP = AccesoDB.datosProveedor(conexion);
			
			for (Proveedor proveedor : listaP) {
				
				if(proveedor.getCodproveedor().equalsIgnoreCase(cod)) {
					ventana.getResulBusquedaProv().setText("The supplier: | "+ proveedor.getNombreProveedor()
					+" "+" | , will be deleted.");
					ventana.getBotonDeleteProvFinal().setVisible(true);
					return;
				} else {
					ventana.getResulBusquedaProv().setText("Supplier doesn't exist");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonDeleteProvFinal()) {
			
			//Recogemos el nif para buscar el empleado
			String cod = ventana.getInsertCODDeleteProv().getText();
			
			int afectados = AccesoDB.borrarProveedor(cod, conexion);
			
			if(afectados == 0) {
				ventana.getResulDeleteProv().setText("Error deleting supplier");
			} else {
				ventana.getResulDeleteProv().setText("Supplier deleted");
			}
		}
		
		
		else if(e.getSource()==ventana.getBotonCustomers()) {
			
			//Mostramos panel de clientes
			ventana.getPanelClientes().setVisible(true);
			ventana.getSubPanelInsCliente().setVisible(true);
			ventana.getPanelBotonesCliente().setVisible(true);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			
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
		
		//BOT�N INSERTAR CLIENTE
		else if (e.getSource() == ventana.getBotonInsertClienteok()) {

			if(ventana.getInsertCodProv().getText().isEmpty() || ventana.getInsertNomProv().getText().isEmpty() ||
					ventana.getInsertContProv().getText().isEmpty())
			{
				ventana.getResulInsertCliente().setForeground(Color.GRAY);
				ventana.getResulInsertCliente().setText("Please, enter all the fields");
				
			} else {
				//Limpiamos la etiqueta de resultado final y devolvemos el color
				ventana.getResulInsertCliente().setText("");
				ventana.getResulInsertCliente().setForeground(new Color(0,157,233));
				
				
			ArrayList<Cliente> nuevoCliente = new ArrayList<Cliente>();

			// Recogemos los datos del nuevo empleado
			String dni = ventana.getInsertNIFCliente().getText();
			String nombre = ventana.getInsertNomCliente().getText();
			int telefono = Integer.parseInt(ventana.getInsertTelCliente().getText());
			String email = ventana.getInsertMailCliente().getText();

			Cliente cli = new Cliente(dni, nombre, email, telefono);

			nuevoCliente.add(cli);

			int afectados = AccesoDB.insertarCliente(nuevoCliente, conexion);

			if (afectados == 0) {
				ventana.getResulInsertCliente().setText("Error adding customer");
			} else {
				ventana.getResulInsertCliente().setText("Customer added");
				AccesoDB.obtenerMatrizClientes();
			}
		}
		
	}
		
		
		else if(e.getSource() == ventana.getBotonActualizarCliente()) {
			
			//Limpiamos todas la etiquetas rellenas
			ventana.getInsertNIFUpdateCliente().setText("");
			ventana.getInsertNewDataCliente().setText("");
			ventana.getResultUpdateCliente().setText("");
			
			//Ocultamos los paneles de Insert y delete
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelEditCliente().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonUpdateFinalCl()) {
			
			if(ventana.getInsertNIFUpdateCliente().getText().isEmpty() || ventana.getInsertNewDataCliente().getText().isEmpty()) {
				ventana.getResultUpdateProv().setForeground(Color.RED);
				ventana.getResultUpdateCliente().setText("Please, enter all the items");
			} else {
				//Limpiamos la etiqueta de resultado final y devolvemos el color
				ventana.getResultUpdateCliente().setText("");
				ventana.getResultUpdateCliente().setForeground(new Color(0,157,233));
				
				//Recogemos los datos que queremos actualizar
				String cod = ventana.getInsertNIFUpdateCliente().getText();
				String campo = ventana.getComboUpdateCliente().getSelectedItem().toString();
				String nuevoDato = ventana.getInsertNewDataCliente().getText();
				
				int afectados = AccesoDB.actualizarCliente(cod, campo, nuevoDato, conexion);
				
				if(afectados == 0) {
					ventana.getResultUpdateCliente().setText("Error updating customer");
				} else {
					ventana.getResultUpdateCliente().setText("Customer updated");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonBorrarCliente()) {
			
			//Limpiamos etiquetas rellenas
			ventana.getInsertNIFDeleteCli().setText("");
			ventana.getResulBusquedaCli().setText("");
			ventana.getResulDeleteCliente().setText("");
			
			//Ocultamos los paneles de insert y update empleado as� como el bot�n delete
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getBotonDeleteClienteFinal().setVisible(false);
			
			//Mostramos el panel de Update
			ventana.getSubPanelElimCliente().setVisible(true);
		}
		
		else if(e.getSource() == ventana.getBotonSearchCliente()) {
			
			//Recogemos el nif para buscar el cliente
			String nif = ventana.getInsertNIFDeleteCli().getText();
			
			ArrayList<Cliente> listaCli = AccesoDB.datosCliente(conexion);
			
			for (Cliente cliente : listaCli) {
				
				if(cliente.getDni_Cliente().equalsIgnoreCase(nif)) {
					ventana.getResulBusquedaCli().setText("The customer: | "+ cliente.getNombre()
					+" "+" | , will be deleted.");
					ventana.getBotonDeleteClienteFinal().setVisible(true);
					return;
				} else {
					ventana.getResulBusquedaCli().setText("Customer doesn't exist");
				}
			}
		}
		
		else if(e.getSource() == ventana.getBotonDeleteClienteFinal()) {
			
			//Recogemos el nif para buscar el cliente
			String nif = ventana.getInsertNIFDeleteCli().getText();
			
			int afectados = AccesoDB.borrarCliente(nif, conexion);
			
			if(afectados == 0) {
				ventana.getResulDeleteCliente().setText("Error deleting customer");
			} else {
				ventana.getResulDeleteCliente().setText("Customer deleted");
			}
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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
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
			ventana.getSubPanelInsCliente().setVisible(false);
			ventana.getPanelBotonesCliente().setVisible(false);
			ventana.getSubPanelEditCliente().setVisible(false);
			ventana.getSubPanelElimCliente().setVisible(false);
			ventana.getPanelServicios().setVisible(false);
			ventana.getPanelAlmacen().setVisible(false);
			ventana.getSubPanelInsProv().setVisible(false);
			ventana.getPanelBotonesProv().setVisible(false);
			ventana.getSubPanelEditProv().setVisible(false);
			ventana.getSubPanelElimProv().setVisible(false);
					
		}
		
	}

	//FALTAN IMAGENES BOTONES CLIENTES
	
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
		
		//
		else if (e.getSource()==ventana.getBotonInsertProvOk()) {
			Image imgBotonInsertProvOk = new ImageIcon("img\\insert hover.png").getImage();
			ventana.getBotonInsertProvOk().setIcon(new ImageIcon(imgBotonInsertProvOk.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonActualizarProveedor()) {
			Image imgBotonUpdateProveedor = new ImageIcon("img\\update supplier hover.png").getImage();
			ventana.getBotonActualizarProveedor().setIcon(new ImageIcon(imgBotonUpdateProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonBorrarProveedor()) {
			Image imgBotonBorrarProveedor = new ImageIcon("img\\delete supplier hover.png").getImage();
			ventana.getBotonBorrarProveedor().setIcon(new ImageIcon(imgBotonBorrarProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonDeliveryNotes()) {
			Image imgBotonDeliveryNotes = new ImageIcon("img\\delivery notes hover.png").getImage();
			ventana.getBotonDeliveryNotes().setIcon(new ImageIcon(imgBotonDeliveryNotes.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}	
		
		
		else if (e.getSource()==ventana.getBotonUpdateFinalPr()) {
			Image imgBotonUpdateFinalPr = new ImageIcon("img\\update hover.png").getImage();
			ventana.getBotonUpdateFinalPr().setIcon(new ImageIcon(imgBotonUpdateFinalPr.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonSearchProv()) {
			Image imgBotonSearchProv = new ImageIcon("img\\search hover.png").getImage();
			ventana.getBotonSearchProv().setIcon(new ImageIcon(imgBotonSearchProv.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}	
		else if (e.getSource()==ventana.getBotonDeleteProvFinal()) {
			Image imgBotonDeleteProvFinal = new ImageIcon("img\\delete hover.png").getImage();
			ventana.getBotonDeleteProvFinal().setIcon(new ImageIcon(imgBotonDeleteProvFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
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
		
		//
		
		else if (e.getSource()==ventana.getBotonActualizarProveedor()) {
			Image imgBotonUpdateProveedor = new ImageIcon("img\\update supplier.png").getImage();
			ventana.getBotonActualizarProveedor().setIcon(new ImageIcon(imgBotonUpdateProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonBorrarProveedor()) {
			Image imgBotonBorrarProveedor = new ImageIcon("img\\delete supplier.png").getImage();
			ventana.getBotonBorrarProveedor().setIcon(new ImageIcon(imgBotonBorrarProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonDeliveryNotes()) {
			Image imgBotonDeliveryNotes = new ImageIcon("img\\delivery notes.png").getImage();
			ventana.getBotonDeliveryNotes().setIcon(new ImageIcon(imgBotonDeliveryNotes.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}	
		else if (e.getSource()==ventana.getBotonInsertProvOk()) {
			Image imgBotonInsertProvOk = new ImageIcon("img\\insert.png").getImage();
			ventana.getBotonInsertProvOk().setIcon(new ImageIcon(imgBotonInsertProvOk.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonUpdateFinalPr()) {
			Image imgBotonUpdateFinalPr = new ImageIcon("img\\update.png").getImage();
			ventana.getBotonUpdateFinalPr().setIcon(new ImageIcon(imgBotonUpdateFinalPr.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonSearchProv()) {
			Image imgBotonSearchProv = new ImageIcon("img\\search.png").getImage();
			ventana.getBotonSearchProv().setIcon(new ImageIcon(imgBotonSearchProv.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonDeleteProvFinal()) {
			Image imgBotonDeleteProvFinal = new ImageIcon("img\\delete.png").getImage();
			ventana.getBotonDeleteProvFinal().setIcon(new ImageIcon(imgBotonDeleteProvFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
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
		
		//
		else if (e.getSource()==ventana.getBotonActualizarProveedor()) {
			Image imgBotonUpdateProveedor = new ImageIcon("img\\update supplier press.png").getImage();
			ventana.getBotonActualizarProveedor().setIcon(new ImageIcon(imgBotonUpdateProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
			ventana.getBotonActualizarProveedor().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonBorrarProveedor()) {
			Image imgBotonBorrarProveedor = new ImageIcon("img\\delete supplier press.png").getImage();
			ventana.getBotonBorrarProveedor().setIcon(new ImageIcon(imgBotonBorrarProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
			ventana.getBotonBorrarProveedor().setContentAreaFilled(false);
		}
		else if (e.getSource()==ventana.getBotonDeliveryNotes()) {
			Image imgBotonDeliveryNotes = new ImageIcon("img\\delivery notes press.png").getImage();
			ventana.getBotonDeliveryNotes().setIcon(new ImageIcon(imgBotonDeliveryNotes.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
			ventana.getBotonDeliveryNotes().setContentAreaFilled(false);
		}	
		else if (e.getSource()==ventana.getBotonInsertProvOk()) {
			Image imgBotonInsertProvOk = new ImageIcon("img\\insert press.png").getImage();
			ventana.getBotonInsertProvOk().setIcon(new ImageIcon(imgBotonInsertProvOk.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonInsertProvOk().setContentAreaFilled(false);
		}
		
		else if (e.getSource()==ventana.getBotonUpdateFinalPr()) {
			Image imgBotonUpdateFinalPr = new ImageIcon("img\\update.png").getImage();
			ventana.getBotonUpdateFinalPr().setIcon(new ImageIcon(imgBotonUpdateFinalPr.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonUpdateFinalPr().setContentAreaFilled(false);
		}
		
		else if (e.getSource()==ventana.getBotonSearchProv()) {
			Image imgBotonSearchProv = new ImageIcon("img\\search.png").getImage();
			ventana.getBotonSearchProv().setIcon(new ImageIcon(imgBotonSearchProv.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonSearchProv().setContentAreaFilled(false);
		}
		
		else if (e.getSource()==ventana.getBotonDeleteProvFinal()) {
			Image imgBotonDeleteProvFinal = new ImageIcon("img\\delete.png").getImage();
			ventana.getBotonDeleteProvFinal().setIcon(new ImageIcon(imgBotonDeleteProvFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
			ventana.getBotonDeleteProvFinal().setContentAreaFilled(false);
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
		
		//
		else if (e.getSource()==ventana.getBotonActualizarProveedor()) {
			Image imgBotonUpdateProveedor = new ImageIcon("img\\update supplier.png").getImage();
			ventana.getBotonActualizarProveedor().setIcon(new ImageIcon(imgBotonUpdateProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonBorrarProveedor()) {
			Image imgBotonBorrarProveedor = new ImageIcon("img\\delete supplier.png").getImage();
			ventana.getBotonBorrarProveedor().setIcon(new ImageIcon(imgBotonBorrarProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}
		else if (e.getSource()==ventana.getBotonDeliveryNotes()) {
			Image imgBotonDeliveryNotes = new ImageIcon("img\\delivery notes.png").getImage();
			ventana.getBotonDeliveryNotes().setIcon(new ImageIcon(imgBotonDeliveryNotes.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		}	
		else if (e.getSource()==ventana.getBotonInsertProvOk()) {
			Image imgBotonInsertProvOk = new ImageIcon("img\\insert.png").getImage();
			ventana.getBotonInsertProvOk().setIcon(new ImageIcon(imgBotonInsertProvOk.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonUpdateFinalPr()) {
			Image imgBotonUpdateFinalPr = new ImageIcon("img\\update.png").getImage();
			ventana.getBotonUpdateFinalPr().setIcon(new ImageIcon(imgBotonUpdateFinalPr.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonSearchProv()) {
			Image imgBotonSearchProv = new ImageIcon("img\\search.png").getImage();
			ventana.getBotonSearchProv().setIcon(new ImageIcon(imgBotonSearchProv.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
		
		else if (e.getSource()==ventana.getBotonDeleteProvFinal()) {
			Image imgBotonDeleteProvFinal = new ImageIcon("img\\delete.png").getImage();
			ventana.getBotonDeleteProvFinal().setIcon(new ImageIcon(imgBotonDeleteProvFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		}
	}	
}

