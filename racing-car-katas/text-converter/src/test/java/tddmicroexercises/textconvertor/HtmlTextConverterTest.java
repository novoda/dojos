package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTextConverterTest {

    private static final String FILE_PATH = Thread.currentThread().getContextClassLoader().getResource("foo").toString();

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter(FILE_PATH);
        assertEquals(FILE_PATH, converter.getFilename());
    }
}
