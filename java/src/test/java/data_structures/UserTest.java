package data_structures;

import java.io.*;
import java.util.Base64;

class UserTest implements Serializable {
    private static final long serialVersionUID = 23422342432L;
    private String name;
    private Integer age;
    private String address;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserTest test = new UserTest();

        test.age = 3;
        test.name = "zls";

        String serializedObj = serializeObjectToString(test);
/*        File file = new File("test.ser");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(serializedObj.getBytes());
        fos.close();*/

        byte[] bytes = new byte[serializedObj.getBytes().length];
        File file = new File("test.ser");
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);

        UserTest test2 = (UserTest) deSerializeObjectFromString(new String(bytes));
        System.out.println(test2.age);
        System.out.println(test2.name);
        System.out.println(test2.address);
    }

    public static String serializeObjectToString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();

        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public static Object deSerializeObjectFromString(String s)
            throws IOException, ClassNotFoundException {

        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

}
