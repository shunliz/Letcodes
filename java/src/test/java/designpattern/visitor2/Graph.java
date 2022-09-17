package designpattern.visitor2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Graph implements DataStructure{
    private List<String> nodes = new LinkedList<>();
    private Visitor visitor;

    public Graph(){
        nodes.add("1");
        nodes.add("2");
    }

    @Override
    public void traverse(int type) throws IOException {
        for(String dat : nodes){
            visitor.visit(dat);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }
}
