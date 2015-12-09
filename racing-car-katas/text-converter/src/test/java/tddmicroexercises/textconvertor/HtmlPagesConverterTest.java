package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class HtmlPagesConverterTest {

    private static final String FILE_PATH = Thread.currentThread().getContextClassLoader().getResource("foo").toString();

    @Test
    public void foo() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter(FILE_PATH);
        assertEquals(FILE_PATH, converter.getFilename());
    }
}
