package ch.zbw.db.jdbcdemo.ui;

public interface Application {
	/**
	 * Callback when connect button is pressed.
	 * 
	 * This callback is expected to create a DBMS connection using the given
	 * credentials.
	 * 
	 * @param user
	 *            Username to connect with
	 * @param pass
	 *            Password to connect with
	 */
	void onConnect(String user, String pass);

	/**
	 * Callback when disconnect button is pressed. This callback is expected to
	 * terminate any possible DBMS connection.
	 */
	void onDisconnect();

	/**
	 * Callback when query execute button is pressed. It is expected that the
	 * query given is executed.
	 * 
	 * @param query
	 *            Query to be executed.
	 */
	void onExecute(String query);
	
	/**
	 * This callback asks for a worker object linked to the given 
	 * worker number. The object might be hallow.
	 * 
	 * @param no Worker number (Primary key) of the worker asked for
	 *  
	 * @return An object linked to the given record.
	 */
	AbstractWorker onWorkerGet(int no);

	/**
	 * This callback asks for a worker object not yet available in 
	 * the backend.
	 * 
	 * @param Name	Name of the worker
	 * @param GivenName Givenname of the worker
	 * 
	 * @return A (yet) unsaved version of the worker.
	 */
	AbstractWorker onWorkerNew(String Name, String GivenName);
}