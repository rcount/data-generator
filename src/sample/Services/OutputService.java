package sample.Services;

import java.util.*;

public class OutputService {

    private Map<Integer, String> generatableTypes = new TreeMap<>();

    private ResourceBundle resources = ResourceBundle.getBundle(ResourceNames.RESOURCE_BUNDLE);

    public OutputService(){
        this.generatableTypes.put(GeneratableFactory.BINARY, this.resources.getString(ResourceNames.DataTypes.BINARY));
        this.generatableTypes.put(GeneratableFactory.HEXADECIMAL, this.resources.getString(ResourceNames.DataTypes.HEXADECIMAL));
        this.generatableTypes.put(GeneratableFactory.OCTAL, this.resources.getString(ResourceNames.DataTypes.OCTAL));
        this.generatableTypes.put(GeneratableFactory.NUMBER_DATA, this.resources.getString(ResourceNames.DataTypes.NUMBER_VALUE));
        this.generatableTypes.put(GeneratableFactory.IPV4, this.resources.getString(ResourceNames.DataTypes.IPV4));
        this.generatableTypes.put(GeneratableFactory.IPV6, this.resources.getString(ResourceNames.DataTypes.IPV6));
        this.generatableTypes.put(GeneratableFactory.MAC_ADDRESS, this.resources.getString(ResourceNames.DataTypes.MAC_ADDRESS));
        this.generatableTypes.put(GeneratableFactory.ISBN_10, this.resources.getString(ResourceNames.DataTypes.ISBN_10));
        this.generatableTypes.put(GeneratableFactory.ISBN_13, this.resources.getString(ResourceNames.DataTypes.ISBN_13));
        this.generatableTypes.put(GeneratableFactory.UPC, this.resources.getString(ResourceNames.DataTypes.UPC));
        this.generatableTypes.put(GeneratableFactory.LATITUDE, this.resources.getString(ResourceNames.DataTypes.LATITUDE));
        this.generatableTypes.put(GeneratableFactory.LONGITUDE, this.resources.getString(ResourceNames.DataTypes.LONGITUDE));
        this.generatableTypes.put(GeneratableFactory.FIRST_NAME, this.resources.getString(ResourceNames.DataTypes.FIRST_NAME));
        this.generatableTypes.put(GeneratableFactory.MIDDLE_NAME, this.resources.getString(ResourceNames.DataTypes.MIDDLE_NAME));
        this.generatableTypes.put(GeneratableFactory.LAST_NAME, this.resources.getString(ResourceNames.DataTypes.LAST_NAME));
        this.generatableTypes.put(GeneratableFactory.GENDER, this.resources.getString(ResourceNames.DataTypes.GENDER));
        this.generatableTypes.put(GeneratableFactory.HEX_STRING, this.resources.getString(ResourceNames.DataTypes.HEX_STRING));
        this.generatableTypes.put(GeneratableFactory.CURRENCY, this.resources.getString(ResourceNames.DataTypes.CURRENCY));
        this.generatableTypes.put(GeneratableFactory.GUID, this.resources.getString(ResourceNames.DataTypes.GUID_UUID));
        this.generatableTypes.put(GeneratableFactory.BOOLEAN, this.resources.getString(ResourceNames.DataTypes.DATA_BOOL));
    }

    public Map<Integer, String> getGeneratableTypes(){
        return this.generatableTypes;
    }
}
