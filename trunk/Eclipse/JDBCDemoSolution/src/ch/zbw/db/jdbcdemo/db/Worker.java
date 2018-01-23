package ch.zbw.db.jdbcdemo.db;

import java.sql.Connection;

import ch.zbw.db.jdbcdemo.ui.AbstractWorker;

/**
 * This class represents a worker in sqlteacherdb.
 */
public class Worker extends AbstractWorker {
	/**
	 * Creates a worker
	 * 
	 * @param conn	Connection to the DB backend
	 * @param Number	Primary key of the worker record, -1 if new.
	 */
	public Worker(Connection conn, int Number) {
		super(conn, Number);
	}
	
	public Worker(Connection conn, String Name, String GivenName) {
		super(conn, Name, GivenName);
	}
	
	@Override
	public void doLoad() {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void doSave() {
		/** TODO Create the DB access. */
	}

	@Override
	public void doRevert() {
		/** TODO Create the DB access. */

		// Notify registered windows about the change of values.
		notifyAll();
	}

	@Override
	public void doDelete() {
		/** TODO Create the DB access. */
	}
}
