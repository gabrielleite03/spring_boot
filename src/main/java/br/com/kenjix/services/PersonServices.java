package br.com.kenjix.services;

import br.com.kenjix.data.dto.v1.PersonDTO;
import br.com.kenjix.data.dto.v2.PersonDTOV2;
import br.com.kenjix.exception.ResourceNotFoundException;
import br.com.kenjix.mapper.custom.PersonMapper;
import br.com.kenjix.model.Person;
import br.com.kenjix.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static br.com.kenjix.mapper.ObjectMapper.parseListObjects;
import static br.com.kenjix.mapper.ObjectMapper.parseObject;

// É necessário para possibilitar a injeção onde necessário
@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personConverter;

    public List<PersonDTO> findAll() {

        logger.info("Finding all People!");

        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity, PersonDTO.class);
    }


    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {

        logger.info("Creating one Person!");
        var entity = personConverter.convertDTOtoEntity(person);
        return personConverter.convertEntityToDTO(personRepository.save(entity));

    }

    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}
