package no.probe.example.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import no.probe.example.calculation.Graph;
import no.probe.example.calculation.Graph.GlycoEdge;

import org.jgrapht.DirectedGraph;

/**
 * @author Vegard Tveit
 * @author Joakim Kartveit
 */

public class GraphOutputSearch {

    public static Integer count = 0;
    public static ArrayList graphs = new ArrayList();

    public GraphOutputSearch() {

    }

    public void GraphAlgorithm4(DirectedGraph<String, Graph.GlycoEdge> testGraph, ArrayList<String> startArray, double largestMass) throws IOException {

        GlycanSearcherUtilities utilities = new GlycanSearcherUtilities();
        Set<String> vertexSet = testGraph.vertexSet();

        Integer size = 1;
        ArrayList<String> vertexesToRemove = new ArrayList<String>();
        while (size != 0) {

            for (String s : vertexSet) {
                String[] words = utilities.GetNames(s);

                for (int i = 0; i < words.length; i = i + 1) {
                    String check = words[i];
                    if ("Xylose".equals(check)) {
                        if ( words.length < 1 ) {
                            if (words[i].equals(words[i + 1])) {
                                vertexesToRemove.add(s);
                            }
                        }
                    }
                }
            }

            for (String s : vertexSet) {
                String[] words = utilities.GetNames(s);

                for (int i = 0; i < words.length; i = i + 1) {
                    String check = words[i];
                    if ("Fucose".equals(check)) {
                         if ( words.length < 1 ) {
                            if (words[i].equals(words[i + 1])) {
                                vertexesToRemove.add(s);
                            }
                        }
                    }
                }
            }

            for (String s : vertexSet) {
             String[] words = utilities.GetNames(s);
                for (int i = 0; i < words.length; i = i + 1) {
                    String check = words[i];
                    if ("Neu5Ac".equals(check)) {
                         if ( words.length < 1 ) {
                            if (words[i].equals(words[i + 1])) {
                                vertexesToRemove.add(s);
                            }
                        }
                    }
                }
            }

            for (String s : vertexSet) {
                String[] words = utilities.GetNames(s);

                for (int i = 0; i < words.length; i = i + 1) {
                    String check = words[i];
                    if ("Neu5Ac-H2O|".equals(check)) {
                         if ( words.length < 1 ) {
                            if (words[i].equals(words[i + 1])) {
                                vertexesToRemove.add(s);
                            }
                        }
                    }
                }
            }

            for (String s : vertexesToRemove) {
                testGraph.removeVertex(s);
            }

            size = vertexesToRemove.size();
            vertexesToRemove.clear();
        }

        count = count + 1;

        System.out.println("THIS IS GRAPH NUMBER " + count);
        graphs.add(testGraph);

    }

    public ArrayList<DirectedGraph<String, Graph.GlycoEdge>> GetGlycanGraph() {

        return graphs;
    }

    public ArrayList<String> GetGlycanCombination() {

        return null;

    }

}