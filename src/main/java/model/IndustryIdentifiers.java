package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryIdentifiers {
    private String identifier;

    /**
     * Class constructor
     */
    public IndustryIdentifiers(){}

    /**
     * Class constructor specifying identifier (ISBN number)
     * @param identifier
     */
    public IndustryIdentifiers(String identifier){
        this.identifier = identifier;
    }

    /**
     * @return identifier (ISBN number)
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
