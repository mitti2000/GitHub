package ch.zbw.db.jdbcdemo.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.zbw.db.jdbcdemo.app.DemoApp;

public class MainWindow implements ApplicationWindow {

	private JFrame frmJdbcDemoApplication;
	private JTextArea diag_output = null;
	private JTextArea data_output = null;
	private JTextArea query = null;
	private JTextField username;
	private JTextField password;
	private Application app = new DemoApp(this);

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJdbcDemoApplication = new JFrame();
		frmJdbcDemoApplication.setTitle("JDBC Demo Application");
		frmJdbcDemoApplication.setBounds(100, 100, 450, 300);
		frmJdbcDemoApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel control = new JPanel();
		frmJdbcDemoApplication.getContentPane().add(control, BorderLayout.EAST);
		control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		control.add(panel);

		JLabel lblNewLabel = new JLabel("User:");
		panel.add(lblNewLabel);

		username = new JTextField();
		panel.add(username);
		username.setColumns(10);

		JPanel password_panel = new JPanel();
		control.add(password_panel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		password_panel.add(lblNewLabel_1);

		password = new JTextField();
		password_panel.add(password);
		password.setColumns(10);

		JPanel panel_2 = new JPanel();
		control.add(panel_2);

		JButton btnConnect = new JButton("Connect");
		panel_2.add(btnConnect);

		JButton btnNewButton = new JButton("Disconnect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.onDisconnect();
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnEditWorker = new JButton("Edit Worker");
		btnEditWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerEditWindow we = new WorkerEditWindow(app);
				we.display(true);
			}
		});
		panel_2.add(btnEditWorker);

		JPanel panel_3 = new JPanel();
		control.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		query = new JTextArea();
		query.setColumns(25);
		query.setRows(5);
		JScrollPane query_pane = new JScrollPane(query);
		panel_3.add(query_pane);

		JButton btnExecuteQuery = new JButton("Execute query");
		btnExecuteQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.onExecute(query.getText());
			}
		});
		panel_3.add(btnExecuteQuery);

		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.onConnect(username.getText(), password.getText());
			}
		});

		data_output = new JTextArea();
		data_output.setRows(20);
		data_output.setColumns(50);
		JScrollPane data = new JScrollPane(data_output);
		frmJdbcDemoApplication.getContentPane().add(data, BorderLayout.CENTER);

		diag_output = new JTextArea();
		diag_output.setRows(5);
		JScrollPane diag = new JScrollPane(diag_output);
		frmJdbcDemoApplication.getContentPane().add(diag, BorderLayout.SOUTH);
	}

	public void display() {
		display(true);
	}
	
	public void display(boolean show) {
		frmJdbcDemoApplication.setVisible(show);
		frmJdbcDemoApplication.pack();
	}

	@Override
	public void logAdd(String msg) {
		diag_output.setText(diag_output.getText() + "\n" + msg);
	}

	@Override
	public void displayResult(String[] result) {
		data_output.setText(joinString("\n", result));
	}
	
	private String joinString(String delimiter, String[] a) {
		StringBuffer sb = new StringBuffer();
		
		for (String s : a) {
			sb.append(delimiter);
			sb.append(s);
		}

		return sb.substring(delimiter.length());
	}

	public void setApplication(Application app) {
		this.app = app;
	}
}
