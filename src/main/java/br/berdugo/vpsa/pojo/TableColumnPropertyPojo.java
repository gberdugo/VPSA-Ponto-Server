package br.berdugo.vpsa.pojo;

import br.berdugo.vpsa.enums.ColumnType;

public class TableColumnPropertyPojo {
	
	private int index;
	
	private String type;
	
	public TableColumnPropertyPojo(int index, ColumnType type) {
		this.index = index;
		this.type = type.name();
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(ColumnType type) {
		this.type = type.name();
	}
}
