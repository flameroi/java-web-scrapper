package testProjectAliParser;

import com.fasterxml.jackson.databind.JsonNode;
import testProjectAliParser.parser.Parser;
import testProjectAliParser.writer.ResultsWriter;

import java.io.File;
import java.io.IOException;

public class Scraper {

    private Parser parser;

    private ResultsWriter resultsWriter;

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setWriter(ResultsWriter resultsWriter) {
        this.resultsWriter = resultsWriter;
    }

    public void scrap(File file) throws IOException {
        JsonNode results = this.parser.parse();
        this.resultsWriter.write(file, results);
    }
}
