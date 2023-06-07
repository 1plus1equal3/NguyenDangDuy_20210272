package hust.soict.ICT.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media{

    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc() {
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Added " + track);
        }else System.out.println("Already have" + track);
    }

    public void removeTrack(Track track){
        if(tracks.remove(track)){
            System.out.println("Remove " + track + "successful");
        }else System.out.println("Unable to remove " + track);
    }

    public int getLength(){
        int length = 0;
        for(Track track: tracks) length+= track.getLength();
        return length;
    }
}
