/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import arbol.*;
import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Familia
 */
public class TreePanel<T extends Comparable<T>> extends JPanel{
    private Node<T> root;
    private int nodeRadius = 62;
    private int horizontalSpacing = 200;
    private int verticalSpacing = 150;
    private int nodeCounter = 0;

    public TreePanel(Node<T> root) {
        this.root = root;
    }
    
    public void setRoot(Node<T> root){
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 70, horizontalSpacing);
        }
    }

    private void drawTree(Graphics g, Node<T> node, int x, int y, int spacing) {
        g.setColor(Color.BLUE);
        g.fillOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
        g.setColor(Color.WHITE);
        g.drawString(node.data.toString(), x - 62, y + 5);

        if (node.left != null) {
            int childX = x - spacing;
            int childY = y + verticalSpacing;
            g.setColor(Color.BLACK);
            g.drawLine(x, y + nodeRadius, childX, childY - nodeRadius);
            drawTree(g, node.left, childX, childY, spacing / 2);
        }

        if (node.right != null) {
            int childX = x + spacing;
            int childY = y + verticalSpacing;
            g.setColor(Color.BLACK);
            g.drawLine(x, y + nodeRadius, childX, childY - nodeRadius);
            drawTree(g, node.right, childX, childY, spacing / 2);
        }
    }
}
