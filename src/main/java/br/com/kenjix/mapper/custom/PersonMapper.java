package br.com.kenjix.mapper.custom;

import br.com.kenjix.data.dto.PersonDTO;
import br.com.kenjix.data.dto.v2.PersonDTOV2;
import br.com.kenjix.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOtoEntity(PersonDTOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        // entity.setBirthDay(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }

    public  PersonDTO convertPersonToDTO(Optional<Person> person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.get().getId());
        dto.setFirstName(person.get().getFirstName());
        dto.setLastName(person.get().getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.get().getAddress());
        dto.setGender(person.get().getGender());
        dto.setEnabled(person.get().getEnabled());
        return dto;
    }
}