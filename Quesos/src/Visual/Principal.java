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
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
import java.util.Scanner;
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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ComplejoDeQueso complejo;
	//private File dirqueso;
	private File dircomplejo;
	//private File dirfactura;
	//private File dircliente;
	private String HOST="192.168.43.112";
	final int PUERTO=4400;
	private Socket SckCliente;
    private DataInputStream dis;
    private DataOutputStream dos;

	/**
	 * Launch the application.
	 *
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

	}

	/**
	 * Create the frame.
	 */
	public Principal(String direccionHOST) {
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/if_list-alt_173045.png")));
		HOST=direccionHOST;
		complejo = new ComplejoDeQueso(0, 0, 0);
		try {
		
			SckCliente =new Socket(HOST,PUERTO);
			System.out.println("ya me conecte");
			dos= new DataOutputStream(SckCliente.getOutputStream());
			
			dos.writeUTF("Peticion de datos");
			System.out.println("dick new55555");
			dis = new DataInputStream(SckCliente.getInputStream());
			ObjectInputStream ois = new ObjectInputStream(dis);
			complejo = (ComplejoDeQueso) ois.readObject();
			dos.close();
			dis.close();
			SckCliente.close();
		
		}catch(IOException e1) {
			System.out.println("Error: "+e1);
			dispose();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		
		
		
		
//		dircomplejo =new File("DataComplejo.txt");
//		try {
//			FileInputStream Fi = new FileInputStream(dircomplejo);
//			ObjectInputStream input = new ObjectInputStream(Fi);
//			complejo=(ComplejoDeQueso) input.readObject();
//			input.close();
//			Fi.close();
//			
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("El archivo no fue encontrado"+e1);
//		} catch(IOException e2) {
//			System.out.println("Error: "+e2);
//		}catch(ClassNotFoundException e3) {
//			System.out.println("Error: "+e3);
//		}
		
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
		mnFactura.add(mntmFacturarCompra);
		
		
		mntmFacturarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Facturar ventana = new Facturar(complejo);
				ventana.setVisible(true);
				
				
			}
		});
		
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
//				//System.out.println("saliendo///");
//				try {
//					FileOutputStream Fo=new FileOutputStream(dircomplejo);
//					ObjectOutputStream output= new ObjectOutputStream(Fo);
//					output.writeObject(complejo);
//					output.close();
//					Fo.close();
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					System.out.println("El archivo no fue encontrado"+e1);
//				} catch(IOException e2) {
//					System.out.println("Error: "+e2);
//				}
		
				try {
					System.out.println("dipp");
					SckCliente =new Socket(HOST,PUERTO);
					
					dos= new DataOutputStream(SckCliente.getOutputStream());
					dos.writeUTF("Datos Nuevos");
					ObjectOutputStream oot =new ObjectOutputStream(dos);
					oot.writeObject(complejo);
					System.out.println("dipper");
					oot.close();
					System.out.println("even more");
					dos.close();
					System.out.println("dipp");
				}catch(IOException e1) {
					System.out.println("Error: "+e1);
				}
				
				System.out.println("calm down");
			}
		});
//		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				try {
//					
//					SckCliente =new Socket(HOST,PUERTO);
//					
//					dos= new DataOutputStream(SckCliente.getOutputStream());
//					dos.writeUTF("Datos Nuevos");
//					
//					ObjectOutputStream oot =new ObjectOutputStream(dos);
//					oot.writeObject(complejo);
//					
//					oot.close();
//					
//					dos.close();
//					
//				}catch(IOException e1) {
//					System.out.println("Error: "+e1);
//				}
//				
//				
//			}
//		});
		
//		addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				try {
//					
//					SckCliente =new Socket(HOST,PUERTO);
//					
//					dos= new DataOutputStream(SckCliente.getOutputStream());
//					dos.writeUTF("Datos Nuevos");
//					
//					ObjectOutputStream oot =new ObjectOutputStream(dos);
//					oot.writeObject(complejo);
//					
//					oot.close();
//					
//					dos.close();
//					
//				}catch(IOException e1) {
//					System.out.println("Error: "+e1);
//				}
//			}
//		});
	}
}
