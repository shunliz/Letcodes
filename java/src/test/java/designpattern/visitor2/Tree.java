package designpattern.visitor2;




import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Tree implements DataStructure {
    private List<String> data = new LinkedList<>();
    private Visitor visitor;

    public Tree(){
        data.add("1");
        data.add("2");
        data.add("3");
    }

    @Override
    public void traverse(int type) throws IOException {
        for(String dt: data){
            visitor.visit(dt);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }
}
