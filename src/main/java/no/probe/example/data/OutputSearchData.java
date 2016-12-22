/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Probe
 */
public class OutputSearchData {

    /**
     * Data from the search method is processed here with the data for the
     * table.
     *
     *
     */
    public ArrayList hitsDifference = new ArrayList();
    public ArrayList<Double> percentHits = new ArrayList();
    public ArrayList<Double> SaccharideMasses = new ArrayList();
    public ArrayList<String> names = new ArrayList();

    public void OutputSearchData(LinkedHashMap<Double, Integer> hitMap,LinkedHashMap<String, Double> glycanMap) throws IOException {

        double peaks = FileData.peaks; //Amounts of peaks the mgf file contains
        Set<String> names1 = glycanMap.keySet(); // Saccharide names
        int totalAmountPeaks = 0;
        names = new ArrayList<String>(names1);
        for (Map.Entry<Double, Integer> d : hitMap.entrySet()) {
           
            Integer value = d.getValue();

            totalAmountPeaks = totalAmountPeaks + value;
        
        }

        for (Double d : hitMap.keySet()) {
            double hits = hitMap.get(d);

            hitsDifference.add(hits);

            double percent = ((hits / totalAmountPeaks) * 100);
            double percent2 = Math.round(percent * 1000) / 1000.0d;

            percentHits.add(percent2);

        }

        for (String s : glycanMap.keySet()) {// Fetching the mass values from the the hashmap
            double value = glycanMap.get(s);
            SaccharideMasses.add(value);

        }

        System.out.println("Results difference");
        System.out.println("Total amount of peaks " + peaks);
        System.out.println(hitsDifference);
        System.out.println(SaccharideMasses);
        System.out.println(names);
        System.out.println(percentHits);
        hitMap.clear();

    }

    public ArrayList<Integer> GetHitsDifference() {

        return hitsDifference;
    }

    public ArrayList<Double> GetSaccharideMasses() {

        return SaccharideMasses;
    }

    public ArrayList<Double> GetPercentHits() {

        return percentHits;
    }

    public ArrayList<String> GetNames() {

        return names;
    }

}