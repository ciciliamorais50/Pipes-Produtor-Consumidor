import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Filtro extends Thread {
    private DataInputStream in;
    private DataOutputStream out;

    private double total = 0;
    private int count = 0;

    public Filtro(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            while (true) {
                double valor = in.readDouble();
                total += valor;
                count++;

                double media = total / count;

                System.out.println("[Filtro] Média calculada: " + media);

                out.writeDouble(media);
                out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro no Filtro: " + e.getMessage());
        }
    }
}
