package it.polito.tdp.newufosightings.model;

public class ArcoPeso {
	
	private String state1;
	private String state2;
	private Integer peso;
	public ArcoPeso(String state1, String state2, Integer peso) {
		super();
		this.state1 = state1;
		this.state2 = state2;
		this.peso = peso;
	}
	public String getState1() {
		return state1;
	}
	public String getState2() {
		return state2;
	}
	public Integer getPeso() {
		return peso;
	}
	
	

}
