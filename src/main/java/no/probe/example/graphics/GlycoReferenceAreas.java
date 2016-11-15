/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.graphics;

import com.compomics.util.gui.interfaces.SpectrumAnnotation;
import com.compomics.util.gui.spectrum.DefaultSpectrumAnnotation;
import com.compomics.util.gui.spectrum.ReferenceArea;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import no.probe.example.calculation.Graph;
import no.probe.example.data.GlycanSearcherUtilities;
import org.jgrapht.DirectedGraph;

/**
 *
 * @author Probe
 */
public class GlycoReferenceAreas {

    public GlycoReferenceAreas() {

    }

    public HashSet GlycoReference(DirectedGraph<String, Graph.GlycoEdge> graph) {
        ReferenceArea referenceArea = null;
        HashSet<ReferenceArea> referenceList = new HashSet();
        ArrayList<String> vertexList = new ArrayList();
        ArrayList<Integer> nameList = new ArrayList();
        ArrayList<Integer> list = new ArrayList();

        double start = 0;
        double end = 0;
        double delta = 0;
        GlycanSearcherUtilities utilities = new GlycanSearcherUtilities();
        int i = 0;
        for (String node : graph.vertexSet()) {
            vertexList.add(node);

        }
        for (int j = 0; j < vertexList.size(); j = j + 1) {
//        for (String s1 : vertexList) {
            String s1 = vertexList.get(j);
            for (int v = 0; v < vertexList.size(); v = v + 1) {
                String s2 = vertexList.get(v);
                boolean hasSameChar = utilities.HasSameChar(s1, s2);
                if (hasSameChar == true) {

                    if (!s1.contentEquals(s2)) {

                        if (!list.contains(s2)) {
                            if (!list.contains(s1)) {
                                list.add(j);
                                nameList.add(v);
                                vertexList.remove(v);
                            }
                        }
                    }
                }
            }
        }

//        for (int remove : list) {
//            vertexList.remove(remove);
//        }
        for (String s : vertexList) {
            String name = null;
            HashMap<String, double[]> losses = utilities.GetLosses(s);
            for (Map.Entry<String, double[]> d : losses.entrySet()) {
                name = d.getKey();
                double[] value = d.getValue();

                if (value.length == 2) {

                    start = value[1];
                    end = value[0];
                    delta = end - start;

//                distances.put((end - start), name);
                }

            }

            if (delta <= 160.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.YELLOW, 0.01f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.30, true);
                referenceList.add(referenceArea);

            } else if (delta <= 200) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.RED, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 250.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.GREEN, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 300.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.BLUE, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 350.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.RED, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta < 600) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.BLUE, 0.1f, true, true, Color.BLACK, true, Color.BLACK, 1, 1.0, true);
                referenceList.add(referenceArea);
            }else if (delta < 800) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.RED, 0.1f, true, true, Color.BLACK, true, Color.BLACK, 1, 1.0, true);
                referenceList.add(referenceArea);
            }
        }
        return referenceList;
    }
    
       public HashSet GlycoReferencePickedVertexes(ArrayList<String> pickedNodes) {
        ReferenceArea referenceArea = null;
        HashSet<ReferenceArea> referenceList = new HashSet();
        ArrayList<String> vertexList = new ArrayList();
        ArrayList<Integer> nameList = new ArrayList();
        ArrayList<Integer> list = new ArrayList();

        double start = 0;
        double end = 0;
        double delta = 0;
        GlycanSearcherUtilities utilities = new GlycanSearcherUtilities();
        int i = 0;
//        for (String node : graph.vertexSet()) {
//            vertexList.add(node);
//
//        }
//        for (int j = 0; j < vertexList.size(); j = j + 1) {
////        for (String s1 : vertexList) {
//            String s1 = vertexList.get(j);
//            for (int v = 0; v < vertexList.size(); v = v + 1) {
//                String s2 = vertexList.get(v);
//                boolean hasSameChar = utilities.HasSameChar(s1, s2);
//                if (hasSameChar == true) {
//
//                    if (!s1.contentEquals(s2)) {
//
//                        if (!list.contains(s2)) {
//                            if (!list.contains(s1)) {
//                                list.add(j);
//                                nameList.add(v);
//                                vertexList.remove(v);
//                            }
//                        }
//                    }
//                }
//            }
//        }

//        for (int remove : list) {
//            vertexList.remove(remove);
//        }
        for (String s : pickedNodes) {
            String name = null;
            HashMap<String, double[]> losses = utilities.GetLosses(s);
            for (Map.Entry<String, double[]> d : losses.entrySet()) {
                name = d.getKey();
                double[] value = d.getValue();

                if (value.length == 2) {

                    start = value[1];
                    end = value[0];
                    delta = end - start;

//                distances.put((end - start), name);
                }

            }

            if (delta <= 160.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.YELLOW, 0.01f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.30, true);
                referenceList.add(referenceArea);

            } else if (delta <= 200) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.RED, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 250.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.GREEN, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 300.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.BLUE, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 350.0) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.RED, 0.09f, true, true, Color.BLACK, true, Color.BLACK, 1, 0.50, true);
                referenceList.add(referenceArea);
            } else if (delta <= 600) {

                referenceArea = new ReferenceArea("" + i++, name, start, end, Color.BLUE, 0.1f, true, true, Color.BLACK, true, Color.BLACK, 1, 1.0, true);
                referenceList.add(referenceArea);
            }
        }
        return referenceList;
    }

    public DefaultSpectrumAnnotation GlycoAnnotation(String s) {

        DefaultSpectrumAnnotation test = null;
        GlycanSearcherUtilities check = new GlycanSearcherUtilities();
        int counter = 0;

        HashSet<SpectrumAnnotation> annotations = new HashSet<SpectrumAnnotation>();

        String[] words = s.split("\\_");
        String[] GetNames = check.GetNames(s);
        HashMap<String, double[]> losses = check.GetLosses(s);

        String name = words[0];
        double totalMass = check.GetTotalMass(s);

        test = new DefaultSpectrumAnnotation(totalMass, 0.9, Color.BLUE, name);
        annotations.add(test);

        return test;

    }

}
