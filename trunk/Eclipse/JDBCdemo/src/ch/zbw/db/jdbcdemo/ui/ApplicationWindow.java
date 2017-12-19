package ch.zbw.db.jdbcdemo.ui;

public interface ApplicationWindow {
	/**
	 * Adds a message to the logging area. The message passed is added on the
	 * top of the log window.
	 * 
	 * @param msg
	 *            Message to be added.
	 */
	public void logAdd(String msg);

	/**
	 * Displays the given result in the main window.
	 * 
	 * @param result
	 *            Array of result lines. Each array element represents a line.
	 */
	public void displayResult(String[] result);
}
