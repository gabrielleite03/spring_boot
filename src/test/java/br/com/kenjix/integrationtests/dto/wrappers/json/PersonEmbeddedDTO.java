package br.com.kenjix.integrationtests.dto.wrappers.json;

import br.com.kenjix.integrationtests.dto.PersonDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class PersonEmbeddedDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "people")
    private List<PersonDTO> people;

    public PersonEmbeddedDTO() {
    }

    public List<PersonDTO> getPeople() {
        return people;
    }

    public void setPeople(List<PersonDTO> people) {
        this.people = people;
    }
}
