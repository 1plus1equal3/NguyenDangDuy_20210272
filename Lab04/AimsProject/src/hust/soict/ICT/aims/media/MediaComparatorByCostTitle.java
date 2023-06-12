package hust.soict.ICT.aims.media;

import java.util.Comparator;
import java.util.function.Function;

public class MediaComparatorByCostTitle implements Comparator<Media> {


    @Override
    public int compare(Media o1, Media o2) {
        if(o1.getCost()==o2.getCost()) return 0;
        else return o1.getCost() > o2.getCost() ? 1:-1;
    }

    @Override
    public Comparator<Media> thenComparing(Comparator<? super Media> other) {
        return Comparator.super.thenComparing(Media::getTitle);
    }
}
