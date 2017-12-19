package ch.zbw.db.jdbcdemo.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WorkerEditWindow implements Observer {
	public static final AbstractWorker EMPTY_WORKER = new AbstractWorker(null, "N/A", "N/A") {
		@Override
		protected void doLoad() {
		}

		@Override
		public void doSave() {
		}

		@Override
		public void doRevert() {
		}

		@Override
		public void doDelete() {
		}
	};

	private JFrame frame;
	private JTextField WorkerNoField;
	private JTextField txtNamefield;
	private JTextField txtGivennamefield;
	
	private Application app;
	private AbstractWorker worker = EMPTY_WORKER;

	/**
	 * Create the application.
	 */
	public WorkerEditWindow(Application app) {
		this.app = app;
		initialize();
	}
	
	public void display(boolean show) {
		frame.setVisible(show);
		frame.pack();
	}

	private void onWorkerChanged(AbstractWorker worker) {
		if (worker == null) {
			worker = EMPTY_WORKER;
		}

		this.worker.deleteObserver(this);
		this.worker = worker;
		worker.addObserver(this);
		worker.load();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel Nav = new JPanel();
		panel.add(Nav, BorderLayout.NORTH);
		Nav.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		WorkerNoField = new JTextField();
		WorkerNoField.setText("1");
		Nav.add(WorkerNoField);
		WorkerNoField.setColumns(10);
		WorkerNoField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				worker.NumberSet(Integer.parseInt(WorkerNoField.getText()));
			}
		});

		
		JButton btnLoad = new JButton("Laden");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onWorkerChanged(app.onWorkerGet(Integer.parseInt(WorkerNoField.getText())));
			}
		});
		Nav.add(btnLoad);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblName = new JLabel("Name");
		panel_2.add(lblName);
		
		txtNamefield = new JTextField();
		txtNamefield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				worker.NameSet(txtNamefield.getText());
			}
		});
		txtNamefield.setText("NameField");
		panel_2.add(txtNamefield);
		txtNamefield.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname");
		panel_2.add(lblVorname);
		
		txtGivennamefield = new JTextField();
		txtGivennamefield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				worker.NameSet(txtGivennamefield.getText());
			}
		});
		txtGivennamefield.setText("GivennameField");
		panel_2.add(txtGivennamefield);
		txtGivennamefield.setColumns(10);
		
		JPanel Manipulation = new JPanel();
		panel.add(Manipulation, BorderLayout.SOUTH);
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				worker.save();
			}
		});
		
		JButton btnNeu = new JButton("Neu");
		btnNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onWorkerChanged(app.onWorkerNew(txtNamefield.getText(), txtGivennamefield.getText()));
			}
		});
		Manipulation.add(btnNeu);
		Manipulation.add(btnSave);
		
		JButton btnCancel = new JButton("Abbrechen");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker.revert();
				display(false);
			}
		});
		
		JButton btnDelete = new JButton("L\u00F6schen");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker.delete();
				worker = EMPTY_WORKER;
			}
		});
		Manipulation.add(btnDelete);
		Manipulation.add(btnCancel);
	}

	@Override
	public void update(Observable o, Object arg) {
		WorkerNoField.setText(((Integer)worker.NumberGet()).toString());
		txtNamefield.setText(worker.NameGet());
		txtGivennamefield.setText(worker.GivenNameGet());
	}

}
