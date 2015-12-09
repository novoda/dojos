package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {
    public static final String BREAK_LINE = "<br />";

//    private static final String FILE_PATH = Resources.getResource("foo").toString();

//    @Ignore // f*k the filesystem
//    @Test
//    public void foo() {
//        HtmlTextConverter converter = new HtmlTextConverter(FILE_PATH);
//        assertEquals(FILE_PATH, converter.getFilename());
//    }

    @Test
    public void givenAnyInput_thenItIsFollowedByABreakLine() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("not used");

        BufferedReader reader = new BufferedReader(new StringReader(" "));

        assertEquals(" " + BREAK_LINE, converter.convertToHtml(reader));
    }

    @Test
    public void givenAnAmplisand_thenItIsEncoded() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("not used");

        BufferedReader reader = new BufferedReader(new StringReader("&"));

        assertEquals(expect("&amp;"), converter.convertToHtml(reader));
    }

    private String expect(final String input) {
        return input + "<br />";
    }
}
