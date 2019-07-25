package Logico;

public class Esferico extends Queso {


	public Esferico(double preciobase, double preciounitario, double radio,String codigo) {
		super(preciobase, preciounitario, radio,codigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		double aux =0;
		aux= (4 * Math.PI * Math.pow(radio, 3) ) / 3;
		return aux;
	}
}
