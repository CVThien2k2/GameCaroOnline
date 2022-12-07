package model;

public class Player {
	private String Name;
	private String Value;
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public Player(String name, String value, int ID) {
		Name = name;
		Value = value;
		this.ID = ID;
	}

	public Player(String name, String value) {
		Name = name;
		Value = value;
	}

}
