/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.calculation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import no.probe.example.data.GlycanData;
import no.probe.example.graphics.GlycanSearcherFrame;
import uk.ac.ebi.jmzml.xml.io.MzMLUnmarshallerException;

/**
 *
 * @author Probe The glycanSearch searches each spectra for glycanMass
 *
 *
 *
 */
public class GlycanSearch {

    public GlycanSearch() throws IOException, MzMLUnmarshallerException {

    }

    /**
     * 
     * GlycanSearch searches for a the saccharides from the list of saccharides choosen by the user.
     *
     * @param spectraList list containing the spectra with glycans.
     * @param massMax the highest delta so check if matches to a glycan mz. This is a parameter too reduce the search time by avoiding redundant calculations
     * @param glycanMap HashMap containing string name and double corresponding to mz of saccharide
     * @param saccharideList is the name of list of saccharides the user want to search for.
     * @return returns hitmap. A Hashmap containing string with saccharide names and number of integers of hits
     * @throws IOException
     * @throws MzMLUnmarshallerException
     */
    public LinkedHashMap<Double, Integer> runSearch(ArrayList<double[][]> spectraList, double massMax, LinkedHashMap<String, Double> glycanMap, String saccharideList) throws IOException, MzMLUnmarshallerException {

        LinkedHashMap<Double, Integer> hitMap = null;
        if (saccharideList.equals("Standard")) {
            hitMap = GlycanData.getHitMap();
        } else if (saccharideList.equals("Tagged")) {
            hitMap = GlycanData.getHitMapTagged();
            
        }

        double maxValue = GlycanSearcherFrame.maxValue;
        double sensitivity = GlycanSearcherFrame.sensitivity;
        double minValue = GlycanSearcherFrame.minValue;
        ArrayList<Double> SaccharideMasses = new ArrayList();

        long startTime = System.currentTimeMillis();

        if (hitMap.isEmpty()) {
            hitMap.clear();
        } else {

        }

        boolean found = false;

        for (String s : glycanMap.keySet()) {
            double value = glycanMap.get(s);
            SaccharideMasses.add(value);
        }

        //Difference Search
        for (double[][] spectra : spectraList) {

            for (int i = 0; i < spectra[1].length; i = i + 1) {

                double numberAtI = spectra[0][i];

                if (numberAtI > minValue && numberAtI < maxValue) {
                    for (int j = 0; j < spectra.length; j++) {
                        double numberAtJ;
                        numberAtJ = spectra[0][j];
                        double difference = numberAtI - numberAtJ;
                        if (difference > massMax) {
                            break;
                        }

                        if (difference < 90) {
                            break;
                        }

                        for (Double SaccharideMasse : SaccharideMasses) {
                            double glycanMass = SaccharideMasse;
                            if (difference > glycanMass - sensitivity && difference < glycanMass + sensitivity) {

                                found = true;

                                hitMap.put(glycanMass, hitMap.get(glycanMass) + 1);

                            }
                        }
                    }
                    if (!found) {

                    }

                }

            }
        }
        long estimatedTime1 = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime1);
        //peak search
        for (double[][] spectra : spectraList) {

            for (int i = 0; i < spectra[0].length; i = i + 1) {

                double mass = spectra[0][i];

                for (Double SaccharideMasse : SaccharideMasses) {
                    double glycanMass = SaccharideMasse;
                    if (mass > glycanMass - sensitivity && mass < glycanMass + sensitivity) {
                        found = true;
                        hitMap.put(glycanMass, hitMap.get(glycanMass) + 1);

                    }
                }
            }
            if (!found) {
            }
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);

        return hitMap;

    }

}
