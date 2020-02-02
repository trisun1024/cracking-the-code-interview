import java.util.*;

public class BuildOrder {

    // You are given a list of projects and a list of dependencies. All of a project's dependencies must be
    // built before the project is. Find a build order that will allow the projects to be built. If there
    // is no valid build order, return an error

    public Project[] findBuildOrder(String[] projects, String[][] dependencies) {
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

    private Project[] orderProjects(List<Project> projects) {
        Project[] order = new Project[projects.size()];
        int endOfList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            if (current == null) {
                return null;
            }
            List<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    private int addNonDependent(Project[] order, List<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
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
    }



}
