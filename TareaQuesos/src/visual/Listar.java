package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Cliente;
import logical.Comercio;
import logical.Factura;
import logical.Queso;
import logical.QuesoCilindro;
import logical.QuesoCilindroHueco;
import logical.QuesoEsferico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Listar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private String tipoLista;
	private String id;

	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Listar dialog = new Listar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Listar(String tipoDeLista) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Listar.class.getResource("/img/if_list_103613.png")));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				loadTable();
			}
		});
		setResizable(false);
		setTitle("Lista");
		tipoLista = tipoDeLista;


		
		setBounds(100, 100, 699, 514);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					loadTable();
				}
			});
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//Obtener index
						int index;
						if(table.getSelectedRow()>=0){
							//btnEliminar.setEnabled(true);
							//btnModificar.setEnabled(true);
							index = table.getSelectedRow();
							switch(tipoLista)
							{
								
							}
							//id = (String)table.getModel().getValueAt(index, 0);
							//System.out.println(id);				
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				String[] columnNames = {""};
				if(tipoDeLista.equalsIgnoreCase("Clientes"))
				{
					String[] columnNamesClientes = {"Nombres","Apellidos","Cedula","Dirección", "Teléfono"};
					columnNames = columnNamesClientes;
				}
				if(tipoDeLista.equalsIgnoreCase("Quesos"))
				{
					String[] columnNamesBarcos = {"ID","Tipo", "Precio base", "Precio unidad", "Volumen", "Precio total"};
					columnNames = columnNamesBarcos;
				}
				if(tipoDeLista.equalsIgnoreCase("Facturas"))
				{
					String[] columnNamesClientes = {"Nombres","Apellidos","Cedula","Dirección", "Teléfono", "ID","Queso", "Precio"};
					columnNames = columnNamesClientes;
				}

				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				loadTable();
				scrollPane.setViewportView(table);
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonOk = new JButton("OK");
				botonOk.setVisible(false);

				botonOk.setActionCommand("OK");
				buttonPane.add(botonOk);
				getRootPane().setDefaultButton(botonOk);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	public void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];		
		if(tipoLista.equalsIgnoreCase("Quesos"))
		{
			for (Queso q : Comercio.getInstance().getQuesos()) {
					fila[0] = q.getId();
					if(q instanceof QuesoEsferico)
					{
						fila[1] = "Esférico";
					}
					if(q instanceof QuesoCilindroHueco)
					{
						fila[1] = "Cilindro Hueco";
					}
					
					if(q instanceof QuesoCilindro)
					{
	
						fila[1] =  "Cilindro";
					}
					
					fila[2] = q.getPrecioBase();
					fila[3] = q.getPrecioUnidad();
					fila[4] = q.Volumen();
					fila[5] = q.precioTotal();
					model.addRow(fila);
				}
		
		//
		}

		if(tipoLista.equalsIgnoreCase("Clientes"))
		{
		for (Cliente c : Comercio.getInstance().getClientes()) {


				fila[0] = c.getNombre();
				fila[1] = c.getApellido();
				fila[2] = c.getCedula();
				fila[3] = c.getDireccion();
				fila[4] = c.getTelefono();
				model.addRow(fila);

			}

		}
		if(tipoLista.equalsIgnoreCase("Facturas"))
		{
			//JOptionPane.showMessageDialog(null, Comercio.getInstance().getFacturas().get(0).getQuesos().size());

			Cliente f = null;

		for (int i = 0; i < Comercio.getInstance().getFacturas().size(); i++) {
			f = Comercio.getInstance().getFacturas().get(i).getCliente();

			for (int j = 0; j < Comercio.getInstance().getFacturas().get(i).getQuesos().size(); j++) {
				
				fila[0] = f.getNombre();
				fila[1] = f.getApellido();
				fila[2] = f.getCedula();
				fila[3] = f.getDireccion();
				fila[4] = f.getTelefono();
				fila[5] = Comercio.getInstance().getFacturas().get(i).getQuesos().get(j).getId();
				if(Comercio.getInstance().getFacturas().get(i).getQuesos().get(j) instanceof QuesoEsferico)
				{
					fila[6] = "Esférico";
				}
				if(Comercio.getInstance().getFacturas().get(i).getQuesos().get(j) instanceof QuesoCilindroHueco)
				{
					fila[6] = "Cilindro Hueco";
				}
				
				if(Comercio.getInstance().getFacturas().get(i).getQuesos().get(j) instanceof QuesoCilindro)
				{

					fila[6] =  "Cilindro";
				}
				fila[7] = Comercio.getInstance().getFacturas().get(i).getQuesos().get(j).precioTotal();
				model.addRow(fila);

			}
		}

		}	
		
		
		
	}

}
