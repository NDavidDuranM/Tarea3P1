package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Comercio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarCliente.class.getResource("/img/if_user_173122.png")));
		setTitle("Registro de clientes");
		setBounds(100, 100, 525, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCdulanmeroDeIdentidad = new JLabel("C\u00E9dula/N\u00FAmero de identidad");
		lblCdulanmeroDeIdentidad.setBounds(154, 16, 232, 14);
		contentPanel.add(lblCdulanmeroDeIdentidad);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(154, 41, 232, 23);
		setLocationRelativeTo(null);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(154, 105, 112, 23);
		contentPanel.add(txtNombre);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(154, 80, 168, 14);
		contentPanel.add(lblNombres);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(281, 105, 105, 23);
		contentPanel.add(txtApellido);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(281, 80, 168, 14);
		contentPanel.add(lblApellidos);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(25, 177, 129, 23);
		contentPanel.add(txtDireccion);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(25, 152, 129, 14);
		contentPanel.add(lblDireccin);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(169, 177, 222, 23);
		contentPanel.add(txtTelefono);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(169, 152, 168, 14);
		contentPanel.add(lblTelfono);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/img/if_user_173122.png")));
		label.setBounds(15, 16, 112, 128);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cedula = txtCedula.getText();
						String Nombre = txtNombre.getText() ;
						String apellido = txtApellido.getText();
						String direccion = txtDireccion.getText();
						String telefono = txtTelefono.getText();
						Comercio.getInstance().agregarCliente(cedula, Nombre, apellido, direccion, telefono);
						
						txtNombre.setText("");
						txtCedula.setText("");
						txtDireccion.setText("");
						txtApellido.setText("");
						txtTelefono.setText("");

						txtCedula.requestFocus();
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
