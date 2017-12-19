package ch.zbw.db.jdbcdemo.ui;

import java.sql.Connection;
import java.util.Observable;

public abstract class AbstractWorker extends Observable {
	public static enum EntityState {
		UNKNOWN,
		HOLLOW,
		NEW,
		CLEAN,
		DIRTY,
		DELETED
	}
	
	protected Connection conn;
	protected EntityState CurrentState = EntityState.UNKNOWN;
	
	private int Number;
	private String Name;
	private String GivenName;
	
	/**
	 * Creates a worker
	 * 
	 * @param conn	Connection to the DB backend
	 * @param Number	Primary key of the worker record, -1 if new.
	 */
	public AbstractWorker(Connection conn, int Number) {
		this.conn = conn;
		this.Number = Number;
		CurrentState = EntityState.HOLLOW;
		setChanged();
	}
	
	public AbstractWorker(Connection conn, String Name, String GivenName) {
		this.conn = conn;
		this.Number = -1;
		this.Name = Name;
		this.GivenName = GivenName;
		CurrentState = EntityState.NEW;
		setChanged();
	}
	
	public int NumberGet() {
		synchronized(this) {
			return Number;
		}
	}
	
	public void NumberSet(int nr) {
		synchronized(this) {
			Number = nr;
			if (CurrentState == EntityState.CLEAN) {
				CurrentState = EntityState.NEW;
			}
			setChanged();
			notifyObservers();
		}
	}
	
	public String NameGet() {
		synchronized(this) {
			return Name;
		}
	}
	
	public void NameSet(String Name) {
		synchronized(this) {
			this.Name = Name;
			if (CurrentState == EntityState.CLEAN) {
				CurrentState = EntityState.DIRTY;
			}
			setChanged();
			notifyObservers();
		}
	}
	
	public String GivenNameGet() {
		synchronized(this) {
			return GivenName;
		}
	}
	
	public void GivenNameSet(String Name) {
		synchronized(this) {
			this.GivenName = Name;
			if (CurrentState == EntityState.CLEAN) {
				CurrentState = EntityState.DIRTY;
			}
			setChanged();
			notifyObservers();
		}
	}

	public final void load() {
		synchronized(this) {
			doLoad();
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * Load the record's details from the DB backend
	 */
	protected abstract void doLoad(); 

	public final void save() {
		synchronized(this) {
			doSave();
			notifyObservers();
		}
	}

	/**
	 * Save the record in the DB backend. Either insert it or update 
	 * it depending on the object state.
	 */
	public abstract void doSave();

	public final void revert() {
		synchronized(this) {
			doRevert();
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Reload a possibly dirty instance of Worker from the DB
	 */
	public abstract void doRevert();

	public final void delete() {
		synchronized(this) {
			doDelete();
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Deletes the represented worker in the DB backend.
	 */
	public abstract void doDelete();
}
