package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Vertex> vertixes = new ArrayList<>();
    private boolean[][] adjMat;

    private int size;

    public Graph (int maxVertexCount){
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label){
        Vertex vertex = new Vertex(label);
        vertixes.add(vertex);
        size++;
    }

    public void addEdge(String start, String finish){
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex==-1 || finishIndex == -1){
            throw new IllegalArgumentException("Invalid label in Vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;

    }

    private int indexOf(String label) {
        for (int i = 0; i<size; i++){
            if (vertixes.get(i).getLabel().equals(label)){
                return i;
            }
        }
        return -1;
    }

    public void addEdges (String start, String second, String... others){
        int startIndex = indexOf(start);
        addEdge(start,second);

        for (String other:others){
            if (indexOf(other)==-1){
                throw new IllegalArgumentException("Invalid label in Vertex");
            }
        }
        for (String other : others) {
            addEdge(start,other);
        }
    }

    public int getSize(){
        return size;
    }

    public void display(){
        for(int i=0; i<size; i++){
            System.out.print(vertixes.get(i));
            for (int j=0; j<size; j++){
                if (adjMat[i][j]){
                    System.out.print(" -> "+vertixes.get(j));
                }
            }
            System.out.println();
        }
    }



}
