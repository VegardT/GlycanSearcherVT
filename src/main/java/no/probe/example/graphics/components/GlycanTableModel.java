package no.probe.example.graphics.components;

import com.compomics.util.experiment.massspectrometry.Charge;
import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import com.compomics.util.experiment.massspectrometry.Precursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import javax.swing.table.DefaultTableModel;
import no.probe.example.calculation.Graph;
import no.probe.example.data.FileData;
import no.probe.example.data.GlycanSearcherUtilities;
import no.probe.example.data.GraphOutputSearch;
import org.jgrapht.DirectedGraph;

/**
 * Model for a glycan table.
 */
public class GlycanTableModel extends DefaultTableModel {

    private ArrayList<Integer> NrOfVertexes = new ArrayList();

    private ArrayList<Integer> nrOfPeaks = new ArrayList();

    private ArrayList<Double> maxVertex = new ArrayList();

    private ArrayList<Double> maxList = new ArrayList();

    private ArrayList<ArrayList> nameList = new ArrayList();

    private ArrayList<String> spectrumTitles = new ArrayList();

    private ArrayList<Double> precursorMassList = new ArrayList();

    private ArrayList<Double> glycanMassList = new ArrayList();

    /**
     * Constructor
     *
     * @param spectraList
     *
     */
    public GlycanTableModel(ArrayList<double[][]> spectraList) throws InterruptedException {
        GlycanSearcherUtilities utilities = new GlycanSearcherUtilities();

        FileData glycoSpectrum = new FileData();
        ArrayList<MSnSpectrum> GlycoSpectrum = glycoSpectrum.GetGlyCoSpectrum();
        
        
        for (MSnSpectrum msn : GlycoSpectrum) {

            String spectrumTitle = msn.getSpectrumTitle();
            Precursor precursor = msn.getPrecursor();
            ArrayList<Charge> possibleCharges = precursor.getPossibleCharges();
            Charge charge = possibleCharges.get(0);
            double precursorMass = precursor.getMass(charge.value);

            double maxMz = msn.getMaxMz();
            double glycanMass =   precursorMass - maxMz;

            precursorMassList.add(precursorMass);
            spectrumTitles.add(spectrumTitle);
            maxList.add(maxMz);
            glycanMassList.add(glycanMass);

        }

        LinkedHashSet<String> verticeNames = new LinkedHashSet<String>();
        GraphOutputSearch getGraphs = new GraphOutputSearch();
        ArrayList<DirectedGraph<String, Graph.GlycoEdge>> graphs = getGraphs.GetGlycanGraph();
        ArrayList<String> listOfNames = new ArrayList<String>();

        for (DirectedGraph<String, Graph.GlycoEdge> g : graphs) {
            ArrayList<Double> massList = new ArrayList<Double>();
            int vertexes = g.vertexSet().size();
            ArrayList<String> list = new ArrayList<String>(g.vertexSet());
            for (String s : list) {
                String[] words = s.split("\\_");
                double GetTotalMass = utilities.GetTotalMass(s);

                massList.add(GetTotalMass);
                verticeNames.add(words[0]);
                listOfNames.add(words[0]);

            }

            if (!list.isEmpty()) {
                Double max = Collections.max(massList);

                maxVertex.add(max);

                NrOfVertexes.add(vertexes);

                ArrayList<String> nn = new ArrayList<String>(verticeNames);
                nameList.add(nn);
                verticeNames.clear();
            }
        }

        for (double[][] i : spectraList) {// Fetching the mass values from the the hashmap
            int peaks = i[0].length;

            nrOfPeaks.add(peaks);

        }
        LinkedHashSet<String> nameSet = new LinkedHashSet<String> ();
        for (String s : listOfNames) {
            nameSet.add(s);

        }

        setUpTableModel(NrOfVertexes, maxVertex, nrOfPeaks, maxList, nameList, spectrumTitles, precursorMassList, glycanMassList);

    }

    public GlycanTableModel() {

    }

    /**
     * Set up the table model.
     *
     * @param graphList
     *
     */
    private void setUpTableModel(ArrayList<Integer> NrOfVertexes, ArrayList<Double> maxVertex, ArrayList<Integer> nrOfPeaks, ArrayList<Double> maxList, ArrayList<ArrayList> nameList, ArrayList<String> spectrumTitles, ArrayList<Double> precursorMassList, ArrayList<Double> glycanMassList) {

        this.maxVertex = maxVertex;
        this.NrOfVertexes = NrOfVertexes;
        this.maxList = maxList;
        this.nrOfPeaks = nrOfPeaks;
        this.nameList = nameList;
        this.spectrumTitles = spectrumTitles;
        this.precursorMassList = precursorMassList;
        this.glycanMassList = glycanMassList;

    }

    @Override
    public int getRowCount() {

        if (maxVertex != null) {

            return maxVertex.size();
        } else {

            if (NrOfVertexes != null) {

                return NrOfVertexes.size();
            } else {
                if (maxList != null) {

                    return maxList.size();
                } else {

                    if (nrOfPeaks != null) {

                        return nrOfPeaks.size();

                    } else {

                        if (nameList != null) {

                            return nameList.size();

                        } else {

                            if (spectrumTitles != null) {

                                return spectrumTitles.size();
                            } else {

                                if (precursorMassList != null) {

                                    return precursorMassList.size();
                                } else {

                                    if (glycanMassList != null) {

                                        return glycanMassList.size();
                                    }
                                }

                                return 0;
                            }
                        }

                    }
                }
            }
        }
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {

            case 0:

                return "Spectrum title";
            case 1:

                return "Vertexes";
            case 2:

                return "Largest Mass";
            case 3:

                return "Largest found mass";
            case 4:

                return "Peaks";
            case 5:

                return "Saccharides";

            case 6:

                return "Precursor Mass";

            case 7:

                return "Glycan Mass";

        }
        return null;
    }

    @Override
    public Object getValueAt(int row, int column) {

        try {

            Integer vertexes = NrOfVertexes.get(row);
            Double max = maxList.get(row);
            Integer peaks = nrOfPeaks.get(row);
            Double mv = maxVertex.get(row);
            ArrayList name = nameList.get(row);
            String title = spectrumTitles.get(row);
            double precursor = precursorMassList.get(row);
            double glycanMass = glycanMassList.get(row);

            switch (column) {

                case 0:
                    return title;

                case 1:
                    return vertexes;

                case 2:
                    return max;

                case 3:

                    return mv;

                case 4:
                    return peaks;

                case 5:
                    return name;
                case 6:
                    return precursor;
                case 7:
                    return glycanMass;

                default:
                    return "";

            }
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        for (int i = 0; i < getRowCount(); i++) {
            if (getValueAt(i, columnIndex) != null) {
                return getValueAt(i, columnIndex).getClass();
            }
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
