package pairmatching.view;

public class IoPrinter {
    protected static final String DIVISION_HASH = "#############################################";

    protected void print(final Object message) {
        System.out.print(message);
    }

    protected void println(final Object message) {
        System.out.println(message);
    }

    protected void println() {
        this.println("");
    }


}
