package tddmicroexercises.textconvertor;

import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

    private static final String FILE_PATH = Resources.getResource("foo").toString();

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter(FILE_PATH);
        assertEquals(FILE_PATH, converter.getFilename());
    }
    
}
