package singleton;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

@Data
public class Test implements java.io.Serializable {

    private String name;
    private int age;
    private double a;
    private Test1 test1;

    public Test(String name, int age, double a) {
        this.name = name;
        this.age = age;
        this.a = a;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeOject");
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
        out.writeDouble(a);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readOject");
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age = in.readInt();//这样就跟write时的顺序一致了
        this.a = in.readDouble();
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("NoOject");
        this.name = "无名氏";
        this.age = 0;
        this.a = 99.9;
    }

//  @Override
//  public String toString() {
//    return this.name + "\t" + age + "\t" + a;
//  }

    public static void main(String[] args) {
        File tempfile = new File("d:/tmp/", "out.txt");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempfile));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tempfile));
            //)
            //{
            if (!tempfile.exists()) {
                tempfile.mkdirs();
                tempfile.createNewFile();
            }
            Test a = new Test("测试", 56, 4.5);
            Test1 test1 = new Test1("22");
            a.setTest1(test1);

            oos.writeObject(a);
            Test temp = (Test) ois.readObject();
            System.out.println(a);
            System.out.println(temp.getTest1().ss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}