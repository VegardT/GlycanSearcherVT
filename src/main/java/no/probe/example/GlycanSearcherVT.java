package no.probe.example;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import no.probe.example.graphics.FileReaderDialog;
import uk.ac.ebi.jmzml.xml.io.MzMLUnmarshallerException;

/**
 * @author Vegard Tveit
 * @author Joakim Kartveit
 */

public class GlycanSearcherVT {

    private FileReaderDialog dialog;

    public void StartGUI() throws IOException, ClassNotFoundException, MzMLUnmarshallerException {

        dialog = new FileReaderDialog(null);
        dialog.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileReaderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileReaderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileReaderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileReaderDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GlycanSearcherVT glycanSearcherVT = new GlycanSearcherVT();
                try {
                    glycanSearcherVT.StartGUI();
                } catch (IOException ex) {
                    Logger.getLogger(GlycanSearcherVT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GlycanSearcherVT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MzMLUnmarshallerException ex) {
                    Logger.getLogger(GlycanSearcherVT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}