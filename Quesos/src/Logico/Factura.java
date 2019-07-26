package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {

	private String codigo;
	private Cliente cliente;
	private ArrayList<Queso> quesos;
	private int cantqueso;
	private double preciofacturado;

	public Factura(String codigo, Cliente cliente, int cantqueso,double preciofacturado) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		quesos= new ArrayList<Queso>();
		this.cantqueso = cantqueso;
		this.preciofacturado =preciofacturado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public int getCantqueso() {
		return cantqueso;
	}

	public void setCantqueso(int cantqueso) {
		this.cantqueso = cantqueso;
	}
	
	public double getPreciofacturado() {
		return preciofacturado;
	}

	public void setPreciofacturado(double preciofacturado) {
		this.preciofacturado = preciofacturado;
	}

	public double preciototal() {
		double aux=0;
		for(int i =0; i<cantqueso;i++) {
			aux=quesos.get(i).preciototal()+aux;
		}
		
		return aux;
	}

	public double precioDeMayor() {
		int aux = 0;
		double volumenCompara = 0;
		double precio = 0;
		for (int i = 0; i < cantqueso; i++) {
			if (quesos.get(i).volumen() > volumenCompara) {
				aux = i;
				volumenCompara = quesos.get(i).volumen();
			}
		}

		precio = quesos.get(aux).preciototal();

		return precio;
	}
	public boolean existequeso(String codigo) {
		boolean aux = false;
		for (int i =0;i<cantqueso && aux == false ;i++) {
			if(quesos.get(i).getCodigo().equals(codigo)) {
				aux=true;
			}
		}
		return aux;
	}

}
