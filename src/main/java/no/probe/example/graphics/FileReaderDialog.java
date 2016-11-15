/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.graphics;

import com.compomics.util.experiment.massspectrometry.MSnSpectrum;
import com.compomics.util.gui.spectrum.ReferenceArea;
import com.compomics.util.gui.spectrum.SpectrumPanel;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.picking.PickedState;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import no.probe.example.graphics.components.GlycanTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import no.probe.example.calculation.ExtensiveGlycanSearch;
import no.probe.example.calculation.GlycanSearch;
import no.probe.example.calculation.Graph;
import no.probe.example.data.FileData;
import no.probe.example.data.GlycanData;
import no.probe.example.data.GlycanSearcherUtilities;
import no.probe.example.data.GraphOutputSearch;
import no.probe.example.data.OutputSearchData;
import no.probe.example.graphics.components.SaccharideTableModel;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.jgrapht.DirectedGraph;
import uk.ac.ebi.jmzml.xml.io.MzMLUnmarshallerException;

/**
 *
 * @author Probe
 */
public final class FileReaderDialog extends javax.swing.JDialog {

    public static String fileName;
    public static File selectedFile;

    public static double minValue;
    public static double maxValue;
    public static double sensitivity;
    public static double threshold;
    public static ArrayList<double[][]> spectraList;
    Label labelInfo;
//    public static ArrayList<double[]> spectraWithGlycan = new ArrayList();

    /**
     * Creates new form FileReader
     *
     * @param parent the parent
     */
    public FileReaderDialog(java.awt.Frame parent) {

        super(parent, true);
        initComponents();
        displayResults();
        setLocationRelativeTo(null);

    }

    public void displayResults() {

        // Populate the table
//        GlycanTableModel glycanTableModel = new GlycanTableModel();
//        table.setModel(glycanTableModel);
//        glycanTableModel.fireTableDataChanged();
//        SaccharideTableModel saccharideTableModel = new SaccharideTableModel();
//        jTable2.setModel(saccharideTableModel);
//        saccharideTableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFrame5 = new javax.swing.JFrame();
        jFrame6 = new javax.swing.JFrame();
        jToggleButton1 = new javax.swing.JToggleButton();
        findGlycanButton = new javax.swing.JButton();
        spectraPanel = new javax.swing.JPanel();
        graphPanel1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        minBox = new javax.swing.JComboBox();
        sensitivityBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        thresholdBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        fField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fileJLabal = new javax.swing.JLabel();
        open = new javax.swing.JButton();
        maxBox = new javax.swing.JComboBox();
        specField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        button1.setLabel("button1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame6Layout = new javax.swing.GroupLayout(jFrame6.getContentPane());
        jFrame6.getContentPane().setLayout(jFrame6Layout);
        jFrame6Layout.setHorizontalGroup(
            jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame6Layout.setVerticalGroup(
            jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToggleButton1.setText("Close");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        findGlycanButton.setText("Find Glycan");
        findGlycanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findGlycanButtonActionPerformed(evt);
            }
        });

        spectraPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Spectra"));
        spectraPanel.setLayout(new javax.swing.BoxLayout(spectraPanel, javax.swing.BoxLayout.LINE_AXIS));

        graphPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph"));
        graphPanel1.setLayout(new javax.swing.BoxLayout(graphPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dataset Properties"));

        jTable2.setModel(new SaccharideTableModel()

        );
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1547, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input and Settings"));

        minBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "100", "200", "300" }));

        sensitivityBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.01", "0.02", "0.03", "0.04", "0.05", "0.06", "0.07", "0.08", "0.09", "0.1", "10.0","0.001" }));
        sensitivityBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensitivityBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("MAX search value");

        jLabel4.setText("Sensitivity");

        thresholdBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "5", "10", "20","50","100","500","1000" }));
        thresholdBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("MIN search value");

        fField.setEditable(false);
        fField.setText("Please select a file");

        jLabel3.setText("Nr of spectra in file");

        fileJLabal.setText("File:");

        open.setText("open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        maxBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"20000", "10000 ", "1400", "1200", "800", "600" }));

        jLabel5.setText("Intensity Threshold");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minBox, 0, 919, Short.MAX_VALUE)
                            .addComponent(maxBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(sensitivityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thresholdBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(specField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(173, 173, 173))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fileJLabal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(open)
                    .addComponent(fileJLabal)
                    .addComponent(fField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(sensitivityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thresholdBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maxBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Spectra properties"));

        table.setModel(new GlycanTableModel());
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1523, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.getAccessibleContext().setAccessibleName("Spectra properties");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spectraPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findGlycanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spectraPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(graphPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findGlycanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        spectraPanel.getAccessibleContext().setAccessibleName("Spectra properties");
        jPanel1.getAccessibleContext().setAccessibleDescription("");
        jPanel3.getAccessibleContext().setAccessibleName("");
        jPanel3.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
// Loads file and reutrns an ArrayList containing the spectra

        JFileChooser chooser = new JFileChooser();

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            selectedFile = chooser.getSelectedFile();
            String filepath = chooser.getName(selectedFile);
            fField.setText(filepath);

            fileName = selectedFile.getName();
            System.out.println(fileName);

        }

    }//GEN-LAST:event_openActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void sensitivityBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensitivityBoxActionPerformed

    }//GEN-LAST:event_sensitivityBoxActionPerformed

    private void thresholdBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thresholdBoxActionPerformed

    /*
     findGlycanButton activates the difference search methode
     */
    private void findGlycanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findGlycanButtonActionPerformed

////        //Variables
////        double massMax = GlycanData.getMassMax();
////        threshold = Double.parseDouble(thresholdBox.getSelectedItem().toString());
////        sensitivity = Double.parseDouble(sensitivityBox.getSelectedItem().toString()); //search parameter
////        maxValue = Double.parseDouble(maxBox.getSelectedItem().toString());
////        minValue = Double.parseDouble(minBox.getSelectedItem().toString()); //search parameter
////        LinkedHashMap<String, Double> glycanMap = GlycanData.getMassGalMap();
////
////        try {
////
////            ExtensiveGlycanSearch extensiveGlycanSearch = new ExtensiveGlycanSearch();
////            OutputSearchData searchResults = new OutputSearchData();
////            FileData getData = new FileData();
////            GlycanSearch glycanSearch = new GlycanSearch();
////
////            spectraList = getData.GetSpectra(selectedFile, fileName, threshold);
////
////            LinkedHashMap<Double, Integer> runSearch = glycanSearch.runSearch(spectraList, massMax, glycanMap);
////
////            //SearchResults for glycanSarch
////            searchResults.OutputSearchData(runSearch);
////            ArrayList<Integer> hitsDifference = searchResults.GetHitsDifference();
////            ArrayList<String> names = searchResults.GetNames();
////            ArrayList<Double> saccharideMasses = searchResults.GetSaccharideMasses();
////            ArrayList<Double> percentHits = searchResults.GetPercentHits();
////
////            //Display result for glycanSearch
////            SaccharideTableModel saccharideTableModel = new SaccharideTableModel(hitsDifference, names, saccharideMasses, percentHits);
////            jTable2.setModel(saccharideTableModel);
////            saccharideTableModel.fireTableDataChanged();
////
////            //Search and build graphs
////            extensiveGlycanSearch.search(spectraList);
////
////            //SearchResults for ExtensiveGlycanSarch
////            GlycanTableModel glycanTableModel = new GlycanTableModel(spectraList);
////            table.setModel(glycanTableModel);
////            glycanTableModel.fireTableDataChanged();
////
//////             GraphOutputSearch getGraphs = new GraphOutputSearch();
//////            ArrayList<DirectedGraph<String, Graph.GlycoEdge>> graphs = getGraphs.GetGlycanGraph();
////        } catch (IOException ex) {
////            Logger.getLogger(FileReaderDialog.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (MzMLUnmarshallerException ex) {
////            Logger.getLogger(FileReaderDialog.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (ClassNotFoundException ex) {
////            Logger.getLogger(FileReaderDialog.class.getName()).log(Level.SEVERE, null, ex);
////        }
////
////
    }//GEN-LAST:event_findGlycanButtonActionPerformed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        GraphOutputSearch getGraphs = new GraphOutputSearch();
//        ArrayList<String> list = new ArrayList();
//        ArrayList<SpectrumAnnotation> annotations = new ArrayList<SpectrumAnnotation>();
        ArrayList<DirectedGraph<String, Graph.GlycoEdge>> graphs = getGraphs.GetGlycanGraph();
        GlycanSearcherUtilities check = new GlycanSearcherUtilities();
//        UndirectedSparseGraph VisualisationGraph = new UndirectedSparseGraph<String, String>();
        GlycoReferenceAreas reference = new GlycoReferenceAreas();
//        DefaultSpectrumAnnotation test = null;
//        ReferenceArea referenceArea = null;
         ArrayList<MSnSpectrum> mSnSpectrum = FileData.glycoSpectrum;

        ArrayList<double[][]> spectra = new ArrayList();
        HashMap<Double, String> distances = new HashMap<Double, String>();

        int selectedRow = table.getSelectedRow();
        for (double[][] i : spectraList) {// Fetching the mass values from the the hashmap

            spectra.add(i);
        }

        double[][] s = spectra.get(selectedRow);
        RealMatrix matrix = MatrixUtils.createRealMatrix(s);
        double[] intensity = matrix.getRow(1);
        double[] mz = matrix.getRow(0);

        SpectrumPanel spectrumPanel = new SpectrumPanel(mz, intensity, 0.0, "2", "fileName", 50, false, false, false, 2, false);
        spectrumPanel.setAnnotations(null);

        DirectedGraph<String, Graph.GlycoEdge> graph = graphs.get(selectedRow);

//        Set<String> vertexSet = graph.vertexSet();
//        Set<Graph.GlycoEdge> edgeSet = graph.edgeSet();

//        int counter = 0;

        HashSet glycoReferenceList = reference.GlycoReference(graph);

        UndirectedSparseGraph visualisationGraph = check.TranslateDirectGraph(graph);
        
//        ReferenceArea referenceArea = null;
        
        for(Object referenceArea : glycoReferenceList){
            
            spectrumPanel.addReferenceAreaXAxis((ReferenceArea) referenceArea);
            
        }

//        SpectrumPanel.setKnownMassDeltas(distances);
//        spectrumPanel.setAnnotations(annotations);
        
        VisualizationViewer<String, String> vv = new VisualizationViewer<String, String>(new FRLayout<String, String>(visualisationGraph),
                new Dimension(graphPanel1.getWidth() - 20, graphPanel1.getHeight() - 100));
        vv.setBackground(Color.WHITE);

//        annotations.add(test);
        
        // create the visualization viewer
//            VisualizationViewer<String, String> vv = new VisualizationViewer<String, String>(new FRLayout<String, String>(VisualisationGraph));
//                    new Dimension(graphPanel1.getWidth() - 20, graphPanel1.getHeight() - 100));
//            vv.setBackground(Color.WHITE);
            
//         set the vertex label transformer
        vv.getRenderContext().setVertexLabelTransformer(new Transformer<String, String>() {
            @Override
            public String transform(String arg0) {
                return arg0;
            }
        });

//         set the edge label transformer
//        vv.getRenderContext().setEdgeLabelTransformer(new Transformer<String, String>() {
//            @Override
//            public String transform(String arg0) {
//                return arg0;
//            }
//        });
//         set the vertex renderer
//////        vv.getRenderer().setVertexRenderer(new ProteinInferenceVertexRenderer());
        // set the edge label renderer
//        vv.getRenderer().setEdgeLabelRenderer(new BasicEdgeLabelRenderer<String, String>() {
//
//            @Override
//            public void labelEdge(RenderContext<String, String> rc, Layout<String, String> layout, String e, String label) {
//                // do nothing
//            }
//        });
////         set the vertex label renderer
//        vv.getRenderer().setVertexLabelRenderer(new BasicVertexLabelRenderer<String, String>() {
//
//            @Override
//            public void labelVertex(RenderContext<String, String> rc, Layout<String, String> layout, String v, String label) {
//                if (label.startsWith("132") && showPeptideLabels) {
//                    String fullTooltip = nodeToolTips.get(label);
//                    super.labelVertex(rc, layout, v, fullTooltip.substring(0, fullTooltip.indexOf("<br>")));
//                }
//                if (label.startsWith("Protein") && showProteinLabels) {
//                    super.labelVertex(rc, layout, v, label.substring(label.indexOf(" ") + 1));
//                }
//            }
//        });
//         set the edge format
//        vv.getRenderContext().setEdgeDrawPaintTransformer(edgePaint);
//        vv.getRenderContext().setEdgeStrokeTransformer(edgeStroke);
//         set the mouse interaction mode
        final DefaultModalGraphMouse<String, Number> graphMouse = new DefaultModalGraphMouse<String, Number>();
        graphMouse.setMode(ModalGraphMouse.Mode.PICKING);
        vv.setGraphMouse(graphMouse);
//        
        // add a key listener
//        vv.addKeyListener(new KeyAdapter() {

//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_A) {
//                    for (String tempNode : nodes) {
//                        visualizationViewer.getPickedVertexState().pick(tempNode, true);
//                    }
//                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//                    for (String tempNode : nodes) {
//                        visualizationViewer.getPickedVertexState().pick(tempNode, false);
//                    }
//                }
//                super.keyReleased(e);
//            }
//        }); 
        // set the vertex tooltips
//        vv.setVertexToolTipTransformer(
//                new ToStringLabeller<String>() {
//
//                    @Override
//                    public String transform(String v) {
//                        if (nodeToolTips != null && nodeToolTips.get(v) != null) {
//                            return super.transform(nodeToolTips.get(v));
//                        } else {
//                            return super.transform(v.substring(v.indexOf(" ") + 1));
//                        }
//                    }
//                }
//        );
//         attach the listener that will print when the vertices selection changes
        final PickedState<String> pickedState = vv.getPickedVertexState();
        pickedState.addItemListener(
                new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        Object subject = e.getItem();
                        if (subject instanceof String) {
                            String vertex = (String) subject;
                            if (pickedState.isPicked(vertex)) {
                                System.out.println("picked: " + vertex);
//                                if (!selectedNodes.contains(vertex)) {
//                                    selectedNodes.add(vertex);
//                                }
                            } else {
                                System.out.println("not picked: " + vertex);
//                                selectedNodes.remove(vertex);
                            }
                        }
                        //updateNodeSelection();
                    }
                }
        );
//        ScalingControl scaler = new CrossoverScalingControl();
//        scaler.scale(vv, 0.9f, vv.getCenter());

//        graphPanel.removeAll();
//        graphPanel.add(vv);
//        graphPanel.revalidate();
//        graphPanel.repaint();
//        PopupMenu spectrumGlycoAnnotations = null;
//        
//        
        graphPanel1.removeAll();

        graphPanel1.add(vv);

        graphPanel1.revalidate();

        graphPanel1.repaint();

        spectraPanel.removeAll();

        spectraPanel.add(spectrumPanel);

        spectraPanel.validate();

        spectraPanel.repaint();
    }//GEN-LAST:event_tableMouseReleased

//            public void paintVertex(RenderContext<String, String> rc, Layout<String, String> layout, String vertex) {
//            GraphicsDecorator graphicsContext = rc.getGraphicsContext();
//            Point2D center = layout.transform(vertex);
//            Shape shape = null;
//            Color color = null;
//
//            int alpha = 255;
//
//            // check if the node is selected or should be semi-transparent
//            if (!selectedNeighborNodes.isEmpty()) {
//                if (!selectedNeighborNodes.contains(vertex) && !selectedNodes.contains(vertex)) {
//                    alpha = 50;
//                }
//            } else {
//                if (!selectedNodes.contains(vertex)) {
//                    alpha = 50;
//                }
//}
//            }

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        tableMouseReleased(null);
    }//GEN-LAST:event_tableKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JTextField fField;
    private javax.swing.JLabel fileJLabal;
    private javax.swing.JButton findGlycanButton;
    private javax.swing.JPanel graphPanel1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JFrame jFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox maxBox;
    private javax.swing.JComboBox minBox;
    private javax.swing.JButton open;
    private javax.swing.JComboBox sensitivityBox;
    private javax.swing.JTextField specField;
    private javax.swing.JPanel spectraPanel;
    private javax.swing.JTable table;
    private javax.swing.JComboBox thresholdBox;
    // End of variables declaration//GEN-END:variables

}
