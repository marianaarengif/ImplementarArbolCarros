/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import arbol.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Familia
 */
public class TreePanel<T extends Comparable<T>> extends JPanel{
   private Node<T> root;
    private final int nodeRadius = 30;
    private final int verticalSpacing = 80;
    private final Map<T, Color> nodeColors = new HashMap<>(); //mapa para guardar colores
    private final Random random = new Random();

    public TreePanel(Node<T> root) {
        this.root = root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
        assignColors(root); // Asignar colores a los nodos
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            int treeDepth = getTreeDepth(root);
            int panelWidth = getWidth();
            int initialSpacing = panelWidth / (int) Math.pow(2, treeDepth - 1);
            drawTree(g, root, panelWidth / 2, 50, initialSpacing);
        }
    }

    private void drawTree(Graphics g, Node<T> node, int x, int y, int spacing) {
        if (node == null) return;

        // Dibujar nodo con color único
        g.setColor(nodeColors.get(node.data));
        g.fillOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);

        // Dibujar texto centrado dentro del nodo
        g.setColor(Color.WHITE);
        String text = node.data.toString();
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        g.drawString(text, x - textWidth / 2, y + fm.getAscent() / 2);

        // Dibujar conexiones
        g.setColor(Color.BLACK);
        if (node.left != null) {
            int childX = x - spacing;
            int childY = y + verticalSpacing;
            g.drawLine(x, y + nodeRadius, childX, childY - nodeRadius);
            drawTree(g, node.left, childX, childY, spacing / 2);
        }
        if (node.right != null) {
            int childX = x + spacing;
            int childY = y + verticalSpacing;
            g.drawLine(x, y + nodeRadius, childX, childY - nodeRadius);
            drawTree(g, node.right, childX, childY, spacing / 2);
        }
    }

    // Asignar colores únicos a cada nodo
    private void assignColors(Node<T> node) {
        if (node == null) return;
        if (!nodeColors.containsKey(node.data)) {
            nodeColors.put(node.data, getRandomColor());
        }
        assignColors(node.left);
        assignColors(node.right);
    }

    // Generar un color aleatorio
    private Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    // Método para calcular la profundidad del árbol
    private int getTreeDepth(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right));
    }
    
    private int getTreeWidth(Node<T> node) {
        if (node == null) return 0;
        return 1 + getTreeWidth(node.left) + getTreeWidth(node.right);
    }
    
    // **Ajustar el tamaño del panel basado en la cantidad de nodos**
    private void updatePanelSize() {
        int depth = getTreeDepth(root);
        int width = Math.max(800, getTreeWidth(root) * (nodeRadius * 3)); // Asegurar espacio horizontal
        int height = depth * verticalSpacing + 100; // Asegurar espacio vertical

        setPreferredSize(new Dimension(width, height));
        revalidate(); // Forzar actualización de layout
}
}