package testProjectAliParser.writer;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

public interface ResultsWriter {

    void write(File file, JsonNode results) throws IOException;
}
