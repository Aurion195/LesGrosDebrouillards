/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legrosdebrouillard;

import TSPModel_PtiDeb.TSPModel_PtiDeb;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSinkDOT;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class TestGraph {


    public static void CreateGraph(){
        JFrame fenetre = new JFrame();

        JPanel panel = new JPanel();

        fenetre.setContentPane(panel);

        GridLayout grid = new GridLayout(2,1);
        panel.setLayout(grid);
        panel.setPreferredSize(new Dimension(1920,1080));


        fenetre.setTitle("Les ptits Débrouillards - GraphUI");
        fenetre.setSize(1920, 1080);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Observer o = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

            }
        };

        TSPModel_PtiDeb g = new TSPModel_PtiDeb(o);
        g.addPoint(0, 0,0);
        g.addPoint(1, 1,1);
        g.addPoint(2, 2,1);
        g.addPoint(3, 3,1);
        g.addPoint(4, 4,1);
        g.premierPoint(0);

        Graph G = new DefaultGraph("vue");
        Viewer viewer = new Viewer(G, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.disableAutoLayout();


        Viewer viewer2 = new Viewer(G, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer2.disableAutoLayout();


        G.addNode("1");
        G.addNode("2");
        G.addNode("3");
        G.addNode("4");
        G.addNode("5");

        Node n = G.getNode("1");
        n.setAttribute("xyz", 0,1,0);

        Node n1 = G.getNode("2");
        n1.setAttribute("xyz", 1,1,0);

        Node n2 = G.getNode("3");
        n2.setAttribute("xyz", 2,1,0);

        Node n3 = G.getNode("4");
        n3.setAttribute("xyz", 3,1,0);

        Node n4 = G.getNode("5");
        n4.setAttribute("xyz", 4,1,0);


        G.addAttribute("ui.quality");
        G.addAttribute("ui.antialias");

        ViewPanel view = viewer.addDefaultView(false);   // false indicates "no JFrame".
        ViewPanel view2 = viewer2.addDefaultView(false);


        panel.add("graph1", view);
        panel.add("graph2", view2);

        fenetre.setLocationRelativeTo(null);
        fenetre.pack();

        FileSinkDOT fs = new FileSinkDOT();
        try {
            fs.writeAll(G, "/home/antwan/file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
	// write your code here
        CreateGraph();
    }
}
