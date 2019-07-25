package logical;

public class QuesoCilindro extends Queso{
	
	protected double longitud;
	
	public QuesoCilindro(String id, int precioBase, int precioUnidad, double radio, double longitud) {
		super(id, precioBase, precioUnidad, radio);
		this.longitud=longitud;
	}

	@Override
	public double Volumen() {
		return areaBase() * longitud;
	}

	public double areaBase() {
		return ( Math.PI * Math.pow(radio, 2) );
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

}
