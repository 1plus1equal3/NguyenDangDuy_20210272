package hust.soict.ICT.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<>();
    public Book() {}

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Added " + authorName);
        }else System.out.println("Already have" + authorName);
    }

    public void removeAuthor(String authorName){
        if(authors.remove(authorName)){
            System.out.println("Remove " + authorName + "successful");
        }else System.out.println("Unable to remove " + authorName);
    }
}
