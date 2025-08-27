package br.com.kenjix.integrationtests.dto.wrappers.xmlandyaml;

import br.com.kenjix.integrationtests.dto.BookDTO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class PagedModelBook {

    @XmlElement(name = "_embedded")
    private List<BookDTO> content;

    public PagedModelBook() {
    }

    public List<BookDTO> getContent() {
        return content;
    }

    public void setContent(List<BookDTO> content) {
        this.content = content;
    }
}

