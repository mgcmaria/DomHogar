package tablas;

public class Proveedor {
	
	private String codproveedor, nombreProveedor;

	public Proveedor(String codproveedor, String nombreProveedor) {
		super();
		this.codproveedor = codproveedor;
		this.nombreProveedor = nombreProveedor;
	}

	public String getCodproveedor() {
		return codproveedor;
	}

	public void setCodproveedor(String codproveedor) {
		this.codproveedor = codproveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

}
