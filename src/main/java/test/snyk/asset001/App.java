package test.snyk.asset001;

public class App {
    public void bad() throws Throwable {
        String data = System.getenv("DATA");
        Box<String> box = new Box<String>();
        box.set(data);

        Process process = Runtime.getRuntime().exec(box.get());
        process.waitFor();
    }

    public void good() throws Throwable {
        String data = "DATA";
        Box<String> box = new Box<String>();
        box.set(data);

        Process process = Runtime.getRuntime().exec(box.get());
        process.waitFor();
    }

    public static void main(String[] args) throws Throwable {
        (new App()).good();
        (new App()).bad();
    }
}
