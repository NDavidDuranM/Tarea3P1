package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cilindrico;
import Logico.CilindricoHueco;
import Logico.ComplejoDeQueso;
import Logico.Esferico;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class HacerQueso extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtPrecioBase;
	private JTextField txtPrecioUnitario;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HacerQueso frame = new HacerQueso();
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
	public HacerQueso(ComplejoDeQueso complejo) {
		setTitle("Hacer Queso");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 118, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblRadio = new JLabel("Radio");
		lblRadio.setBounds(185, 11, 46, 14);
		contentPane.add(lblRadio);
		
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setBounds(146, 180, 46, 14);
		contentPane.add(lblLongitud);
		
		JLabel lblPrecioBase = new JLabel("Precio base");
		lblPrecioBase.setBounds(10, 68, 96, 14);
		contentPane.add(lblPrecioBase);
		
		JLabel lblPrecioUnitario = new JLabel("Precio unitario");
		lblPrecioUnitario.setBounds(185, 68, 96, 14);
		contentPane.add(lblPrecioUnitario);
		
		JLabel lblRadioInterno = new JLabel("Radio Interno");
		lblRadioInterno.setBounds(10, 180, 96, 14);
		contentPane.add(lblRadioInterno);
		
		JRadioButton rdbtnEsferico = new JRadioButton("Esferico");
		
		rdbtnEsferico.setSelected(true);
		rdbtnEsferico.setBounds(10, 139, 109, 23);
		contentPane.add(rdbtnEsferico);
		
		JRadioButton rdbtnCilindrico = new JRadioButton("Cilindrico");
		
		rdbtnCilindrico.setBounds(116, 139, 109, 23);
		contentPane.add(rdbtnCilindrico);
		
		JRadioButton rdbtnCilindricoHueco = new JRadioButton("Cilindrico Hueco");
		
		rdbtnCilindricoHueco.setBounds(264, 139, 109, 23);
		contentPane.add(rdbtnCilindricoHueco);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 37, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JSpinner spnRadio = new JSpinner();
		spnRadio.setBounds(185, 36, 86, 20);
		contentPane.add(spnRadio);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setBounds(10, 93, 86, 20);
		contentPane.add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setBounds(185, 93, 86, 20);
		contentPane.add(txtPrecioUnitario);
		txtPrecioUnitario.setColumns(10);
		
		JSpinner spnRadioInterno = new JSpinner();
		spnRadioInterno.setEnabled(false);
		spnRadioInterno.setBounds(10, 205, 96, 20);
		contentPane.add(spnRadioInterno);
		
		JSpinner spnLongitud = new JSpinner();
		spnLongitud.setEnabled(false);
		spnLongitud.setBounds(146, 205, 85, 20);
		contentPane.add(spnLongitud);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEsferico.isSelected()==true) {
					Esferico aux =new Esferico(Double.parseDouble(txtPrecioBase.getText()), Double.parseDouble(txtPrecioUnitario.getText()), Double.parseDouble(spnRadio.getValue().toString()), txtCodigo.getText());
					complejo.getQuesos().add(aux);
					complejo.setCantqueso(complejo.getCantqueso()+1);
				}
				if(rdbtnCilindricoHueco.isSelected()==true) {
					CilindricoHueco aux =new CilindricoHueco(Double.parseDouble(txtPrecioBase.getText()), Double.parseDouble(txtPrecioUnitario.getText()), Double.parseDouble(spnRadio.getValue().toString()),Double.parseDouble(spnLongitud.getValue().toString()),Double.parseDouble(spnRadioInterno.getValue().toString()), txtCodigo.getText());
					complejo.getQuesos().add(aux);
					complejo.setCantqueso(complejo.getCantqueso()+1);
				}
				if(rdbtnCilindrico.isSelected()==true) {
					Cilindrico aux =new Cilindrico(Double.parseDouble(txtPrecioBase.getText()), Double.parseDouble(txtPrecioUnitario.getText()), Double.parseDouble(spnRadio.getValue().toString()),Double.parseDouble(spnLongitud.getValue().toString()), txtCodigo.getText());
					complejo.getQuesos().add(aux);
					complejo.setCantqueso(complejo.getCantqueso()+1);
				}
			}
		});
		btnAgregar.setBounds(304, 204, 89, 23);
		contentPane.add(btnAgregar);
		
		
		rdbtnEsferico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCilindrico.setSelected(false);
				rdbtnCilindricoHueco.setSelected(false);
				spnLongitud.setEnabled(false);
				spnRadioInterno.setEnabled(false);
			}
		});
		rdbtnCilindricoHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCilindrico.setSelected(false);
				rdbtnEsferico.setSelected(false);
				spnLongitud.setEnabled(true);
				spnRadioInterno.setEnabled(true);
				
			}
		});
		rdbtnCilindrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCilindricoHueco.setSelected(false);
				rdbtnEsferico.setSelected(false);
				spnLongitud.setEnabled(true);
				spnRadioInterno.setEnabled(false);
			}
		});
	}
}
