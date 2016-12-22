 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.data;

import java.util.LinkedHashMap;

/**
 *
 * @author Probe
 */
public class GlycanData {

    private static final double massMax = 1000;

    public static LinkedHashMap<String, Double> getMassGalMap() {

        LinkedHashMap<String, Double> glycanMap = new LinkedHashMap();
        glycanMap.put("Xylose", 132.0423);
        glycanMap.put("Hexose", 162.0528);
        glycanMap.put("Fucose", 146.0579 );
        glycanMap.put("HexNAc", 204.0866);

        glycanMap.put("HexNAc+", 205.0866);
        glycanMap.put("Neu5Ac-H2O", 274.0794);
        glycanMap.put("Neu5Ac", 291.0954);

        return glycanMap;

    }

    public static LinkedHashMap<String, Double> getModificationMap() {

        LinkedHashMap<String, Double> modificationMap = new LinkedHashMap();

        modificationMap.put("Oxygen or NH2 ", 16.0);
        modificationMap.put("NH3", 17.0);
        modificationMap.put("H2O", 18.0);
        modificationMap.put("sulfur", 32.06);

        return modificationMap;

    }

    public static double getMassMax() {
        return massMax;
    }

    public static LinkedHashMap<Double, Integer> getHitMap() {

        LinkedHashMap<String, Double> masses = GlycanData.getMassGalMap();

        int value = 0;

        LinkedHashMap<Double, Integer> hitMap = new LinkedHashMap();
        for (String s : masses.keySet()) {// Fetching the mass values from the the hashmap
            Double key = masses.get(s);
            hitMap.put(key, value);
        }

        return hitMap;

    }

    public static LinkedHashMap<String, Double> GetAminoAcids() {

        LinkedHashMap<String, Double> aminoAcids = new LinkedHashMap();

        aminoAcids.put("Gly", 57.05);
        aminoAcids.put("Ala", 71.08);
        aminoAcids.put("Ser", 87.08);
        aminoAcids.put("Pro", 97.12);
        aminoAcids.put("Val", 99.07);
        aminoAcids.put("Thr", 101.1);
        aminoAcids.put("Cys", 103.1);
        aminoAcids.put("Leu", 113.2);
        aminoAcids.put("Ile", 113.2);
        aminoAcids.put("Asn", 114.1);
        aminoAcids.put("Asp", 115.1);
        aminoAcids.put("Gln", 128.05858);
        aminoAcids.put("Lys", 128.09496);
        aminoAcids.put("Glu", 129.04259);
        aminoAcids.put("Met", 131.04048);
        aminoAcids.put("His", 137.05891);
        aminoAcids.put("Phe", 147.06841);
        aminoAcids.put("Arg", 156.10111);
        aminoAcids.put("Tyr", 163.06333);
        aminoAcids.put("Trp", 186.07931);

        return aminoAcids;
    }

    public static LinkedHashMap<String, Double> GetTaggedOxoniumIons() {

        LinkedHashMap<String, Double> taggedIons = new LinkedHashMap();

        taggedIons.put("tag-oxNeu5Ac", 475.1857);
        taggedIons.put("tag-oxNeu5Ac [-H2O]", 457.1751);
        taggedIons.put("tag-oxGal", 406.1643);
        taggedIons.put("oxNeu5Ac",230.0659);
        taggedIons.put("tag-sugar fragment", 304.1326);
        taggedIons.put("HexNAc", 204.0866);
        taggedIons.put("oxGal", 161.0445);

        return taggedIons;
    }
    
    
        public static LinkedHashMap<Double, Integer> getHitMapTagged() {

        LinkedHashMap<String, Double> masses = GlycanData.GetTaggedOxoniumIons();

        int value = 0;

        LinkedHashMap<Double, Integer> hitMap = new LinkedHashMap();
        for (String s : masses.keySet()) {// Fetching the mass values from the the hashmap
            Double key = masses.get(s);
            hitMap.put(key, value);
        }

        return hitMap;

    }
    

    public static double[] getHexNacIonSeries() {

        double[] hexNAc = {168.0, 138.0, 144.0, 126.0};

        return hexNAc;

    }

    public static double[] getNeu5AcIonSeries() {

        double[] Neu5NAc = {222.0, 246.0, 256.0, 264.0, 214.0, 292.0, 310.0};

        return Neu5NAc;

    }

}