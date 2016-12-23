package no.probe.example.graphics.components;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Model for a table.
 */
public class SaccharideTableModel extends DefaultTableModel {

    private ArrayList<Integer> hitsDifference;
    private ArrayList<String> names;
    private ArrayList<Double> saccharideMasses;
    private ArrayList<Double> percentHits;

    public SaccharideTableModel(ArrayList<Integer> hitsDifference, ArrayList<String> names, ArrayList<Double> saccharideMasses, ArrayList<Double> percentHits) {

        setUpTableModel(hitsDifference, names, saccharideMasses, percentHits);

    }

    public SaccharideTableModel() {

    }

    /**
     * Set up the table model.
     *
     * 
     *
     */
    private void setUpTableModel(ArrayList<Integer> hitsDifference, ArrayList<String> names, ArrayList<Double> saccharideMasses, ArrayList<Double> percentHits) {
        this.hitsDifference = hitsDifference;
        this.names = names;
        this.saccharideMasses = saccharideMasses;
        this.percentHits = percentHits;

    }

    @Override
    public int getRowCount() {

        if (names != null) {

            return names.size();
        } else {

            if (saccharideMasses != null) {

                return saccharideMasses.size();

            } else {

                if (hitsDifference != null) {

                    return hitsDifference.size();

                } else {

                    if (percentHits != null) {

                        return percentHits.size();
                    }
                    return 0;

                }

            }

        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Saccharide";

            case 1:

                return "Mass";

            case 2:
                return "Number of hits";

            case 3:
                return "Percent of Hits";

            default:
                return "";

        }
    }

    @Override
    public Object getValueAt(int row, int column) {

        try {

            Object hits = hitsDifference.get(row);
            String name =  names.get(row);
            Double vekta =  saccharideMasses.get(row);
            Double prosent =  percentHits.get(row);

            switch (column) {
                case 0:
                    return name;
                case 1:
                    return vekta;
                case 2:
                    return hits;
                case 3:
                    return prosent;
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
