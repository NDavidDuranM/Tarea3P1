package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cilindrico;
import Logico.CilindricoHueco;
import Logico.Cliente;
import Logico.ComplejoDeQueso;
import Logico.EnviarFactura;
import Logico.Esferico;
import Logico.Factura;
import java.net.*;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Facturar extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTable TablaQueso;
	private JTable tableQuesoSeleccionado;
	private JTextField txtCodigoFactura;


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturar frame = new Facturar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Facturar(ComplejoDeQueso complejo) {
		
		Factura helper = new Factura("0", null, 0, 0);
		setTitle("Facturar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 488);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBounds(10, 11, 774, 126);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(103, 11, 46, 20);
		panelCliente.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(326, 11, 46, 20);
		panelCliente.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(549, 11, 46, 20);
		panelCliente.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(103, 64, 46, 20);
		panelCliente.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(326, 64, 59, 20);
		panelCliente.add(lblTelefono);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(103, 30, 120, 20);
		panelCliente.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(326, 30, 120, 20);
		panelCliente.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(549, 30, 120, 20);
		panelCliente.add(txtApellido);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(103, 84, 120, 20);
		panelCliente.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(326, 84, 120, 20);
		panelCliente.add(txtTelefono);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtTelefono.getText().equals("")|| txtDireccion.getText().equals("")) {
						System.out.println("por favor llene todos los parametros");
						
					}else {
						Cliente aux = new Cliente(txtCedula.getText(),txtNombre.getText(),txtApellido.getText(),Long.parseLong(txtTelefono.getText()),txtDireccion.getText());
						complejo.getClientes().add(aux);
						complejo.setCantcli(complejo.getCantcli()+1);
						txtNombre.setEnabled(false);
						txtApellido.setEnabled(false);
						txtDireccion.setEnabled(false);
						txtTelefono.setEnabled(false);
						btnRegistrar.setEnabled(false);
					}
				}catch(NumberFormatException e1) {
					System.out.println("por favor introduzca un numero valido");
				}
				
				
				
			}
		});
		btnRegistrar.setEnabled(false);
		btnRegistrar.setBounds(567, 83, 89, 23);
		panelCliente.add(btnRegistrar);
		
		JPanel PanelFactura = new JPanel();
		PanelFactura.setBorder(new TitledBorder(null, "Facturar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelFactura.setBounds(10, 148, 774, 291);
		contentPane.add(PanelFactura);
		PanelFactura.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 364, 236);
		PanelFactura.add(scrollPane);
		
		TablaQueso = new JTable();
		Object[][] QuesoHelper =new Object[complejo.getCantqueso()][5];
		int auxcountQueso=0;
		for(int i =0; i<complejo.getCantqueso();i++,auxcountQueso++) {
			if(complejo.getQuesos().get(i)instanceof Esferico) {
				QuesoHelper[auxcountQueso][0]="Queso Esferico";
			}
			if(complejo.getQuesos().get(i)instanceof Cilindrico) { 
				QuesoHelper[auxcountQueso][0]="Queso Cilindrico";
			}
			if(complejo.getQuesos().get(i)instanceof CilindricoHueco) { 
				QuesoHelper[auxcountQueso][0]="Queso Cilindrico con Hueco";
			}
			QuesoHelper[auxcountQueso][1]=complejo.getQuesos().get(i).getCodigo();
			QuesoHelper[auxcountQueso][2]=complejo.getQuesos().get(i).getPreciobase();
			QuesoHelper[auxcountQueso][3]=complejo.getQuesos().get(i).getPreciounitario();
			QuesoHelper[auxcountQueso][4]=complejo.getQuesos().get(i).volumen();
			
		}		
		TablaQueso.setModel(new DefaultTableModel(
			QuesoHelper,
			new String[] {
				"Tipo", "Codigo", "Precio Base", "Precio Unitaro","Volumen"
			}
		));
		TablaQueso.setFillsViewportHeight(true);
		scrollPane.setViewportView(TablaQueso);
		
		JLabel lblQuesos = new JLabel("Quesos");
		lblQuesos.setBounds(148, 15, 46, 14);
		PanelFactura.add(lblQuesos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(401, 101, 363, 179);
		PanelFactura.add(scrollPane_1);
		
		tableQuesoSeleccionado = new JTable();
		Object[][] QuesoHelperSelecionado =new Object[complejo.getCantqueso()][3];
//		int auxcountQuesoSeleccionado=0;
//		for(int i =0; i<complejo.getCantqueso();i++,auxcountQuesoSeleccionado++) {
//			if(complejo.getQuesos().get(i)instanceof Esferico) {
//				QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Esferico";
//			}
//			if(complejo.getQuesos().get(i)instanceof Cilindrico) { 
//				QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Cilindrico";
//			}
//			if(complejo.getQuesos().get(i)instanceof CilindricoHueco) { 
//				QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Cilindrico con Hueco";
//			}
//			QuesoHelperSelecionado[auxcountQuesoSeleccionado][1]=helper.getQuesos().get(i).volumen();
//			QuesoHelperSelecionado[auxcountQuesoSeleccionado][2]=helper.getPreciofacturado();
//			
//			
//			
//		}
		tableQuesoSeleccionado.setModel(new DefaultTableModel(
				new Object[][]{},
			new String[] {
				"Tipo", "Volumen", "Precio"
			}
		));
		tableQuesoSeleccionado.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tableQuesoSeleccionado);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		
		btnSeleccionar.setBounds(401, 15, 89, 23);
		PanelFactura.add(btnSeleccionar);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(401, 51, 46, 14);
		PanelFactura.add(lblTotal);
		
		JLabel labelpreciototal = new JLabel("0.0");
		labelpreciototal.setBounds(456, 51, 89, 14);
		PanelFactura.add(labelpreciototal);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setBounds(675, 15, 89, 23);
		PanelFactura.add(btnFacturar);
		
		txtCodigoFactura = new JTextField();
		if(complejo.getCantfactura()==0){
			txtCodigoFactura.setText("0");
		}else {
			txtCodigoFactura.setText(Integer.toString(Integer.parseInt(complejo.getFacturas().get(complejo.getCantfactura()-1).getCodigo())+1));
		}
		txtCodigoFactura.setEnabled(false);
		txtCodigoFactura.setBounds(511, 15, 141, 23);
		PanelFactura.add(txtCodigoFactura);
		txtCodigoFactura.setColumns(10);
		
		
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(complejo.existecliente(txtCedula.getText())== true) {
					txtNombre.setEnabled(false);
					txtApellido.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					btnRegistrar.setEnabled(false);
					txtNombre.setText(complejo.BuscarClienteBycode(txtCedula.getText()).getNombre());
					txtApellido.setText(complejo.BuscarClienteBycode(txtCedula.getText()).getApellido());
					txtDireccion.setText(complejo.BuscarClienteBycode(txtCedula.getText()).getDireccion());
					txtTelefono.setText(Long.toString((complejo.BuscarClienteBycode(txtCedula.getText()).getTelefono())));
					
				}
				else {
					txtNombre.setEnabled(true);
					txtApellido.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefono.setEnabled(true);
					btnRegistrar.setEnabled(true);
					txtNombre.setText("");
					txtApellido.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
					
				}
				if(txtCedula.getText().equals("")) {
					txtNombre.setEnabled(false);
					txtApellido.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					btnRegistrar.setEnabled(false);
					txtNombre.setText("");
					txtApellido.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
				}
			}
		});
		txtCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(complejo.existecliente(txtCedula.getText())== true) {
					txtNombre.setEnabled(false);
					txtApellido.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					btnRegistrar.setEnabled(false);
					txtNombre.setText(complejo.BuscarClienteBycode(txtCedula.getText()).getNombre());
					txtApellido.setText(complejo.BuscarClienteBycode(txtCedula.getText()).getApellido());
					txtDireccion.setText(complejo.BuscarClienteBycode(txtCedula.getText()).getDireccion());
					txtTelefono.setText(Long.toString((complejo.BuscarClienteBycode(txtCedula.getText()).getTelefono())));
					
				}
				else {
					txtNombre.setEnabled(true);
					txtApellido.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefono.setEnabled(true);
					btnRegistrar.setEnabled(true);
					txtNombre.setText("");
					txtApellido.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
					
				}
				if(txtCedula.getText().equals("")) {
					txtNombre.setEnabled(false);
					txtApellido.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					btnRegistrar.setEnabled(false);
					txtNombre.setText("");
					txtApellido.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
				}
			}
		});
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(helper.getCantqueso()>0 && complejo.existecliente(txtCedula.getText())==true ) {
					helper.setCodigo(txtCodigoFactura.getText());
					helper.setCliente(complejo.BuscarClienteBycode(txtCedula.getText()));
					helper.setPreciofacturado(helper.preciototal());
					complejo.getFacturas().add(helper);
					complejo.setCantfactura(complejo.getCantfactura()+1);
					
					dispose();
				}else {
					System.out.println("Seleccione parametros correctos para la factura");
				}
				
			}
		});
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(helper.existequeso(TablaQueso.getValueAt(TablaQueso.getSelectedRow(), 1).toString())==true) {
					System.out.println("Este queso ya fue seleccionado");
				}else {
					helper.getQuesos().add(complejo.BuscarQuesoBycode(TablaQueso.getValueAt(TablaQueso.getSelectedRow(), 1).toString()));
					helper.setCantqueso(helper.getCantqueso()+1);
					
					labelpreciototal.setText(Double.toString(helper.preciototal()));
					int auxcountQuesoSeleccionado=0;
					for(int i =0; i<helper.getCantqueso();i++,auxcountQuesoSeleccionado++) {
						if(complejo.getQuesos().get(i)instanceof Esferico) {
							QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Esferico";
						}
						if(complejo.getQuesos().get(i)instanceof Cilindrico) { 
							QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Cilindrico";
						}
						if(complejo.getQuesos().get(i)instanceof CilindricoHueco) { 
							QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Cilindrico con Hueco";
						}
						QuesoHelperSelecionado[auxcountQuesoSeleccionado][1]=helper.getQuesos().get(i).volumen();
						QuesoHelperSelecionado[auxcountQuesoSeleccionado][2]=helper.getQuesos().get(i).preciototal();
						
						
						
					}
					tableQuesoSeleccionado.setModel(new DefaultTableModel(
							QuesoHelperSelecionado,
						new String[] {
							"Tipo", "Volumen", "Precio"
						}
					));
				}
				
			}
		});
	}
	
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
