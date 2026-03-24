package client;

import java.io.*; 
import java.net.Socket; 
import java.util.Scanner; 
import java.io.IOException;

public class TCPClient {
	
	   public TCPClient() throws IOException { 

	        // Conectarse al servidor en localhost en el puerto 2020 
		    final int puerto = 2022;
	        Socket  socket  =  new  Socket ( "localhost" , puerto ); 
	        System.out.println( "Conectado correctamente al servidor." ); 

	        // Configurar flujos de entrada y salida para la comunicación 
	        BufferedReader  in_socket  =  new  BufferedReader ( new  InputStreamReader (socket.getInputStream())); 
	        PrintWriter  out_socket  =  new  PrintWriter ( new  OutputStreamWriter (socket.getOutputStream()), true ); 
	        
            // este es ejemplo de proyecto
	        // Recibir y mostrar el mensaje de bienvenida del servidor 
	        String  message  = in_socket.readLine(); 
	        System.out.println( "El servidor dice: " + message); 

	        // Enviar un mensaje al servidor
	        while(!message.equals("close")){
	        	Scanner  keyboard  =  new  Scanner (System.in); 
		        message = keyboard.nextLine(); 
		        out_socket.println(message); 
		        
		        System.out.println("hOLA: " +message);
		        
		        String  message2  = in_socket.readLine(); 
		        System.out.println( "Accion Server: " + message2); 
		    }
	        // Cerrar la conexión
	        socket.close(); 
	        System.out.println( "El puerto 2020 se cerró correctamente." ); 
	    } 

	    public  static  void  main (String[] args) { 

	        try { 
	            new  TCPClient (); // Iniciar el cliente

	         } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	    } 
}
