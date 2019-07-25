package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.ComplejoDeQueso;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ComplejoDeQueso complejo;

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
		complejo = new ComplejoDeQueso(0, 0, 0);
		setTitle("Complejo de Quesos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 418);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFactura = new JMenu("Factura");
		menuBar.add(mnFactura);
		
		JMenuItem mntmFacturarCompra = new JMenuItem("Facturar compra");
		mntmFacturarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar ventana= new Facturar(complejo);
				ventana.setVisible(true);
			}
		});
		mnFactura.add(mntmFacturarCompra);
		
		JMenuItem mntmVerFacturasRealizadas = new JMenuItem("Ver Facturas realizadas");
		mntmVerFacturasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaFactura ventana=new ListaFactura(complejo);
				ventana.setVisible(true);
			}
		});
		mnFactura.add(mntmVerFacturasRealizadas);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmVerListaDe = new JMenuItem("Ver lista de clientes");
		mntmVerListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCliente ventana = new ListaCliente(complejo);
				ventana.setVisible(true);
			}
		});
		mnClientes.add(mntmVerListaDe);
		
		JMenu mnQuesos = new JMenu("Quesos");
		menuBar.add(mnQuesos);
		
		JMenuItem mntmHacerQuesos = new JMenuItem("Hacer quesos");
		mntmHacerQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerQueso ventana = new HacerQueso(complejo);
				ventana.setVisible(true);
			}
		});
		mnQuesos.add(mntmHacerQuesos);
		
		JMenuItem mntmVerQuesos = new JMenuItem("Ver quesos");
		mntmVerQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaQueso ventana= new ListaQueso(complejo);
				ventana.setVisible(true);
			}
		});
		mnQuesos.add(mntmVerQuesos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
