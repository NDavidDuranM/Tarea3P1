package Logico;

import java.io.Serializable;

public class Cilindrico extends Queso implements Serializable {

	protected double longitud;

	public Cilindrico(double preciobase, double preciounitario, double radio, double longitud,String codigo) {
		super(preciobase, preciounitario, radio,codigo);
		this.longitud = longitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		double aux =0;
		aux= (Math.PI*(radio*radio)*longitud);
		return aux;
	}
	
	
	
	
}
