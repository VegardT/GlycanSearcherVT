package no.probe.example.data;

import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import no.probe.example.calculation.Graph;
import org.jgrapht.DirectedGraph;

/**
 * @author Vegard Tveit
 * @author Joakim Kartveit
 */

public class GraphInformation {

    public GraphInformation() {

    }

    public File SpectraSuggestions() throws IOException {
        GraphOutputSearch getGraphs = new GraphOutputSearch();
        ArrayList<DirectedGraph<String, Graph.GlycoEdge>> glycanGraphList = getGraphs.GetGlycanGraph();
        ArrayList<MSnSpectrum> spectrum = FileData.glycoSpectrum;
        HashSet<String> names = new HashSet();
        ArrayList<String> allData = new ArrayList();

        LinkedHashMap<String, Integer> glycoInformation = new LinkedHashMap();
        String combinationData = "";

        for (int i = 0; i < spectrum.size(); i = i + 1) {
            String test = "";
            DirectedGraph<String, Graph.GlycoEdge> g = glycanGraphList.get(i);
            MSnSpectrum ms = spectrum.get(i);
            String spectrumTitle = ms.getSpectrumTitle();

            Set<String> vertexSet = g.vertexSet();

            for (String s : vertexSet) {

                String[] vertexInformation = s.split("\\_");

                String name = vertexInformation[0];
                String replaceAll = name.replaceAll("\\(.*\\)", "");
                names.add(replaceAll);

            }
            for (String s : names) {
                test += s + "\t";
            }

            for (String key : names) {
                int frequency = Collections.frequency(names, key);
                glycoInformation.put(key, frequency);

            }

            combinationData = spectrumTitle + "_" + test + "-";
            allData.add(combinationData);

            PrintWriter out = new PrintWriter("C:\\Users\\Probe\\Documents\\Koder\\Test\\testFile.txt");

            out.println("." + spectrumTitle);
            System.out.println(spectrumTitle);
            for (Entry<String, Integer> e : glycoInformation.entrySet()) {

                String key = e.getKey();
                String frequency = Integer.toString(e.getValue());
                out.println(key + "   " + frequency);
                System.out.print(key + "  " + frequency + "\n");

            }
            System.out.println(" ");
            glycoInformation.clear();
        }

        String mainString = null;

        for (String s : allData) {
            mainString += s + "\t";
        }

        return null;
    }

}