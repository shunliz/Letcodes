package designpattern.visitor2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileVisitor implements Visitor{
    private FileWriter fileWriter = new FileWriter(new File("data.dat"));

    public FileVisitor() throws IOException {
    }

    @Override
    public String visit(String data) throws IOException {
        fileWriter.write(data);
        return null;
    }

    public void export(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
