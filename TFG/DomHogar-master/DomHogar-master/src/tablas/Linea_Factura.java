package tablas;

public class Linea_Factura {
	
	private String 	codLinea, codServicio, numFactura;
	private int cantidad;
	
	public Linea_Factura(String codLinea, String codServicio, String numFactura, int cantidad) {
		super();
		this.codLinea = codLinea;
		this.codServicio = codServicio;
		this.numFactura = numFactura;
		this.cantidad = cantidad;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public String getCodServicio() {
		return codServicio;
	}

	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
