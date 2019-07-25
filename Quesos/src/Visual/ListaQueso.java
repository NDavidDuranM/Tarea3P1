package Visual;

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

public class ListaQueso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaQueso frame = new ListaQueso();
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
	public ListaQueso(ComplejoDeQueso complejo) {
		setResizable(false);
		setTitle("Lista de quesos");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panel.setBounds(10, 11, 614, 250);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 594, 228);
		panel.add(scrollPane);
		
		table = new JTable();
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
		table.setModel(new DefaultTableModel(
			QuesoHelper,
			new String[] {
				"Tipo", "Codigo", "Precio Base", "Precio Unitaro","Volumen"
			}
		));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}

}
