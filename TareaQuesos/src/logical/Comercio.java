package logical;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Comercio {
	private ArrayList<Queso>  quesos;
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	private static Comercio comercio = null;
	
	
	private Comercio() {
		super();
		quesos = new ArrayList<Queso>();
		facturas = new ArrayList<Factura>();
		clientes = new ArrayList<Cliente>();
	}
	
	public static Comercio getInstance()
	{
		if(comercio == null)
		{
			comercio = new Comercio();
		}
		return comercio;
	}

	public ArrayList<Cliente> getClientes()
	{
		return clientes;
	}
	public ArrayList<Queso> getQuesos()
	{
		return quesos;
	}
	public ArrayList<Factura> getFacturas()
	{
		return facturas;
	}
	
	public Queso getQueso(String id)
	{
		Queso q=null;
		int i=0;
		while(i<quesos.size() || q==null)
		{
			if(quesos.get(i).getId().equalsIgnoreCase(id))
			{
				q = quesos.get(i);
			}
			i++;
		}
		return q;
	}
	
	public void borrarQuesos(ArrayList<Queso> quesosV)
	{
		//Creando una copia para no afectar a quesosV
		int limite = quesos.size();
		
		for (int i = 0; i < limite; i++) {
			for (int j = 0; j < quesosV.size(); j++) {
				if(quesos.get(i).getId().equalsIgnoreCase(quesosV.get(j).getId()))
				{
					quesos.remove(i);
				}
			}
		}
	}
	public void devolverQuesos(Queso quesoDev)
	{
		quesos.add(quesoDev);
	}
	
	
	public void agregarCliente(String cedula, String nombre, String apellido, String direccion, String telefono)
	{
		Cliente cliente = new Cliente(cedula, nombre, apellido, direccion, telefono);
		clientes.add(cliente);
		JOptionPane.showMessageDialog(null, "Registrado");
	}
	
	public void agregarQueso(String id, String tipo, int precioBase, int precioUnidad, double radio, double radioInterno, double longitud)
	{
		if(tipo.equalsIgnoreCase("Queso esferico"))
		{
			QuesoEsferico quesoEsf = new QuesoEsferico(id, precioBase, precioUnidad, radio);
			quesos.add(quesoEsf);
			JOptionPane.showMessageDialog(null, "Queso esférico registrado");

		}
		if(tipo.equalsIgnoreCase("Queso cilindro"))
		{
			QuesoCilindro quesoCil = new QuesoCilindro(id, precioBase, precioUnidad, radio, longitud);
			quesos.add(quesoCil);
			JOptionPane.showMessageDialog(null, "Queso cilindro registrado");

		}
		if(tipo.equalsIgnoreCase("Queso cilindro hueco"))
		{
			QuesoCilindroHueco quesoCilHuec = new QuesoCilindroHueco(id,precioBase, precioUnidad, radio, longitud, radioInterno);
			quesos.add(quesoCilHuec);
			JOptionPane.showMessageDialog(null, "Queso cilindro hueco registrado");

		}
	}
	
	public void crearFactura(Factura factura)
	{
		facturas.add(factura);
	}
	
	public ArrayList<Queso> obtenerQueso(String tipo)
	{
		ArrayList<Queso> quesosLista = null;
		int i=0;
		while(i<quesosLista.size())
		{

			if(quesos.get(i) instanceof QuesoEsferico && tipo.equalsIgnoreCase("Queso esferico"))
			{
				quesosLista.add(quesos.get(i));
			}
			

			if(quesos.get(i) instanceof QuesoCilindro && tipo.equalsIgnoreCase("Queso cilindro"))
			{
				quesosLista.add(quesos.get(i));
			}
			
			if(quesos.get(i) instanceof QuesoCilindroHueco && tipo.equalsIgnoreCase("Queso cilindro hueco"))
			{
				quesosLista.add(quesos.get(i));
			}
			i++;
		}
		return quesosLista;
	}
	
	public int getCantQuesoTipo(String tipo)
	{
		int cantidad = 0;
		int i=0;
		while(i<quesos.size())
		{
			if(quesos.get(i) instanceof QuesoEsferico && tipo.equalsIgnoreCase("Queso esferico"))
			{
				cantidad++;
			}
			
			if(quesos.get(i) instanceof QuesoCilindro && tipo.equalsIgnoreCase("Queso cilindro"))
			{
				cantidad++;
			}
			
			if(quesos.get(i) instanceof QuesoCilindroHueco && tipo.equalsIgnoreCase("Queso cilindro hueco"))
			{
				cantidad++;
			}
			i++;		
		}
		return cantidad;
	}
	
	public int buscarCliente(String cedula)
	{
		int encontrado = -1;
		int i=0;
		if(clientes.size()>0)
		{
			try
			{
				while (i< clientes.size() || encontrado == -1) {
					if(clientes.get(i).getCedula().equalsIgnoreCase(cedula))
					{
						encontrado = i;
					}
					i++;
				}
			}catch(Exception e1)
			{//Pongo este TryCatch porque por alguan razón cuando existe más de un cliente el bucle se pone loco
				//JOptionPane.showMessageDialog(null, "Cliente no existe");
			}

		}
		return encontrado;
	}
	
	public Cliente getClienteByCed(String cedula)
	{
		Cliente c=null;
		int pos = buscarCliente(cedula);
		if(pos != -1)
		{
			c = clientes.get(pos);
		}
	
		return c;
	}
	
	public double getPrecioMayorVolumen()
	{
		double precio=0;
		double volumen = 0;
		int i = 0, iQueso=-1;
		//Buscar el queso de mayor volumen 
		while(i<quesos.size())
		{
			if(quesos.get(i) instanceof QuesoEsferico && quesos.get(i).Volumen() > volumen)
			{
				volumen = quesos.get(i).Volumen();
				precio = quesos.get(i).precioTotal();
			}
			i++;
		}
		return precio;
	}
	
	
	
}
