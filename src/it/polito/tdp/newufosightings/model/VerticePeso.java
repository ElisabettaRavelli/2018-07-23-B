package it.polito.tdp.newufosightings.model;

public class VerticePeso {
	
	private String state;
	private Integer sommaPesi;
	public VerticePeso(String state, Integer sommaPesi) {
		super();
		this.state = state;
		this.sommaPesi = sommaPesi;
	}
	public String getState() {
		return state;
	}
	public Integer getSommaPesi() {
		return sommaPesi;
	}
	@Override
	public String toString() {
		return String.format("State=%s -> SommaPesi=%s", state, sommaPesi);
	}
	
	

}
