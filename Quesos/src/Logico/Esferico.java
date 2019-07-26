package Logico;

import java.io.Serializable;

public class Esferico extends Queso implements Serializable {


	public Esferico(double preciobase, double preciounitario, double radio,String codigo) {
		super(preciobase, preciounitario, radio,codigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		double aux =0;
		aux= (Math.PI*(radio*radio*radio)*4)/3;
		return aux;
	}
}
