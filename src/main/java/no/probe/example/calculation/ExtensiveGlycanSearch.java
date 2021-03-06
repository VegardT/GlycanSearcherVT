/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.calculation;

import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import no.probe.example.data.FileData;
import no.probe.example.data.GlycanData;
import no.probe.example.data.HexHexNacSearch;
import no.probe.example.graphics.GlycanSearcherFrame;
import org.jgrapht.DirectedGraph;

/**
 *
 * @author Probe
 */
public class ExtensiveGlycanSearch {

    /**
     *
     */
//   public static HashSet<Double> allDifferences;
    public ExtensiveGlycanSearch() {

    }

    public static ArrayList<DirectedGraph<String, Graph.GlycoEdge>> test = new ArrayList();

    public void search(ArrayList<double[][]> spectraList, HashMap<String, Double> glycanGalMap) throws IOException {

        FileData getSpectrum = new FileData();
        ArrayList<MSnSpectrum> spectrumList = getSpectrum.GetGlyCoSpectrum();

        HashSet<Double> allDifferences = new HashSet();

        Graph graphMaker = new Graph();
        HexHexNacSearch search = new HexHexNacSearch();
        HashMap<Double, Integer> foundSaccharides = new HashMap();
//        HashMap<String, Double> glycanGalMap = GlycanData.getMassGalMap();

        ArrayList<Double> massArray = new ArrayList();
        ArrayList<Double> massArrayGlc = new ArrayList();
        ArrayList<Double> massArrayGal = new ArrayList();

        LinkedHashSet<Double> detectedMasses = new LinkedHashSet();
        LinkedHashSet<String> detectedNames = new LinkedHashSet();

        boolean found = false;

        double maxValue = GlycanSearcherFrame.maxValue;
        double sensitivity = GlycanSearcherFrame.sensitivity;
        double minValue = GlycanSearcherFrame.minValue;

//        ArrayList<Double> mass = new ArrayList();
//
        ArrayList<String> name = new ArrayList();

        ArrayList<String> nameGlc = new ArrayList();
        ArrayList<String> nameGal = new ArrayList();
        glycanGalMap.remove("HexNAc", 204.0866);
        glycanGalMap.remove("HexNAc+", 205.0866);
        glycanGalMap.put("GalNAc", 204.0866);
        glycanGalMap.put("GalNAc+", 205.0866);

        int value = 0;
        for (Map.Entry<String, Double> s : glycanGalMap.entrySet()) {

            double d = s.getValue();
            String key = s.getKey();
            massArrayGal.add(d);
            nameGal.add(key);
        }
        glycanGalMap.remove("GalNAc", 204.0866);
        glycanGalMap.remove("GalNAc+", 205.0866);
        glycanGalMap.put("GlcNAc", 204.0866);
        glycanGalMap.put("GlcNAc+", 205.0866);

        for (Map.Entry<String, Double> s : glycanGalMap.entrySet()) {

            double d = s.getValue();
            String key = s.getKey();
            massArrayGlc.add(d);
            nameGlc.add(key);
        }

//        for (double[] s : spectraAndMzMap.keySet()) {// Fetching the mass values from the the hashmap
//        for (double[] s : spectraWithGlycan) {
        for (int v = 0; v < spectraList.size(); v = v + 1) {
//        for (int v = 0; v < 120; v = v + 1) {
            MSnSpectrum spectrum = spectrumList.get(v);
            double[][] spectra = spectraList.get(v);
            String hexhexnacSearch = search.HexHexNacStructure(spectra);
            if ("GlcNAc".equals(hexhexnacSearch)) {
                name = nameGlc;
                massArray = massArrayGlc;
            } else {
                name = nameGal;
                massArray = massArrayGal;
            }


            int length = spectra[0].length;

            for (int i = 0; i < length; i = i + 1) {

                double numberAtI = spectra[0][i];
                if (numberAtI > minValue && numberAtI < maxValue) {
                    for (int j = 0; j < length; j++) {
                        double numberAtJ;
                        numberAtJ = spectra[0][j];
                        double difference = numberAtI - numberAtJ;
                        if (difference > 125.0) {

                            allDifferences.add(Math.round(difference * 10) / 10.0d);
//                         
                        }
                        for (int k = 0; k < massArray.size(); k++) {
                            double glycanMass = massArray.get(k);
                            if (difference > glycanMass - sensitivity && difference < glycanMass + sensitivity) {

                                String endPeak = String.valueOf(numberAtI);
                                String startPeak = String.valueOf(numberAtJ);

                                found = true;
                                foundSaccharides.put(glycanMass, value);
                                foundSaccharides.put(glycanMass, foundSaccharides.get(glycanMass) + 1);

                                if (glycanMass > 125.0) {

                                    allDifferences.add(Math.round(glycanMass * 10) / 10.0d);
                                }

//                                differenceIntensities.add(Double.toString(glycanMass)+"-"+Double.toString(spectra[1][j])+"-"+ Double.toString(spectra[1][j]));
                                detectedMasses.add(glycanMass);
                                detectedNames.add(name.get(k) + "(" + endPeak + "-" + startPeak + ")" + "_Neutral Loss");

                            }
                            if (!found) {

                            }
                        }
                    }
                }

                double peakMass = spectra[0][i];
                for (int k = 0; k < massArray.size(); k++) {
                    double glycanMass = massArray.get(k);
                    if (peakMass > glycanMass - sensitivity && peakMass < glycanMass + sensitivity) {
                        found = true;

                        String peak = String.valueOf(peakMass);

                        if (glycanMass > 125.0) {
                            allDifferences.add(glycanMass);
                        }
                        detectedMasses.add(glycanMass);
                        foundSaccharides.put(glycanMass, value);
                        foundSaccharides.put(glycanMass, foundSaccharides.get(glycanMass) + 1);
                        detectedNames.add(name.get(k) + "(" + peak + "-" + "0.0" + ")" + "_" + "Peak");
                    }
                }
            }

//            graphMaker.GraphMaker4(spectra, allDifferences, detectedMasses, detectedNames,spectrum);
            graphMaker.GraphMaker6(spectra, allDifferences, detectedMasses, detectedNames, spectrum);
            detectedNames.clear();
            detectedMasses.clear();

            allDifferences.clear();

        }

    }
}
