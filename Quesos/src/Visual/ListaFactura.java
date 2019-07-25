package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Cilindrico;
import Logico.CilindricoHueco;
import Logico.ComplejoDeQueso;
import Logico.Esferico;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaFactura extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaFactura frame = new ListaFactura();
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
	public ListaFactura(ComplejoDeQueso complejo) {
		setResizable(false);
		setTitle("Lista de facturas");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 617, 256);
		panel.setLayout(null);
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 597, 234);
		panel.add(scrollPane);
		
		table = new JTable();
		Object[][] FacturaHelper = new Object[complejo.getCantfactura()][4];
		int auxcountFactura=0;
		
		for(int i =0; i<complejo.getCantfactura();i++,auxcountFactura++) {
			
			FacturaHelper[auxcountFactura][0]=complejo.getFacturas().get(i).getCodigo();
			FacturaHelper[auxcountFactura][1]=complejo.getFacturas().get(i).getPreciofacturado();
			FacturaHelper[auxcountFactura][2]=complejo.getFacturas().get(i).getCliente().getNombre();
			FacturaHelper[auxcountFactura][3]=complejo.getFacturas().get(i).getCantqueso();
			
		}	
		
		table.setModel(new DefaultTableModel(
			FacturaHelper,
			new String[] {
				"Codigo", "Precio facturado", "Cliente","Cantidad de Quesos"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
	}
	

}
