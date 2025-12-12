import java.io.DataOutputStream;
import java.util.Random;

public class Produtor extends Thread {
    private DataOutputStream out;
    private Random rand = new Random();

    public Produtor(DataOutputStream out) {
        this.out = out;
    }

    public void run() {
        try {
            while (true) {
                double valor = rand.nextDouble(); // valor entre 0 e 1
                out.writeDouble(valor);
                out.flush();
                System.out.println("[Produtor] Produziu: " + valor);

                sleep(Math.abs(rand.nextInt() % 1000)); // entre 0 e 1 sec
            }
        } catch (Exception e) {
            System.out.println("Erro no Produtor: " + e.getMessage());
        }
    }
}

