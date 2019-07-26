package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.ComplejoDeQueso;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class ListaCliente extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCliente frame = new ListaCliente();
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
	public ListaCliente(ComplejoDeQueso complejo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaCliente.class.getResource("/img/if_88_171447.png")));
		setTitle("Lista de clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panel.setBounds(10, 11, 424, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 404, 228);
		panel.add(scrollPane);
		
		table = new JTable();
		
		Object[][] clienteHelper =new Object[complejo.getCantcli()][4];
		int auxcountcliente=0;
		for(int i =0; i<complejo.getCantcli();i++,auxcountcliente++) {
			clienteHelper[auxcountcliente][0]=complejo.getClientes().get(i).getCedula();
			clienteHelper[auxcountcliente][1]=complejo.getClientes().get(i).getNombre();
			clienteHelper[auxcountcliente][2]=complejo.getClientes().get(i).getDireccion();
			clienteHelper[auxcountcliente][3]=complejo.getClientes().get(i).getTelefono();
			
		}		
		table.setModel(new DefaultTableModel(
			clienteHelper,
			new String[] {
				"Cedula", "Nombre", "Direccion", "Telefono"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
}
