package testProjectAliParser;

import testProjectAliParser.parser.ali.AliParser;
import testProjectAliParser.writer.CsvResultsWriter;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Scraper scraper = new Scraper();
        scraper.setParser(new AliParser());
        scraper.setWriter(new CsvResultsWriter());
        scraper.scrap(new File("test.csv"));
    }
}