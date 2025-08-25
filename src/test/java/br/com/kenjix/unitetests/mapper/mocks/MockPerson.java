package br.com.kenjix.unitetests.mapper.mocks;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.kenjix.data.dto.BookDTO;
import br.com.kenjix.data.dto.PersonDTO;
import br.com.kenjix.model.Book;
import br.com.kenjix.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public static class MockBook {


        public Book mockEntity() {
            return mockEntity(0);
        }

        public BookDTO mockDTO() {
            return mockDTO(0);
        }

        public List<Book> mockEntityList() {
            List<Book> books = new ArrayList<Book>();
            for (int i = 0; i < 14; i++) {
                books.add(mockEntity(i));
            }
            return books;
        }

        public List<BookDTO> mockDTOList() {
            List<BookDTO> books = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                books.add(mockDTO(i));
            }
            return books;
        }

        public Book mockEntity(Integer number) {
            Book book = new Book();
            book.setId(number.longValue());
            book.setAuthor("Some Author" + number);
            book.setLaunchDate(new Date());
            book.setPrice(25D);
            book.setTitle("Some Title" + number);
            return book;
        }

        public BookDTO mockDTO(Integer number) {
            BookDTO book = new BookDTO();
            book.setId(number.longValue());
            book.setAuthor("Some Author" + number);
            book.setLaunchDate(new Date());
            book.setPrice(25D);
            book.setTitle("Some Title" + number);
            return book;
        }

    }
}
