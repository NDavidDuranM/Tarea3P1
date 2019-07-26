package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.ComplejoDeQueso;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ComplejoDeQueso complejo;
	private File dirqueso;
	private File dircomplejo;
	private File dirfactura;
	private File dircliente;

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
		dircomplejo =new File("DataComplejo.txt");
		try {
			FileInputStream Fi = new FileInputStream(dircomplejo);
			ObjectInputStream input = new ObjectInputStream(Fi);
			complejo=(ComplejoDeQueso) input.readObject();
			input.close();
			Fi.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("El archivo no fue encontrado"+e1);
		} catch(IOException e2) {
			System.out.println("Error: "+e2);
		}catch(ClassNotFoundException e3) {
			System.out.println("Error: "+e3);
		}
		
		setTitle("Complejo de Quesos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 418);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFactura = new JMenu("Factura");
		menuBar.add(mnFactura);
		
		JMenuItem mntmFacturarCompra = new JMenuItem("Facturar compra");
		mntmFacturarCompra.setEnabled(false);
		mntmFacturarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar ventana= new Facturar(complejo);
				ventana.setVisible(true);
			}
		});
		mnFactura.add(mntmFacturarCompra);
		
		JMenuItem mntmVerFacturasRealizadas = new JMenuItem("Ver Facturas realizadas");
		mntmVerFacturasRealizadas.setEnabled(false);
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
		mntmVerListaDe.setEnabled(false);
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
		mntmVerQuesos.setEnabled(false);
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
		mnClientes.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				if(complejo.getCantcli()>0) {
					mntmVerListaDe.setEnabled(true);
				}
				
			}
		});
		mnQuesos.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				if(complejo.getCantqueso()>0) {
					mntmVerQuesos.setEnabled(true);	
				}
				
			}
			
		});
		mnFactura.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				if(complejo.getCantqueso()>0) {
					mntmFacturarCompra.setEnabled(true);
				}
				if(complejo.getCantfactura()>0) {
					mntmVerFacturasRealizadas.setEnabled(true);
				}
				
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("saliendo///");
				try {
					FileOutputStream Fo=new FileOutputStream(dircomplejo);
					ObjectOutputStream output= new ObjectOutputStream(Fo);
					output.writeObject(complejo);
					output.close();
					Fo.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("El archivo no fue encontrado"+e1);
				} catch(IOException e2) {
					System.out.println("Error: "+e2);
				}
			}
		});
		
		
	}
}
