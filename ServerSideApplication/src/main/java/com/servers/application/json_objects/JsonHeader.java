package com.servers.application.json_objects;

public class JsonHeader {

    private String header;
    private String type;
    private String jsonBlock;


    // Getter Methods

    public String getHeader() {
        return header;
    }

    public String getType() {
        return type;
    }

    public String getJsonBlock() {
        return jsonBlock;
    }

    // Setter Methods

    public void setHeader(String header) {
        this.header = header;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setJsonBlock(String jsonBlock) {
        this.jsonBlock = jsonBlock;
    }

}
