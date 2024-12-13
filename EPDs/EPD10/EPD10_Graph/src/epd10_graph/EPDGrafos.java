package epd10_graph;

import datastructures.Graph;
import datastructures.AdjacencyMapGraph;
import datastructures.Edge;
import datastructures.Vertex;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author jonathanquishpe
 */
public class EPDGrafos {

    public static void main(String[] args) {
        //declaro un grafo no direccionado
        Graph<String, Integer> grafoNoDireccionado = new AdjacencyMapGraph<>(false);
//declaro un grafo direccionado
        Graph<String, Integer> grafoDireccionado = new AdjacencyMapGraph<>(true);
        Vertex<String> v1 = grafoNoDireccionado.insertVertex("V1");
        Vertex<String> v2 = grafoNoDireccionado.insertVertex("V2");
        Vertex<String> v3 = grafoNoDireccionado.insertVertex("V3");
        Vertex<String> v4 = grafoNoDireccionado.insertVertex("V4");
        grafoNoDireccionado.insertEdge(v1, v2, 1);
        grafoNoDireccionado.insertEdge(v1, v3, 1);
        grafoNoDireccionado.insertEdge(v2, v3, 1);
        grafoNoDireccionado.insertEdge(v2, v4, 1);
        grafoNoDireccionado.insertEdge(v3, v4, 1);
        System.out.println("Numero vertices: " + grafoNoDireccionado.numVertices()
                + " numero aristas: " + grafoNoDireccionado.numEdges());
        print(grafoNoDireccionado);
    }

    /**
     * Helper routine to get a Vertex(Position) from a string naming the vertex
     */
    public static Vertex<String> getVertex(String vertexLabel, Graph<String, Integer> sGraph) {
// Go through vertex list to find vertex
        for (Vertex<String> vs : sGraph.vertices()) {
            if (vs.getElement().equals(vertexLabel)) {
                return vs;
            }
        }
        return null;
    }

    /**
     * Printing all the vertices in the list , followed by printing all the
     * edges
     */
    public static void print(Graph<String, Integer> sGraph) {
        System.out.println("Vertices: " + sGraph.numVertices()
                + " Edges: " + sGraph.numEdges());
//imprimir todos los vertices
        for (Vertex<String> vs : sGraph.vertices()) {
            System.out.println(vs.getElement());
        }
//imprimir todas las aristas
        for (Edge<Integer> es : sGraph.edges()) {
            System.out.println(es.getElement());
        }
    }

    /**
     * Constructs a graph from an array of array strings.
     *
     * An edge can be specified as { "SFO", "LAX" }, in which case edge is
     * created with default edge value of 1, or as { "SFO", "LAX", "337" }, in
     * which case the third entry should be a string that will be converted to
     * an integral value.
     */
    public static Graph<String, Integer> graphFromEdgelist(String[][] edges, boolean directed) {
        Graph<String, Integer> g = new AdjacencyMapGraph<>(directed);
// first pass to get sorted set of vertex labels
        TreeSet<String> labels = new TreeSet<>();
        for (String[] edge : edges) {
            labels.add(edge[0]);
            labels.add(edge[1]);
        }
// now create vertices (in alphabetical order)
        HashMap<String, Vertex<String>> verts = new HashMap<>();
        for (String label : labels) {
            verts.put(label, g.insertVertex(label));
        }
// now add edges to the graph
        for (String[] edge : edges) {
            Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2]));
            g.insertEdge(verts.get(edge[0]), verts.get(edge[1]), cost);
        }
        return g;
    }
}
