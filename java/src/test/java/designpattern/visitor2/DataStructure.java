package designpattern.visitor2;

import java.io.IOException;

public interface DataStructure {
    void traverse(int type) throws IOException;
    void accept(Visitor visitor);
}
