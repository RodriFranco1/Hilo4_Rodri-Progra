import java.util.Random;

class Vehiculo extends Thread {
    private final Pistas pistas;
    private final Random random = new Random();

    public Vehiculo(String nombre, Pistas pistas) {
        super(nombre);
        this.pistas = pistas;
    }

    @Override
    public void run() {
        try {
            int pista = pistas.entrar();
            System.out.println(getName() + " ha entrado en la pista " + (pista + 1) + ".");

            // Tiempo aleatorio entre 2 y 5 segundos
            long inicio = System.nanoTime();
            Thread.sleep(2000 + random.nextInt(3001));
            double segundos = (System.nanoTime() - inicio) / 1_000_000_000.0;

            System.out.printf("%s completó la prueba en %.3f segundos.%n", getName(), segundos);

            pistas.salir(pista);
            System.out.println(getName() + " ha salido de la pista " + (pista + 1) + ".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}