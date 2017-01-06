/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.calculation;

import com.compomics.util.experiment.massspectrometry.Charge;
import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import com.compomics.util.experiment.massspectrometry.Precursor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import no.probe.example.data.GlycanSearcherUtilities;
import no.probe.example.data.GraphOutputSearch;
import no.probe.example.graphics.FileReaderDialog;
import no.probe.example.graphics.GlycanSearcherFrame;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DirectedMultigraph;

/**
 *
 * @author Probe
 */
public class Graph {

    public Graph() {

    }


    public void GraphMaker6(double[][] spectra, HashSet<Double> allDifferences, LinkedHashSet<Double> detectedMasses, LinkedHashSet<String> detectedNames, MSnSpectrum spectrum) throws IOException {

        GlycanSearcherUtilities utilities = new GlycanSearcherUtilities();

        Precursor precursor = spectrum.getPrecursor();
        ArrayList<Charge> possibleCharges = precursor.getPossibleCharges();
        
        Charge Charge = possibleCharges.get(0);
        
        
        
        double maxMz = spectrum.getMaxMz();
        double precursorMass = precursor.getMass(Charge.value);
        double mz = precursor.getMz();
       

//         double largestMass = (precursorMass - maxMz );
        
        double largestMass = 800;
        double mass = 0;
        int n = 0;

        boolean found = false;
        double sensitivity = GlycanSearcherFrame.sensitivity;

        DirectedGraph<String, GlycoEdge> testGraph = new DirectedMultigraph<String, GlycoEdge>(new ClassBasedEdgeFactory<String, GlycoEdge>(GlycoEdge.class));

        allDifferences.clear();

        ArrayList<String> startArray = new ArrayList(detectedNames);
        ArrayList<String> vertexList = new ArrayList();
        ArrayList<String> newVertexList = new ArrayList();
        vertexList.addAll(detectedNames);

        for (String s : detectedNames) {
            testGraph.addVertex(s);

            double GetTotalMass = utilities.GetTotalMass(s);

        }

        while (!vertexList.isEmpty()) {

            for (String s : vertexList) {
                double delta1 = 0;
                double one = 0;
                double two = 0;

                HashMap<String, double[]> lastStepValues = utilities.GetLosses(s);
                String lastName = null;
                double[] lastValue = null;
                for (Map.Entry<String, double[]> entry : lastStepValues.entrySet()) {
                    lastName = entry.getKey();
                    lastValue = entry.getValue();
                    one = lastValue[1];
                    two = lastValue[0];
                    delta1 = two - one;

                }

                for (String v : detectedNames) {
                    //Set up values for last step

                    String nextName = null;
                    double[] nextValue = null;

                    HashMap<String, double[]> nextStepValues = utilities.GetLosses(v);

                    for (Map.Entry<String, double[]> entry2 : nextStepValues.entrySet()) {
                        nextName = entry2.getKey();
                        nextValue = entry2.getValue();
                        double three = nextValue[1];
                        double four = nextValue[0];

                        double delta2 = four - three;

                        double deltaCheck = delta1 + delta2;

//                        System.out.println(one + " " + two + " " + three + " " + four);
                        if (deltaCheck <= largestMass) {
                            if (two > three - 1.0 && two < three + 1.0) {
                                String startValue = Double.toString(lastValue[0]);
                                String endValue = Double.toString(lastValue[0]);
                                double delta = nextValue[0] + lastValue[1];
                                String deltaString = Double.toString(deltaCheck);

                                boolean combinationTest = utilities.CombinationTest(lastName, lastName);

                                if (combinationTest == false) {

                                    String newVertex = lastName + "|" + nextName + "(" + four + "-" + one + ")" + "_" + deltaString + "_" + "NeutralLoss";

                                    testGraph.addVertex(newVertex);

//                                testGraph.addEdge(s, newVertex);
                                    testGraph.addEdge(v, newVertex, new GlycoEdge(v, newVertex, delta));
                                    newVertexList.add(newVertex);

                                    if (delta > largestMass) {
                                        largestMass = delta;

                                    }
                                }
                                
                            } else if (four > one - 1.0 && four < one + 1.0) {
                                String startValue = Double.toString(lastValue[0]);
                                String endValue = Double.toString(lastValue[1]);
                                double delta = nextValue[0] + lastValue[1];
                                String deltaString = Double.toString(deltaCheck);

                                boolean combinationTest = utilities.CombinationTest(lastName, lastName);

                                if (combinationTest == false) {

                                    String newVertex = lastName + "|" + nextName + "(" + two + "-" + three + ")" + "_" + deltaString + "_" + "NeutralLoss";

                                    testGraph.addVertex(newVertex);
                                    testGraph.addEdge(v, newVertex, new GlycoEdge(v, newVertex, delta));

                                    newVertexList.add(newVertex);

                                    if (delta > largestMass) {
                                        largestMass = delta;

                                    }
                                }
                            }
                        }

                    }

                }
            }
            if (vertexList.size() > 130) {
                break;

            }
            vertexList.clear();

            vertexList.addAll(newVertexList);
            newVertexList.clear();
        }

        GraphOutputSearch graphAlgorithm = new GraphOutputSearch();

        graphAlgorithm.GraphAlgorithm4(testGraph, startArray, largestMass);

    }

    public static class GlycoEdge<V> extends DefaultEdge {

        private V v1;
        private V v2;
        private double label;

        public GlycoEdge(V v1, V v2, double label) {
            this.v1 = v1;
            this.v2 = v2;
            this.label = 0.0;
        }

        public V getV1() {
            return v1;
        }

        public V getV2() {
            return v2;
        }

        public double toDouble() {
            return label;
        }
    }

}
