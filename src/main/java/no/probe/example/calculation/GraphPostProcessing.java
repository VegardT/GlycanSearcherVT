package no.probe.example.calculation;

import java.util.ArrayList;
import java.util.Collections;
import org.jgrapht.DirectedGraph;

/**
 *
 * @author Vegard Tveit
 * @author Joakim Kartveit
 */
public class GraphPostProcessing {


    public ArrayList<DirectedGraph<String, Graph.GlycoEdge>> postProcessing(ArrayList<DirectedGraph<String, Graph.GlycoEdge>> graphs) {

        ArrayList<String> nameList = new ArrayList();
        ArrayList<String> nameToRemove = new ArrayList();
        ArrayList<Integer> nrOfHits = new ArrayList();

        for (DirectedGraph<String, Graph.GlycoEdge> g : graphs) {

            for (String s : g.vertexSet()) {
                String[] words = s.split("\\_");
                String name = words[0];
                nameList.add(name);
            }
        }

        for (String s : nameList) {
            int hits = Collections.frequency(nameList, s);
            nrOfHits.add(hits);
        }


        Integer max = Collections.max(nrOfHits);

        for (String s : nameList) {
            int hits = Collections.frequency(nameList, s);

            if (hits >= (max * 0.7)) {
                nameToRemove.add(s);

            }
        }

        for (DirectedGraph<String, Graph.GlycoEdge> g : graphs) {
            for (String s : g.vertexSet()) {
                String[] words = s.split("\\_");
                String name = words[0];
                for (String n : nameToRemove) {
                    if (n.equals(name)) {
                        g.removeVertex(s);
                    }
                }
            }
        }

        return graphs;
    }
}