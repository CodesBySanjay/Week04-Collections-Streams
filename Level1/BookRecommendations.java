import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
}

public class BookRecommendations {
    public static List<List<BookRecommendation>> getRecommendations(List<Book> books) {
        List<BookRecommendation> filtered = books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted(Comparator.comparingDouble(b -> -b.rating))
            .limit(10)
            .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < filtered.size(); i += 5) {
            pages.add(filtered.subList(i, Math.min(i + 5, filtered.size())));
        }
        return pages;
    }
}
