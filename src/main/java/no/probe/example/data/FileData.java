package no.probe.example.data;

import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import com.compomics.util.experiment.massspectrometry.SpectrumFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import uk.ac.ebi.jmzml.xml.io.MzMLUnmarshallerException;

/**
 *
 * Probe This class stores the spectrum from the mgf file and stores
 * them in a arrayList and gets the amount of peaks.
 *
 * @author Vegard Tveit
 * @author Joakim Kartveit
 *
 */
public class FileData {

    protected static int peaks = 0;
    private SpectrumFactory spectrumFactory = SpectrumFactory.getInstance(100000);
    public static ArrayList<MSnSpectrum> glycoSpectrum = new ArrayList<MSnSpectrum>();
    public int nrOfSpectra = 0;

    public FileData() {

    }

    public ArrayList<double[][]> GetSpectra(File selectedFile, String fileName, double threshold) throws IOException, ClassNotFoundException, MzMLUnmarshallerException, InterruptedException {

        Properties prop = new Properties();
        InputStream input = null;

        MSnSpectrum spectrum;
        int nrOfSpectra = 0;
        
        
        HexHexNacSearch test = new HexHexNacSearch();
        ArrayList<String> mgfGlycanSpectra = new ArrayList<String>();

        double[][] dd = null;
        System.out.println("threshold " + threshold);

        ArrayList<Double> intensity = new ArrayList<Double>();
        ArrayList<Double> masses = new ArrayList<Double>();

        ArrayList<double[][]> fileSpectra = new ArrayList<double[][]>();

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

                    if (mzAndIntensity[1][i] >= threshold) {
                        intensity.add(mzAndIntensity[1][i]);
                        masses.add(mzAndIntensity[0][i]);

                    }
                }

                dd = new double[2][intensity.size()];

                for (int j = 0; j < intensity.size(); j++) {
                    dd[1][j] = intensity.get(j);
                    dd[0][j] = masses.get(j);
                }

            }

            boolean hexHexNacSearch = test.HexHexNacSearch(dd);
            if (hexHexNacSearch) {

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



        try {

            input = new FileInputStream("GlycanSearcherVT.properties");

            // load a properties file
            prop.load(input);

            Path file = Paths.get(prop.getProperty("pathToGlycanSpectra.mgf"));

            Files.write(file, mgfGlycanSpectra, Charset.forName("UTF-8"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return fileSpectra;
    }

    public ArrayList<MSnSpectrum> GetGlyCoSpectrum() {

        return glycoSpectrum;

    }
}