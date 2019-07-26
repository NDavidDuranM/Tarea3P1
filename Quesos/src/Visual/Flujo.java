package Visual;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Flujo extends Thread{
	
	Socket nsfd;
	DataInputStream flujoLectura;
	DataOutputStream flujoEscritura;
	
	public Flujo (Socket sfd) {
		nsfd = sfd;
		try {
			flujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
			flujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
		} catch (IOException ioe) {
			System.out.println("IOException(Flujo): " + ioe );
		}
	}
	
	@Override
	public void run() {
		/*broadcast(nsfd.getInetAddress() + "> se ha conectado.");
		Principal.Facturar.add( (Object) this);
		while(true) {
			try {
				String linea = flujoLectura.readUTF();
				if( !linea.equals("")) {
					linea = nsfd.getInetAddress() + "> " + linea;
					broadcast(linea);
				}
			} catch ( IOException ioe ) {
				Servidor.usuarios.removeElement(this);
				broadcast(nsfd.getInetAddress() + "> se ha desconectado.");
				break;
			}
		}*/
	}

}