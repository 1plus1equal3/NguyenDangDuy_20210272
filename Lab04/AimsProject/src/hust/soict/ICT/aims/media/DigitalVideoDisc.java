package hust.soict.ICT.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
    }

    public String toString() {
        return this.getId() + ". "
                + this.getTitle() + " - "
                + this.getCategory() + " - "
                + this.getDirector() + " - "
                + this.getLength() + ": "
                + this.getCost() + "$\n";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

