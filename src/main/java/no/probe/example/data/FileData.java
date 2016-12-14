/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.data;

import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import com.compomics.util.experiment.massspectrometry.SpectrumFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import no.probe.example.graphics.FileReaderDialog;
import uk.ac.ebi.jmzml.xml.io.MzMLUnmarshallerException;

/**
 *
 * @author Probe This class stores the spectrum from the mgf file and stores
 * them in a arrayList and gets the amount of peaks.
 *
 */
public class FileData {

    public static int peaks = 0;
    public static int relevantPeaks = 0;
    public static ArrayList<double[]> mzValues = new ArrayList();
//    public static LinkedHashMap<double[], double[][]> spectraAndMzMap = new LinkedHashMap();

    SpectrumFactory spectrumFactory = SpectrumFactory.getInstance(100000);

    public static ArrayList<double[][]> spectraList = new ArrayList();

    MSnSpectrum spectrum;
    public static ArrayList<MSnSpectrum> glycoSpectrum = new ArrayList();
    public int nrOfSpectra = 0;

    public FileData() {

    }

    /**
     * 
     * 
     * @param selectedFile
     * @param fileName
     * @param threshold
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws MzMLUnmarshallerException 
     */
    public ArrayList<double[][]> GetSpectra(File selectedFile, String fileName, double threshold) throws IOException, FileNotFoundException, ClassNotFoundException, MzMLUnmarshallerException {

        nrOfSpectra = 0;
        
        
        HexHexNacSearch test = new HexHexNacSearch();
        ArrayList<String> mgfGlycanSpectra = new ArrayList();

        double[][] dd = null;
        System.out.println("threshold " + threshold);
        peaks = 0;
        relevantPeaks = 0;

        ArrayList<Double> intensity = new ArrayList();
        ArrayList<Double> masses = new ArrayList();

        ArrayList<double[][]> fileSpectra = new ArrayList();

        spectrumFactory.addSpectra(selectedFile);

  
        int nrOfSpectraWithGlycan = 0;

        for (String spectrumTitle : spectrumFactory.getSpectrumTitles(fileName)) {
            nrOfSpectra = nrOfSpectra + 1;

            spectrum = (MSnSpectrum) spectrumFactory.getSpectrum(fileName, spectrumTitle);
      

            String mgf = spectrum.asMgf();

            double[][] mzAndIntensity = spectrum.getMzAndIntensityAsArray();

            int length = mzAndIntensity[1].length;

            if (0 != length) {

                for (int i = 0; i < length; i++) {

//                    if (mzAndIntensity[0][i] >= 800) {// hardcoded variable for sorting out only the lowest part pf spectra
                    if (mzAndIntensity[1][i] >= threshold) {
                        intensity.add(mzAndIntensity[1][i]);
                        masses.add(mzAndIntensity[0][i]);

//                        }
                    }
                }

                dd = new double[2][intensity.size()];

                for (int j = 0; j < intensity.size(); j++) {
                    dd[1][j] = intensity.get(j);
                    dd[0][j] = masses.get(j);
                }

            }

            boolean hexHexNacSearch = test.HexHexNacSearch(dd);
            if (hexHexNacSearch == true) {

                fileSpectra.add(dd);
                nrOfSpectraWithGlycan = nrOfSpectraWithGlycan + 1;
                mgfGlycanSpectra.add(mgf);
                glycoSpectrum.add(spectrum);

            }

            intensity.clear();
            masses.clear();

        }
        System.out.println("nr of spectra = " + nrOfSpectra);
        System.out.println("nr of nr Of Spectra With Glycan = " + nrOfSpectraWithGlycan);

        Path file = Paths.get("C:\\Users\\Probe\\Documents\\GlycoMS\\GlycanSpectra.mgf");

        Files.write(file, mgfGlycanSpectra, Charset.forName("UTF-8"));

        return fileSpectra;
    }

    public ArrayList<MSnSpectrum> GetGlyCoSpectrum() {

        return glycoSpectrum;

    }

}
