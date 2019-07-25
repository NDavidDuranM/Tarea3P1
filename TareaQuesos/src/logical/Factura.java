package logical;

import java.util.ArrayList;

public class Factura {
	private Cliente cliente;
	private ArrayList<Queso> quesos;
	
	
	
	public Factura(Cliente cliente, ArrayList<Queso> quesos) {
		super();
		this.cliente = cliente;
		this.quesos = quesos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Queso> getQuesos() {
		return quesos;
	}
	public void setQuesos(ArrayList<Queso> quesos) {
		this.quesos = quesos;
	}
	
	public double precioTotal()
	{
		double precio=0;
		for (Queso queso : quesos) {
			precio += queso.precioTotal();
		}
		return precio;
		
	}
	
}
