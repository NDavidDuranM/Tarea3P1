package Logico;

public abstract class Queso {
	
	protected String codigo;
	protected double preciobase;
	protected double preciounitario;// preciounitario>0
	protected double radio;
	
	public Queso(double preciobase, double preciounitario, double radio,String codigo) {
		super();
		this.codigo=codigo;
		this.preciobase = preciobase;
		this.preciounitario = preciounitario;
		this.radio = radio;
	}	
	
	public double getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(double preciobase) {
		this.preciobase = preciobase;
	}

	public double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public abstract double volumen();
	
	public double preciototal() {
		double aux=0;
		aux= preciobase+(preciounitario*volumen());
		return aux;
	}
	

}
