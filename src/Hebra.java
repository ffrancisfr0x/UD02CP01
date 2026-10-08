public class Hebra extends  Thread{
    private final char c;
    private final int veces;

    public Hebra(char c, int veces) {
        this.c = c;
        this.veces = veces;
    }

    @Override
    public void run() {
        for(int i = 0; i < veces; i++) {
            System.out.print(c);
        }
    }
}

