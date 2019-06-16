package tablas;

import java.sql.Date;

public class Ventas {
	
	private int importeVentaProducto,cantidad, importeFactura;
	private String numFactura, codServicio, nombreServicio, nombre, dni_Cliente;
	private Date fecha;
	

	public Ventas(int importeVentaProducto, int cantidad, int importeFactura, String numFactura, String codServicio,
			String nombreServicio, String nombre, String dni_Cliente, Date fecha) {
		super();
		this.importeVentaProducto = importeVentaProducto;
		this.cantidad = cantidad;
		this.importeFactura = importeFactura;
		this.numFactura = numFactura;
		this.codServicio = codServicio;
		this.nombreServicio = nombreServicio;
		this.nombre = nombre;
		this.dni_Cliente = dni_Cliente;
		this.fecha = fecha;
	}


	public int getImporteVentaProducto() {
		return importeVentaProducto;
	}


	public void setImporteVentaProducto(int importeVentaProducto) {
		this.importeVentaProducto = importeVentaProducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getImporteFactura() {
		return importeFactura;
	}


	public void setImporteFactura(int importeFactura) {
		this.importeFactura = importeFactura;
	}


	public String getNumFactura() {
		return numFactura;
	}


	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}


	public String getCodServicio() {
		return codServicio;
	}


	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}


	public String getNombreServicio() {
		return nombreServicio;
	}


	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni_Cliente() {
		return dni_Cliente;
	}


	public void setDni_Cliente(String dni_Cliente) {
		this.dni_Cliente = dni_Cliente;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	

}
