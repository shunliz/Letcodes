package designpattern.visitor2;

import java.io.IOException;

public class Visitor2App {
    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();
        FileVisitor visitor = new FileVisitor();
        tree.accept(visitor);
        tree.traverse(1);
        visitor.export();
    }
}
