package logical;

public abstract class Queso {
	protected String id;
	protected int precioBase, precioUnidad;
	protected double radio;
	
	
	
	public Queso(String id, int precioBase, int precioUnidad, double radio) {
		super();
		this.id = id;
		this.precioBase = precioBase;
		this.precioUnidad = precioUnidad;
		this.radio = radio;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getPrecioBase() {
		return precioBase;
	}



	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}



	public int getPrecioUnidad() {
		return precioUnidad;
	}



	public void setPrecioUnidad(int precioUnidad) {
		this.precioUnidad = precioUnidad;
	}



	public double getRadio() {
		return radio;
	}



	public void setRadio(double radio) {
		this.radio = radio;
	}

	public abstract double Volumen();
	
	public double precioTotal() {
		double precio = 0;
		precio = precioBase + ( precioUnidad * Volumen() );
		precio = Math.round(precio * 100) / 100f;
		return precio;
	}
}
