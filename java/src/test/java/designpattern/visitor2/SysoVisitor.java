package designpattern.visitor2;

public class SysoVisitor implements Visitor{
    private StringBuilder sb = new StringBuilder();
    @Override
    public String visit(String data) {
        sb.append(data);
        return null;
    }

    public void export(){
        System.out.println(sb.toString());
    }
}
