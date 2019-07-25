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

	public double areaBase()
	{
		return 0;
	}
	
	
	@Override
	public double Volumen() {
		
		return (3.1416)*longitud*(Math.pow(radio, 2) - Math.pow(radioInterno, 2));
	}
	
	public static double parcialVolumen(double radioParcial, double radioParcialInterno, double longitudParcial) {
		
		return (3.1416)*longitudParcial*(Math.pow(radioParcial, 2) - Math.pow(radioParcialInterno, 2));
	}
	

}
