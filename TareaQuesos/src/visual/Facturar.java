package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Button;

import javax.swing.table.DefaultTableModel;

import logical.Cliente;
import logical.Comercio;
import logical.Factura;
import logical.Queso;
import logical.QuesoCilindro;
import logical.QuesoCilindroHueco;
import logical.QuesoEsferico;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Facturar extends JDialog {
//m mnmnm
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JComboBox comboMateria;
	private JComboBox comboTipo;
	private JList<String> listClientes;
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private ArrayList<Queso> quesos= new ArrayList<Queso>();
	private Cliente cliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/img/if_report_card_2639898.png")));
		setTitle("Facturar");
		setResizable(false);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				//cargarPrestamosClientes();
				cargarTabla(comboTipo.getSelectedIndex());
				//JOptionPane.showMessageDialog(null, "foco");
				//cargarPrestamosClientes();

				
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		
		setBounds(100, 100, 581, 466);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Buscar cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 545, 88);
			setLocationRelativeTo(null);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				txtCedula = new JTextField();
				txtCedula.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		            	cliente = Comercio.getInstance().getClienteByCed(txtCedula.getText());
		            	if(cliente != null)
		            	{
		                	txtNombre.setText(cliente.getNombre());
		                	txtApellidos.setText(cliente.getApellido());
		                	txtDireccion.setText(cliente.getDireccion());
		                	//cargarPrestamosClientes();
		            	}
		            	else
		            	{
		            		JOptionPane.showMessageDialog(null, "Cliente no existe");
		            	}
		            	
					}
				});
				txtCedula.setToolTipText("Ingresa c\u00E9dula a buscar");
				txtCedula.setBounds(94, 11, 172, 23);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("C\u00E9dula");
				lblNombre.setBounds(10, 14, 69, 14);
				panel.add(lblNombre);
			}
			{
				JLabel lblApellido = new JLabel("Nombre");
				lblApellido.setBounds(10, 42, 69, 14);
				panel.add(lblApellido);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBackground(SystemColor.info);
				txtNombre.setEnabled(false);
				txtNombre.setFocusTraversalKeysEnabled(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(94, 39, 172, 23);
				panel.add(txtNombre);
			}
			{
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setBounds(279, 14, 69, 14);
				panel.add(lblApellidos);
			}
			{
				txtApellidos = new JTextField();
				txtApellidos.setBackground(SystemColor.info);
				txtApellidos.setEnabled(false);
				txtApellidos.setFocusTraversalKeysEnabled(false);
				txtApellidos.setColumns(10);
				txtApellidos.setBounds(363, 11, 172, 23);
				panel.add(txtApellidos);
			}
			{
				JLabel lblDireccin = new JLabel("Direcci\u00F3n");
				lblDireccin.setBounds(279, 45, 69, 14);
				panel.add(lblDireccin);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBackground(SystemColor.info);
				txtDireccion.setEnabled(false);
				txtDireccion.setFocusTraversalKeysEnabled(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(363, 42, 172, 23);
				panel.add(txtDireccion);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 121, 545, 262);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblTipo = new JLabel("Tipo");
				lblTipo.setBounds(10, 11, 46, 14);
				panel.add(lblTipo);
			}
			{
				comboTipo = new JComboBox();
				comboTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//CLICK DEL COMBO BOX
						cargarTabla(comboTipo.getSelectedIndex());
						//JOptionPane.showMessageDialog(null, comboTipo.getSelectedIndex());
					}
				});
				comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Todas los quesos", "Esf\u00E9ricos", "Cilindro", "Cilindro hueco"}));
				comboTipo.setBounds(47, 11, 164, 23);
				panel.add(comboTipo);
			}
			{
				JLabel lblMateria = new JLabel("Materia");
				lblMateria.setVisible(false);
				lblMateria.setBounds(221, 11, 46, 14);
				panel.add(lblMateria);
			}
			{
				comboMateria = new JComboBox();
				comboMateria.setVisible(false);
				comboMateria.setBounds(277, 11, 108, 23);
				panel.add(comboMateria);
			}
			{
				listClientes = new JList();
				listClientes.setBackground(SystemColor.info);
				listClientes.setBounds(328, 57, 207, 194);
				panel.add(listClientes);
			}
			
			Button botonPrestar = new Button("Prestar");
			botonPrestar.setVisible(false);
			botonPrestar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtNombre.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Debe buscar un cliente");
						txtCedula.requestFocus();
					}
					else
					{
						cargarListClientes();
					}
				}
			});
			botonPrestar.setBounds(237, 57, 70, 22);
			panel.add(botonPrestar);
			{
				Button botonDevolver = new Button("Devolver");
				botonDevolver.setVisible(false);
				botonDevolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(listClientes.getSelectedIndex() >=0)
						{
							 String id = listClientes.getSelectedValue().toString();
						     String[] getID = id.split("-");
						     //System.out.println(getID[0].trim());
						     quesos.remove(listClientes.getSelectedIndex());
						     
						     //listClientes.remove(listClientes.getSelectedIndex());
							 cargarListClientes();//Rellenar el JList otra vez
						     System.out.print(quesos.size());

						}
						else
						{
							JOptionPane.showMessageDialog(null, "Debe elegir un queso");
						}
					}
				});
				botonDevolver.setBounds(237, 85, 70, 22);
				panel.add(botonDevolver);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(15, 68, 196, 183);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel_1.add(scrollPane, BorderLayout.CENTER);
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
				        int pos=-1;
				        int index=-1;
				        String id ="";
				        Queso queso = null;
				        Object checkbox = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
						if(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) instanceof Boolean) {
							index = table.getSelectedRow();
							id = (String)table.getModel().getValueAt(index, 1);
							//Agregando el queso seleccionado a la lista
							queso = Comercio.getInstance().getQueso(id);
							if(checkbox.toString().equals("true"))
							{
								quesos.add(queso);
							}
							if(checkbox.toString().equals("false"))
							{
								quesos.remove(queso);
							}
						}

					}
				});
				scrollPane.setViewportView(table);
			}
			
			JLabel label = new JLabel("");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(txtNombre.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Debe buscar un cliente");
						txtCedula.requestFocus();
					}
					else
					{
						cargarListClientes();
						comboTipo.setSelectedIndex(0);
					}
				}
			});
			label.setIcon(new ImageIcon(Facturar.class.getResource("/img/if_go-next_118773.png")));
			label.setBounds(244, 129, 69, 20);
			panel.add(label);
			
			JLabel label_1 = new JLabel("");
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listClientes.getSelectedIndex() >=0)
					{
						 String id = listClientes.getSelectedValue().toString();
					     String[] getID = id.split("-");
					     //System.out.println(getID[0].trim());
					     quesos.remove(listClientes.getSelectedIndex());
					     
					     //listClientes.remove(listClientes.getSelectedIndex());
						 cargarListClientes();//Rellenar el JList otra vez
					     System.out.print(quesos.size());

					}
					else
					{
						JOptionPane.showMessageDialog(null, "Debe elegir un queso");
					}
				}
			});
			label_1.setIcon(new ImageIcon(Facturar.class.getResource("/img/2.png")));
			label_1.setBounds(244, 166, 69, 20);
			panel.add(label_1);
		}

		//MANEJANDO LA TABLA PARA QUE SEA CHECKBOX 
		String[] columnNames = {" ","ID","TIPO","PRECIO"};
		//model = new DefaultTableModel();
		model = new DefaultTableModel() {
		    @Override
			public
		    Class<?> getColumnClass(int columnIndex) {
		        return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
		    }
		};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);


		//txtCedula.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
		txtCedula.getActionMap().put("OnEnter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enter pressed
            	//System.out.println("HOLA");
            	Cliente cliente = Comercio.getInstance().getClienteByCed(txtCedula.getText());
            	if(cliente != null)
            	{
                	txtNombre.setText(cliente.getNombre());
                	txtApellidos.setText(cliente.getApellido());
                	txtDireccion.setText(cliente.getDireccion());
                	//cargarPrestamosClientes();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Cliente no existe");
            	}
            	}
            
        });

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						
						Factura factura = new Factura(cliente, quesos);
						Comercio.getInstance().crearFactura(factura);
						Comercio.getInstance().borrarQuesos(quesos);
						comboTipo.setSelectedIndex(0);
						cargarTabla(0);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		cargarTabla(0);
		//cargarPrestamosClientes();
	}

	public void cargarTabla(int tipo)
	{
		
		switch(tipo)
		{
		case 0://Todos los quesos
			cargarQuesos();

			break;
		case 1://Esféricos
			cargarEsfericos();
			break;
		case 2://Cilindros
			cargarCilindros();

			break;
		case 3://Cilindros huevos
			cargarCilindrosHuecos();

			break;
			
		}
		
	}
	
	public void cargarListClientes()
	{
		DefaultListModel<String> model = new DefaultListModel<String>();
		String name="";
		for (Queso q : quesos) {
			if(q instanceof QuesoEsferico)
				name = "Esférico";
			if(q instanceof QuesoCilindroHueco)
				name = "Cilindro Hueco";
			if(q instanceof QuesoCilindro)
				name =  "Cilindro";
			
			model.addElement(q.getId()+"-"+name);
		}
		//Factura factura = new Factura(cliente, quesos);
		//Comercio.getInstance().crearFactura(factura);
		//Comercio.getInstance().borrarQuesos(quesos);
		cargarTabla(0);
		listClientes.setModel(model);
		
	}

	public void cargarQuesos()
	{//Cargar todos los quesos
		String name = null;
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];		
		
		for (Queso q : Comercio.getInstance().getQuesos()) {
			if(q instanceof QuesoEsferico)
				name = "Esférico";
			if(q instanceof QuesoCilindroHueco)
				name = "Cilindro Hueco";
			if(q instanceof QuesoCilindro)
				name =  "Cilindro";
			model.addRow(new Object[]{false, q.getId(), name,q.precioTotal()});
			
		}
	}
	public void cargarEsfericos()
	{//Cargar quesos esfericos
		String name = null;
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];		
		
		for (Queso q : Comercio.getInstance().getQuesos()) {
			if(q instanceof QuesoEsferico)
			{
				name = "Esférico";
				model.addRow(new Object[]{false, q.getId(), name,q.precioTotal()});

			}
			
		}
	}
	public void cargarCilindros()
	{//Cargar quesos cilindros
		String name = null;
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];		
		
		for (Queso q : Comercio.getInstance().getQuesos()) {
			if(q instanceof QuesoCilindro)
			{
				name = "Cilindro";
				model.addRow(new Object[]{false, q.getId(), name,q.precioTotal()});

			}
			
		}
	}
	public void cargarCilindrosHuecos()
	{//Cilindros huecos
		String name = null;
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];		
		
		for (Queso q : Comercio.getInstance().getQuesos()) {
			if(q instanceof QuesoCilindroHueco)
			{
				name = "Cilindro Hueco";
				model.addRow(new Object[]{false, q.getId(), name,q.precioTotal()});

			}
			
		}
	}
}
