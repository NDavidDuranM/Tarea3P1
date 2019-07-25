package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/if_list-alt_173045.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistro = new JMenu("Registro");
		mnRegistro.setIcon(new ImageIcon(Principal.class.getResource("/img/if_book_sans_add_103401.png")));
		menuBar.add(mnRegistro);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar cliente");
		mntmRegistrarCliente.setIcon(new ImageIcon(Principal.class.getResource("/img/if_user-add_216490.png")));
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente regCliente = new RegistrarCliente();
				regCliente.setModal(true);
				regCliente.setVisible(true);
			}
		});
		mnRegistro.add(mntmRegistrarCliente);
		
		JMenuItem mntmRegistrarQueso = new JMenuItem("Registrar queso");
		mntmRegistrarQueso.setIcon(new ImageIcon(Principal.class.getResource("/img/if__q_2559784.png")));
		mntmRegistrarQueso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroQueso regQueso = new RegistroQueso();
				regQueso.setModal(true);
				regQueso.setVisible(true);
			}
		});
		mnRegistro.add(mntmRegistrarQueso);
		
		JMenu mnListar = new JMenu("Listar");
		mnListar.setIcon(new ImageIcon(Principal.class.getResource("/img/if_list_103613.png")));
		menuBar.add(mnListar);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/if_88_171447.png")));
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar listar = new Listar("Clientes");
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmClientes);
		
		JMenuItem mntmQuesos = new JMenuItem("Quesos");
		mntmQuesos.setIcon(new ImageIcon(Principal.class.getResource("/img/if__q_2559784.png")));
		mntmQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar listar = new Listar("Quesos");
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmQuesos);
		
		JMenuItem mntmFacturas = new JMenuItem("Facturas");
		mntmFacturas.setIcon(new ImageIcon(Principal.class.getResource("/img/if_090_Notes_183217.png")));
		mntmFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar listar = new Listar("Facturas");
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmFacturas);
		
		JMenu mnFactura = new JMenu("Factura");
		mnFactura.setIcon(new ImageIcon(Principal.class.getResource("/img/if_report_card_2639898.png")));
		menuBar.add(mnFactura);
		
		JMenuItem mntmCrearFactura = new JMenuItem("Crear factura");
		mntmCrearFactura.setIcon(new ImageIcon(Principal.class.getResource("/img/if_plus_103681.png")));
		mntmCrearFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar factura = new Facturar();
				factura.setModal(true);
				factura.setVisible(true);
			}
		});
		mnFactura.add(mntmCrearFactura);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
