package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Comercio;
import logical.QuesoCilindro;
import logical.QuesoCilindroHueco;
import logical.QuesoEsferico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;

public class RegistroQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtPrecioBase;
	private JRadioButton radioCilindro;
	private 	JRadioButton radioCilindroHueco;
	private JRadioButton radioEsferico;
	private JTextField txtPrecioUnidad;
	private JTextField txtRadio;
	private JTextField txtVolumen;
	private JTextField txtPrecioTotal;
	private JTextField txtLongitud;
	private JTextField txtLongitudCilindroHueco;
	private JTextField txtRadioInt;
	private JPanel panelCilindro;
	private JPanel panelCilindroHueco;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RegistroPublicaciones dialog = new RegistroPublicaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistroQueso() {
		setResizable(false);
		setTitle("Registrar quesos");

		setBounds(100, 100, 610, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 575, 219);
		contentPanel.add(panel);
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(76, 35, 46, 14);
		panel.add(lblId);
		
		JLabel lblTtulo = new JLabel("Precio base:");
		lblTtulo.setBounds(15, 65, 107, 14);
		panel.add(lblTtulo);
		
		txtID = new JTextField();
		txtID.setBounds(140, 30, 336, 23);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setColumns(10);
		txtPrecioBase.setBounds(140, 62, 98, 23);
		panel.add(txtPrecioBase);
		
		JLabel lblPrecioUnidad = new JLabel("Precio Unidad:");
		lblPrecioUnidad.setBounds(253, 65, 107, 14);
		panel.add(lblPrecioUnidad);
		
		txtPrecioUnidad = new JTextField();
		txtPrecioUnidad.setColumns(10);
		txtPrecioUnidad.setBounds(378, 62, 98, 23);
		panel.add(txtPrecioUnidad);
		
		JLabel lblRadio = new JLabel("Radio:");
		lblRadio.setBounds(15, 95, 107, 14);
		panel.add(lblRadio);
		
		txtRadio = new JTextField();
		txtRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioEsferico.isSelected())
				{
					double volumenParcial = -1;
					double radio = Double.valueOf(txtRadio.getText());			
		
					volumenParcial = QuesoEsferico.parcialVolumen(radio);
					txtVolumen.setText(String.valueOf(volumenParcial));		
					double precioTotal = -1;
					try
					{
						int precioBase = Integer.valueOf(txtPrecioBase.getText());
						int precioUnidad = Integer.valueOf(txtPrecioUnidad.getText());
						precioTotal = Double.valueOf(QuesoEsferico.parcialPrecioTotal(precioBase, precioUnidad, volumenParcial));

					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
					}
					
					txtPrecioTotal.setText(String.valueOf(precioTotal));
				}
				
			}
		});
		txtRadio.setColumns(10);
		txtRadio.setBounds(140, 92, 98, 23);
		panel.add(txtRadio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 135, 560, 74);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de queso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		radioEsferico = new JRadioButton("Esf\u00E9rico");
		radioEsferico.setSelected(true);
		radioEsferico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					panelCilindro.setVisible(false);
					panelCilindroHueco.setVisible(false);
					//RadioButtons
					radioCilindroHueco.setSelected(false);
					radioCilindro.setSelected(false);
					
				

			}
		});
		radioEsferico.setBounds(6, 27, 117, 23);
		panel_1.add(radioEsferico);
		
		radioCilindro = new JRadioButton("Cilindro");
		radioCilindro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLongitud.requestFocus();
				panelCilindroHueco.setVisible(false);
				panelCilindro.setVisible(true);
				//Radios
				radioEsferico.setSelected(false);
				radioCilindroHueco.setSelected(false);
			}
		});
		radioCilindro.setBounds(198, 27, 109, 23);
		panel_1.add(radioCilindro);
		
		radioCilindroHueco = new JRadioButton("Cilindro hueco");
		radioCilindroHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLongitudCilindroHueco.requestFocus();
				panelCilindro.setVisible(false);
				panelCilindroHueco.setVisible(true);
				//Radios
				radioEsferico.setSelected(false);
				radioCilindro.setSelected(false);
			}
		});
		radioCilindroHueco.setBounds(358, 27, 141, 23);
		panel_1.add(radioCilindroHueco);
		
		panelCilindro = new JPanel();
		panelCilindro.setVisible(false);
		panelCilindro.setLayout(null);
		panelCilindro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Queso Cilindro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		panelCilindro.setBounds(10, 248, 575, 74);
		contentPanel.add(panelCilindro);
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(15, 41, 75, 14);
		panelCilindro.add(lblLongitud);
		
		txtLongitud = new JTextField();
		txtLongitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioCilindro.isSelected())
				{
					double longitudCnormal = -1;
					double radio = Double.valueOf(txtRadio.getText());
					double volumenParcial=-1;
					
					longitudCnormal = Double.valueOf(txtLongitud.getText());
					volumenParcial = QuesoCilindro.parcialVolumen(radio,longitudCnormal);
					txtVolumen.setText(String.valueOf(volumenParcial));
					double precioTotal = -1;
					try
					{
						int precioBase = Integer.valueOf(txtPrecioBase.getText());
						int precioUnidad = Integer.valueOf(txtPrecioUnidad.getText());
						precioTotal = Double.valueOf(QuesoCilindro.parcialPrecioTotal(precioBase, precioUnidad, volumenParcial));

					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
					}
					
					txtPrecioTotal.setText(String.valueOf(precioTotal));
				}
			}
		});
		txtLongitud.setColumns(10);
		txtLongitud.setBackground(Color.WHITE);
		txtLongitud.setBounds(91, 35, 382, 23);
		panelCilindro.add(txtLongitud);
		
		panelCilindroHueco = new JPanel();
		panelCilindroHueco.setVisible(false);
		panelCilindroHueco.setLayout(null);
		panelCilindroHueco.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Queso Cilindro Hueco", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		panelCilindroHueco.setBounds(10, 248, 575, 80);
		contentPanel.add(panelCilindroHueco);
		
		JLabel label_6 = new JLabel("Longitud:");
		label_6.setBounds(15, 41, 75, 14);
		panelCilindroHueco.add(label_6);
		
		txtLongitudCilindroHueco = new JTextField();
		txtLongitudCilindroHueco.setColumns(10);
		txtLongitudCilindroHueco.setBackground(Color.WHITE);
		txtLongitudCilindroHueco.setBounds(91, 35, 166, 23);
		panelCilindroHueco.add(txtLongitudCilindroHueco);
		
		txtRadioInt = new JTextField();
		txtRadioInt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioCilindroHueco.isSelected())
				{
				
				double volumenParcial = -1;
				double radio = Double.valueOf(txtRadio.getText());
				double longitudChueco = -1;
				double radioInterno = -1;
				longitudChueco = Double.valueOf(txtLongitudCilindroHueco.getText());
				radioInterno = Double.valueOf(txtRadioInt.getText());
				volumenParcial = QuesoCilindroHueco.parcialVolumen(radio,longitudChueco, radioInterno);
				txtVolumen.setText(String.valueOf(volumenParcial));
				double precioTotal = -1;
				try
				{
					int precioBase = Integer.valueOf(txtPrecioBase.getText());
					int precioUnidad = Integer.valueOf(txtPrecioUnidad.getText());
					precioTotal = Double.valueOf(QuesoCilindroHueco.parcialPrecioTotal(precioBase, precioUnidad, volumenParcial));

				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
				}
				
				txtPrecioTotal.setText(String.valueOf(precioTotal));
				
				}

			}
		});
		txtRadioInt.setColumns(10);
		txtRadioInt.setBackground(Color.WHITE);
		txtRadioInt.setBounds(348, 35, 125, 23);
		panelCilindroHueco.add(txtRadioInt);
		
		JLabel lblRadioInt = new JLabel("Radio Int:");
		lblRadioInt.setBounds(272, 41, 75, 14);
		panelCilindroHueco.add(lblRadioInt);
		
		txtVolumen = new JTextField();
		txtVolumen.setFocusable(false);
		txtVolumen.setFocusTraversalKeysEnabled(false);
		txtVolumen.setBounds(238, 374, 98, 23);
		contentPanel.add(txtVolumen);
		txtVolumen.setEditable(false);
		txtVolumen.setColumns(10);
		txtVolumen.setBackground(SystemColor.info);
		
		JLabel label_2 = new JLabel("Vol:");
		label_2.setBounds(189, 379, 46, 14);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Precio total:");
		label_3.setBounds(362, 379, 107, 14);
		contentPanel.add(label_3);
		
		txtPrecioTotal = new JTextField();
		txtPrecioTotal.setFocusable(false);
		txtPrecioTotal.setFocusTraversalKeysEnabled(false);
		txtPrecioTotal.setBounds(487, 374, 98, 23);
		contentPanel.add(txtPrecioTotal);
		txtPrecioTotal.setEditable(false);
		txtPrecioTotal.setColumns(10);
		txtPrecioTotal.setBackground(SystemColor.info);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = txtID.getText();
						int precioBase = Integer.valueOf(txtPrecioBase.getText());
						int precioUnidad = Integer.valueOf(txtPrecioUnidad.getText());
						double radioNormal = Double.valueOf(txtRadio.getText());
						double longitud = -1;						
						if(radioEsferico.isSelected())
						{
							Comercio.getInstance().agregarQueso(id, "Queso esferico", precioBase, precioUnidad, radioNormal, -1, -1);
						}
						if(radioCilindro.isSelected())
						{
							longitud = Double.valueOf(txtLongitud.getText());
							Comercio.getInstance().agregarQueso(id, "Queso cilindro", precioBase, precioUnidad, radioNormal, -1, longitud);
						}
						if(radioCilindroHueco.isSelected())
						{
							longitud = Double.valueOf(txtLongitudCilindroHueco.getText());
							double radioInterno = Double.valueOf(txtRadioInt.getText());
							Comercio.getInstance().agregarQueso(id, "Queso cilindro hueco", precioBase, precioUnidad, radioNormal, radioInterno, longitud);
						}
						txtID.setText("");
						txtPrecioBase.setText("");
						txtPrecioUnidad.setText("");
						txtPrecioBase.setText("");
						txtRadio.setText("");
						txtRadioInt.setText("");
						txtVolumen.setText("");
						txtLongitud.setText("");
						txtLongitudCilindroHueco.setText("");
						txtPrecioTotal.setText("");
						txtID.requestFocus();
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
	}
}
