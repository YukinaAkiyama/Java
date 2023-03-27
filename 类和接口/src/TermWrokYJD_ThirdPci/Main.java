package TermWrokYJD_ThirdPci;

public class Main {
    public static void main(String[] args) {
        NetworkCard networkCard = new NetworkCard();
        networkCard.print();
        networkCard.start();
        networkCard.stop();
        SoundCard soundCard  = new SoundCard();
        soundCard.print();
        soundCard.start();
        soundCard.stop();
        Graphics graphics = new Graphics();
        graphics.print();
        graphics.start();
        graphics.stop();
    }
}
