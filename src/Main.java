public class Main {
    public static void main(String[] args) {
        Pistas pistas = new Pistas();

        for (int i = 1; i <= 4; i++) {
            new Vehiculo("Vehículo " + i, pistas).start();
        }
    }
}