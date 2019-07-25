package Logico;

import java.util.ArrayList;

public class ComplejoDeQueso {

	private ArrayList<Cliente> clientes;
	private int cantcli;
	private ArrayList<Queso> quesos;
	private int cantqueso;
	private ArrayList<Factura> facturas;
	private int cantfactura;

	public ComplejoDeQueso(int cantcli, int cantqueso, int cantfactura) {
		super();
		clientes = new ArrayList<Cliente>();
		this.cantcli = cantcli;
		quesos = new ArrayList<Queso>();
		this.cantqueso = cantqueso;
		facturas = new ArrayList<Factura>();
		this.cantfactura = cantfactura;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getCantcli() {
		return cantcli;
	}

	public void setCantcli(int cantcli) {
		this.cantcli = cantcli;
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

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public int getCantfactura() {
		return cantfactura;
	}

	public void setCantfactura(int cantfactura) {
		this.cantfactura = cantfactura;
	}
	
	public int cantquesoEsferico() {
		int aux=0;
		
		for(int i =0; i<cantqueso;i++)
			if (quesos.get(i)instanceof Esferico) {
				aux++;			
			}
		
		return aux;
	}
	
	public int cantquesoCilindrico() {
		int aux=0;
		
		for(int i =0; i<cantqueso;i++)
			if (quesos.get(i)instanceof Cilindrico) {
				aux++;			
			}
		
		return aux;
	}
	
	public int cantquesoCilindricoHueco() {
		int aux=0;
		
		for(int i =0; i<cantqueso;i++)
			if (quesos.get(i)instanceof CilindricoHueco) {
				aux++;			
			}
		
		return aux;
	}
	
	public boolean existecliente(String cedula) {
		boolean aux = false;
		for (int i =0;i<cantcli && aux == false ;i++) {
			if(clientes.get(i).getCedula().equals(cedula)) {
				aux=true;
			}
		}
		return aux;
	}
	
	public Queso BuscarQuesoBycode(String codigo) {
		Queso aux=null;
		for (int i =0;i<cantqueso;i++) {
			if(quesos.get(i).getCodigo().equals(codigo)) {
				aux=quesos.get(i);
			}
		}
		return aux;
	}
	
	public Cliente BuscarClienteBycode(String codigo) {
		Cliente aux=null;
		for (int i =0;i<cantcli;i++) {
			if(clientes.get(i).getCedula().equals(codigo)) {
				aux=clientes.get(i);
			}
		}
		return aux;
	}
	

}
