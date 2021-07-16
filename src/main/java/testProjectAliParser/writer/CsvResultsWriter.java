package testProjectAliParser.writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class CsvResultsWriter implements ResultsWriter {

    @Override
    public void write(File file, JsonNode results) throws IOException {
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstNode = results.elements().next();
        firstNode.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(file, results);
    }
}
