package ContenidoDeServidor;

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

import Logico.ComplejoDeQueso;

public class Servidor {

	private ServerSocket servidor = null;
	private Socket cliente = null;
	private DataInputStream dis;
	private DataOutputStream dos;
	private File DataDelServidor;
	private ComplejoDeQueso complejo;
	final int PUERTO = 4400;

//	public void RecibirArchivo( ) throws IOException {
//        // Creamos socket servidor escuchando en el mismo puerto donde se comunica el cliente
//        // en este caso el puerto es el 4400
//        servidor = new ServerSocket( 4400 );
//        System.out.println( "Esperando recepcion de archivos..." ); 
//	}

	public void iniciarServidor() {

		complejo = new ComplejoDeQueso(0, 0, 0);
		DataDelServidor = new File("DataServer.txt");

		
		try {
			FileInputStream Fi = new FileInputStream(DataDelServidor);
			ObjectInputStream input = new ObjectInputStream(Fi);
			complejo = (ComplejoDeQueso) input.readObject();
			input.close();
			Fi.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("El archivo no fue encontrado" + e1);
		} catch (IOException e2) {
			System.out.println("Error: " + e2);
		} catch (ClassNotFoundException e3) {
			System.out.println("Error: " + e3);
		}

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor Iniciado");

			while (true) {

				// Creamos el socket que atendera el servidor
				cliente = servidor.accept();
				System.out.println("Cliente conectado");

				// Creamos flujo de entrada para leer los datos que envia el cliente
//	             dis = new DataInputStream( cliente.getInputStream() );
				dis = new DataInputStream(cliente.getInputStream());

				
				String accion =(String) dis.readUTF();
				System.out.println("dick new");
				if (accion.equals("Peticion de datos")) {
					System.out.println("dick new22");
					dos = new DataOutputStream(cliente.getOutputStream());
					ObjectOutputStream out = new ObjectOutputStream(dos);
					out.writeObject(complejo);
					out.close();
					dos.close();
					System.out.println("dick new223");
				}
				System.out.println("dick new2");
				if(accion.equals("Datos Nuevos")) {
					
					try {
						
						ObjectInputStream ois = new ObjectInputStream(dis);
						complejo=(ComplejoDeQueso) ois.readObject();
						
						FileOutputStream Fo = new FileOutputStream(DataDelServidor);
						ObjectOutputStream output = new ObjectOutputStream(Fo);
						output.writeObject(complejo);
						System.out.println("dipp");
						output.close();
						Fo.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						System.out.println("El archivo no fue encontrado" + e1);
					} catch (IOException e2) {
						System.out.println("Error: " + e2);
					} catch (ClassNotFoundException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} 
				}
				
				cliente.close();
				System.out.println("Cliente Desconectado");

			}
		} catch (IOException e1) {
			System.out.println("Error:" + e1);

		}
		System.out.println("dickfin");

	}

	public ServerSocket getServidor() {
		return servidor;
	}

	public void setServidor(ServerSocket servidor) {
		this.servidor = servidor;
	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}

	public File getDataDelServidor() {
		return DataDelServidor;
	}

	public void setDataDelServidor(File dataDelServidor) {
		DataDelServidor = dataDelServidor;
	}

	public ComplejoDeQueso getComplejo() {
		return complejo;
	}

	public void setComplejo(ComplejoDeQueso complejo) {
		this.complejo = complejo;
	}

	public int getPUERTO() {
		return PUERTO;
	}
	
}
