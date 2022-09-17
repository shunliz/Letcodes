package designpattern.builder2;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Builder2App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ComputerDirector director=new ComputerDirector();//1
        ComputerBuilder builder=new MacComputerBuilder("I5处理器","三星125");//2
        director.makeComputer(builder);//3
        Computer macComputer=builder.getComputer();//4
        System.out.println("mac computer:"+macComputer.toString());

        ComputerBuilder lenovoBuilder=new LenovoComputerBuilder("I7处理器","海力士222");
        director.makeComputer(lenovoBuilder);
        Computer lenovoComputer=lenovoBuilder.getComputer();
        System.out.println("lenovo computer:"+lenovoComputer.toString());

        StringBuilder sb;
        StringBuffer sbf;
        DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2=dFactory.newDocumentBuilder();
        Document doc;
        doc=builder2.parse(new File("src/Builder/config.xml"));
    }
}
