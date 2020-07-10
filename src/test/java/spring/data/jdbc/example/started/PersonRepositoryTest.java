package spring.data.jdbc.example.started;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person(null, "효혁", 26);
        personRepository.save(person);
        assertThat(person.getPersonId()).isNotNull();

        Person persistPerson = personRepository.findById(1L).get();
        assertThat(persistPerson).isEqualTo(person);

        person.setAge(27);
        personRepository.save(person);
        Person persistPersonOlder = personRepository.findById(1L).get();
        assertThat(persistPersonOlder.getAge()).isEqualTo(27);

        personRepository.delete(person);
        assertThat(personRepository.findAll()).hasSize(0);
    }
}
