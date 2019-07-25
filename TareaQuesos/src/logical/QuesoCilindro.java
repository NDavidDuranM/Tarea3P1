package logical;

public class QuesoCilindro extends Queso{
	
	protected double longitud;
	
	public QuesoCilindro(String id, int precioBase, int precioUnidad, double radio, double longitud) {
		super(id, precioBase, precioUnidad, radio);
		this.longitud=longitud;
	}

	@Override
	public double Volumen() {
		
		return (3.1416)*Math.pow(radio, 2)*longitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public double precioTotal() {
		
		return precioBase+precioUnidad*Volumen();

	}
	
	public static double parcialVolumen(double radioParcial, double longitudParcial) {
		
		return (3.1416)*Math.pow(radioParcial, 2)*longitudParcial;
	}
	public static double parcialPrecioTotal(int precioBase, int precioUnidad, double Volumen) {
		
		return precioBase+precioUnidad*Volumen;

	}
}
