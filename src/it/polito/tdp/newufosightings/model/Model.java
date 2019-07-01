package it.polito.tdp.newufosightings.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.newufosightings.db.NewUfoSightingsDAO;

public class Model {
	
	private NewUfoSightingsDAO dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	private List<ArcoPeso> arcoPeso;
	private List<VerticePeso> verticePeso;
	
	public Model() {
		this.dao = new NewUfoSightingsDAO();
		this.arcoPeso = new ArrayList<>();
		this.verticePeso = new ArrayList<>();
	}
	
	public void creaGrafo(Integer anno, Integer giorni) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.arcoPeso = this.dao.getConnessioni(anno, giorni);
		for(ArcoPeso tmp: this.arcoPeso) {
			Graphs.addEdgeWithVertices(this.grafo, tmp.getState1(), tmp.getState2(), (double) tmp.getPeso());
			System.out.println("Arco aggiunto tra "+tmp.getState1()+ "->"+ tmp.getState2()+ "con peso= "+ tmp.getPeso());
		}
		
	}

	public int getVertici() {
		return this.grafo.vertexSet().size();
	}

	public int getArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<VerticePeso> sommaPesiAdiacenti(){
		int somma = 0;
		for(String s: this.grafo.vertexSet()) {
			List<String> vicini = Graphs.neighborListOf(this.grafo, s);
			for(String v : vicini) {
				somma = somma + (int) this.grafo.getEdgeWeight(this.grafo.getEdge(s, v));
			}
			verticePeso.add(new VerticePeso(s, somma));
		}
		return verticePeso;
	}

}
