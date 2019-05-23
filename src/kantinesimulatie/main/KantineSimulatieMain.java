package kantinesimulatie.main;

public class KantineSimulatieMain {

    private static final int DAGEN = 7;

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        KantineSimulatie simulatie = new KantineSimulatie();
        int dagen = args.length == 0 ? DAGEN : Integer.parseInt(args[0]);

        simulatie.simuleer(dagen);
    }

}
