package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {
        BufferedReader reader = readFileFromSystem();

        return convertToHtml(reader);
    }

    private BufferedReader readFileFromSystem() throws FileNotFoundException {
        return new BufferedReader(new FileReader(fullFilenameWithPath));
    }

    public String convertToHtml(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String html = "";
        while (line != null) {
            html += escapeHtml(line);
            line = reader.readLine();
        }
        return html;
    }

    private String escapeHtml(String input) {
        return StringEscapeUtils.escapeHtml(input) + "<br />";
    }

    public String getFilename() {
        return this.fullFilenameWithPath;
    }
}
