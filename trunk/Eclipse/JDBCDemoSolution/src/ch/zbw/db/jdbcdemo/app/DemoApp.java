package ch.zbw.db.jdbcdemo.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ch.zbw.db.jdbcdemo.db.Worker;
import ch.zbw.db.jdbcdemo.ui.AbstractWorker;
import ch.zbw.db.jdbcdemo.ui.Application;
import ch.zbw.db.jdbcdemo.ui.ApplicationWindow;
import ch.zbw.db.jdbcdemo.ui.WorkerEditWindow;

public class DemoApp implements Application {
	private final ApplicationWindow app;
	private Connection theConnection;

	public DemoApp(ApplicationWindow a) {
		app = a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.zbw.db.jdbcdemo.app.Application#onConnect(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void onConnect(String user, String pass) {
		app.logAdd("onConnect with user: " + user + ", pass: " + pass);
		Properties props = new Properties();
		props.put("user", user);
		props.put("password", pass);
		try {
			theConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlteacherdb", props);
			app.logAdd("Connection funzt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			app.logAdd(e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.zbw.db.jdbcdemo.app.Application#onDisconnect()
	 */
	@Override
	public void onDisconnect() {
		app.logAdd("onDisconnect called");
		if (theConnection != null) {
			try {
				theConnection.close();
				theConnection = null;
				app.logAdd("Connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				app.logAdd(e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.zbw.db.jdbcdemo.app.Application#onExecute(java.lang.String)
	 */
	@Override
	public void onExecute(String query) {
		if (theConnection == null) {
			app.logAdd("Not connected");
			return;
		}
		app.logAdd("onExecute: " + query);
		Statement st;
		try {
			st = theConnection.createStatement();

			ResultSet result = st.executeQuery(query);
			ArrayList<String> data = new ArrayList<String>();

			ResultSetMetaData metaData = result.getMetaData();

			int colCount = metaData.getColumnCount();

			while (result.next()) {

				int counter = 1;
				String row = "";

				while (counter <= colCount) {

					row = row + result.getString(counter) + ";";

					counter++;
				}

				data.add(row);
				row = "";
				counter = 0;

			}
			app.displayResult(data.toArray(new String[0]));
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			app.logAdd(e.getMessage());
		}

	}

	@Override
	public AbstractWorker onWorkerGet(int no) {

		Worker wk1 = new Worker(theConnection, no);
		return wk1;
	}

	@Override
	public AbstractWorker onWorkerNew(String Name, String GivenName) {
		return null;
	}
}
