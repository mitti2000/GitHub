import java.time.LocalDateTime;

public interface TimeService extends java.rmi.Remote {
	public LocalDateTime getTime() throws java.rmi.RemoteException;

}
