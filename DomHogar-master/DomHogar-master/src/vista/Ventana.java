package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import controlador.AccesoDB;
import controlador.Eventos;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//DECLARACION DE COMPONENTES - ATRIBUTOS DE LA CLASE (PRIVADAS)	
	//Atributos de pantalla LOGIN y paneles de INICIO
	private JLabel etiquetaUser, etiquetaPass, etiquetaResulLogin, imagenInicio, imagenLogin, imageLogo;
	private JTextField cajaUser;
	private JPasswordField cajaPass;
	private JButton botonLogin, botonExit, botonPurchases, botonSales, botonSuppliers, botonCustomers, botonServices, botonStock,
	botonHR, botonUser, botonLogout, botonExitInit;
	private JPanel panelIzq, panelDer;	
	
	//Atributos de RECURSOS / EMPLEADOS
	private JPanel panelEmpleado, subPanelEmpInsertar, subPanelBotonesEmp, subPanelEmpUpdate;
	private JScrollPane barraEmpleados;
	private JTable tablaEmpleados;
	private JButton botonActualizarEmpleado, botonBorrarEmpleado, botonExpEmplFichero, botonInsertFinal;
	private JLabel nuevoEmpleado;
	private JTextField insertNomEmpl, insertApelEmpl, insertNIFEmp, insertPhoneEmp, insertEmailEmp, insertUserEmp, 
	insertPassEmp, insertPerfilEmp;
	private JLabel resulInsertEmp;
	
	//Atributos de COMPRAS
	private JPanel panelCompras;
	private JButton botonAlbaran;
	private JScrollPane barraCompras;
	
	//Atributos de VENTAS
	private JPanel panelVentas;
	
	//Atributos de SERVICIOS
	private JPanel panelServicios;
	
	//Atributos de PROVEEDORES
	private JPanel panelProveedores, subPanelInsProv, subPanelEditProv, subPanelElimProv, panelBotonesProv;
	private JTextField insertCodProv, insertNomProv, insertContProv;
	private JScrollPane barraProveedores;
	private JTable tablaProveedores;
	private JButton botonInsertProveedor, botonActualizarProveedor, botonBorrarProveedor, botonInsertProvOk;
	private JLabel nuevoProv, resulInsertProv, editProv, elimProv;
	
	//Atributos de ALMACÉN
	private JPanel panelAlmacen;
	
	//Atributos de CLIENTES
	private JPanel panelClientes;
	
	//COLORES
	Color color_blanco = Color.WHITE;
	Color color_azul = new Color(0,157,233);
	Color color_panel = new Color(202,233,255);
	
	//CONSTRUCTOR
	public Ventana() {
		setSize(400,520); //Tamano de la Ventana
		setLocationRelativeTo(null); //Eliminamos la autolocalizaciÃ³n
		setTitle("ERP DOMHOGAR"); //Titulo
		setLayout(null); // Lo colocamos nosotros
		setResizable(false); //Desactivamos botón maximizar
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes\\logo sin fondo.png")); //Imagen de la App
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Para programa cuendo cerramos
		incializarComponentes(); //Metodo que inicializa los componentes
		setVisible(true); //Visible
	}

	//FUNCION QUE INICIALIZA LOS COMPONENTES
	private void incializarComponentes() {
		
		getContentPane().setBackground(new Color(255,255,255)); //Damos un color de fondo 
				
		//PANTALLA LOGIN
		
		Image imgLogin = new ImageIcon("imagenes\\logo1.PNG").getImage();
		imagenLogin = new JLabel(new ImageIcon(imgLogin.getScaledInstance(265, 200, Image.SCALE_SMOOTH)));
		//las coordenadas del final han de coincidir con las anteriores
		imagenLogin.setBounds(60, 10, 265, 200);
		add(imagenLogin);
				
		//Etiqueta Usuario
		etiquetaUser = new JLabel("user");//Creamos el componente
		etiquetaUser.setBounds(50,240,80,25);//Posicionamos
		etiquetaUser.setFont(new Font("Segoe UI",Font.PLAIN,25));//Damos formato al contenido
		etiquetaUser.setForeground(new Color(0,157,233));;//Color del texto
		add(etiquetaUser);//Anadimos
				
		//Etiqueta Password
		etiquetaPass = new JLabel("password");//Creamos el componente
		etiquetaPass.setBounds(50,290,120,25);
		etiquetaPass.setFont(new Font("Segoe UI",Font.PLAIN,25));//Damos formato al contenido
		etiquetaPass.setForeground(new Color(0,157,233));//Color del texto
		add(etiquetaPass);//Anadimos
				
		//Etiqueta Resultado del Login
		etiquetaResulLogin = new JLabel("");//Creamos el componente
		etiquetaResulLogin.setBounds(70,420,250,25);
		etiquetaResulLogin.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		etiquetaResulLogin.setForeground(Color.DARK_GRAY);//Color del texto
		add(etiquetaResulLogin);//Anadimos
				
		cajaUser = new JTextField();//Creamos el componente
		cajaUser.setBounds(180,240,150,30);//Posicionamos
		cajaUser.setBorder(null); //Eliminamos el borde
		cajaUser.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		cajaUser.setBackground(new Color(0,157,233)); //Color de fondo
		cajaUser.setForeground(new Color(255,255,255));//Color del texto
		cajaUser.setHorizontalAlignment(JTextField.CENTER); //Centramos en la caja
		add(cajaUser);//Anadimos
				
		cajaPass = new JPasswordField();//Creamos el componente
		cajaPass.setBounds(180,290,150,30);//Posicionamos
		cajaPass.setBorder(null); //Eliminamos el borde
		cajaPass.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		cajaPass.setBackground(color_azul); //Color de fondo
		cajaPass.setForeground(new Color(255,255,255));//Color del texto
		cajaPass.setHorizontalAlignment(JTextField.CENTER); //Centramos en la caja
		add(cajaPass);//Anadimos
				
		botonLogin = new JButton("");//Creamos el componente
		botonLogin.setBounds(50,360,136,42);
		botonLogin.setBorder(null); //Eliminamos el borde
		botonLogin.setIcon(new ImageIcon("imagenes/login.png"));
		botonLogin.setBackground(color_blanco);
		add(botonLogin);//Anadimos 
				
		botonExit = new JButton("");//Creamos el componente
		botonExit.setBounds(200,360,136,42);
		botonExit.setIcon(new ImageIcon("imagenes/exit_login.png"));
		botonExit.setBorder(new MatteBorder(null));
		botonExit.setBackground(color_blanco);
		add(botonExit);//Anadimos					
		
		//PAGINA PRINCIPAL
		
		Image img = new ImageIcon("img/imagen_inicio.jpg").getImage();		
		imagenInicio = new JLabel(new ImageIcon(img.getScaledInstance(750, 580, Image.SCALE_SMOOTH)));
		imagenInicio.setBounds(200, 40, 750, 580);
		add(imagenInicio);
		imagenInicio.setVisible(false);
		
		panelIzq = new JPanel();
		panelIzq.setBackground(color_blanco);
		panelIzq.setBounds(0, 0, 200, 700);
		panelIzq.setLayout(null);
		add(panelIzq);
		panelIzq.setVisible(false);
		
		panelDer = new JPanel();
		panelDer.setBackground(color_blanco);
		panelDer.setBounds(980, 0, 200, 700);
		panelDer.setLayout(null);
		add(panelDer);
		panelDer.setVisible(false);
		
		//Botones panel izquierdo
		
		Image imgBotonPurchases = new ImageIcon("img\\purchases.png").getImage();
		botonPurchases = new JButton(new ImageIcon(imgBotonPurchases.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonPurchases.setBounds(30,40,125,80);
		botonPurchases.setBackground(color_blanco);
		botonPurchases.setBorder(null);
		panelIzq.add(botonPurchases);
		
		Image imgBotonSales = new ImageIcon("img\\sales.png").getImage();
		botonSales = new JButton(new ImageIcon(imgBotonSales.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonSales.setBounds(30,140,125,80);
		botonSales.setBackground(color_blanco);
		botonSales.setBorder(null);
		panelIzq.add(botonSales);
		
		Image imgBotonSuppliers = new ImageIcon("img\\suppliers.png").getImage();
		botonSuppliers = new JButton(new ImageIcon(imgBotonSuppliers.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonSuppliers.setBounds(30,240,125,80);
		botonSuppliers.setBackground(color_blanco);
		botonSuppliers.setBorder(null);
		panelIzq.add(botonSuppliers);
		
		Image imgBotonCustomers = new ImageIcon("img\\customers.png").getImage();
		botonCustomers = new JButton(new ImageIcon(imgBotonCustomers.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonCustomers.setBounds(30,340,125,80);
		botonCustomers.setBackground(color_blanco);
		botonCustomers.setBorder(null);
		panelIzq.add(botonCustomers);
		
		Image imgBotonServices = new ImageIcon("img\\services.png").getImage();
		botonServices = new JButton(new ImageIcon(imgBotonServices.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonServices.setBounds(30,440,125,80);
		botonServices.setBackground(color_blanco);
		botonServices.setBorder(null);
		panelIzq.add(botonServices);
		
		Image imgBotonStock = new ImageIcon("img\\stock.png").getImage();
		botonStock = new JButton(new ImageIcon(imgBotonStock.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonStock.setBounds(30,540,125,80);
		botonStock.setBackground(color_blanco);
		botonStock.setBorder(null);
		panelIzq.add(botonStock);
		
		//Botones panel derecho
				
		Image imgLog = new ImageIcon("img\\logo sin fondo.PNG").getImage();
		imageLogo = new JLabel(new ImageIcon(imgLog.getScaledInstance(180, 130, Image.SCALE_SMOOTH)));
		//las coordenadas del final han de coincidir con las anteriores
		imageLogo.setBounds(5, 40, 180, 130);
		panelDer.add(imageLogo);
		
		Image imgBotonHR = new ImageIcon("img\\human resources.png").getImage();
		botonHR = new JButton(new ImageIcon(imgBotonHR.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonHR.setBounds(18,200,125,80);
		botonHR.setBackground(color_blanco);
		botonHR.setBorder(null);
		panelDer.add(botonHR);
		
		Image imgBotonUser = new ImageIcon("img\\boton_user.png").getImage();
		botonUser = new JButton(new ImageIcon(imgBotonUser.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonUser.setBounds(18,350,125,80);
		botonUser.setBackground(color_blanco);
		botonUser.setBorder(null);
		panelDer.add(botonUser);
		
		Image imgBotonLogout = new ImageIcon("img\\logout.png").getImage();
		botonLogout = new JButton(new ImageIcon(imgBotonLogout.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonLogout.setBounds(18,445,125,80);
		botonLogout.setBackground(color_blanco);
		botonLogout.setBorder(null);
		panelDer.add(botonLogout);
		
		Image imgBotonExit = new ImageIcon("img\\exit.png").getImage();
		botonExitInit = new JButton(new ImageIcon(imgBotonExit.getScaledInstance(125,80, Image.SCALE_SMOOTH)));
		botonExitInit.setBounds(18,540,125,80);
		botonExitInit.setBackground(color_blanco);
		botonExitInit.setBorder(null);
		panelDer.add(botonExitInit);
		
		panelEmpleado();
		panelCompras();
		panelVentas();
		panelProveedores();
		panelClientes();
		panelServicios();
		panelAlmacen();
		
	}

	// PANEL COMPRAS
	private void panelCompras() {
		
		panelCompras = new JPanel();
		panelCompras.setBackground(Color.white);
		panelCompras.setBounds(240, 0, 900, 500);
		panelCompras.setLayout(null);
		add(panelCompras);
		panelCompras.setVisible(false);
		
		botonAlbaran = new JButton("ALBARÁN");
		botonAlbaran.setBounds(400,350,110,42);
		botonAlbaran.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del botï¿½n
		botonAlbaran.setBackground(Color.BLUE);
		panelCompras.add(botonAlbaran);//Anadimos 
		
		barraCompras = new JScrollPane();
		barraCompras.setBounds(10, 400, 680, 300);
		panelCompras.add(barraCompras);		
		
	} 

	//PANEL VENTAS
	private void panelVentas() {
		panelVentas = new JPanel();
		panelVentas.setBackground(Color.white);
		panelVentas.setBounds(240, 0, 900, 500);
		panelVentas.setLayout(null);
		add(panelVentas);
		panelVentas.setVisible(false);
	}

	//PANEL PROVEEDORES
	private void panelProveedores() {
		panelProveedores = new JPanel();
		panelProveedores.setBackground(new Color(186,236,247));
		panelProveedores.setBounds(200, 40, 750, 230);
		panelProveedores.setLayout(null);
		add(panelProveedores);
		panelProveedores.setVisible(false);
		
		barraProveedores = new JScrollPane();
		barraProveedores.setBounds(38, 20, 680, 120);
		panelProveedores.add(barraProveedores);
		
		String titulosProveedores[] = {"Codigo proveedor", "Nombre proveedor", "contacto"};
		String infoProveedores[][] = AccesoDB.obtenerMatrizProveedores();
		
		tablaProveedores = new JTable(infoProveedores,titulosProveedores);
		tablaProveedores.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaProveedores.getColumnModel().getColumn(1).setPreferredWidth(115);
		tablaProveedores.getColumnModel().getColumn(2).setPreferredWidth(140);
		barraProveedores.setViewportView(tablaProveedores);
		
		//SUBPANEL INSERTAR PROVEEDOR
		
		subPanelInsProv = new JPanel();
		subPanelInsProv.setBounds(200, 230, 750, 268);
		subPanelInsProv.setBackground(new Color(186,236,247));
		subPanelInsProv.setLayout(null);
		add(subPanelInsProv);
		subPanelInsProv.setVisible(false);	
		
		nuevoProv = new JLabel("new supplier");
		nuevoProv.setBounds(300,30,200,30);
		nuevoProv.setBorder(null);
		nuevoProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		nuevoProv.setForeground(new Color(000,000,000));//Color del texto
		subPanelInsProv.add(nuevoProv);
		
		insertCodProv = new JTextField();//Creamos el componente
		TextPrompt placeholder = new TextPrompt("Código Proveedor", insertCodProv);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
	    insertCodProv.setBounds(40,90,200,30);//Posicionamos
	    insertCodProv.setBorder(null); //Eliminamos el borde
	    insertCodProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertCodProv.setBackground(new Color(0,157,233)); //Color de fondo
	    insertCodProv.setForeground(new Color(255,255,255));//Color del texto
	    subPanelInsProv.add(insertCodProv);//Anadimos
	    
	    insertNomProv = new JTextField();//Creamos el componente
		TextPrompt placeholder1 = new TextPrompt("Nombre Proveedor", insertNomProv);
	    placeholder1.changeAlpha(0.75f);
	    placeholder1.changeStyle(Font.ITALIC);
	    insertNomProv.setBounds(250,90,430,30);//Posicionamos
	    insertNomProv.setBorder(null); //Eliminamos el borde
	    insertNomProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertNomProv.setBackground(new Color(0,157,233)); //Color de fondo
	    insertNomProv.setForeground(new Color(255,255,255));//Color del texto
	    subPanelInsProv.add(insertNomProv);//Anadimos
				
		insertContProv = new JTextField();//Creamos el componente
		TextPrompt placeholder2 = new TextPrompt("Contacto Proveedor", insertContProv);
	    placeholder2.changeAlpha(0.75f);
	    placeholder2.changeStyle(Font.ITALIC);
	    insertContProv.setBounds(40,150,400,30);//Posicionamos
	    insertContProv.setBorder(null); //Eliminamos el borde
	    insertContProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertContProv.setBackground(new Color(0,157,233)); //Color de fondo
	    insertContProv.setForeground(new Color(255,255,255));//Color del texto
	    subPanelInsProv.add(insertContProv);//Anadimos
	    
	        
		botonInsertProvOk = new JButton("INSERT");//Creamos el componente
		botonInsertProvOk.setBounds(550,140,110,42);
		botonInsertProvOk.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del botï¿½n
		//botonInsetEmpleado.setIcon(new ImageIcon("imagenes/login.png"));
		botonInsertProvOk.setBackground(Color.BLUE);
		subPanelInsProv.add(botonInsertProvOk);//Anadimos 
		
		resulInsertProv = new JLabel("");//Creamos el componente
		resulInsertProv.setBounds(100,200,500,30);//Posicionamos
		resulInsertProv.setBorder(null); //Eliminamos el borde
		resulInsertProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulInsertProv.setForeground(new Color(000,000,000));//Color del texto
		subPanelInsProv.add(resulInsertProv);//Anadimos	
		
		//SUBPANEL EDITAR PROVEEDOR
		
		subPanelEditProv = new JPanel();
		subPanelEditProv.setBounds(200, 230, 750, 268);
		subPanelEditProv.setBackground(new Color(186,236,247));
		subPanelEditProv.setLayout(null);
		add(subPanelEditProv);
		subPanelEditProv.setVisible(false);	
		
		editProv = new JLabel("edit supplier");
		editProv.setBounds(300,30,200,30);
		editProv.setBorder(null);
		editProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		editProv.setForeground(new Color(000,000,000));//Color del texto
		subPanelEditProv.add(editProv);
		
		//SUBPANEL ELIMINAR PROVEEDOR
		
		subPanelElimProv = new JPanel();
		subPanelElimProv.setBounds(200, 230, 750, 268);
		subPanelElimProv.setBackground(new Color(186,236,247));
		subPanelElimProv.setLayout(null);
		add(subPanelElimProv);
		subPanelElimProv.setVisible(false);	
		
		elimProv = new JLabel("delete supplier");
		elimProv.setBounds(300,30,200,30);
		elimProv.setBorder(null);
		elimProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		elimProv.setForeground(new Color(000,000,000));//Color del texto
		subPanelElimProv.add(elimProv);
		
	    
		//Panel botones PROVEEDORES
	    
		panelBotonesProv = new JPanel();
		panelBotonesProv.setBounds(200, 498, 750, 120);
		panelBotonesProv.setBackground(new Color(186,236,247));
		panelBotonesProv.setLayout(null);
		add(panelBotonesProv);
		panelBotonesProv.setVisible(false);		
	    
	  
		botonInsertProveedor = new JButton("NEW SUPPLIER");//Creamos el componente
		botonInsertProveedor.setBounds(67,42,160,42);
		botonInsertProveedor.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del botn
		//botonInsertProveedor.setIcon(new ImageIcon("imagenes/login.png"));
		botonInsertProveedor.setBackground(Color.BLUE);
		panelBotonesProv.add(botonInsertProveedor);//Anadimos 
		
		botonActualizarProveedor = new JButton("UPDATE SUPPLIER");//Creamos el componente
		botonActualizarProveedor.setBounds(294,42,160,42);
		botonActualizarProveedor.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del botï¿½n
		//botonActualizarProveedor.setIcon(new ImageIcon("imagenes/login.png"));
		botonActualizarProveedor.setBackground(Color.BLUE);
		panelBotonesProv.add(botonActualizarProveedor);//Anadimos 
		
		botonBorrarProveedor = new JButton("DELETE SUPPLIER");//Creamos el componente
		botonBorrarProveedor.setBounds(521,42,160,42);
		botonBorrarProveedor.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del botï¿½n
		//botonBorrarProveedor.setIcon(new ImageIcon("imagenes/login.png"));
		botonBorrarProveedor.setBackground(Color.BLUE);
		panelBotonesProv.add(botonBorrarProveedor);//Anadimos 
		


	}
	
	//PANEL CLIENTES
	private void panelClientes() {
		panelClientes = new JPanel();
		panelClientes.setBackground(Color.white);
		panelClientes.setBounds(240, 0, 900, 500);
		panelClientes.setLayout(null);
		add(panelClientes);
		panelClientes.setVisible(false);
	}
	
	//PANEL SERVICIOS
	private void panelServicios() {
		panelServicios = new JPanel();
		panelServicios.setBackground(Color.white);
		panelServicios.setBounds(240, 0, 900, 500);
		panelServicios.setLayout(null);
		add(panelServicios);
		panelServicios.setVisible(false);
	}

	//PANEL ALMACÉN
	private void panelAlmacen() {
		panelAlmacen = new JPanel();
		panelAlmacen.setBackground(Color.white);
		panelAlmacen.setBounds(240, 0, 900, 500);
		panelAlmacen.setLayout(null);
		add(panelAlmacen);
		panelAlmacen.setVisible(false);
	}

	//PANEL EMPLEADO
	private void panelEmpleado() {
		
		//PANEL TABLA EMPLEADO
		
		panelEmpleado = new JPanel();
		panelEmpleado.setBackground(color_panel);
		panelEmpleado.setBounds(200, 40, 750, 230);
		panelEmpleado.setLayout(null);
		add(panelEmpleado);
		panelEmpleado.setVisible(false);		
		
		//Construimos la tabla empleados
		
		barraEmpleados = new JScrollPane();
		barraEmpleados.setBounds(20, 20, 710, 190);
		panelEmpleado.add(barraEmpleados);
		
		String titulosEmpleados[] = {"Nombre", "Apellidos", "e-mail", "NIF", "Telefono"};
		String infoEmpleados[][] = AccesoDB.obtenerMatrizEmpleados();
		
		tablaEmpleados = new JTable(infoEmpleados,titulosEmpleados);
		tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaEmpleados.getColumnModel().getColumn(1).setPreferredWidth(115);
		tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(140);
		barraEmpleados.setViewportView(tablaEmpleados);
			
		//SUBPANEL INSERTAR EMPLEADO - Este sub-panel va cambiando en función de los botones que se vayan pulsando
		
		subPanelEmpInsertar = new JPanel();
		subPanelEmpInsertar.setBounds(200, 270, 750, 268);
		subPanelEmpInsertar.setBackground(color_panel);
		subPanelEmpInsertar.setLayout(null);
		add(subPanelEmpInsertar);
		subPanelEmpInsertar.setVisible(false);	
		
		//CAMPOS DEL SUBPANEL INSERTAR EMPLEADO
		
		nuevoEmpleado = new JLabel("new employee");
		nuevoEmpleado.setBounds(20, 0, 710, 60);
		nuevoEmpleado.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		nuevoEmpleado.setForeground(color_azul);//Color del texto
		nuevoEmpleado.setHorizontalAlignment(JLabel.CENTER);
		nuevoEmpleado.setVerticalAlignment(JLabel.CENTER);
		subPanelEmpInsertar.add(nuevoEmpleado);//Anadimos
		
		insertNomEmpl = new JTextField();//Creamos el componente
		TextPrompt placeholder = new TextPrompt("Employee's name", insertNomEmpl);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
		insertNomEmpl.setBounds(20,70,200,30);//Posicionamos		
		insertNomEmpl.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
		insertNomEmpl.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		insertNomEmpl.setBackground(Color.WHITE); //Color de fondo
		insertNomEmpl.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertNomEmpl);//Anadimos
		
		insertApelEmpl = new JTextField();//Creamos el componente
		TextPrompt placeholder1 = new TextPrompt("Employee's surname", insertApelEmpl);
	    placeholder1.changeAlpha(0.75f);
	    placeholder1.changeStyle(Font.ITALIC);
	    insertApelEmpl.setBounds(250,70,480,30);//Posicionamos
	    insertApelEmpl.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertApelEmpl.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertApelEmpl.setBackground(Color.WHITE); //Color de fondo
	    insertApelEmpl.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertApelEmpl);//Anadimos
		
		insertNIFEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder2 = new TextPrompt("NIF", insertNIFEmp);
	    placeholder2.changeAlpha(0.75f);
	    placeholder2.changeStyle(Font.ITALIC);
	    insertNIFEmp.setBounds(20,120,120,30);//Posicionamos
	    insertNIFEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNIFEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertNIFEmp.setBackground(Color.WHITE); //Color de fondo
	    insertNIFEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertNIFEmp);//Anadimos
		
		insertPhoneEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder3 = new TextPrompt("Phone", insertPhoneEmp);
	    placeholder3.changeAlpha(0.75f);
	    placeholder3.changeStyle(Font.ITALIC);
	    insertPhoneEmp.setBounds(170,120,120,30);//Posicionamos
	    insertPhoneEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertPhoneEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertPhoneEmp.setBackground(Color.WHITE); //Color de fondo
	    insertPhoneEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertPhoneEmp);//Anadimos
		
		insertEmailEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder4 = new TextPrompt("e-Mail", insertEmailEmp);
	    placeholder4.changeAlpha(0.75f);
	    placeholder4.changeStyle(Font.ITALIC);
	    insertEmailEmp.setBounds(320,120,410,30);//Posicionamos
	    insertEmailEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertEmailEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertEmailEmp.setBackground(Color.WHITE); //Color de fondo
	    insertEmailEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertEmailEmp);//Anadimos
		
		insertUserEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder5 = new TextPrompt("User", insertUserEmp);
	    placeholder5.changeAlpha(0.75f);
	    placeholder5.changeStyle(Font.ITALIC);
	    insertUserEmp.setBounds(20,170,200,30);//Posicionamos
	    insertUserEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertUserEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertUserEmp.setBackground(Color.WHITE); //Color de fondo
	    insertUserEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertUserEmp);//Anadimos
		
		insertPassEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder6 = new TextPrompt("Password", insertPassEmp);
	    placeholder6.changeAlpha(0.75f);
	    placeholder6.changeStyle(Font.ITALIC);
	    insertPassEmp.setBounds(250,170,200,30);//Posicionamos
	    insertPassEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertPassEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertPassEmp.setBackground(Color.WHITE); //Color de fondo
	    insertPassEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertPassEmp);//Anadimos	
		
		insertPerfilEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder7 = new TextPrompt("Profile (general/administrador)", insertPerfilEmp);
	    placeholder7.changeAlpha(0.75f);
	    placeholder7.changeStyle(Font.ITALIC);
	    insertPerfilEmp.setBounds(480,170,250,30);//Posicionamos
	    insertPerfilEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertPerfilEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertPerfilEmp.setBackground(Color.WHITE); //Color de fondo
	    insertPerfilEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(insertPerfilEmp);//Anadimos	
		
		Image imgBotonInsertFinal = new ImageIcon("img\\insert.png").getImage();
		botonInsertFinal = new JButton(new ImageIcon(imgBotonInsertFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonInsertFinal.setBounds(20,220,110,42);
		botonInsertFinal.setBackground(new Color(186,236,247));
		botonInsertFinal.setBorder(null); //Eliminamos el borde
		subPanelEmpInsertar.add(botonInsertFinal);//Anadimos 
		
		resulInsertEmp = new JLabel();//Creamos el componente
		resulInsertEmp.setBounds(150,222,500,30);//Posicionamos
		resulInsertEmp.setBorder(null); //Eliminamos el borde
		resulInsertEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulInsertEmp.setForeground(color_azul);//Color del texto
		subPanelEmpInsertar.add(resulInsertEmp);//Anadimos	
		
		//SUBPANEL BOTONES

		subPanelBotonesEmp = new JPanel();
		subPanelBotonesEmp.setBounds(200, 538, 750, 82);
		subPanelBotonesEmp.setBackground(color_panel);
		subPanelBotonesEmp.setLayout(null);
		add(subPanelBotonesEmp);
		subPanelBotonesEmp.setVisible(false);	
		
		//BOTONES DEL SUBPANEL
		
		Image imgBotonUpdateEmpleado = new ImageIcon("img\\update.png").getImage();
		botonActualizarEmpleado = new JButton(new ImageIcon(imgBotonUpdateEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		botonActualizarEmpleado.setBounds((int) 67.5, 20, 160, 42);
		botonActualizarEmpleado.setBorder(null); // Eliminamos el borde
		botonActualizarEmpleado.setBackground(color_panel);
		subPanelBotonesEmp.add(botonActualizarEmpleado);// Anadimos

		Image imgBotonDeleteEmpleado = new ImageIcon("img\\delete.png").getImage();
		botonBorrarEmpleado = new JButton(new ImageIcon(imgBotonDeleteEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		botonBorrarEmpleado.setBounds(295, 20, 160, 42);
		botonBorrarEmpleado.setBorder(null); // Eliminamos el borde
		botonBorrarEmpleado.setBackground(color_panel);
		subPanelBotonesEmp.add(botonBorrarEmpleado);// Anadimos

		Image imgBotonExportEmpleado = new ImageIcon("img\\export to file.png").getImage();
		botonExpEmplFichero = new JButton(new ImageIcon(imgBotonExportEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		botonExpEmplFichero.setBounds((int) 522.5, 20, 160, 42);
		botonExpEmplFichero.setBorder(null); // Eliminamos el borde
		botonExpEmplFichero.setBackground(color_panel);
		subPanelBotonesEmp.add(botonExpEmplFichero);// Anadimos
		
	}

	//METODO PARA PONER A LA ESCUCHA LOS EVENTOS	
	public void Eventos (Eventos manejador) {
		botonLogin.addActionListener(manejador);
		botonExit.addActionListener(manejador);
		botonLogin.addMouseListener(manejador);
		botonExit.addMouseListener(manejador);
		botonSales.addMouseListener(manejador);
		botonPurchases.addMouseListener(manejador);
		botonSuppliers.addMouseListener(manejador);
		botonCustomers.addMouseListener(manejador);
		botonServices.addMouseListener(manejador);
		botonStock.addMouseListener(manejador);
		botonHR.addMouseListener(manejador);
		botonUser.addMouseListener(manejador);
		botonLogout.addMouseListener(manejador);
		botonExitInit.addMouseListener(manejador);	
		botonInsertFinal.addMouseListener(manejador);
		imageLogo.addMouseListener(manejador);
		botonInsertProveedor.addMouseListener(manejador);
		botonActualizarProveedor.addMouseListener(manejador);
		botonBorrarProveedor.addMouseListener(manejador);
		botonInsertProvOk.addMouseListener(manejador);
		botonActualizarEmpleado.addMouseListener(manejador);
		botonBorrarEmpleado.addMouseListener(manejador);
		botonExpEmplFichero.addMouseListener(manejador);
		
	}
	
	//GETTER Y SETTER
	public JLabel getEtiquetaUser() {
		return etiquetaUser;
	}
	public void setEtiquetaUser(JLabel etiquetaUser) {
		this.etiquetaUser = etiquetaUser;
	}
	public JLabel getEtiquetaPass() {
		return etiquetaPass;
	}
	public void setEtiquetaPass(JLabel etiquetaPass) {
		this.etiquetaPass = etiquetaPass;
	}
	public JTextField getCajaUser() {
		return cajaUser;
	}
	public void setCajaUser(JTextField cajaUser) {
		this.cajaUser = cajaUser;
	}
	public JPasswordField getCajaPass() {
		return cajaPass;
	}
	public void setCajaPass(JPasswordField cajaPass) {
		this.cajaPass = cajaPass;
	}
	public JButton getBotonLogin() {
		return botonLogin;
	}
	public void setBotonLogin(JButton botonLogin) {
		this.botonLogin = botonLogin;
	}
	public JLabel getEtiquetaResulLogin() {
		return etiquetaResulLogin;
	}
	public void setEtiquetaResulLogin(JLabel etiquetaResulLogin) {
		this.etiquetaResulLogin = etiquetaResulLogin;
	}
	public JButton getBotonExit() {
		return botonExit;
	}
	public void setBotonExit(JButton botonExit) {
		this.botonExit = botonExit;
	}
	public JLabel getImagenInicio() {
		return imagenInicio;
	}
	public void setImagenInicio(JLabel imagenInicio) {
		this.imagenInicio = imagenInicio;
	}
	public JLabel getImagenLogin() {
		return imagenLogin;
	}
	public void setImagenLogin(JLabel imagenLogin) {
		this.imagenLogin = imagenLogin;
	}
	public JButton getBotonPurchases() {
		return botonPurchases;
	}
	public void setBotonPurchases(JButton botonPurchases) {
		this.botonPurchases = botonPurchases;
	}
	public JPanel getPanelIzq() {
		return panelIzq;
	}
	public void setPanelIzq(JPanel panelIzq) {
		this.panelIzq = panelIzq;
	}
	public JPanel getPanelDer() {
		return panelDer;
	}
	public JScrollPane getBarraEmpleados() {
		return barraEmpleados;
	}
	public void setBarraEmpleados(JScrollPane barraEmpleados) {
		this.barraEmpleados = barraEmpleados;
	}
	public void setPanelDer(JPanel panelDer) {
		this.panelDer = panelDer;
	}		
	public JLabel getImageLogo() {
		return imageLogo;
	}
	public void setImageLogo(JLabel imageLogo) {
		this.imageLogo = imageLogo;
	}
	public JButton getBotonSales() {
		return botonSales;
	}
	public void setBotonSales(JButton botonSales) {
		this.botonSales = botonSales;
	}
	public JButton getBotonSuppliers() {
		return botonSuppliers;
	}
	public void setBotonSuppliers(JButton botonSuppliers) {
		this.botonSuppliers = botonSuppliers;
	}
	public JButton getBotonCustomers() {
		return botonCustomers;
	}
	public void setBotonCustomers(JButton botonCustomers) {
		this.botonCustomers = botonCustomers;
	}
	public JButton getBotonServices() {
		return botonServices;
	}
	public void setBotonServices(JButton botonServices) {
		this.botonServices = botonServices;
	}
	public JButton getBotonStock() {
		return botonStock;
	}
	public void setBotonStock(JButton botonStock) {
		this.botonStock = botonStock;
	}
	public JButton getBotonHR() {
		return botonHR;
	}
	public void setBotonHR(JButton botonHR) {
		this.botonHR = botonHR;
	}
	public JButton getBotonUser() {
		return botonUser;
	}
	public void setBotonUser(JButton botonUser) {
		this.botonUser = botonUser;
	}
	public JButton getBotonLogout() {
		return botonLogout;
	}
	public void setBotonLogout(JButton botonLogout) {
		this.botonLogout = botonLogout;
	}
	public JButton getBotonExitInit() {
		return botonExitInit;
	}
	public void setBotonExitInit(JButton botonExitInit) {
		this.botonExitInit = botonExitInit;
	}
	public JTable getTablaEmpleados() {
		return tablaEmpleados;
	}
	public void setTablaEmpleados(JTable tablaEmpleados) {
		this.tablaEmpleados = tablaEmpleados;
	}
	public JButton getBotonActualizarEmpleado() {
		return botonActualizarEmpleado;
	}
	public void setBotonActualizarEmpleado(JButton botonActualizarEmpleado) {
		this.botonActualizarEmpleado = botonActualizarEmpleado;
	}
	public JButton getBotonBorrarEmpleado() {
		return botonBorrarEmpleado;
	}
	public void setBotonBorrarEmpleado(JButton botonBorrarEmpleado) {
		this.botonBorrarEmpleado = botonBorrarEmpleado;
	}
	public JButton getBotonExpEmplFichero() {
		return botonExpEmplFichero;
	}
	public void setBotonExpEmplFichero(JButton botonExpEmplFichero) {
		this.botonExpEmplFichero = botonExpEmplFichero;
	}
	public JPanel getPanelEmpleado() {
		return panelEmpleado;
	}
	public void setPanelEmpleado(JPanel panelEmpleado) {
		this.panelEmpleado = panelEmpleado;
	}
	public JPanel getSubPanelEmpInsertar() {
		return subPanelEmpInsertar;
	}
	public void setSubPanelEmpInsertar(JPanel subPanelEmpInsertar) {
		this.subPanelEmpInsertar = subPanelEmpInsertar;
	}
	public JPanel getSubPanelBotonesEmp() {
		return subPanelBotonesEmp;
	}
	public void setSubPanelBotonesEmp(JPanel subPanelBotonesEmp) {
		this.subPanelBotonesEmp = subPanelBotonesEmp;
	}
	public JTextField getInsertNomEmpl() {
		return insertNomEmpl;
	}
	public void setInsertNomEmpl(JTextField insertNomEmpl) {
		this.insertNomEmpl = insertNomEmpl;
	}
	public JTextField getInsertApelEmpl() {
		return insertApelEmpl;
	}
	public void setInsertApelEmpl(JTextField insertApelEmpl) {
		this.insertApelEmpl = insertApelEmpl;
	}
	public JTextField getInsertNIFEmp() {
		return insertNIFEmp;
	}
	public void setInsertNIFEmp(JTextField insertNIFEmp) {
		this.insertNIFEmp = insertNIFEmp;
	}
	public JTextField getInsertPhoneEmp() {
		return insertPhoneEmp;
	}
	public void setInsertPhoneEmp(JTextField insertPhoneEmp) {
		this.insertPhoneEmp = insertPhoneEmp;
	}
	public JTextField getInsertEmailEmp() {
		return insertEmailEmp;
	}
	public void setInsertEmailEmp(JTextField insertEmailEmp) {
		this.insertEmailEmp = insertEmailEmp;
	}
	public JTextField getInsertUserEmp() {
		return insertUserEmp;
	}
	public void setInsertUserEmp(JTextField insertUserEmp) {
		this.insertUserEmp = insertUserEmp;
	}
	public JTextField getInsertPassEmp() {
		return insertPassEmp;
	}
	public void setInsertPassEmp(JTextField insertPassEmp) {
		this.insertPassEmp = insertPassEmp;
	}
	public JButton getBotonInsertFinal() {
		return botonInsertFinal;
	}
	public void setBotonInsertFinal(JButton botonInsertFinal) {
		this.botonInsertFinal = botonInsertFinal;
	}
	public JLabel getResulInsertEmp() {
		return resulInsertEmp;
	}
	public void setResulInsertEmp(JLabel resulInsertEmp) {
		this.resulInsertEmp = resulInsertEmp;
	}
	public JTextField getInsertPerfilEmp() {
		return insertPerfilEmp;
	}
	public void setInsertPerfilEmp(JTextField insertPerfilEmp) {
		this.insertPerfilEmp = insertPerfilEmp;
	}	
	public JPanel getPanelCompras() {
		return panelCompras;
	}
	public void setPanelCompras(JPanel panelCompras) {
		this.panelCompras = panelCompras;
	}	
	public JButton getBotonAlbaran() {
		return botonAlbaran;
	}
	public void setBotonAlbaran(JButton botonAlbaran) {
		this.botonAlbaran = botonAlbaran;
	}
	public JScrollPane getBarraCompras() {
		return barraCompras;
	}
	public void setBarraCompras(JScrollPane barraCompras) {
		this.barraCompras = barraCompras;
	}
	public JPanel getPanelVentas() {
		return panelVentas;
	}
	public void setPanelVentas(JPanel panelVentas) {
		this.panelVentas = panelVentas;
	}	
	public JPanel getPanelProveedores() {
		return panelProveedores;
	}
	public void setPanelProveedores(JPanel panelProveedores) {
		this.panelProveedores = panelProveedores;
	}
	public JPanel getPanelClientes() {
		return panelClientes;
	}
	public void setPanelClientes(JPanel panelClientes) {
		this.panelClientes = panelClientes;
	}
	public JPanel getPanelServicios() {
		return panelServicios;
	}
	public void setPanelServicios(JPanel panelServicios) {
		this.panelServicios = panelServicios;
	}
	public JPanel getPanelAlmacen() {
		return panelAlmacen;
	}
	public void setPanelAlmacen(JPanel panelAlmacen) {
		this.panelAlmacen = panelAlmacen;
	}

	public JPanel getSubPanelEmpUpdate() {
		return subPanelEmpUpdate;
	}

	public void setSubPanelEmpUpdate(JPanel subPanelEmpUpdate) {
		this.subPanelEmpUpdate = subPanelEmpUpdate;
	}

	public JLabel getNuevoEmpleado() {
		return nuevoEmpleado;
	}

	public void setNuevoEmpleado(JLabel nuevoEmpleado) {
		this.nuevoEmpleado = nuevoEmpleado;
	}

	public JPanel getSubPanelInsProv() {
		return subPanelInsProv;
	}

	public void setSubPanelInsProv(JPanel subPanelInsProv) {
		this.subPanelInsProv = subPanelInsProv;
	}

	public JPanel getSubPanelEditProv() {
		return subPanelEditProv;
	}

	public void setSubPanelEditProv(JPanel subPanelEditProv) {
		this.subPanelEditProv = subPanelEditProv;
	}

	public JPanel getSubPanelElimProv() {
		return subPanelElimProv;
	}

	public void setSubPanelElimProv(JPanel subPanelElimProv) {
		this.subPanelElimProv = subPanelElimProv;
	}

	public JPanel getPanelBotonesProv() {
		return panelBotonesProv;
	}

	public void setPanelBotonesProv(JPanel panelBotonesProv) {
		this.panelBotonesProv = panelBotonesProv;
	}

	public JTextField getInsertCodProv() {
		return insertCodProv;
	}

	public void setInsertCodProv(JTextField insertCodProv) {
		this.insertCodProv = insertCodProv;
	}

	public JTextField getInsertNomProv() {
		return insertNomProv;
	}

	public void setInsertNomProv(JTextField insertNomProv) {
		this.insertNomProv = insertNomProv;
	}

	public JTextField getInsertContProv() {
		return insertContProv;
	}

	public void setInsertContProv(JTextField insertContProv) {
		this.insertContProv = insertContProv;
	}

	public JScrollPane getBarraProveedores() {
		return barraProveedores;
	}

	public void setBarraProveedores(JScrollPane barraProveedores) {
		this.barraProveedores = barraProveedores;
	}

	public JTable getTablaProveedores() {
		return tablaProveedores;
	}

	public void setTablaProveedores(JTable tablaProveedores) {
		this.tablaProveedores = tablaProveedores;
	}

	public JButton getBotonInsertProveedor() {
		return botonInsertProveedor;
	}

	public void setBotonInsertProveedor(JButton botonInsertProveedor) {
		this.botonInsertProveedor = botonInsertProveedor;
	}

	public JButton getBotonActualizarProveedor() {
		return botonActualizarProveedor;
	}

	public void setBotonActualizarProveedor(JButton botonActualizarProveedor) {
		this.botonActualizarProveedor = botonActualizarProveedor;
	}

	public JButton getBotonBorrarProveedor() {
		return botonBorrarProveedor;
	}

	public void setBotonBorrarProveedor(JButton botonBorrarProveedor) {
		this.botonBorrarProveedor = botonBorrarProveedor;
	}

	public JButton getBotonInsertProvOk() {
		return botonInsertProvOk;
	}

	public void setBotonInsertProvOk(JButton botonInsertProvOk) {
		this.botonInsertProvOk = botonInsertProvOk;
	}

	public JLabel getNuevoProv() {
		return nuevoProv;
	}

	public void setNuevoProv(JLabel nuevoProv) {
		this.nuevoProv = nuevoProv;
	}

	public JLabel getResulInsertProv() {
		return resulInsertProv;
	}

	public void setResulInsertProv(JLabel resulInsertProv) {
		this.resulInsertProv = resulInsertProv;
	}

	public JLabel getEditProv() {
		return editProv;
	}

	public void setEditProv(JLabel editProv) {
		this.editProv = editProv;
	}

	public JLabel getElimProv() {
		return elimProv;
	}

	public void setElimProv(JLabel elimProv) {
		this.elimProv = elimProv;
	}
}
