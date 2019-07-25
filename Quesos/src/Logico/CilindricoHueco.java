package Logico;

public class CilindricoHueco extends Cilindrico {

	private double radioInterno;
	
	public CilindricoHueco(double preciobase, double preciounitario, double radio, double longitud,
			double radioInterno,String codigo) {
		super(preciobase, preciounitario, radio, longitud,codigo);
		this.radioInterno = radioInterno;
	}

	public double getRadioInterno() {
		return radioInterno;
	}

	public void setRadioInterno(double radioInterno) {
		this.radioInterno = radioInterno;
	}
	
	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		double aux =0;
		aux= Math.PI*((radio*radio)-(radioInterno*radioInterno))*longitud;
		
		return aux;
	}
}
