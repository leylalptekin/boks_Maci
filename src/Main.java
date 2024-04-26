public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("İsmail", 95, 100, 100, 75);
        Fighter f2 = new Fighter("Hakan", 85, 100, 95, 70);

        Match match = new Match(f1, f2, 70, 100);
        match.run();
    }
}
