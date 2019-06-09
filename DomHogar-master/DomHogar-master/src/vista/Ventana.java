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
	private JPanel panelEmpleado, subPanelEmpInsertar, subPanelBotonesEmp, subPanelEmpUpdate, subPanelEmpDelete, subPanelEmpExport;
	private JScrollPane barraEmpleados;
	private JTable tablaEmpleados;
	private JButton botonActualizarEmpleado, botonBorrarEmpleado, botonExpEmplFichero, botonInsertEmpFinal, botonUpdateEmpFinal, botonSearchEmp,
	botonDeleteEmpFinal, botonExportEmpFinal;
	private JLabel nuevoEmpleado, updateEmpleado, deleteEmpleado, labelPreguntaCambioEmp, labelNewDataEmp, exportEmpleado;
	private JTextField insertNomEmpl, insertApelEmpl, insertNIFEmp, insertPhoneEmp, insertEmailEmp, insertUserEmp, 
	insertPassEmp, insertPerfilEmp, insertNIFUpdateEmp, insertNewDataEmp, insertNIFDeleteEmp, insertUsuarioPC;
	private JLabel resulInsertEmp, resultUpdateEmp, resulBusquedaEmp, resulDeleteEmp, resulExportEmp, insertRutaExportEmp;
	private JComboBox <String> comboUpdateEmp;
	
	//Atributos de COMPRAS
	private JPanel panelCompras;
	private JButton botonAlbaran;
	private JScrollPane barraCompras;
	private JTable tablaCompras;
	
	//Atributos de VENTAS
	private JPanel panelVentas;
	
	//Atributos de SERVICIOS
	private JPanel panelServicios;
	
	//Atributos de PROVEEDORES
	private JPanel panelProveedores, subPanelInsProv, subPanelEditProv, subPanelElimProv, panelBotonesProv;
	private JTextField insertCodProv, insertNomProv, insertContProv, insertCODUpdateProv, insertNewDataProv, insertCODDeleteProv;
	private JScrollPane barraProveedores;
	private JTable tablaProveedores;
	private JButton botonInsertProveedor, botonActualizarProveedor, botonBorrarProveedor, botonInsertProvOk, 
	botonDeliveryNotes, botonUpdateEmpFinalPr, botonSearchProv, botonDeleteProvFinal, botonUpdateFinalPr;
	private JLabel nuevoProv, resulInsertProv, editProv, elimProv, labelPreguntaCambioProv, labelNewDataProv,
	resultUpdateProv, resulBusquedaProv, resulDeleteProv;
	private JComboBox <String>comboUpdateProv;
	
	//Atributos de ALMAC�N
	private JPanel panelAlmacen;
	
	//Atributos de CLIENTES
	private JPanel panelClientes, subPanelInsCliente, panelBotonesCliente, subPanelEditCliente, subPanelElimCliente;
	private JScrollPane barraClientes;
	private JTable tablaClientes;
	private JLabel nuevoCliente, resulInsertCliente, editCliente, labelPreguntaCambioCliente, labelNewDataCliente,
	resultUpdateCliente, elimCliente, resulBusquedaCli, resulDeleteCliente;
	private JTextField insertNIFCliente, insertNomCliente, insertTelCliente, insertNIFUpdateCliente, insertNIFDeleteCli,
	insertNewDataCliente, insertMailCliente;
	private JButton botonInsertClienteok, botonActualizarCliente, botonBorrarCliente, botonUpdateFinalCl,
	botonSearchCliente, botonDeleteClienteFinal, botonBills;
	private JComboBox<String> comboUpdateCliente;
	
	//COLORES
	Color color_blanco = Color.WHITE;
	Color color_azul = new Color(0,157,233);
	Color color_panel = new Color(202,233,255);
	
	//CONSTRUCTOR
	public Ventana() {
		setSize(400,520); //Tamano de la Ventana
		setLocationRelativeTo(null); //Eliminamos la autolocalización
		setTitle("ERP DOMHOGAR"); //Titulo
		setLayout(null); // Lo colocamos nosotros
		setResizable(false); //Desactivamos bot�n maximizar
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
		panelCompras.setBackground(color_panel);
		panelCompras.setBounds(200, 40, 750, 700);
		panelCompras.setLayout(null);
		add(panelCompras);
		panelCompras.setVisible(false);
		

		botonAlbaran = new JButton("ALBARAN");
		botonAlbaran.setBounds(400,350,110,42);
		botonAlbaran.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del bot�n
		botonAlbaran.setBackground(Color.BLUE);
		panelCompras.add(botonAlbaran);//Anadimos 

		barraCompras = new JScrollPane();
		barraCompras.setBounds(20, 20, 710, 190);
		panelCompras.add(barraCompras);

		
		String titulosCompras[] = {"N. Albar�n", "Codigo Producto", "Nombre producto", "Cantidad", "Importe compra", "Importe Total", 
				"C�d. Proveedor", "Proveedor", "Fecha"};
		String infoCompras[][] = AccesoDB.obtenerMatrizCompras();
		
		tablaCompras = new JTable(infoCompras,titulosCompras);
		barraCompras.setViewportView(tablaCompras);
		
	} 

	//PANEL VENTAS
	private void panelVentas() {
		panelVentas = new JPanel();
		panelVentas.setBackground(color_panel);
		panelVentas.setBounds(200, 40, 750, 230);
		panelVentas.setLayout(null);
		add(panelVentas);
		panelVentas.setVisible(false);
	}

	//PANEL PROVEEDORES
	private void panelProveedores() {
		panelProveedores = new JPanel();
		panelProveedores.setBackground(color_panel);
		panelProveedores.setBounds(200, 40, 750, 230);
		panelProveedores.setLayout(null);
		add(panelProveedores);
		panelProveedores.setVisible(false);
		
		barraProveedores = new JScrollPane();
		barraProveedores.setBounds(20, 20, 710, 190);
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
		subPanelInsProv.setBounds(200, 270, 750, 268);
		subPanelInsProv.setBackground(color_panel);
		subPanelInsProv.setLayout(null);
		add(subPanelInsProv);
		subPanelInsProv.setVisible(false);	
		
		nuevoProv = new JLabel("new supplier");
		nuevoProv.setBounds(20, 0, 710, 60);
		nuevoProv.setBorder(null);
		nuevoProv.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		nuevoProv.setForeground(color_azul);//Color del texto
		nuevoProv.setHorizontalAlignment(JLabel.CENTER);
		nuevoProv.setVerticalAlignment(JLabel.CENTER);
		subPanelInsProv.add(nuevoProv);
		
		//caja codigo nuevo proveedor
		insertCodProv = new JTextField();//Creamos el componente
		TextPrompt placeholder = new TextPrompt("supplier's code", insertCodProv);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
	    insertCodProv.setBounds(40,90,200,30);//Posicionamos
	    insertCodProv.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertCodProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertCodProv.setBackground(Color.WHITE); //Color de fondo
	    insertCodProv.setForeground(color_azul);//Color del texto
	    subPanelInsProv.add(insertCodProv);//Anadimos
	    
	    //caja nombre nuevo proveedor
	    insertNomProv = new JTextField();//Creamos el componente
		TextPrompt placeholder1 = new TextPrompt("supplier's name", insertNomProv);
	    placeholder1.changeAlpha(0.75f);
	    placeholder1.changeStyle(Font.ITALIC);
	    insertNomProv.setBounds(250,90,430,30);//Posicionamos
	    insertNomProv.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNomProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertNomProv.setBackground(Color.WHITE); //Color de fondo
	    insertNomProv.setForeground(color_azul);//Color del texto
	    subPanelInsProv.add(insertNomProv);//Anadimos
		
	    //caja mail nuevo proveedor
		insertContProv = new JTextField();//Creamos el componente
		TextPrompt placeholder2 = new TextPrompt("contact", insertContProv);
	    placeholder2.changeAlpha(0.75f);
	    placeholder2.changeStyle(Font.ITALIC);
	    insertContProv.setBounds(40,150,400,30);//Posicionamos
	    insertContProv.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertContProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertContProv.setBackground(Color.WHITE); //Color de fondo
	    insertContProv.setForeground(color_azul);//Color del texto
	    subPanelInsProv.add(insertContProv);//Anadimos
	    
	    //boton insertar
	    Image imgBotonInsertProvOk = new ImageIcon("img\\insert.png").getImage();
		botonInsertProvOk = new JButton(new ImageIcon(imgBotonInsertProvOk.getScaledInstance(110,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonInsertProvOk.setBounds(550,140,110,42);
		botonInsertProvOk.setBorder(null); //Eliminamos el borde
		botonInsertProvOk.setBackground(new Color(186,236,247));
		subPanelInsProv.add(botonInsertProvOk);//Anadimos 
		
		//resultado insercion
		resulInsertProv = new JLabel("");//Creamos el componente
		resulInsertProv.setBounds(100,200,500,30);//Posicionamos
		resulInsertProv.setBorder(null); //Eliminamos el borde
		resulInsertProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulInsertProv.setForeground(new Color(000,000,000));//Color del texto
		subPanelInsProv.add(resulInsertProv);//Anadimos	
		
		//SUBPANEL EDITAR PROVEEDOR
		
		subPanelEditProv = new JPanel();
		subPanelEditProv.setBounds(200, 270, 750, 268);
		subPanelEditProv.setBackground(color_panel);
		subPanelEditProv.setLayout(null);
		add(subPanelEditProv);
		subPanelEditProv.setVisible(false);	
		
		editProv = new JLabel("update supplier");
		editProv.setBounds(20, 0, 710, 60);
		editProv.setBorder(null);
		editProv.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		editProv.setForeground(color_azul);//Color del texto
		editProv.setHorizontalAlignment(JLabel.CENTER);
		editProv.setVerticalAlignment(JLabel.CENTER);
		subPanelEditProv.add(editProv);
		
		//caja cod proveedor a editar
		insertCODUpdateProv = new JTextField();//Creamos el componente
		TextPrompt placeholder8 = new TextPrompt("Insert supplier's code", insertCODUpdateProv);
	    placeholder8.changeAlpha(0.75f);
	    placeholder8.changeStyle(Font.ITALIC);
	    insertCODUpdateProv.setBounds(20,70,200,30);//Posicionamos		
	    insertCODUpdateProv.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertCODUpdateProv.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertCODUpdateProv.setBackground(Color.WHITE); //Color de fondo
	    insertCODUpdateProv.setForeground(color_azul);//Color del texto
	    subPanelEditProv.add(insertCODUpdateProv);//Anadimos
	    
	    labelPreguntaCambioProv = new JLabel("What do you want to change?");
	    labelPreguntaCambioProv.setBounds(20, 120, 300, 30);
	    labelPreguntaCambioProv.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
	    labelPreguntaCambioProv.setForeground(color_azul);//Color del texto
	    subPanelEditProv.add(labelPreguntaCambioProv);//Anadimos
	    
	    //combo para elegir que campo editar
	    comboUpdateProv = new JComboBox<String>();
	    comboUpdateProv.addItem("codproveedor");
	    comboUpdateProv.addItem("nombreProveedor");
	    comboUpdateProv.addItem("mail");
	    comboUpdateProv.setBounds(340, 120, 300, 30);
	    subPanelEditProv.add(comboUpdateProv);

		labelNewDataProv = new JLabel("Insert new data");
		labelNewDataProv.setBounds(20, 170, 300, 30);
		labelNewDataProv.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
		labelNewDataProv.setForeground(color_azul);//Color del texto
		subPanelEditProv.add(labelNewDataProv);//Anadimos
		
		//nueva info
		insertNewDataProv = new JTextField();//Creamos el componente
		TextPrompt placeholder9 = new TextPrompt("Insert new data", insertNewDataProv);
	    placeholder9.changeAlpha(0.75f);
	    placeholder9.changeStyle(Font.ITALIC);
	    insertNewDataProv.setBounds(340,170,300,30);//Posicionamos		
	    insertNewDataProv.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNewDataProv.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNewDataProv.setBackground(Color.WHITE); //Color de fondo
	    insertNewDataProv.setForeground(color_azul);//Color del texto
	    subPanelEditProv.add(insertNewDataProv);//Anadimos
	    
	    //boton actualizar
	    Image imgBotonUpdateFinalPr = new ImageIcon("img\\update.png").getImage();
		botonUpdateFinalPr = new JButton(new ImageIcon(imgBotonUpdateFinalPr.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonUpdateFinalPr.setBounds(20,220,110,42);
		botonUpdateFinalPr.setBackground(new Color(186,236,247));
		botonUpdateFinalPr.setBorder(null); //Eliminamos el borde
		subPanelEditProv.add(botonUpdateFinalPr);//Anadimos 
		
		//resultado de la actualizacion
		resultUpdateProv = new JLabel();//Creamos el componente
		resultUpdateProv.setBounds(150,222,500,30);//Posicionamos
		resultUpdateProv.setBorder(null); //Eliminamos el borde
		resultUpdateProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resultUpdateProv.setForeground(color_azul);//Color del texto
		subPanelEditProv.add(resultUpdateProv);//Anadimos

		
		//SUBPANEL ELIMINAR PROVEEDOR
		
		subPanelElimProv = new JPanel();
		subPanelElimProv.setBounds(200, 270, 750, 268);
		subPanelElimProv.setBackground(color_panel);
		subPanelElimProv.setLayout(null);
		add(subPanelElimProv);
		subPanelElimProv.setVisible(false);	
		
		elimProv = new JLabel("delete supplier");
		elimProv.setBounds(20, 0, 710, 60);
		elimProv.setBorder(null);
		elimProv.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		elimProv.setForeground(color_azul);//Color del texto
		elimProv.setHorizontalAlignment(JLabel.CENTER);
		elimProv.setVerticalAlignment(JLabel.CENTER);
		subPanelElimProv.add(elimProv);
		
		//cod proveedor a eliminar
		insertCODDeleteProv = new JTextField();//Creamos el componente
		TextPrompt placeholder11 = new TextPrompt("Insert supplier's code", insertCODDeleteProv);
	    placeholder11.changeAlpha(0.75f);
	    placeholder11.changeStyle(Font.ITALIC);
	    insertCODDeleteProv.setBounds(20,70,200,30);//Posicionamos		
	    insertCODDeleteProv.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertCODDeleteProv.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertCODDeleteProv.setBackground(Color.WHITE); //Color de fondo
	    insertCODDeleteProv.setForeground(color_azul);//Color del texto
	    subPanelElimProv.add(insertCODDeleteProv);//Anadimos
		
	    //boton busqueda
	    Image imgBotonSearchProv = new ImageIcon("img\\search.png").getImage();
		botonSearchProv = new JButton(new ImageIcon(imgBotonSearchProv.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonSearchProv.setBounds(20,130,110,42);
		botonSearchProv.setBackground(new Color(186,236,247));
		botonSearchProv.setBorder(null); //Eliminamos el borde
		subPanelElimProv.add(botonSearchProv);//Anadimos 
		
		//resultado busqueda
		resulBusquedaProv = new JLabel();//Creamos el componente
		resulBusquedaProv.setBounds(150,130,500,30);//Posicionamos
		resulBusquedaProv.setBorder(null); //Eliminamos el borde
		resulBusquedaProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulBusquedaProv.setForeground(color_azul);//Color del texto
		subPanelElimProv.add(resulBusquedaProv);//Anadimos
		
		//boton borrar el proveedor seleccionado
		Image imgBotonDeleteProvFinal = new ImageIcon("img\\delete.png").getImage();
		botonDeleteProvFinal = new JButton(new ImageIcon(imgBotonDeleteProvFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonDeleteProvFinal.setBounds(20,190,110,42);
		botonDeleteProvFinal.setBackground(new Color(186,236,247));
		botonDeleteProvFinal.setBorder(null); //Eliminamos el borde
		subPanelElimProv.add(botonDeleteProvFinal);//Anadimos 
		botonDeleteProvFinal.setVisible(false);
		
		//resultado del borrado
		resulDeleteProv = new JLabel();//Creamos el componente
		resulDeleteProv.setBounds(150,190,500,30);//Posicionamos
		resulDeleteProv.setBorder(null); //Eliminamos el borde
		resulDeleteProv.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulDeleteProv.setForeground(color_azul);//Color del texto
		subPanelEmpDelete.add(resulDeleteProv);//Anadimos	
	

		 
		
	    
		//Panel botones PROVEEDORES
	    
		panelBotonesProv = new JPanel();
		panelBotonesProv.setBounds(200, 538, 750, 82);
		panelBotonesProv.setBackground(color_panel);
		panelBotonesProv.setLayout(null);
		add(panelBotonesProv);
		panelBotonesProv.setVisible(false);		
	    
		Image imgbotonActualizarProveedor = new ImageIcon("img\\update supplier.png").getImage();
		botonActualizarProveedor = new JButton(new ImageIcon(imgbotonActualizarProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonActualizarProveedor.setBounds((int) 67.5, 20, 160, 42);
		botonActualizarProveedor.setBorder(null); //Eliminamos el borde
		botonActualizarProveedor.setBackground(color_panel);
		panelBotonesProv.add(botonActualizarProveedor);//Anadimos 
		
		Image imgbotonBorrarProveedor = new ImageIcon("img\\delete supplier.png").getImage();
		botonBorrarProveedor = new JButton(new ImageIcon(imgbotonBorrarProveedor.getScaledInstance(160,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonBorrarProveedor.setBounds(295, 20, 160, 42);
		botonBorrarProveedor.setBorder(null); //Eliminamos el borde
		botonBorrarProveedor.setBackground(color_panel);
		panelBotonesProv.add(botonBorrarProveedor);//Anadimos 
		
		Image imgbotonDeliveryNotes = new ImageIcon("img\\delivery notes.png").getImage();
		botonDeliveryNotes = new JButton(new ImageIcon(imgbotonDeliveryNotes.getScaledInstance(160,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonDeliveryNotes.setBounds((int) 522.5, 20, 160, 42);
		botonDeliveryNotes.setBorder(null); //Eliminamos el borde
		botonDeliveryNotes.setBackground(color_panel);
		panelBotonesProv.add(botonDeliveryNotes);//Anadimos 
		


	}
	
	//PANEL CLIENTES
	private void panelClientes() {
		panelClientes = new JPanel();
		panelClientes.setBackground(color_panel);
		panelClientes.setBounds(200, 40, 750, 230);
		panelClientes.setLayout(null);
		add(panelClientes);
		panelClientes.setVisible(false);
		
		barraClientes = new JScrollPane();
		barraClientes.setBounds(20, 20, 710, 190);
		panelClientes.add(barraClientes);
		
		String titulosClientes[] = {"DNI Cliente", "Nombre Cliente", "Email", "Tel�fono"};
		String infoClientes[][] = AccesoDB.obtenerMatrizClientes();
		
		tablaClientes = new JTable(infoClientes,titulosClientes);
		tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(115);
		tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(140);
		barraClientes.setViewportView(tablaClientes);
		
		//SUBPANEL INSERTAR CLIENTE
		
		subPanelInsCliente = new JPanel();
		subPanelInsCliente.setBounds(200, 270, 750, 268);
		subPanelInsCliente.setBackground(color_panel);
		subPanelInsCliente.setLayout(null);
		add(subPanelInsCliente);
		subPanelInsCliente.setVisible(false);	
				
		nuevoCliente = new JLabel("new customer");
		nuevoCliente.setBounds(20, 0, 710, 60);
		nuevoCliente.setBorder(null);
		nuevoCliente.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		nuevoCliente.setForeground(color_azul);//Color del texto
		nuevoCliente.setHorizontalAlignment(JLabel.CENTER);
		nuevoCliente.setVerticalAlignment(JLabel.CENTER);
		subPanelInsCliente.add(nuevoCliente);
		
		//caja codigo nuevo cliente
		insertNIFCliente = new JTextField();//Creamos el componente
		TextPrompt placeholder = new TextPrompt("customer's code", insertNIFCliente);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
	    insertNIFCliente.setBounds(40,90,200,30);//Posicionamos
	    insertNIFCliente.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNIFCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertNIFCliente.setBackground(Color.WHITE); //Color de fondo
	    insertNIFCliente.setForeground(color_azul);//Color del texto
	    subPanelInsCliente.add(insertNIFCliente);//Anadimos
				
		  //caja nombre nuevo cliente
	    insertNomCliente = new JTextField();//Creamos el componente
		TextPrompt placeholder1 = new TextPrompt("customer's name", insertNomCliente);
	    placeholder1.changeAlpha(0.75f);
	    placeholder1.changeStyle(Font.ITALIC);
	    insertNomCliente.setBounds(250,90,430,30);//Posicionamos
	    insertNomCliente.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNomCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertNomCliente.setBackground(Color.WHITE); //Color de fondo
	    insertNomCliente.setForeground(color_azul);//Color del texto
	    subPanelInsCliente.add(insertNomCliente);//Anadimos
				
			//caja telefono nuevo cliente
	    insertTelCliente = new JTextField();//Creamos el componente
		TextPrompt placeholder2 = new TextPrompt("email", insertTelCliente);
	    placeholder2.changeAlpha(0.75f);
	    placeholder2.changeStyle(Font.ITALIC);
	    insertTelCliente.setBounds(40,130,400,30);//Posicionamos
	    insertTelCliente.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertTelCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertTelCliente.setBackground(Color.WHITE); //Color de fondo
	    insertTelCliente.setForeground(color_azul);//Color del texto
	    subPanelInsCliente.add(insertTelCliente);//Anadimos
	    
	    //insertMailCliente
	    insertMailCliente = new JTextField();//Creamos el componente
		TextPrompt placeholder3 = new TextPrompt("phone", insertMailCliente);
	    placeholder3.changeAlpha(0.75f);
	    placeholder3.changeStyle(Font.ITALIC);
	    insertMailCliente.setBounds(40,170,120,30);//Posicionamos
	    insertMailCliente.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertMailCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    insertMailCliente.setBackground(Color.WHITE); //Color de fondo
	    insertMailCliente.setForeground(color_azul);//Color del texto
	    subPanelInsCliente.add(insertMailCliente);//Anadimos
		
			//boton insertar
	    Image imgBotonInsertClienteOk = new ImageIcon("img\\insert.png").getImage();
		botonInsertClienteok = new JButton(new ImageIcon(imgBotonInsertClienteOk.getScaledInstance(110,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonInsertClienteok.setBounds(550,140,110,42);
		botonInsertClienteok.setBorder(null); //Eliminamos el borde
		//Falta incluir la imagen del bot�n
		botonInsertClienteok.setBackground(new Color(186,236,247));
		subPanelInsCliente.add(botonInsertClienteok);//Anadimos 
				
		//resultado insercion
		resulInsertCliente = new JLabel("");//Creamos el componente
		resulInsertCliente.setBounds(100,200,500,30);//Posicionamos
		resulInsertCliente.setBorder(null); //Eliminamos el borde
		resulInsertCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulInsertCliente.setForeground(new Color(000,000,000));//Color del texto
		subPanelInsCliente.add(resulInsertCliente);//Anadimos	
		
		
		//SUBPANEL EDITAR CLIENTE
		
		subPanelEditCliente = new JPanel();
		subPanelEditCliente.setBounds(200, 270, 750, 268);
		subPanelEditCliente.setBackground(color_panel);
		subPanelEditCliente.setLayout(null);
		add(subPanelEditCliente);
		subPanelEditCliente.setVisible(false);	
		
		editCliente = new JLabel("update supplier");
		editCliente.setBounds(20, 0, 710, 60);
		editCliente.setBorder(null);
		editCliente.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		editCliente.setForeground(color_azul);//Color del texto
		editCliente.setHorizontalAlignment(JLabel.CENTER);
		editCliente.setVerticalAlignment(JLabel.CENTER);
		subPanelEditCliente.add(editCliente);
		
		//caja nif cliente editar
		insertNIFUpdateCliente = new JTextField();//Creamos el componente
		TextPrompt placeholder8 = new TextPrompt("Insert customer's NIF", insertNIFUpdateCliente);
	    placeholder8.changeAlpha(0.75f);
	    placeholder8.changeStyle(Font.ITALIC);
	    insertNIFUpdateCliente.setBounds(20,70,200,30);//Posicionamos		
	    insertNIFUpdateCliente.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNIFUpdateCliente.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNIFUpdateCliente.setBackground(Color.WHITE); //Color de fondo
	    insertNIFUpdateCliente.setForeground(color_azul);//Color del texto
	    subPanelEditCliente.add(insertNIFUpdateCliente);//Anadimos
	    
	    labelPreguntaCambioCliente = new JLabel("What do you want to change?");
	    labelPreguntaCambioCliente.setBounds(20, 120, 300, 30);
	    labelPreguntaCambioCliente.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
	    labelPreguntaCambioCliente.setForeground(color_azul);//Color del texto
	    subPanelEditCliente.add(labelPreguntaCambioCliente);//Anadimos
		
		//combo para elegir que campo editar
	    comboUpdateCliente = new JComboBox<String>();
	    comboUpdateCliente.addItem("dni_Cliente");
	    comboUpdateCliente.addItem("nombre");
		comboUpdateCliente.addItem("telefono");
	    comboUpdateCliente.addItem("email");
	    comboUpdateCliente.setBounds(340, 120, 300, 30);
	    subPanelEditCliente.add(comboUpdateCliente);

		labelNewDataCliente = new JLabel("Insert new data");
		labelNewDataCliente.setBounds(20, 170, 300, 30);
		labelNewDataCliente.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
		labelNewDataCliente.setForeground(color_azul);//Color del texto
		subPanelEditCliente.add(labelNewDataCliente);//Anadimos
		
		//nueva info
		insertNewDataCliente = new JTextField();//Creamos el componente
		TextPrompt placeholder9 = new TextPrompt("Insert new data", insertNewDataCliente);
	    placeholder9.changeAlpha(0.75f);
	    placeholder9.changeStyle(Font.ITALIC);
	    insertNewDataCliente.setBounds(340,170,300,30);//Posicionamos		
	    insertNewDataCliente.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNewDataCliente.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNewDataCliente.setBackground(Color.WHITE); //Color de fondo
	    insertNewDataCliente.setForeground(color_azul);//Color del texto
	    subPanelEditCliente.add(insertNewDataCliente);//Anadimos
		
			//boton actualizar
	    Image imgBotonUpdateFinalCl = new ImageIcon("img\\update.png").getImage();
		botonUpdateFinalCl = new JButton(new ImageIcon(imgBotonUpdateFinalCl.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonUpdateFinalCl.setBounds(20,220,110,42);
		botonUpdateFinalCl.setBackground(new Color(186,236,247));
		botonUpdateFinalCl.setBorder(null); //Eliminamos el borde
		subPanelEditCliente.add(botonUpdateFinalCl);//Anadimos 
		
			//resultado de la actualizacion
		resultUpdateCliente = new JLabel();//Creamos el componente
		resultUpdateCliente.setBounds(150,222,500,30);//Posicionamos
		resultUpdateCliente.setBorder(null); //Eliminamos el borde
		resultUpdateCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resultUpdateCliente.setForeground(color_azul);//Color del texto
		subPanelEditCliente.add(resultUpdateCliente);//Anadimos
		
	//SUBPANEL ELIMINAR CLIENTE
		
		subPanelElimCliente = new JPanel();
		subPanelElimCliente.setBounds(200, 270, 750, 268);
		subPanelElimCliente.setBackground(color_panel);
		subPanelElimCliente.setLayout(null);
		add(subPanelElimCliente);
		subPanelElimCliente.setVisible(false);	
		
		elimCliente = new JLabel("delete customer");
		elimCliente.setBounds(20, 0, 710, 60);
		elimCliente.setBorder(null);
		elimCliente.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		elimCliente.setForeground(color_azul);//Color del texto
		elimCliente.setHorizontalAlignment(JLabel.CENTER);
		elimCliente.setVerticalAlignment(JLabel.CENTER);
		subPanelElimCliente.add(elimCliente);
		
		//nif cliente a eliminar
		insertNIFDeleteCli = new JTextField();//Creamos el componente
		TextPrompt placeholder11 = new TextPrompt("Insert customer's NIF", insertNIFDeleteCli);
	    placeholder11.changeAlpha(0.75f);
	    placeholder11.changeStyle(Font.ITALIC);
	    insertNIFDeleteCli.setBounds(20,70,200,30);//Posicionamos		
	    insertNIFDeleteCli.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNIFDeleteCli.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNIFDeleteCli.setBackground(Color.WHITE); //Color de fondo
	    insertNIFDeleteCli.setForeground(color_azul);//Color del texto
	    subPanelElimCliente.add(insertNIFDeleteCli);//Anadimos
		
		   //boton busqueda
	    Image imgBotonSearchCli = new ImageIcon("img\\search.png").getImage();
		botonSearchCliente = new JButton(new ImageIcon(imgBotonSearchCli.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonSearchCliente.setBounds(20,130,110,42);
		botonSearchCliente.setBackground(new Color(186,236,247));
		botonSearchCliente.setBorder(null); //Eliminamos el borde
		subPanelElimCliente.add(botonSearchCliente);//Anadimos 
		
			//resultado busqueda
		resulBusquedaCli = new JLabel();//Creamos el componente
		resulBusquedaCli.setBounds(150,130,500,30);//Posicionamos
		resulBusquedaCli.setBorder(null); //Eliminamos el borde
		resulBusquedaCli.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulBusquedaCli.setForeground(color_azul);//Color del texto
		subPanelElimCliente.add(resulBusquedaCli);//Anadimos
		
			//boton borrar el cliente seleccionado
		Image imgBotonDeleteClienteFinal = new ImageIcon("img\\delete.png").getImage();
		botonDeleteClienteFinal = new JButton(new ImageIcon(imgBotonDeleteClienteFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonDeleteClienteFinal.setBounds(20,190,110,42);
		botonDeleteClienteFinal.setBackground(new Color(186,236,247));
		botonDeleteClienteFinal.setBorder(null); //Eliminamos el borde
		subPanelElimCliente.add(botonDeleteClienteFinal);//Anadimos 
		botonDeleteClienteFinal.setVisible(false);
		
			//resultado del borrado
		resulDeleteCliente = new JLabel();//Creamos el componente
		resulDeleteCliente.setBounds(150,190,500,30);//Posicionamos
		resulDeleteCliente.setBorder(null); //Eliminamos el borde
		resulDeleteCliente.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulDeleteCliente.setForeground(color_azul);//Color del texto
		subPanelElimCliente.add(resulDeleteCliente);//Anadimos	
		
		//Panel botones CLIENTES
	    
		panelBotonesCliente = new JPanel();
		panelBotonesCliente.setBounds(200, 538, 750, 82);
		panelBotonesCliente.setBackground(color_panel);
		panelBotonesCliente.setLayout(null);
		add(panelBotonesCliente);
		panelBotonesCliente.setVisible(false);		
	    
		//cambiar imagen boton
		Image imgbotonActualizarCliente = new ImageIcon("img\\update customer.png").getImage();
		botonActualizarCliente = new JButton(new ImageIcon(imgbotonActualizarCliente.getScaledInstance(160,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonActualizarCliente.setBounds((int) 67.5, 20, 160, 42);
		botonActualizarCliente.setBorder(null); //Eliminamos el borde
		botonActualizarCliente.setBackground(color_panel);
		panelBotonesCliente.add(botonActualizarCliente);//Anadimos 
		
		//cambiar imagen boton
		Image imgbotonBorrarCliente = new ImageIcon("img\\delete customer.png").getImage();
		botonBorrarCliente = new JButton(new ImageIcon(imgbotonBorrarCliente.getScaledInstance(160,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonBorrarCliente.setBounds(295, 20, 160, 42);
		botonBorrarCliente.setBorder(null); //Eliminamos el borde
		botonBorrarCliente.setBackground(color_panel);
		panelBotonesCliente.add(botonBorrarCliente);//Anadimos 
		
		//cambiar imagen boton
		Image imgbotonBills = new ImageIcon("img\\bills.png").getImage();
		botonBills = new JButton(new ImageIcon(imgbotonBills.getScaledInstance(160,42, Image.SCALE_SMOOTH)));//Creamos el componente
		botonBills.setBounds((int) 522.5, 20, 160, 42);
		botonBills.setBorder(null); //Eliminamos el borde
		botonBills.setBackground(color_panel);
		panelBotonesCliente.add(botonBills);//Anadimos 

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

	//PANEL ALMAC�N
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
			
		//SUBPANEL INSERTAR EMPLEADO - Este sub-panel va cambiando en funci�n de los botones que se vayan pulsando
		
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
		botonInsertEmpFinal = new JButton(new ImageIcon(imgBotonInsertFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonInsertEmpFinal.setBounds(20,220,110,42);
		botonInsertEmpFinal.setBackground(new Color(186,236,247));
		botonInsertEmpFinal.setBorder(null); //Eliminamos el borde
		subPanelEmpInsertar.add(botonInsertEmpFinal);//Anadimos 
		
		resulInsertEmp = new JLabel();//Creamos el componente
		resulInsertEmp.setBounds(150,222,500,30);//Posicionamos
		resulInsertEmp.setBorder(null); //Eliminamos el borde
		resulInsertEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulInsertEmp.setForeground(Color.gray);//Color del texto
		subPanelEmpInsertar.add(resulInsertEmp);//Anadimos	
		
		//SUBPANEL BOTONES

		subPanelBotonesEmp = new JPanel();
		subPanelBotonesEmp.setBounds(200, 538, 750, 82);
		subPanelBotonesEmp.setBackground(color_panel);
		subPanelBotonesEmp.setLayout(null);
		add(subPanelBotonesEmp);
		subPanelBotonesEmp.setVisible(false);	
		
		Image imgBotonUpdateEmpleado = new ImageIcon("img\\update employee.png").getImage();
		botonActualizarEmpleado = new JButton(new ImageIcon(imgBotonUpdateEmpleado.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		botonActualizarEmpleado.setBounds((int) 67.5, 20, 160, 42);
		botonActualizarEmpleado.setBorder(null); // Eliminamos el borde
		botonActualizarEmpleado.setBackground(color_panel);
		subPanelBotonesEmp.add(botonActualizarEmpleado);// Anadimos

		Image imgBotonDeleteEmpleado = new ImageIcon("img\\delete employee.png").getImage();
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
		
		//SUBPANEL UPDATE EMPLEADO
		
		subPanelEmpUpdate = new JPanel();
		subPanelEmpUpdate.setBounds(200, 270, 750, 268);
		subPanelEmpUpdate.setBackground(color_panel);
		subPanelEmpUpdate.setLayout(null);
		add(subPanelEmpUpdate);
		subPanelEmpUpdate.setVisible(false);
		
		updateEmpleado = new JLabel("update employee");
		updateEmpleado.setBounds(20, 0, 710, 60);
		updateEmpleado.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		updateEmpleado.setForeground(color_azul);//Color del texto
		updateEmpleado.setHorizontalAlignment(JLabel.CENTER);
		updateEmpleado.setVerticalAlignment(JLabel.CENTER);
		subPanelEmpUpdate.add(updateEmpleado);//Anadimos
		
		insertNIFUpdateEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder8 = new TextPrompt("Insert employee's NIF", insertNIFUpdateEmp);
	    placeholder8.changeAlpha(0.75f);
	    placeholder8.changeStyle(Font.ITALIC);
	    insertNIFUpdateEmp.setBounds(20,70,200,30);//Posicionamos		
	    insertNIFUpdateEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNIFUpdateEmp.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNIFUpdateEmp.setBackground(Color.WHITE); //Color de fondo
	    insertNIFUpdateEmp.setForeground(color_azul);//Color del texto
	    subPanelEmpUpdate.add(insertNIFUpdateEmp);//Anadimos
	    
	    labelPreguntaCambioEmp = new JLabel("What do you want to change?");
	    labelPreguntaCambioEmp.setBounds(20, 120, 300, 30);
	    labelPreguntaCambioEmp.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
	    labelPreguntaCambioEmp.setForeground(color_azul);//Color del texto
		subPanelEmpUpdate.add(labelPreguntaCambioEmp);//Anadimos
		
		comboUpdateEmp = new JComboBox<String>();
		comboUpdateEmp.addItem("nombre");
		comboUpdateEmp.addItem("apellidos");
		comboUpdateEmp.addItem("email");
		comboUpdateEmp.addItem("NIF_Empleado");
		comboUpdateEmp.addItem("telefono");
		comboUpdateEmp.addItem("usuario");
		comboUpdateEmp.addItem("contrasena");
		comboUpdateEmp.addItem("perfil");
		comboUpdateEmp.setBounds(340, 120, 300, 30);
		subPanelEmpUpdate.add(comboUpdateEmp);
		
		labelNewDataEmp = new JLabel("Insert new data");
		labelNewDataEmp.setBounds(20, 170, 300, 30);
		labelNewDataEmp.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
		labelNewDataEmp.setForeground(color_azul);//Color del texto
		subPanelEmpUpdate.add(labelNewDataEmp);//Anadimos
		
		insertNewDataEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder9 = new TextPrompt("Insert new data", insertNewDataEmp);
	    placeholder9.changeAlpha(0.75f);
	    placeholder9.changeStyle(Font.ITALIC);
	    insertNewDataEmp.setBounds(340,170,300,30);//Posicionamos		
	    insertNewDataEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNewDataEmp.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNewDataEmp.setBackground(Color.WHITE); //Color de fondo
	    insertNewDataEmp.setForeground(color_azul);//Color del texto
	    subPanelEmpUpdate.add(insertNewDataEmp);//Anadimos
	    
	    Image imgBotonUpdateFinal = new ImageIcon("img\\update.png").getImage();
		botonUpdateEmpFinal = new JButton(new ImageIcon(imgBotonUpdateFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonUpdateEmpFinal.setBounds(20,220,110,42);
		botonUpdateEmpFinal.setBackground(new Color(186,236,247));
		botonUpdateEmpFinal.setBorder(null); //Eliminamos el borde
		subPanelEmpUpdate.add(botonUpdateEmpFinal);//Anadimos 
		
		resultUpdateEmp = new JLabel();//Creamos el componente
		resultUpdateEmp.setBounds(150,222,500,30);//Posicionamos
		resultUpdateEmp.setBorder(null); //Eliminamos el borde
		resultUpdateEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resultUpdateEmp.setForeground(Color.gray);//Color del texto
		subPanelEmpUpdate.add(resultUpdateEmp);//Anadimos	
		
		//SUBPANEL DELETE EMPLEADO
		
		subPanelEmpDelete = new JPanel();
		subPanelEmpDelete.setBounds(200, 270, 750, 268);
		subPanelEmpDelete.setBackground(color_panel);
		subPanelEmpDelete.setLayout(null);
		add(subPanelEmpDelete);
		subPanelEmpDelete.setVisible(false);
		
		deleteEmpleado = new JLabel("delete employee");
		deleteEmpleado.setBounds(20, 0, 710, 60);
		deleteEmpleado.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		deleteEmpleado.setForeground(color_azul);//Color del texto
		deleteEmpleado.setHorizontalAlignment(JLabel.CENTER);
		deleteEmpleado.setVerticalAlignment(JLabel.CENTER);
		subPanelEmpDelete.add(deleteEmpleado);//Anadimos al panel
		
		insertNIFDeleteEmp = new JTextField();//Creamos el componente
		TextPrompt placeholder11 = new TextPrompt("Insert employee's NIF", insertNIFDeleteEmp);
	    placeholder11.changeAlpha(0.75f);
	    placeholder11.changeStyle(Font.ITALIC);
	    insertNIFDeleteEmp.setBounds(20,70,200,30);//Posicionamos		
	    insertNIFDeleteEmp.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertNIFDeleteEmp.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertNIFDeleteEmp.setBackground(Color.WHITE); //Color de fondo
	    insertNIFDeleteEmp.setForeground(color_azul);//Color del texto
		subPanelEmpDelete.add(insertNIFDeleteEmp);//Anadimos	

	    Image imgBotonSearchEmp = new ImageIcon("img\\search.png").getImage();
		botonSearchEmp = new JButton(new ImageIcon(imgBotonSearchEmp.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonSearchEmp.setBounds(20,130,110,42);
		botonSearchEmp.setBackground(new Color(186,236,247));
		botonSearchEmp.setBorder(null); //Eliminamos el borde
		subPanelEmpDelete.add(botonSearchEmp);//Anadimos 
		
		resulBusquedaEmp = new JLabel();//Creamos el componente
		resulBusquedaEmp.setBounds(150,130,500,30);//Posicionamos
		resulBusquedaEmp.setBorder(null); //Eliminamos el borde
		resulBusquedaEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulBusquedaEmp.setForeground(Color.gray);//Color del texto
		subPanelEmpDelete.add(resulBusquedaEmp);//Anadimos
		
		Image imgBotonDeleteEmpFinal = new ImageIcon("img\\delete.png").getImage();
		botonDeleteEmpFinal = new JButton(new ImageIcon(imgBotonDeleteEmpFinal.getScaledInstance(110,42, Image.SCALE_SMOOTH)));
		botonDeleteEmpFinal.setBounds(20,190,110,42);
		botonDeleteEmpFinal.setBackground(new Color(186,236,247));
		botonDeleteEmpFinal.setBorder(null); //Eliminamos el borde
		subPanelEmpDelete.add(botonDeleteEmpFinal);//Anadimos 
		botonDeleteEmpFinal.setVisible(false);
		
		resulDeleteEmp = new JLabel();//Creamos el componente
		resulDeleteEmp.setBounds(150,190,500,30);//Posicionamos
		resulDeleteEmp.setBorder(null); //Eliminamos el borde
		resulDeleteEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
		resulDeleteEmp.setForeground(Color.gray);//Color del texto
		subPanelEmpDelete.add(resulDeleteEmp);//Anadimos
		
		//SUBPANEL EXPORT EMPLEADO
		
		subPanelEmpExport = new JPanel();
		subPanelEmpExport.setBounds(200, 270, 750, 268);
		subPanelEmpExport.setBackground(color_panel);
		subPanelEmpExport.setLayout(null);
		add(subPanelEmpExport);
		subPanelEmpExport.setVisible(false);
		
		exportEmpleado = new JLabel("export employee's to file");
		exportEmpleado.setBounds(20, 0, 710, 60);
		exportEmpleado.setFont(new Font("Segoe UI",Font.BOLD,40));//Damos formato al contenido
		exportEmpleado.setForeground(color_azul);//Color del texto
		exportEmpleado.setHorizontalAlignment(JLabel.CENTER);
		exportEmpleado.setVerticalAlignment(JLabel.CENTER);
		subPanelEmpExport.add(exportEmpleado);//Anadimos al panel
		
		insertUsuarioPC = new JTextField();//Creamos el componente
		TextPrompt placeholder12 = new TextPrompt("Insert user PC. Ej. ejemplo", insertUsuarioPC);
		placeholder12.changeAlpha(0.75f);
		placeholder12.changeStyle(Font.ITALIC);
	    insertUsuarioPC.setBounds(20,70,200,30);//Posicionamos		
	    insertUsuarioPC.setBorder(BorderFactory.createLineBorder(color_azul, 2)); //Eliminamos el borde
	    insertUsuarioPC.setFont(new Font("Segoe UI",Font.BOLD,14));//Damos formato al contenido
	    insertUsuarioPC.setBackground(Color.WHITE); //Color de fondo
	    insertUsuarioPC.setForeground(color_azul);//Color del texto
	    subPanelEmpExport.add(insertUsuarioPC);//Anadimos	
		
		insertRutaExportEmp = new JLabel("You'll find the file in C:\\Users\\youruser. Name of file: empleados.csv ");//Creamos el componente
	    insertRutaExportEmp.setBounds(20,120,670,30);//Posicionamos		
	    insertRutaExportEmp.setBorder(null); //Eliminamos el borde
	    insertRutaExportEmp.setFont(new Font("Segoe UI",Font.BOLD,18));//Damos formato al contenido
	    insertRutaExportEmp.setForeground(color_azul);//Color del texto
	    subPanelEmpExport.add(insertRutaExportEmp);//Anadimos
	    
	    Image imgBotonExportEmpFinal = new ImageIcon("img\\export to file.png").getImage();
		botonExportEmpFinal = new JButton(new ImageIcon(imgBotonExportEmpFinal.getScaledInstance(160,42, Image.SCALE_SMOOTH)));
		botonExportEmpFinal.setBounds(20,180,160,42);
		botonExportEmpFinal.setBackground(new Color(186,236,247));
		botonExportEmpFinal.setBorder(null); //Eliminamos el borde
		subPanelEmpExport.add(botonExportEmpFinal);//Anadimos 
				
	    resulExportEmp = new JLabel();//Creamos el componente
	    resulExportEmp.setBounds(200,180,500,30);//Posicionamos
	    resulExportEmp.setBorder(null); //Eliminamos el borde
	    resulExportEmp.setFont(new Font("Segoe UI",Font.BOLD,16));//Damos formato al contenido
	    resulExportEmp.setForeground(Color.GRAY);//Color del texto
	    subPanelEmpExport.add(resulExportEmp);//Anadimos	
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
		imageLogo.addMouseListener(manejador);
		
		botonActualizarEmpleado.addMouseListener(manejador);
		botonBorrarEmpleado.addMouseListener(manejador);
		botonExpEmplFichero.addMouseListener(manejador);
		botonUpdateEmpFinal.addMouseListener(manejador);
		botonSearchEmp.addMouseListener(manejador);
		botonDeleteEmpFinal.addMouseListener(manejador);
		botonInsertEmpFinal.addMouseListener(manejador);
		botonExportEmpFinal.addMouseListener(manejador);
		
		botonActualizarProveedor.addMouseListener(manejador);
		botonBorrarProveedor.addMouseListener(manejador);
		botonDeliveryNotes.addMouseListener(manejador);		
		botonUpdateFinalPr.addMouseListener(manejador);
		botonSearchProv.addMouseListener(manejador);
		botonDeleteProvFinal.addMouseListener(manejador);	
		botonInsertProvOk.addMouseListener(manejador);
		
		botonInsertClienteok.addMouseListener(manejador);
		botonActualizarCliente.addMouseListener(manejador);
		botonBorrarCliente.addMouseListener(manejador);
		botonUpdateFinalCl.addMouseListener(manejador);
		botonSearchCliente.addMouseListener(manejador);
		botonDeleteClienteFinal.addMouseListener(manejador);		
		botonBills.addMouseListener(manejador);	
		
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
	public JLabel getDeleteEmpleado() {
		return deleteEmpleado;
	}

	public void setDeleteEmpleado(JLabel deleteEmpleado) {
		this.deleteEmpleado = deleteEmpleado;
	}

	public JTextField getInsertCODDeleteProv() {
		return insertCODDeleteProv;
	}

	public void setInsertCODDeleteProv(JTextField insertCODDeleteProv) {
		this.insertCODDeleteProv = insertCODDeleteProv;
	}

	public JButton getBotonSearchProv() {
		return botonSearchProv;
	}

	public void setBotonSearchProv(JButton botonSearchProv) {
		this.botonSearchProv = botonSearchProv;
	}

	public JButton getBotonUpdateFinalPr() {
		return botonUpdateFinalPr;
	}

	public void setBotonUpdateFinalPr(JButton botonUpdateFinalPr) {
		this.botonUpdateFinalPr = botonUpdateFinalPr;
	}

	public JButton getBotonDeleteProvFinal() {
		return botonDeleteProvFinal;
	}

	public void setBotonDeleteProvFinal(JButton botonDeleteProvFinal) {
		this.botonDeleteProvFinal = botonDeleteProvFinal;
	}

	public JLabel getResulBusquedaProv() {
		return resulBusquedaProv;
	}

	public void setResulBusquedaProv(JLabel resulBusquedaProv) {
		this.resulBusquedaProv = resulBusquedaProv;
	}

	public JLabel getResulDeleteProv() {
		return resulDeleteProv;
	}

	public void setResulDeleteProv(JLabel resulDeleteProv) {
		this.resulDeleteProv = resulDeleteProv;
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
	public JButton getBotonInsertEmpFinal() {
		return botonInsertEmpFinal;
	}
	public void setBotonInsertEmpFinal(JButton botonInsertFinal) {
		this.botonInsertEmpFinal = botonInsertFinal;
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
	public JLabel getResultUpdateEmp() {
		return resultUpdateEmp;
	}
	public void setResultUpdateEmp(JLabel resultUpdateEmp) {
		this.resultUpdateEmp = resultUpdateEmp;
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
	public JButton getBotonUpdateEmpFinal() {
		return botonUpdateEmpFinal;
	}
	public void setBotonUpdateEmpFinal(JButton botonUpdateFinal) {
		this.botonUpdateEmpFinal = botonUpdateFinal;
	}
	public JLabel getUpdateEmpleado() {
		return updateEmpleado;
	}
	public void setUpdateEmpleado(JLabel updateEmpleado) {
		this.updateEmpleado = updateEmpleado;
	}
	public JTextField getInsertNIFUpdateEmp() {
		return insertNIFUpdateEmp;
	}
	public void setInsertNIFUpdateEmp(JTextField insertNIFUpdateEmp) {
		this.insertNIFUpdateEmp = insertNIFUpdateEmp;
	}
	public JTextField getInsertNewDataEmp() {
		return insertNewDataEmp;
	}
	public void setInsertNewDataEmp(JTextField insertNewDataEmp) {
		this.insertNewDataEmp = insertNewDataEmp;
	}
	public JComboBox<String> getComboUpdateEmp() {
		return comboUpdateEmp;
	}
	public void setComboUpdateEmp(JComboBox<String> comboUpdateEmp) {
		this.comboUpdateEmp = comboUpdateEmp;
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
	public JTextField getInsertCODUpdateProv() {
		return insertCODUpdateProv;
	}
	public void setInsertCODUpdateProv(JTextField insertCODUpdateProv) {
		this.insertCODUpdateProv = insertCODUpdateProv;
	}
	public JTextField getInsertNewDataProv() {
		return insertNewDataProv;
	}
	public void setInsertNewDataProv(JTextField insertNewDataProv) {
		this.insertNewDataProv = insertNewDataProv;
	}
	public JButton getBotonUpdateEmpFinalPr() {
		return botonUpdateEmpFinalPr;
	}
	public void setBotonUpdateEmpFinalPr(JButton botonUpdateEmpFinalPr) {
		this.botonUpdateEmpFinalPr = botonUpdateEmpFinalPr;
	}
	public JLabel getResultUpdateProv() {
		return resultUpdateProv;
	}
	public void setResultUpdateProv(JLabel resultUpdateProv) {
		this.resultUpdateProv = resultUpdateProv;
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
	public JComboBox<String> getComboUpdateProv() {
		return comboUpdateProv;
	}

	public void setComboUpdateProv(JComboBox<String> comboUpdateProv) {
		this.comboUpdateProv = comboUpdateProv;
	}

	public JLabel getElimProv() {
		return elimProv;
	}
	
	public JButton getBotonDeliveryNotes() {
		return botonDeliveryNotes;
	}

	public void setBotonDeliveryNotes(JButton botonDeliveryNotes) {
		this.botonDeliveryNotes = botonDeliveryNotes;
	}
	public void setElimProv(JLabel elimProv) {
		this.elimProv = elimProv;
	}
	public JPanel getSubPanelEmpDelete() {
		return subPanelEmpDelete;
	}
	public void setSubPanelEmpDelete(JPanel subPanelEmpDelete) {
		this.subPanelEmpDelete = subPanelEmpDelete;
	}
	public JButton getBotonSearchEmp() {
		return botonSearchEmp;
	}
	public void setBotonSearchEmp(JButton botonSearchEmp) {
		this.botonSearchEmp = botonSearchEmp;
	}
	public JTextField getInsertNIFDeleteEmp() {
		return insertNIFDeleteEmp;
	}
	public void setInsertNIFDeleteEmp(JTextField insertNIFDeleteEmp) {
		this.insertNIFDeleteEmp = insertNIFDeleteEmp;
	}
	public JLabel getResulBusquedaEmp() {
		return resulBusquedaEmp;
	}
	public void setResulBusquedaEmp(JLabel resulBusquedaEmp) {
		this.resulBusquedaEmp = resulBusquedaEmp;
	}
	public JButton getBotonDeleteEmpFinal() {
		return botonDeleteEmpFinal;
	}
	public void setBotonDeleteEmpFinal(JButton botonDeleteEmpFinal) {
		this.botonDeleteEmpFinal = botonDeleteEmpFinal;
	}
	public JLabel getResulDeleteEmp() {
		return resulDeleteEmp;
	}
	public void setResulDeleteEmp(JLabel resulDeleteEmp) {
		this.resulDeleteEmp = resulDeleteEmp;
	}
	public JPanel getSubPanelEmpExport() {
		return subPanelEmpExport;
	}
	public void setSubPanelEmpExport(JPanel subPanelEmpExport) {
		this.subPanelEmpExport = subPanelEmpExport;
	}
	public JButton getBotonExportEmpFinal() {
		return botonExportEmpFinal;
	}
	public void setBotonExportEmpFinal(JButton botonExportEmpFinal) {
		this.botonExportEmpFinal = botonExportEmpFinal;
	}
	public JLabel getExportEmpleado() {
		return exportEmpleado;
	}
	public void setExportEmpleado(JLabel exportEmpleado) {
		this.exportEmpleado = exportEmpleado;
	}
	public JLabel getInsertRutaExportEmp() {
		return insertRutaExportEmp;
	}
	public void setInsertRutaExportEmp(JLabel insertRutaExportEmp) {
		this.insertRutaExportEmp = insertRutaExportEmp;
	}
	public JLabel getResulExportEmp() {
		return resulExportEmp;
	}
	public void setResulExportEmp(JLabel resulExportEmp) {
		this.resulExportEmp = resulExportEmp;
	}
	public JPanel getSubPanelInsCliente() {
		return subPanelInsCliente;
	}
	public void setSubPanelInsCliente(JPanel subPanelInsCliente) {
		this.subPanelInsCliente = subPanelInsCliente;
	}
	public JPanel getPanelBotonesCliente() {
		return panelBotonesCliente;
	}
	public void setPanelBotonesCliente(JPanel panelBotonesCliente) {
		this.panelBotonesCliente = panelBotonesCliente;
	}
	public JPanel getSubPanelEditCliente() {
		return subPanelEditCliente;
	}
	public void setSubPanelEditCliente(JPanel subPanelEditCliente) {
		this.subPanelEditCliente = subPanelEditCliente;
	}
	public JPanel getSubPanelElimCliente() {
		return subPanelElimCliente;
	}
	public void setSubPanelElimCliente(JPanel subPanelElimCliente) {
		this.subPanelElimCliente = subPanelElimCliente;
	}
	public JScrollPane getBarraClientes() {
		return barraClientes;
	}
	public void setBarraClientes(JScrollPane barraClientes) {
		this.barraClientes = barraClientes;
	}
	public JTable getTablaClientes() {
		return tablaClientes;
	}
	public void setTablaClientes(JTable tablaClientes) {
		this.tablaClientes = tablaClientes;
	}
	public JLabel getNuevoCliente() {
		return nuevoCliente;
	}
	public void setNuevoCliente(JLabel nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}
	public JLabel getResulInsertCliente() {
		return resulInsertCliente;
	}
	public void setResulInsertCliente(JLabel resulInsertCliente) {
		this.resulInsertCliente = resulInsertCliente;
	}
	public JLabel getEditCliente() {
		return editCliente;
	}
	public void setEditCliente(JLabel editCliente) {
		this.editCliente = editCliente;
	}
	public JLabel getResultUpdateCliente() {
		return resultUpdateCliente;
	}
	public void setResultUpdateCliente(JLabel resultUpdateCliente) {
		this.resultUpdateCliente = resultUpdateCliente;
	}
	public JLabel getElimCliente() {
		return elimCliente;
	}
	public void setElimCliente(JLabel elimCliente) {
		this.elimCliente = elimCliente;
	}
	public JLabel getResulBusquedaCli() {
		return resulBusquedaCli;
	}
	public void setResulBusquedaCli(JLabel resulBusquedaCli) {
		this.resulBusquedaCli = resulBusquedaCli;
	}
	public JLabel getResulDeleteCliente() {
		return resulDeleteCliente;
	}
	public void setResulDeleteCliente(JLabel resulDeleteCliente) {
		this.resulDeleteCliente = resulDeleteCliente;
	}
	public JTextField getInsertNIFCliente() {
		return insertNIFCliente;
	}
	public void setInsertNIFCliente(JTextField insertNIFCliente) {
		this.insertNIFCliente = insertNIFCliente;
	}
	public JTextField getInsertNomCliente() {
		return insertNomCliente;
	}
	public void setInsertNomCliente(JTextField insertNomCliente) {
		this.insertNomCliente = insertNomCliente;
	}
	public JTextField getInsertTelCliente() {
		return insertTelCliente;
	}
	public void setInsertTelCliente(JTextField insertTelCliente) {
		this.insertTelCliente = insertTelCliente;
	}
	public JTextField getInsertNIFUpdateCliente() {
		return insertNIFUpdateCliente;
	}
	public void setInsertNIFUpdateCliente(JTextField insertNIFUpdateCliente) {
		this.insertNIFUpdateCliente = insertNIFUpdateCliente;
	}
	public JTextField getInsertNIFDeleteCli() {
		return insertNIFDeleteCli;
	}
	public void setInsertNIFDeleteCli(JTextField insertNIFDeleteCli) {
		this.insertNIFDeleteCli = insertNIFDeleteCli;
	}
	public JTextField getInsertNewDataCliente() {
		return insertNewDataCliente;
	}
	public void setInsertNewDataCliente(JTextField insertNewDataCliente) {
		this.insertNewDataCliente = insertNewDataCliente;
	}
	public JButton getBotonInsertClienteok() {
		return botonInsertClienteok;
	}
	public void setBotonInsertClienteok(JButton botonInsertClienteok) {
		this.botonInsertClienteok = botonInsertClienteok;
	}
	public JButton getBotonActualizarCliente() {
		return botonActualizarCliente;
	}
	public void setBotonActualizarCliente(JButton botonActualizarCliente) {
		this.botonActualizarCliente = botonActualizarCliente;
	}
	public JButton getBotonBorrarCliente() {
		return botonBorrarCliente;
	}
	public void setBotonBorrarCliente(JButton botonBorrarCliente) {
		this.botonBorrarCliente = botonBorrarCliente;
	}
	public JButton getBotonUpdateFinalCl() {
		return botonUpdateFinalCl;
	}
	public void setBotonUpdateFinalCl(JButton botonUpdateFinalCl) {
		this.botonUpdateFinalCl = botonUpdateFinalCl;
	}
	public JButton getBotonSearchCliente() {
		return botonSearchCliente;
	}
	public void setBotonSearchCliente(JButton botonSearchCliente) {
		this.botonSearchCliente = botonSearchCliente;
	}
	public JButton getBotonDeleteClienteFinal() {
		return botonDeleteClienteFinal;
	}
	public void setBotonDeleteClienteFinal(JButton botonDeleteClienteFinal) {
		this.botonDeleteClienteFinal = botonDeleteClienteFinal;
	}
	public JComboBox<String> getComboUpdateCliente() {
		return comboUpdateCliente;
	}
	public void setComboUpdateCliente(JComboBox<String> comboUpdateCliente) {
		this.comboUpdateCliente = comboUpdateCliente;
	}
	public JTextField getInsertMailCliente() {
		return insertMailCliente;
	}
	public void setInsertMailCliente(JTextField insertMailCliente) {
		this.insertMailCliente = insertMailCliente;
	}

	public JButton getBotonBills() {
		return botonBills;
	}

	public void setBotonBills(JButton botonBills) {
		this.botonBills = botonBills;
	}

	public JTextField getInsertUsuarioPC() {
		return insertUsuarioPC;
	}

	public void setInsertUsuarioPC(JTextField insertUsuarioPC) {
		this.insertUsuarioPC = insertUsuarioPC;
	}
}
