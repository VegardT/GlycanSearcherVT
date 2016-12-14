/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.data;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import no.probe.example.calculation.Graph;
import org.jgrapht.DirectedGraph;

/**
 *
 * @author Probe
 */
public class GlycanSearcherUtilities {

    public GlycanSearcherUtilities() {

    }
    int count = 0;

    public String[] GetNames(String s) {

        String[] vertexInformation = s.split("\\_");
        //0 = Name and peak/loss
        //1 = Mass of saccharide/glycan
        //2 = Intensity/Neutral Loss

        String names = vertexInformation[0];
        String[] split = names.split("\\|");
        String[] nameArray = new String[split.length];

        for (int j = 0; j < split.length; j = j + 1) {
            String ss = split[j];
            String name = ss.replaceAll("\\(.*\\)", "");
            nameArray[j] = name;
        }

        return nameArray;
    }

//      public String GetNamesCombinations(String s) {
//
//        String[] vertexInformation = s.split("\\_");
//        //0 = Name and peak/loss
//        //1 = Mass of saccharide/glycan
//        //2 = Intensity/Neutral Loss
//
//        String names = vertexInformation[0];
//        String[] split = names.split("\\|");
//        String[] nameArray = new String[split.length];
//
//        for (int j = 0; j < split.length; j = j + 1) {
//            String ss = split[j];
//            String name = ss.replaceAll("\\(.*\\)", "");
//            nameArray[j] = name;
//        }
//        
//
//        return nameCombination;
//    }
    public double GetTotalMass(String s) {
        String[] vertexInformation = s.split("\\_");
        String ss = null;
        double totalMass;

        if (vertexInformation.length < 1) {
            ss = vertexInformation[1];
            totalMass = Double.parseDouble(ss);
        } else {
            ss = vertexInformation[0];
            String name = ss.substring(ss.indexOf("(") + 1, ss.indexOf(")"));
            String[] split = name.split("\\-");
            double startValue = Double.parseDouble(split[1]);
            double endValue = Double.parseDouble(split[0]);
            double value = endValue - startValue;
            totalMass = value;

        }
        return totalMass;
    }

    public HashMap<String, double[]> GetLosses(String s) {

        HashMap<String, double[]> lossMap = new HashMap();

//        System.out.println(s);
        ArrayList<double[]> lossList = new ArrayList();

        String[] n = s.split("\\_");
        String nn = n[0];
        String name = nn.replaceAll("\\(.*\\)", "");

        String ss = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
        String[] lossPosition = ss.split("-");

        double[] lossArray = new double[lossPosition.length];

        double[] dd = new double[lossArray.length];

        for (int j = 0; j < lossArray.length; j = j + 1) {
            double d = Double.parseDouble(lossPosition[j]);
            dd[j] = Double.parseDouble(lossPosition[j]);
        }

        lossMap.put(name, dd);
        lossList.add(dd);

        //Do some smart stuff here to get the peaks to doubles
        return lossMap;
    }

    public boolean CombinationTest(String firstName, String lastName) {
        boolean combination = false;
        HashMap glycanMap = new HashMap();
        glycanMap.put("Neu5Ac - H2O", 273.05);
        glycanMap.put("Neu5Ac - H2O", 274.14);
        glycanMap.put("Neu5Ac", 290.08);
        glycanMap.put("Neu5Ac", 291.0);
        glycanMap.put("Neu5Ac+", 292.103);
        glycanMap.put("Neu5Ac", 309.0);
        glycanMap.put("Fucose", 147.058);
//        glycanMap.put("GlcA", 176.0);
        glycanMap.put("Xylose", 132.0);
        glycanMap.put("tag-oxGal", 406.1643);
        glycanMap.put("tag fragment [-H2O]", 231.1162);
        glycanMap.put("tag fragment", 249.1267);

//        Set keySet = glycanMap.keySet();
        for (Object o : glycanMap.keySet()) {
            String check = o.toString();
            if (check.equals(firstName)) {
                if (check.equals(lastName)) {
                    combination = true;

                }
            }
        }

        return combination;
    }

    public UndirectedSparseGraph TranslateGraph(DirectedGraph<String, Graph.GlycoEdge> g, Double glycanMass) {

        UndirectedSparseGraph visualisationGraph = new UndirectedSparseGraph<String, String>();

        HashSet<String> nameSet = new HashSet();

        Set<Graph.GlycoEdge> edgeSet = g.edgeSet();
        Set<String> vertexSet = g.vertexSet();

        for (Graph.GlycoEdge e : edgeSet) {

            Object v1 = e.getV1();
            Object v2 = e.getV2();
            String edgeName = e.toString();

            String v1String = v1.toString();
            String v2String = v2.toString();

            visualisationGraph.addEdge(v1String + "|" + v2String, v1String, v2String);

        }

        for (String s : vertexSet) {
            String[] information = s.split("\\_");
            String names = information[0];

            String[] nameList = names.split("\\|");
//            String name = names[information.length - 1];

            for (String ss : nameList) {
                String substring = ss.substring(ss.indexOf("(") + 1, ss.indexOf(")"));
                nameSet.add(substring);
            }

        }

        for (String s : nameSet) {
            visualisationGraph.addVertex("Peptide");
            if (glycanMass < 210.0) {

                if (1 == nameSet.size()) {
                    visualisationGraph.addVertex(s);
                    visualisationGraph.addEdge(s, "Peptide", s);
                }

            } else if (glycanMass < 370.0) {

                if (1 > nameSet.size()) {

                    if (nameSet.contains("GalNac")) {
                        visualisationGraph.addVertex("GalNac");

                        visualisationGraph.addEdge("GalNac", "Peptide", "GalNac");
                        nameSet.remove("GalNac");

                        for (String name : nameSet) {
                            visualisationGraph.addVertex(name);

                            visualisationGraph.addEdge("GalNac", name, name);
                        }

                    } else if (nameSet.contains("GlcNac")) {
                        visualisationGraph.addVertex("GlcNac");

                        visualisationGraph.addEdge("GlcNac", "Peptide", "GlcNac");
                        nameSet.remove("GlcNac");
                        for (String name : nameSet) {
                            visualisationGraph.addVertex(name);

                            visualisationGraph.addEdge("GlcNac", name, name);
                        }

                    }
                }

            } else if (glycanMass < 520.0) {
                if (nameSet.contains("GalNac")) {
                    visualisationGraph.addVertex("GalNac");

                    visualisationGraph.addEdge("GalNac", "Peptide", "GalNac");
                    nameSet.remove("GalNac");

                    for (String name : nameSet) {
                        visualisationGraph.addVertex(name);

                        visualisationGraph.addEdge("GalNac", name, name);
                    }

                } /*else if () {
                
                 }
                
                 } else if () {
                
                 */

            } else {

            }

        }

        return visualisationGraph;
    }

    public UndirectedSparseGraph TranslateDirectGraph(DirectedGraph<String, Graph.GlycoEdge> g) {

        UndirectedSparseGraph visualisationGraph = new UndirectedSparseGraph<String, String>();

        Set<Graph.GlycoEdge> edgeSet = g.edgeSet();
        Set<String> vertexSet = g.vertexSet();
        for (String s : vertexSet) {
            visualisationGraph.addVertex(s);
        }

        for (Graph.GlycoEdge e : edgeSet) {

            Object v1 = e.getV1();
            Object v2 = e.getV2();
            String edgeName = e.toString();

            String v1String = v1.toString();
            String v2String = v2.toString();

            visualisationGraph.addEdge(v1String + "|" + v2String, v1String, v2String);

        }

        return visualisationGraph;
    }

    public boolean HasSameChar(String s1, String s2) {
//        boolean identical = false;
        for (char c : s1.toCharArray()) {
            if (s2.indexOf(c) < 0) {
                return false;
            }
        }
        for (char c : s2.toCharArray()) {
            if (s1.indexOf(c) < 0) {
                return false;
            }
        }

        return true;
    }

}
