package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.ComplejoDeQueso;
import Logico.Servidor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ComplejoDeQueso complejo;
	//private File dirqueso;
	private File dircomplejo;
	//private File dirfactura;
	//private File dircliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		
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
		new Servidor().RecibirArchivo();;
		new Servidor().iniciarServidor();
		
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/if_list-alt_173045.png")));
				
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistro = new JMenu("Registro");
		mnRegistro.setIcon(new ImageIcon(Principal.class.getResource("/img/if_book_sans_add_103401.png")));
		menuBar.add(mnRegistro);
		
		JMenuItem mntmHacerQuesos = new JMenuItem("Quesos");
		mntmHacerQuesos.setIcon(new ImageIcon(Principal.class.getResource("/img/if__q_2559784.png")));
		mnRegistro.add(mntmHacerQuesos);
		mntmHacerQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerQueso ventana = new HacerQueso(complejo);
				ventana.setVisible(true);
			}
		});
		
		JMenu mnListar = new JMenu("Listar");
		mnListar.setIcon(new ImageIcon(Principal.class.getResource("/img/if_list_103613.png")));
		menuBar.add(mnListar);
		
		JMenuItem mntmVerQuesos = new JMenuItem("Quesos");
		mntmVerQuesos.setIcon(new ImageIcon(Principal.class.getResource("/img/if__q_2559784.png")));
		mntmVerQuesos.setEnabled(false);
		mntmVerQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaQueso ventana= new ListaQueso(complejo);
				ventana.setVisible(true);
			}
		});
		
		JMenuItem mntmVerListaDe = new JMenuItem("Clientes");
		mntmVerListaDe.setIcon(new ImageIcon(Principal.class.getResource("/img/if_88_171447.png")));
		mnListar.add(mntmVerListaDe);
		mntmVerListaDe.setEnabled(false);
		mntmVerListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCliente ventana = new ListaCliente(complejo);
				ventana.setVisible(true);
			}
		});
		mnListar.add(mntmVerQuesos);
		
		JMenu mnFactura = new JMenu("Factura");
		mnFactura.setIcon(new ImageIcon(Principal.class.getResource("/img/if_report_card_2639898.png")));
		menuBar.add(mnFactura);
		
		JMenuItem mntmFacturarCompra = new JMenuItem("Crear factura");
		mntmFacturarCompra.setIcon(new ImageIcon(Principal.class.getResource("/img/if_plus_103681.png")));
		mntmFacturarCompra.setEnabled(false);
		mntmFacturarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar ventana;
				try {
					ventana = new Facturar(complejo);
					ventana.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnFactura.add(mntmFacturarCompra);
		
		JMenuItem mntmVerFacturasRealizadas = new JMenuItem("Facturas");
		mntmVerFacturasRealizadas.setIcon(new ImageIcon(Principal.class.getResource("/img/if_090_Notes_183217.png")));
		mntmVerFacturasRealizadas.setEnabled(false);
		mntmVerFacturasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaFactura ventana=new ListaFactura(complejo);
				ventana.setVisible(true);
			}
		});
		mnFactura.add(mntmVerFacturasRealizadas);
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mnRegistro.addMenuListener(new MenuListener() {
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
		mnListar.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				if(complejo.getCantqueso()>0) {
					mntmVerQuesos.setEnabled(true);	
				}
				if (complejo.getCantcli()>0) {
					mntmVerListaDe.setEnabled(true);
				}
				
			}
			
		});
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				//System.out.println("saliendo///");
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
