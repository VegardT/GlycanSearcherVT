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

//int frequency = Collections.frequency(vertexSet, s);
        Integer size = 1;
        ArrayList<String> vertexesToRemove = new ArrayList();
        while (size != 0) {

            for (String s : vertexSet) {
//                String[] split = s.split("\\_");
//                String ss = split[0];
//
//                String[] words = ss.split("\\|");
//
//                String name = words[0];
                
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

//        for(String s : vertexSet){
//            String search = "Neutral loss";
//        
//            if ( s.toLowerCase().contains(search.toLowerCase()) ) {
//                 String r1 = "(^.*?\\(|\\)\\s*$)", r2 = "\\_";
//            String[] ss = s.replaceAll(r1, "").split(r2);
//
//                String startValue = ss[0].replaceAll("[^0-9.]+", " ");
//            
//            
//            
//        }
//        
//        }
        
        
        
        
        
        
        
        
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
