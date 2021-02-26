package com.servers.webserver.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

/**
 * The Json class works with reading and writing Json using
 * an ObjectMapper. Parsed Json String into JsonNodes, which
 * are generic containers of elements inside a Json Stream which can
 * contain various fundamental types (integers, booleans, etc) and complex
 * types like objects and arrays. The JsonNodes are then converted
 * to the Configuration class which stores information the Json
 * provides. The class can also do the reverse, converting a
 * Configuration Object into a JsonNode. It can also the JsonNodes
 * back into a Json String.
 */
public class Json {

    // Provides functionality for reading and writing JSON
    // to and from Plain Old Java Objects or to and from
    // general-purpose JSON Tree Model, as well as related
    // functionality for performing conversions.
    private static ObjectMapper myObjectMapper = defaultObjectMapper();

    /**
     * Initializes an ObjectMapper for the class to utilize, configuring
     * its settings to fail when receiving unknown properties.
     * @return The configured ObjectMapper the class will utilize.
     */
    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    /**
     * Parses the Json stringand converts it into a JsonNode to be used in
     * the Configuration class for the Web Server.
     * @param JsonSrc The String to be converted into a Json Node.
     * @return JsonNode to used in the Configuration class.
     * @throws IOException
     */
    public static JsonNode parse(String JsonSrc) throws IOException {
        return myObjectMapper.readTree(JsonSrc);
    }

    /**
     * Parses the JSON string into an Object.
     * @param node The JSON source which is parsed into a JsonNode
     * @param clazz The Java Object (Configuration) to parse the Json
     *              into an instance of.
     * @param <A> The Generic in place of the unknown object return type
     *           as it can vary.
     * @return
     */
    public static <A> A FromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return myObjectMapper.treeToValue(node, clazz);
    }

    /**
     * Converts the Configuration Object into a JsonNode.
     * @param obj The desired class to be converted to. (Configuration)
     * @return Converted Json created from the Object Parameter.
     */
    public static JsonNode toJson(Object obj) {
        return myObjectMapper.valueToTree(obj);
    }


    /**
     * Driver method using the GenerateJson method to create a Json
     * String using a JsonNode or Object. This one is not pretty.
     * @param node The desired JsonNode to be converted into a Json String.
     * @return A Json String.
     * @throws JsonProcessingException
     */
    public static String stringify(JsonNode node) throws JsonProcessingException{
        return generateJson(node, false);
    }

    /**
     * Driver method using the GenerateJson method to create a Json
     * String using a JsonNode or Object. This one specifically stringifies
     * the object into a "pretty" structure.
     * @param node The desired JsonNode to be converted into a Json String.
     * @return A Json String.
     * @throws JsonProcessingException
     */
    public static String stringifyPretty(JsonNode node) throws JsonProcessingException{
        return generateJson(node, true);
    }

    /**
     * Converts JsonNode or any Object into a Json String.
     * @param e The Object to be converted into a Json String.
     * @param pretty Boolean stating whether or not to enable indentation
     *               for this generator, using a default pretty printer
     *               configured for ObjectMapper.
     * @return The desired Json String.
     * @throws JsonProcessingException
     */
    private static String generateJson(Object e, boolean pretty) throws JsonProcessingException{
        ObjectWriter objectWriter = myObjectMapper.writer();
        if(pretty){
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(e);
    }
}
