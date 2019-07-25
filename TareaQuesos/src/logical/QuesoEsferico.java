package logical;

public class QuesoEsferico extends Queso {

	public QuesoEsferico(String id, int precioBase, int precioUnidad, double radio) {
		super(id, precioBase, precioUnidad, radio);
		
	}

	@Override
	public double Volumen() {
		double volumen = 0;
		volumen = (4 * Math.PI * Math.pow(radio, 3) ) / 3;
		volumen = Math.round(volumen * 100) / 100f;
		return volumen;
	}

	//Este volumen es para mostrarle al usuario lo que va a registrar
	public static double parcialVolumen(double parcialRadio)
	{
		return 4/3*(3.1416)*Math.pow(parcialRadio, 3);
	}
	


}
