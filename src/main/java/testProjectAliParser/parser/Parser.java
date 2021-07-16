package testProjectAliParser.parser;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface Parser {

    JsonNode parse() throws IOException;
}
