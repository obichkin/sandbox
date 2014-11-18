package com.obichkin.algorythms1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Created by mobichkin on 10.11.14.
 */
public class Question3 {

    public static void main(String[] args) throws IOException {

        Graph g = new Graph();
/*        g.readGraph();
        g.contract();
        System.out.println(g);
        g.readGraph();
        System.out.println(g);
*/
        int min = 200;

        for(int i=0; i< 200*200; i++){
            g.readGraph();

            while(  g.getVertices().size() > 2){
                g.contract();
                //System.out.println(g.getVertices().size());
            }

            //System.out.println(g);

            if (g.getVertices().get(0).getEdges().size() == g.getVertices().get(1).getEdges().size()){
                int cur = g.getVertices().get(0).getEdges().size();
                if(cur<min){
                    min = cur;
                }
            }
            if(i%1000==0){
                System.out.println("Current min: " + min);
            }


        }

        System.out.println("Min: " + min);

    }






}
class Vertex {
    String label;
    LinkedList<String> edges;

    public Vertex(String label, LinkedList<String> edges) {
        this.label = label;
        this.edges = edges;
    }

    public void removeSelfLinks(){
        LinkedList<String> copy = (LinkedList<String>) edges.clone();
        for(String s : copy){
            if(s.equals(label)){
                edges.remove(s);
            }
        }
    }

    void addEdges(LinkedList<String> e){
        edges.addAll(e);
    }

    public String getLabel() {
        return label;
    }

    public LinkedList<String> getEdges() {
        return edges;
    }


    public void replaceLinks(String randomVertex, String newBaseVertex){
        for(int i=0; i< edges.size(); i++){
            if(edges.get(i).equals(randomVertex)){
                edges.set(i, newBaseVertex);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Vertex " + getLabel() + "\nEdges ");

        for(String edge:edges){
            result.append(edge);
            result.append(" : ");
        }
        result.append("\n");
        return result.toString();
    }
}

class Graph {

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Graph g\n");

        for(Vertex v : vertices){
            result.append( v );
        }

        return result.toString();
    }

    public Graph() {
        super();
        vertices = new LinkedList<Vertex>();
    }

    public void readGraph() throws IOException {
        vertices = new LinkedList<Vertex>();
        BufferedReader reader = new BufferedReader(new FileReader("kargerMinCut.txt"));
        String s;
        while((s=reader.readLine())!=null){
            String ss[] = s.split("\t");

            String label = ss[0];
            LinkedList<String> edges = new LinkedList<String>();

            for(int i=1; i<ss.length; i++){
                edges.add(ss[i]);
            }

            vertices.add( new Vertex(label, edges));

        }
    }


    public Vertex getVertex(String s){

        for(Vertex v:vertices){
            if(v.getLabel().equals(s)){
                return v;
            }
        }
        return null;
    }

    public Vertex getVertexByValue(Integer i){
        for(Vertex v:vertices){
            if(v.getLabel().equals(i)){
                return v;
            }
        }
        return null;
    }

    public void removeVertex(Vertex v){
        vertices.remove(v);
    }

    public LinkedList<Vertex> getVertices() {
        return vertices;
    }
    private LinkedList<Vertex> vertices;

    public void addVertex(Vertex v){
        vertices.add(v);
    }

    public void replaceVerticeLinks(String v1, String v2){
        for(Vertex v : vertices){
            v.replaceLinks(v1, v2);
        }
    }

    public void contract(){


        try{


            //System.out.println("Contracting Graph g");

            int rV = new Random().nextInt(getVertices().size());
            Vertex randomVertex = vertices.get(rV);

            int rE = new Random().nextInt(randomVertex.getEdges().size());

            String newBaseVertexLabel = randomVertex.edges.get(rE);
            Vertex newBaseVertex = getVertex( randomVertex.edges.get(rE) );

            //add  edges
            newBaseVertex.addEdges(randomVertex.getEdges());

            replaceVerticeLinks( randomVertex.getLabel(), newBaseVertex.getLabel());

            newBaseVertex.removeSelfLinks();

            //remove vertex
            removeVertex(randomVertex);

        }catch (Exception e){


            e.printStackTrace();
            System.exit(0);
        }

    }



}