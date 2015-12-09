package tddmicroexercises.textconvertor;

import com.google.common.io.Resources;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class HtmlPagesConverterTest {

    private static final String FILE_PATH = Resources.getResource("foo").toString();

    @Ignore // this is a follow-up exercise, let's ignore the test for now
    @Test
    public void foo() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter(FILE_PATH);
        assertEquals(FILE_PATH, converter.getFilename());
    }
}
