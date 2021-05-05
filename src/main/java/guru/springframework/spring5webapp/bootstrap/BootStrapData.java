package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.pojo.Author;
import guru.springframework.spring5webapp.pojo.Book;
import guru.springframework.spring5webapp.pojo.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("James", "qu");
        Book book = new Book("first book", "ISBN756254");
        Publisher publisher = new Publisher("best publisher", "4611 viking way", "richmond", "bc", "v3z0h1");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        publisher.getBooks().add(book);
        book.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
