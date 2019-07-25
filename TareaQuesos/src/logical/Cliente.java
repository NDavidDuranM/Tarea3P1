package logical;

public class Cliente {

	private String Cedula, nombre, apellido, direccion, telefono;
	//private ArrayList<Factura> facturas;
	
	
	
	public Cliente(String Cedula, String nombre, String apellido, String direccion, String telefono) {
		super();
		this.Cedula = Cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		//facturas = new ArrayList<Factura>();
	}
	
	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/*public ArrayList<Factura> getFacturas() {
		return facturas;
	}*/
	/*public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}*/
	
	
}
