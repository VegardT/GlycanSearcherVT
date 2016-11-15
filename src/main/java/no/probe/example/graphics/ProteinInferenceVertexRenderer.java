/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.probe.example.graphics;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.probe.example.data.GlycanSearcherUtilities;
// Variables declaration - do not modify//GEN-BEGIN:variables

// End of variables declaration//GEN-END:variables
/**
 *
 * @author Probe
 */
class ProteinInferenceVertexRenderer implements Renderer.Vertex<String, String> {

    private ArrayList<String> selectedNeighborNodes = new ArrayList<String>();
    private ArrayList<String> selectedNodes = new ArrayList<String>();

    @Override
    public void paintVertex(RenderContext<String, String> rc, Layout<String, String> layout, String vertex) {
        Graphics g = new Graphics() {

            @Override
            public Graphics create() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void translate(int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Color getColor() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setColor(Color c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setPaintMode() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setXORMode(Color c1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Font getFont() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setFont(Font font) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Rectangle getClipBounds() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setClip(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Shape getClip() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setClip(Shape clip) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillRect(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clearRect(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawOval(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillOval(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawString(String str, int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        GraphicsDecorator graphicsContext = rc.getGraphicsContext();
        Point2D center = layout.transform(vertex);
        Shape shape = null;
        Color color = null;
        Shape shape2 = null;

        int alpha = 255;

//             check if the node is selected or should be semi-transparent
//            if (!selectedNeighborNodes.isEmpty()) {
//                if (!selectedNeighborNodes.contains(vertex) && !selectedNodes.contains(vertex)) {
//                    alpha = 50;
//                }
//            } else {
//                if (!selectedNodes.contains(vertex)) {
//                    alpha = 50;
//                }
//            }
//
//             draw a highlight to indicate the selected nodes
//            if (selectedNodes.contains(vertex) && highlightCheckBox.isSelected()) {
//                if (vertex.startsWith("Protein")) {
//                    shape = new Ellipse2D.Double(center.getX() - 22, center.getY() - 22, 44, 44);
//                } else if (vertex.startsWith("Peptide")) {
//                    shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);
//                }
//                graphicsContext.setPaint(Color.ORANGE);
//                graphicsContext.fill(shape);
//            }
//
//             draw a highlight indicating the validation or evidence level
//            boolean highlightAdded = false;
//            if (!nodeTypeRadioButton.isSelected()) {
//
//                if (nodeProperties.get(vertex) != null) {
//
//                    highlightAdded = true;
//                    String[] properties = nodeProperties.get(vertex).split("\\|");
//
//                    if (validationStatusRadioButton.isSelected()) {
//                        int validationLevel = Integer.parseInt(properties[0]);
//
//                        if (validationLevel == 0) { // not validated
//                            color = new Color(255, 0, 0, alpha);
//                        } else if (validationLevel == 1) { // doubtful
//                            color = new Color(255, 204, 0, alpha);
//                        } else if (validationLevel == 2) { // confident
//                            color = new Color(110, 196, 97, alpha);
//                        } else { // unknown...
//                            color = new Color(200, 200, 200, alpha);
//                        }
//                    } else if (properties.length > 1) {
//                        int evidenceLevel = Integer.parseInt(properties[1]);
//
//                        if (evidenceLevel == 1) { // protein
//                            color = new Color(110, 196, 97, alpha);
//                        } else if (evidenceLevel == 2) { // transcript
//                            color = new Color(255, 204, 0, alpha);
//                        } else if (evidenceLevel == 3) { // homology
//                            color = new Color(110, 196, 197, alpha);
//                        } else if (evidenceLevel == 4) { // predicted
//                            color = new Color(247, 53, 233, alpha);
//                        } else if (evidenceLevel == 5) { // uncertain
//                            color = new Color(255, 0, 0, alpha);
//                        } else { // unknown...
//                            color = new Color(200, 200, 200, alpha);
//                        }
//                    } else {
//                        color = new Color(200, 200, 200, alpha);
//                    }
//                }
//            }
//      p0.moveTo(0.0f, -s);
//      p0.lineTo(s, 0.0f);
//      p0.lineTo(0.0f, s);
//      p0.lineTo(-s, 0.0f);
//      p0.closePath();
        // draw the actual vertex
        GlycanSearcherUtilities names = new GlycanSearcherUtilities();
        String[] nameArray = names.GetNames(vertex);

        
        int i = nameArray.length;
        
        
        

        String name = nameArray[0];
        if(name.startsWith("tag")){
            name.substring(4);
            
        }
        
        String substring = name.substring(0, 5);
        
      
        
        
        
//       String name = nameArray[0].substring(0, Math.min(6, nameArray[0].length()));
//        String name = word.replaceAll("[^a-zA-Z0-9]", "");

        if (substring.equals("GalNA")) {
            shape = new Rectangle2D.Double(center.getX() - 18, center.getY() - 18, 20, 20);
//                if (!highlightAdded) {
            color = new Color(255, 255, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);
//                }
        } /*else if (substring.equals("GalN")) {
        shape = new Rectangle2D.Double(center.getX() - 18, center.getY() - 18, 20, 20);
        //                if (!highlightAdded) {
        color = new Color(255, 255, 0, alpha);
        
        graphicsContext.setPaint(color);
        
        graphicsContext.fill(shape);
        
        // draw a thin border around the vertex
        color = new Color(150, 150, 150, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);
        //                }
        }*/ else if (substring.equals("GlcNA")) {

            // trekant som peker nedover
            shape = new Rectangle2D.Double(center.getX() - 18, center.getY() - 18, 20, 20);
//                if (!highlightAdded) {
            color = new Color(0, 0, 255, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);
//                } 
        } /*else if (substring.equals("GlcN")) {
        
        // trekant som peker nedover
        shape = new Rectangle2D.Double(center.getX() - 18, center.getY() - 18, 20, 20);
        //                if (!highlightAdded) {
        color = new Color(0, 0, 255, alpha);
        
        graphicsContext.setPaint(color);
        
        graphicsContext.fill(shape);
        
        // draw a thin border around the vertex
        color = new Color(150, 150, 150, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);
        //                }
        }*/ else if (substring.equals("Fucos")) {

            // trekant som peker nedover
            shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX() + 10, (int) center.getX()},
                    new int[]{(int) center.getY() + 10, (int) center.getY() + 10, (int) center.getY() - 10},
                    3);

//                if (!highlightAdded) {
            color = new Color(255, 0, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);
//                } 
        } else if (substring.equals("Neu5A")) {
            // Diamant figur

            shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10, (int) center.getX()},
                    new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY(), (int) center.getY() - 10},
                    4);

//                if (!highlightAdded) {
            color = new Color(200, 0, 200, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } /*else if (name.equals("Neu5Ac+")) {
        // Diamant figur
        
        shape = new Polygon(
        new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10, (int) center.getX()},
        new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY(), (int) center.getY() - 10},
        4);
        
        //                if (!highlightAdded) {
        color = new Color(200, 0, 200, alpha);
        
        graphicsContext.setPaint(color);
        
        graphicsContext.fill(shape);
        
        // draw a thin border around the vertex
        color = new Color(150, 150, 150, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);
        
        }*/ else if (substring.equals("Neu5Ac - H2O")) {
            // Diamant figur

            shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10, (int) center.getX()},
                    new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY(), (int) center.getY() - 10},
                    4);

//                if (!highlightAdded) {
            color = new Color(200, 0, 200, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } else if (substring.equals("Xylos")) {

            shape = new Polygon(
                    new int[]{(int) center.getX(), (int) center.getX() + 4, (int) center.getX() + 12, (int) center.getX() + 6, (int) center.getX() + 10, (int) center.getX(), (int) center.getX() - 10, (int) center.getX() - 6, (int) center.getX() - 12, (int) center.getX() - 4},
                    new int[]{(int) center.getY() - 10, (int) center.getY() + -2, (int) center.getY() - 2, (int) center.getY() + 2, (int) center.getY() + 10, (int) center.getY() + 4, (int) center.getY() + 10, (int) center.getY() + 2, (int) center.getY() - 2, (int) center.getY() - 2},
                    10);

//                if (!highlightAdded) {
            color = new Color(255, 255, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        }/* else if (substring.equals("Hex-")) {
        
        shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);
        
        //                if (!highlightAdded) {
        color = new Color(255, 255, 0, alpha);
        
        graphicsContext.setPaint(color);
        
        graphicsContext.fill(shape);
        
        // draw a thin border around the vertex
        color = new Color(150, 150, 150, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);
        
        }*/ else if (substring.equals("Hexos")) {

            shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);

//                if (!highlightAdded) {
            color = new Color(255, 255, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } else if (name.equals("glc")) {

            shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX() + 10, (int) center.getX()},
                    new int[]{(int) center.getY() + 10, (int) center.getY() + 10, (int) center.getY() + 10},
                    3);

            color = new Color(0, 0, 255, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } else if (name.equals("GlcA")) {

            shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10},
                    new int[]{(int) center.getY(), (int) center.getY() - 10, (int) center.getY()},
                    3);
            color = new Color(0, 0, 255, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.fill(shape);

            color = new Color(0, 0, 0, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

            shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10},
                    new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY()},
                    3);

            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.fill(shape);

            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } else if (substring.equals("Manno")) {

            shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);

            color = new Color(0, 200, 50, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } else if (substring.equals("Gluco")) {

            shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);

            color = new Color(0, 200, 50, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } /*else if (substring.equals("Pept")) {
        
        shape = new Polygon(
        new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10},
        new int[]{(int) center.getY(), (int) center.getY() - 10, (int) center.getY()},
        3);
        color = new Color(0, 0, 255, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.fill(shape);
        
        color = new Color(0, 0, 0, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);
        
        shape = new Polygon(
        new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10},
        new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY()},
        3);
        
        color = new Color(150, 150, 150, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.fill(shape);
        
        color = new Color(150, 150, 150, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);
        
        }*/else if (name.equals("oxGal")) {
           shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);

//                if (!highlightAdded) {
            color = new Color(255, 255, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

       /* }/*else if (name.equals("HexNAc")) {
        // Diamant figur
        
        shape = new Rectangle2D.Double(center.getX() - 18, center.getY() - 18, 20, 20);
        //                if (!highlightAdded) {
        color = new Color(255, 255, 0, alpha);
        
        graphicsContext.setPaint(color);
        
        graphicsContext.fill(shape);
        
        // draw a thin border around the vertex
        color = new Color(255, 255, 255, alpha);
        graphicsContext.setPaint(color);
        graphicsContext.draw(shape);*/

        } else if (name.equals("tag-oxGal")) {
           shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);

//                if (!highlightAdded) {
            color = new Color(255, 255, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        }else if (name.equals("ox-Gal-HexNAc")) {
         shape = new Rectangle2D.Double(center.getX() - 18, center.getY() - 18, 20, 20);
//                if (!highlightAdded) {
            color = new Color(255, 255, 0, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        } else if (name.equals("tag-oxNeu5Ac [-H2O]")) {
                   shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10, (int) center.getX()},
                    new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY(), (int) center.getY() - 10},
                    4);

//                if (!highlightAdded) {
            color = new Color(200, 0, 200, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        }else if (name.equals("tag-oxNeu5Ac")) {
                   shape = new Polygon(
                    new int[]{(int) center.getX() - 10, (int) center.getX(), (int) center.getX() + 10, (int) center.getX()},
                    new int[]{(int) center.getY(), (int) center.getY() + 10, (int) center.getY(), (int) center.getY() - 10},
                    4);

//                if (!highlightAdded) {
            color = new Color(200, 0, 200, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);

        }
        else {
            shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);
            color = new Color(255, 255, 255, alpha);

            graphicsContext.setPaint(color);

            graphicsContext.fill(shape);

            // draw a thin border around the vertex
            color = new Color(150, 150, 150, alpha);
            graphicsContext.setPaint(color);
            graphicsContext.draw(shape);
        }

        // draw a thin border around the highlight
//            if (selectedNodes.contains(vertex) && highlightCheckBox.isSelected()) {
//
//                if (vertex.startsWith("Protein")) {
//                    shape = new Ellipse2D.Double(center.getX() - 22, center.getY() - 22, 44, 44);
//                } else if (vertex.startsWith("Peptide")) {
//                    shape = new Ellipse2D.Double(center.getX() - 14, center.getY() - 14, 28, 28);
//                }
//
//                color = new Color(150, 150, 150, alpha);
//                graphicsContext.setPaint(color);
//                graphicsContext.draw(shape);
//            }
    }
}

//    public ProteinInferenceVertexRenderer() {
//    }

