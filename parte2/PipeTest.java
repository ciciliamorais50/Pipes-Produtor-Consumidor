import java.io.*;

public class PipeTest {

    public static void main(String[] args) throws Exception {

        // Pipe 1: Produtor -> Filtro
        PipedOutputStream pout1 = new PipedOutputStream();
        PipedInputStream pin1 = new PipedInputStream(pout1);

        // Pipe 2: Filtro -> Consumidor
        PipedOutputStream pout2 = new PipedOutputStream();
        PipedInputStream pin2 = new PipedInputStream(pout2);

        Produtor produtor = new Produtor(new DataOutputStream(pout1));
        Filtro filtro = new Filtro(new DataInputStream(pin1), new DataOutputStream(pout2));
        Consumidor consumidor = new Consumidor(new DataInputStream(pin2));

        produtor.start();
        filtro.start();
        consumidor.start();
    }
}
