import java.io.DataInputStream;

public class Consumidor extends Thread {
    private DataInputStream in;

    public Consumidor(DataInputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            while (true) {
                double media = in.readDouble();
                System.out.println("[Consumidor] Média recebida: " + media);
            }
        } catch (Exception e) {
            System.out.println("Erro no Consumidor: " + e.getMessage());
        }
    }
}
