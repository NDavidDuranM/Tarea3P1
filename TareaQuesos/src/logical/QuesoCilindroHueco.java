package logical;

public class QuesoCilindroHueco extends QuesoCilindro {

	private double radioInterno;
	
	public QuesoCilindroHueco(String id, int precioBase, int precioUnidad, double radio, double longitud, double radioInterno) {
		super(id, precioBase, precioUnidad, radio, longitud);
		this.radioInterno = radioInterno;
	
	}

	public double getRadioInterno() {
		return radioInterno;
	}

	public void setRadioInterno(double radioInterno) {
		this.radioInterno = radioInterno;
	}

	@Override
	public double Volumen() {
		return (float) ( areaBase() * longitud );
	}

	public double areaBase() {
		return (Math.PI * (Math.pow(radio, 2) - Math.pow(radioInterno, 2) ) );
	}

}
