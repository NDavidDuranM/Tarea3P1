package logical;

public class QuesoEsferico extends Queso {

	public QuesoEsferico(String id, int precioBase, int precioUnidad, double radio) {
		super(id, precioBase, precioUnidad, radio);
		
	}

	@Override
	public double Volumen() {
		
		return 4/3*(3.1416)*Math.pow(radio, 3);
	}

	@Override
	public double precioTotal() {
		
		return precioBase+precioUnidad*Volumen();

	}
	
	//Este volumen es para mostrarle al usuario lo que va a registrar
	public static double parcialVolumen(double parcialRadio)
	{
		return 4/3*(3.1416)*Math.pow(parcialRadio, 3);
	}
	public static double parcialPrecioTotal(int precioBase, int precioUnidad, double Volumen) {
		
		return precioBase+precioUnidad*Volumen;

	}

}
