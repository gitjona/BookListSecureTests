package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import fi.haagahelia.course.domain.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest 
{
    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook()
    {
        List<Book> books = repository.findByTitle("Animal Farm");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Animal Farm");
    }
    
    @Test
    public void createNewBook() 
    {    	
    	Book book = new Book("Aku Ankka", "Ankkalinna", "123456-789", "2021", new Category("Category 4"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

	
}
