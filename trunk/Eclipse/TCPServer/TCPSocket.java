import java.io.*;
import java.net.*;


public class TCPSocket implements AutoCloseable {
	
	private Socket socket;
	private BufferedReader istream;
	private BufferedWriter ostream;
	
	public TCPSocket (String serverAdress, int serverPort) throws UnknownHostException, IOException
	{
		socket = new Socket(serverAdress, serverPort);
		initializeStream();
		
	}
	
	public TCPSocket (Socket socket) throws UnknownHostException, IOException
	{
		this.socket = socket;
		initializeStream();
		
	}
	
	public void sendLine(String s) throws IOException
	{
		ostream.write(s);
		ostream.newLine();
		ostream.flush();
	}
	
	public String receiveLine() throws IOException
	{
		return(istream.readLine());
	}
	
	private void initializeStream() throws IOException
	{
		ostream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		istream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		socket.close();
	}

}
