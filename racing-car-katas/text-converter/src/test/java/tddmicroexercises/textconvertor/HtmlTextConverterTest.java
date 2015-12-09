package tddmicroexercises.textconvertor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

    private static final String FILE_PATH = Thread.currentThread().getContextClassLoader().getResource("foo").toString();

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter(FILE_PATH);
        assertEquals(FILE_PATH, converter.getFilename());
    }
}
