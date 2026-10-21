class Pistas {
    // true = libre, false = ocupada
    private final boolean[] disponibles = {true, true};

    // Devuelve el índice de la pista (0 o 1) que se ha ocupado
    public synchronized int entrar() throws InterruptedException {
        while (true) {
            for (int i = 0; i < disponibles.length; i++) {
                if (disponibles[i]) {
                    disponibles[i] = false;
                    return i;
                }
            }
            wait(); // Ambas pistas ocupadas: esperar a que se libere alguna
        }
    }

    public synchronized void salir(int pista) {
        disponibles[pista] = true;
        notifyAll(); // Avisar a los vehículos que esperan
    }
}