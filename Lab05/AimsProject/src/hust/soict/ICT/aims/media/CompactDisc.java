package hust.soict.ICT.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Media implements Playable {

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

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added " + track);
        } else System.out.println("Already have" + track);
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Remove " + track + "successful");
        } else System.out.println("Unable to remove " + track);
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) length += track.getLength();
        return length;
    }

    @Override
    public void play() throws PlayerException{
        if(this.getLength()>0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            Iterator iter = tracks.iterator();
            Track nextTrack = null;
            while (iter.hasNext()){
                nextTrack = (Track) iter.next();
            }
            try{
                nextTrack.play();
            }catch (PlayerException e){
                throw e;
            }
        }else throw new PlayerException("ERROR: CD length is not positive!");
    }
}
