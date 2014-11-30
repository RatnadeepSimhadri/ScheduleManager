package com.isys622.schedulemanager.form;

public class SelectItem {

	private Integer value;
	private String label;
	
	public SelectItem( Integer value , String label){
		this.setValue(value);
		this.setLabel(label);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
