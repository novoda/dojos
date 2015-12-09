package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class HtmlPagesConverterTest {

    private static final String FILE_PATH = Thread.currentThread().getContextClassLoader().getResource("foo").toString();

    @Test
    public void foo() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter(FILE_PATH);
        assertEquals(FILE_PATH, converter.getFilename());
    }
}
