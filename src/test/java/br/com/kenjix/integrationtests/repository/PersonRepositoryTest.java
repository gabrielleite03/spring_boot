package br.com.kenjix.integrationtests.repository;

import br.com.kenjix.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.kenjix.model.Person;
import br.com.kenjix.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static junit.framework.TestCase.*;

@ExtendWith(SpringExtension.class)
// Integra o Springframework com o Junit 5. Instrui o JUnit para carregar o contexto do Spring permitindo o uso de componets, beans e recursos configurados no Spring no ambiente de teste. É essencial para testes que dependem do SpringContext
@DataJpaTest()
// Configura o teste para trabalhar com JPA. Carrega apenas os componentes relacionados a camada de persistência como: repositorios, entidades e o contexto de banco de dados. Por padrão, ele usa um banco de dados embutido como por ex.: H2. Neste caso, será o usado TestContainers.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// Por padrao o DataJPATest substitui a configuração de banco de dados por um banco por um banco de dado embutido. Essa annotation desativa, garantido que o banco de dados real será utilizado.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)// Define a ordem de execução dos testes. É importante quando o estado de um teste depende de outro
class PersonRepositoryTest extends AbstractIntegrationTest {

    private static Person person;
    @Autowired
    PersonRepository personRepository;

    @BeforeAll
    static void setUp() {
        person = new Person();
    }

    @Test
    @Order(1)
    void disabledPerson() {
        Pageable pageable = PageRequest.of(0, 12, Sort.by(Sort.Direction.ASC, "firstName"));
        person = personRepository.findPeopleByName("iko", pageable).getContent().get(0);
        assertNotNull(person);
        assertNotNull(person.getId());
        assertEquals("Smiljan - Croatia", person.getAddress());
        assertEquals("Nikola", person.getFirstName());
        assertEquals("Tesla", person.getLastName());
        assertEquals("Male", person.getGender());
        assertTrue(person.getEnabled());
    }

    @Test
    @Order(2)
    void findPeopleByName() {
        Long id = person.getId();
        personRepository.disabledPerson(id);
        var result = personRepository.findById(id);
        person = result.get();
        assertNotNull(person);
        assertNotNull(person.getId());
        assertEquals("Smiljan - Croatia", person.getAddress());
        assertEquals("Nikola", person.getFirstName());
        assertEquals("Tesla", person.getLastName());
        assertEquals("Male", person.getGender());
        assertFalse(person.getEnabled());
    }
}