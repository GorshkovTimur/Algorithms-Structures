package graphs;

import java.util.*;

public class Graph {

    private final List<Vertex> vertixes = new ArrayList<>();
    private boolean[][] adjMat;

    private int size;

    public Graph(int maxVertexCount) {
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        vertixes.add(vertex);
        size++;
    }

    public void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label in Vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;

    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertixes.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public void addEdges(String start, String second, String... others) {
        int startIndex = indexOf(start);
        addEdge(start, second);

        for (String other : others) {
            if (indexOf(other) == -1) {
                throw new IllegalArgumentException("Invalid label in Vertex");
            }
        }
        for (String other : others) {
            addEdge(start, other);
        }
    }

    public int getSize() {
        return size;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertixes.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertixes.get(j));
                }
            }
            System.out.println();
        }
    }

    public void dfs(String startLabel) {
        if (indexOf(startLabel) == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertixes.get(indexOf(startLabel));
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertixes.get(i).setWasVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertixes.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && !vertixes.get(i).isVisited()) {
                return vertixes.get(i);
            }


        }

        return null;
    }

    private void visitVertex(Stack<Vertex> queue, Vertex vertex) {
        displayVertex(vertex);
        vertex.setWasVisited(true);
        queue.push(vertex);

    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        vertex.setWasVisited(true);
        stack.add(vertex);

    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void bfs(String startLabel) {
        if (indexOf(startLabel) == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Vertex vertex = vertixes.get(indexOf(startLabel));

        Queue<Vertex> queue = new LinkedList<>();
        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
            resetVertexState();

        }
    }

    public Stack<String> getShortPath(String startLabel, String finishLabel){
        int start = indexOf(startLabel);
        int finish = indexOf(finishLabel);

        if (start == -1 || finish == -1){
            throw new IllegalArgumentException("Check your start and finish");
        }

        Vertex vertex = vertixes.get(start);

        Queue<Vertex> queue = new ArrayDeque<>();
        visitVertex(queue, vertex);

        while (!queue.isEmpty()){
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            }
            else {
                visitVertex(queue,vertex);
                vertex.setPreviousVertex(queue.peek());

                if (vertex.getLabel().equals(finishLabel)) {
                    return buildPath(vertex);
                }

            }
        }
        resetVertexState();
        return null;
    }


    private Stack<String> buildPath(Vertex vertex) {
        Stack<String> stack = new Stack<>();
        Vertex current = vertex;
        while( current!= null){
            stack.push(current.getLabel());
            current = current.getPreviousVertex();
        }
        return stack;
    }

}


