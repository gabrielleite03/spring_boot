package br.com.kenjix.file.importer.impl;

import br.com.kenjix.data.dto.PersonDTO;
import br.com.kenjix.file.importer.contract.FileImporter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvImporter implements FileImporter {

    @Override
    public List<PersonDTO> importFile(InputStream inputStream) throws Exception {// recebe o inputStream
        CSVFormat format = CSVFormat.Builder.create()// set a forma que trabalharemos com a planilha
                .setHeader() // adiciona o cabeçalho
                .setSkipHeaderRecord(true)// ignora a primeira linha
                .setIgnoreEmptyLines(true) // ignora linhas em branco
                .setTrim(true) // ignora espaços em branco
                .build();

        Iterable<CSVRecord> records = format.parse(new InputStreamReader(inputStream));// realiza o parse para itarable
        return parseRecordsToPersonDTOs(records);
    }

    private List<PersonDTO> parseRecordsToPersonDTOs(Iterable<CSVRecord> records) {
        List<PersonDTO> people = new ArrayList<>();

        for (CSVRecord record : records) {
            PersonDTO person = new PersonDTO();
            person.setFirstName(record.get("first_name"));
            person.setLastName(record.get("last_name"));
            person.setAddress(record.get("address"));
            person.setGender(record.get("gender"));
            person.setEnabled(true);
            people.add(person);
        }
        return people;
    }
}
