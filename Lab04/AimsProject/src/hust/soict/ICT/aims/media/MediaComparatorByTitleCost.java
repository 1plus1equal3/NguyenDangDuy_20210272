package hust.soict.ICT.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

    @Override
    public Comparator<Media> thenComparing(Comparator<? super Media> other) {
        return Comparator.super.thenComparing(Media::getCost);
    }
}
