package Visual;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cilindrico;
import Logico.CilindricoHueco;
import Logico.Cliente;
import Logico.ComplejoDeQueso;
import Logico.Esferico;
import Logico.Factura;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Facturar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTable TablaQueso;
	private JTable tableQuesoSeleccionado;

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
		
		Random rand = new Random();
//		int n = rand.nextInt(100000);
		Factura helper=new Factura("dick", null, 0, 0);
		setTitle("Facturar");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 488);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 774, 126);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(103, 11, 46, 20);
		panel.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(326, 11, 46, 20);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(549, 11, 46, 20);
		panel.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(103, 64, 46, 20);
		panel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(326, 64, 59, 20);
		panel.add(lblTelefono);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(103, 30, 120, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(326, 30, 120, 20);
		panel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(549, 30, 120, 20);
		panel.add(txtApellido);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(103, 84, 120, 20);
		panel.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(326, 84, 120, 20);
		panel.add(txtTelefono);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente aux = new Cliente(txtCedula.getText(),txtNombre.getText(),txtApellido.getText(),Integer.parseInt(txtTelefono.getText()),txtDireccion.getText());
				complejo.getClientes().add(aux);
				complejo.setCantcli(complejo.getCantcli()+1);
				txtNombre.setEnabled(false);
				txtApellido.setEnabled(false);
				txtDireccion.setEnabled(false);
				txtTelefono.setEnabled(false);
				btnRegistrar.setEnabled(false);
			}
		});
		btnRegistrar.setEnabled(false);
		btnRegistrar.setBounds(567, 83, 89, 23);
		panel.add(btnRegistrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Facturar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 148, 774, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 364, 236);
		panel_1.add(scrollPane);
		
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
		panel_1.add(lblQuesos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(401, 101, 363, 179);
		panel_1.add(scrollPane_1);
		
		tableQuesoSeleccionado = new JTable();
		Object[][] QuesoHelperSelecionado =new Object[complejo.getCantqueso()][5];
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
		panel_1.add(btnSeleccionar);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(401, 51, 46, 14);
		panel_1.add(lblTotal);
		
		JLabel labelpreciototal = new JLabel("0.0");
		labelpreciototal.setBounds(456, 51, 89, 14);
		panel_1.add(labelpreciototal);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helper.setCliente(complejo.BuscarClienteBycode(txtCedula.getText()));
				helper.setPreciofacturado(helper.preciototal());
				complejo.getFacturas().add(helper);
				complejo.setCantfactura(complejo.getCantfactura()+1);
			}
		});
		btnFacturar.setBounds(675, 15, 89, 23);
		panel_1.add(btnFacturar);
		
		
		
		txtCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(complejo.existecliente(txtCedula.getText())== true) {
					txtNombre.setEnabled(false);
					txtApellido.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					btnRegistrar.setEnabled(false);
				}
				else {
					txtNombre.setEnabled(true);
					txtApellido.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefono.setEnabled(true);
					btnRegistrar.setEnabled(true);
				}
			}
		});
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				helper.getQuesos().add(complejo.BuscarQuesoBycode(TablaQueso.getValueAt(TablaQueso.getSelectedRow(), 1).toString()));
				helper.setCantqueso(helper.getCantqueso()+1);
				
				labelpreciototal.setText(Double.toString(helper.preciototal()));
				int auxcountQuesoSeleccionado=0;
				for(int i =0; i<complejo.getCantqueso();i++,auxcountQuesoSeleccionado++) {
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
					QuesoHelperSelecionado[auxcountQuesoSeleccionado][2]=helper.getPreciofacturado();
					
					
					
				}
				tableQuesoSeleccionado.setModel(new DefaultTableModel(
						QuesoHelperSelecionado,
					new String[] {
						"Tipo", "Volumen", "Precio"
					}
				));
			}
		});
	}
	
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
