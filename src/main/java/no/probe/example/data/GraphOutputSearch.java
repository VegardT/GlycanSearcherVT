/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import no.probe.example.calculation.Graph;
import no.probe.example.calculation.Graph.GlycoEdge;

import org.jgrapht.DirectedGraph;

/**
 *
 * @author Probe
 */
public class GraphOutputSearch {

    public static Integer count = 0;
    public static ArrayList graphs = new ArrayList();
    public static ArrayList PathCombination = new ArrayList();

    public GraphOutputSearch() {

    }

    public void GraphAlgorithm4(DirectedGraph<String, Graph.GlycoEdge> testGraph, ArrayList<String> startArray, double largestMass) throws IOException {

        ArrayList<Set<GlycoEdge>> edgesToRemove = new ArrayList();
        GlycanSearcherUtilities utilities = new GlycanSearcherUtilities();
        Double max = null;
        Set<String> vertexSet = testGraph.vertexSet();

        Integer size = 1;
        ArrayList<String> vertexesToRemove = new ArrayList();
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
                        } else {
                            //do nothing
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
                        } else {
                            //do nothing
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
                        } else {
                            //do nothing
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
                        } else {
                            //do nothing
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