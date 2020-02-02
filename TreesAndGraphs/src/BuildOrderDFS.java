import java.util.*;

public class BuildOrderDFS {

    // DFS 
    public Deque<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    private Deque<Project> orderProjects(List<Project> projects) {
        Deque<Project> stack = new ArrayDeque<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!dfs(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    private boolean dfs(Project project, Deque<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false;
        }
        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            List<Project> children = project.getChildren();
            for (Project child : children) {
                if (!dfs(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.offerFirst(project);
        }
        return true;
    }

    static class Project {
        private List<Project> children = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies = 0;

        public Project(String n) {
            this.name = n;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }

        public void incrementDependencies() {
            dependencies++;
        }

        public void decrementDependencies() {
            dependencies--;
        }

        public String getName() {
            return this.name;
        }

        public List<Project> getChildren() {
            return children;
        }

        public int getNumberDependencies() {
            return dependencies;
        }

        public enum State {COMPLETE, PARTIAL, BLANK}

        ;
        private State state = State.BLANK;

        public State getState() {
            return this.state;
        }

        public void setState(State state) {
            this.state = state;
        }

    }

    static class Graph {
        private List<Project> nodes = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public List<Project> getNodes() {
            return nodes;
        }
    }
}
