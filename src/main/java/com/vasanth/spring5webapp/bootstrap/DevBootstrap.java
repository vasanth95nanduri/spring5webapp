package com.vasanth.spring5webapp.bootstrap;

import com.vasanth.spring5webapp.dao.AuthorRepository;
import com.vasanth.spring5webapp.dao.BookRepository;
import com.vasanth.spring5webapp.dao.PublisherRepository;
import com.vasanth.spring5webapp.model.Author;
import com.vasanth.spring5webapp.model.Book;
import com.vasanth.spring5webapp.model.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Himalaya Books");
        publisher.setAddress("India");

        publisherRepository.save(publisher);

        //Ram
        Author ram = new Author("Ram", "Nagar");
        Book sec = new Book("Second Road", "1234", publisher);
        ram.getBooks().add(sec);
        sec.getAuthors().add(ram);

        authorRepository.save(ram);
        bookRepository.save(sec);


        //sai
        Author sai = new Author("Sai", "Vasanth");
        Book nodeJs = new Book("Node JS for beginners", "24233", publisher);
        sai.getBooks().add(nodeJs);

        authorRepository.save(sai);
        bookRepository.save(nodeJs);

    }
}
