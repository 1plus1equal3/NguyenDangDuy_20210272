package hust.soict.ICT.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength()>0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }else throw new PlayerException("ERROR: Track length is not positive!");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Track) return title.equals(((Track) obj).getTitle()) && length == ((Track) obj).getLength();
        else return false;
    }
}
