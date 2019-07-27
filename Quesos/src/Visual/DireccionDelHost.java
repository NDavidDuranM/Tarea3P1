package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DireccionDelHost extends JFrame {

	private JPanel contentPane;
	private JTextField txtDireccionIp;
	private String valor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DireccionDelHost frame = new DireccionDelHost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DireccionDelHost() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 328, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDireccionIp = new JTextField();
		txtDireccionIp.setBounds(55, 78, 202, 20);
		contentPane.add(txtDireccionIp);
		txtDireccionIp.setColumns(10);
		
		JLabel lblDireccionDeIp = new JLabel("Direccion de ip del Servidor");
		lblDireccionDeIp.setBounds(55, 32, 202, 14);
		contentPane.add(lblDireccionDeIp);
		
		JButton btnUsarDireccionEscrita = new JButton("Usar Direccion escrita");		
		btnUsarDireccionEscrita.setBounds(55, 130, 202, 23);
		contentPane.add(btnUsarDireccionEscrita);
		
		btnUsarDireccionEscrita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtDireccionIp.getText().equals("")==false) {
					valor=txtDireccionIp.getText();
					Principal principal =new Principal(valor);
					principal.setVisible(true);
					dispose();
				}				
			}
		});
		
	}
}
