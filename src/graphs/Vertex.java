package graphs;

import java.util.Objects;

public class Vertex {

    private final String label;
    private boolean visited;

    private Vertex previousVertex;

    public String getLabel() {
        return label;
    }

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public void setWasVisited(boolean wasVisited) {
        this.visited = wasVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }


}
