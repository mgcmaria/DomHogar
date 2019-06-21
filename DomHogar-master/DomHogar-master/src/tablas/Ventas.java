package tablas;

import java.sql.Date;

public class Ventas {
	
	private int importeVentaServicio,cantidad, importeFactura, cantidadTotal;
	private String numFactura, codServicio, nombreServicio, nombre, dni_Cliente;
	private Date fecha;
	

	public Ventas(String numFactura, String codServicio, String nombreServicio, int cantidad, int importeVentaServicio,
			int cantidadTotal, String nombre, String dni_Cliente, Date fecha) {
		super();
		this.numFactura = numFactura;
		this.codServicio = codServicio;
		this.nombreServicio = nombreServicio;
		this.cantidad = cantidad;
		this.importeVentaServicio = importeVentaServicio;
		this.setCantidadTotal(cantidadTotal);
		this.nombre = nombre;
		this.dni_Cliente = dni_Cliente;
		this.fecha = fecha;
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

	public int getImporteVentaServicio() {
		return importeVentaServicio;
	}

	public void setImporteVentaServicio(int importeVentaServicio) {
		this.importeVentaServicio = importeVentaServicio;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

}
