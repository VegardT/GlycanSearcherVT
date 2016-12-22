/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;

/**
 *
 * @author Probe This is a methode inspired by sweetNet workflow.
 *
 *
 *
 */
public class HexHexNacSearch {

    public HexHexNacSearch() {

    }

    public static ArrayList<double[]> massListWithGlycan = new ArrayList();
    public static HashMap<String, Integer> galNacGlcNacMap = new HashMap();

    public boolean HexHexNacSearch(double[][] dd) {
        if (galNacGlcNacMap.isEmpty()) {
            galNacGlcNacMap.put("GalNac", 0);
            galNacGlcNacMap.put("GlcNac", 0);

        }

        boolean hexHexNAc = false;

        int n = 0;
        double[] mIntensity;
        double[] mMass = null;
        ArrayList<Double> values = new ArrayList();
        ArrayList<Double> testInt = new ArrayList();
        ArrayList<Double> testMass = new ArrayList();

        ArrayList<Double> int126 = new ArrayList();
        ArrayList<Double> int138 = new ArrayList();
        ArrayList<Double> int144 = new ArrayList();
        ArrayList<Double> int168 = new ArrayList();

        double[] hexNacIonSeries = GlycanData.getHexNacIonSeries();

        LinkedHashMap<Double, Double> map = new LinkedHashMap();

        if (dd[1].length >= 2) {

            RealMatrix Matrix = MatrixUtils.createRealMatrix(dd);
            mIntensity = Matrix.getRow(1);
            mMass = Matrix.getRow(0);

            for (int i = 0; i < mIntensity.length; i++) {

                double myMass = mMass[i];

                for (double ion : hexNacIonSeries) {
                    if (ion > myMass - 0.17 && ion < myMass + 0.17) {
                        if (ion == 126.0) {
                            int126.add(mIntensity[i]);
                        }
                        if (ion == 138.0) {
                            int138.add(mIntensity[i]);
                        }
                        if (ion == 144.0) {
                            int144.add(mIntensity[i]);
                        }
                        if (ion == 168.0) {
                            int168.add(mIntensity[i]);
                        }

                        map.put(ion, mIntensity[i]);
                        testInt.add(mIntensity[i]);
                        testMass.add(myMass);
                    }
                }

            }
        }

        ArrayList<String> list = new ArrayList();
        if (!map.isEmpty()) {
            Set<Double> keySet = map.keySet();
            int size = keySet.size();
            if (size >= 4) {
                for (Map.Entry<Double, Double> d : map.entrySet()) {
                    Double key = d.getKey();
                    Double value = d.getValue();
                    values.add(value);

                }

                double GGRatio = ((Collections.max(int138) + (Collections.max(int168))) / (Collections.max(int126) + (Collections.max(int144))));

                hexHexNAc = true;

                if (GGRatio > 1) { //ratio is dependent on energy levels of instrument

                    list.add("GlcNAc");
                    galNacGlcNacMap.put("GlcNac", galNacGlcNacMap.get("GlcNac") + 1);
                } else {

                    list.add("GalNAc");
                    galNacGlcNacMap.put("GalNac", galNacGlcNacMap.get("GalNac") + 1);
                }

            }
        }
        int126.clear();
        int138.clear();
        int144.clear();
        int168.clear();
        values.clear();
        map.clear();


        return hexHexNAc;

    }

    public String HexHexNacStructure(double[][] dd) {

        String hexHexNAc = null;

        int n = 0;
        double[] mIntensity;
        double[] mMass = null;
        ArrayList<Double> values = new ArrayList();
        ArrayList<Double> testInt = new ArrayList();
        ArrayList<Double> testMass = new ArrayList();

        ArrayList<Double> int126 = new ArrayList();
        ArrayList<Double> int138 = new ArrayList();
        ArrayList<Double> int144 = new ArrayList();
        ArrayList<Double> int168 = new ArrayList();

        HashMap<String, Integer> galNacGlcNacMap = new HashMap();

        double[] hexNacIonSeries = GlycanData.getHexNacIonSeries();

        LinkedHashMap<Double, Double> map = new LinkedHashMap();

        if (dd[1].length >= 2) {

            RealMatrix Matrix = MatrixUtils.createRealMatrix(dd);
            mIntensity = Matrix.getRow(1);
            mMass = Matrix.getRow(0);

            for (int i = 0; i < mIntensity.length; i++) {

                double myMass = mMass[i];

                for (double ion : hexNacIonSeries) {
                    if (ion > myMass - 0.17 && ion < myMass + 0.17) {
                        if (ion == 126.0) {
                            int126.add(mIntensity[i]);
                        }
                        if (ion == 138.0) {
                            int138.add(mIntensity[i]);
                        }
                        if (ion == 144.0) {
                            int144.add(mIntensity[i]);
                        }
                        if (ion == 168.0) {
                            int168.add(mIntensity[i]);
                        }

                        map.put(ion, mIntensity[i]);
                        testInt.add(mIntensity[i]);
                        testMass.add(myMass);
                    }
                }

            }
        }

        ArrayList<String> list = new ArrayList();
        if (!map.isEmpty()) {
            Set<Double> keySet = map.keySet();
            int size = keySet.size();
            if (size >= 4) {
                for (Map.Entry<Double, Double> d : map.entrySet()) {
                    Double key = d.getKey();
                    Double value = d.getValue();
                    values.add(value);

                }

                double GGRatio = ((Collections.max(int138) + (Collections.max(int168))) / (Collections.max(int126) + (Collections.max(int144))));

                if (GGRatio > 1) { //ratio is dependent on energy levels of instrument

                    hexHexNAc = "GlcNAc";
                } else {

                    hexHexNAc = "GalNAc";
                }

            }
        }
        int126.clear();
        int138.clear();
        int144.clear();
        int168.clear();
        values.clear();
        map.clear();

        return hexHexNAc;

    }

}