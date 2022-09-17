package designpattern.visitor2;

import java.io.IOException;

public interface Visitor {
    String visit(String data) throws IOException;
}
