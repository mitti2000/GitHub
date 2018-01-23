package ch.zbw.db.jdbcdemo.app;

import ch.zbw.db.jdbcdemo.ui.AbstractWorker;
import ch.zbw.db.jdbcdemo.ui.Application;
import ch.zbw.db.jdbcdemo.ui.ApplicationWindow;

public class DemoAppSolution implements Application {
	private final ApplicationWindow app;
	
	public DemoAppSolution(ApplicationWindow a) {
		app = a;
	}

	/* (non-Javadoc)
	 * @see ch.zbw.db.jdbcdemo.app.Application#onConnect(java.lang.String, java.lang.String)
	 */
	@Override
	public void onConnect(String user, String pass) {
		app.logAdd("onConnect with user: " + user + ", pass: " + pass);
	}

	/* (non-Javadoc)
	 * @see ch.zbw.db.jdbcdemo.app.Application#onDisconnect()
	 */
	@Override
	public void onDisconnect() {
		app.logAdd("onDisconnect called");
	}

	/* (non-Javadoc)
	 * @see ch.zbw.db.jdbcdemo.app.Application#onExecute(java.lang.String)
	 */
	@Override
	public void onExecute(String query) {
		app.logAdd("onExecute: " + query);
	}

	@Override
	public AbstractWorker onWorkerGet(int no) {
		return null;
	}

	@Override
	public AbstractWorker onWorkerNew(String Name, String GivenName) {
		return null;
	}
}
