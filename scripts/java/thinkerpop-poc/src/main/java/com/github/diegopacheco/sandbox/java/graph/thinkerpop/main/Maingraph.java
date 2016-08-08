package com.github.diegopacheco.sandbox.java.graph.thinkerpop.main;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerFactory;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class Maingraph {
	public static void main(String[] args) {
		
		Graph graph = TinkerFactory.createModern();
		graph = TinkerGraph.open();
		System.out.println(graph);
		
		Vertex v1 = graph.addVertex(T.id, 1, T.label, "person", "name", "diego", "age", 31);
		System.out.println(v1);
		
		Vertex v2 = graph.addVertex(T.id, 2, T.label, "person", "name", "alex",  "age", 32);
		System.out.println(v2);
		
		Edge e4 = v1.addEdge("follows", v2);
		System.out.println(e4);
		
		GraphTraversalSource g = graph.traversal();
		System.out.println(g.V(1).values("name").toList() );
		System.out.println(g.V(2).values("name").toList() );
		System.out.println(g.V().values("name").toList() );
		System.out.println(g.V().values("age").toList() );
	}
}
