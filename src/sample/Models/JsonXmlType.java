package sample.Models;


import java.util.ArrayList;
import java.util.List;

/**
 * Public Class to convert a {@link Tablable} to a simpler way to deal with the data for a {@code .json} and {@code .xml} file
 *
 * <p>Copyright 2018 Stephen Vickers, Shane May
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author Stephen Vickers
 */
public class JsonXmlType {

    //MARK: - Private attributes for the class -

    /**
     * Private {@code String} to hold the name of the Column entered by the user.
     */
    private String columnName;

    /**
     * Private {@code int} to hold the amount of data we want to generate.
     */
    private transient int dataAmount = 0; //declared transient so it's not serialized in the Json file.

    /**
     * Private {@link Tablable} to hold the data type to create.
     */
    private transient Tablable dataType; //declared transient so it's not serialized in the Jason file.

    /**
     * Private {@link List} of {@code String}s to hold the data. Since every {@link Tablable} generates it's
     * data as a {@code String} we just use a List<String>.
     */
    private List<String> data = new ArrayList<>();

    //MARK: - Constructors for the class -

    /**
     * Public constructor for the class
     *
     * @param dataType  A {@link Tablable} data type we want to turn into Json or XML.
     * @param amount    An {@link int} containing the amount of data points to create
     */
    public JsonXmlType(Tablable dataType, int amount){
        this.setColumnName(dataType.getColumnName());
        this.setDataType(dataType);
        this.setDataAmount(amount);
        this.generateData();
    }

    //MARK: - Public methods for the class -

    /**
     * Public mutator for the {@link JsonXmlType#columnName} attribute.
     *
     * @param columnName    A {@code String} containing the name of the column.
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Public mutator for the {@link JsonXmlType#dataAmount} attribute.
     *
     * @param dataAmount    A {@code int} containing the amount of data to generate.
     */
    public void setDataAmount(int dataAmount) {
        this.dataAmount = dataAmount;
    }

    /**
     * Public mutator for the {@link JsonXmlType#dataType} attribute.
     *
     * @param dataType  A {@link Tablable} instance that we want to generate data for.
     */
    public void setDataType(Tablable dataType) {
        this.dataType = dataType;
    }

    /**
     * Public accessor for the {@link JsonXmlType#columnName} attribute.
     *
     * @return  A {@code String} containing the name of the column for the type
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Public accessor for the {@link JsonXmlType#dataAmount} attribute.
     *
     * @return  A {@code String} containing the amount of data we want to generate
     */
    public int getDataAmount() {
        return dataAmount;
    }

    /**
     * Public accessor for the {@link JsonXmlType#dataType} attribute.
     *
     * @return  A {@link Tablable} type that we generate data for.
     */
    public Tablable getDataType() {
        return dataType;
    }

    /**
     * Public accessor for the {@link JsonXmlType#data} attribute.
     *
     * @return A {@link List} of {@code String}s with the data we generated
     */
    public List<String> getData() {
        return this.data;
    }

    //MARK: - Private methods for the class -

    /**
     * Private method to load the generated data into the {@link JsonXmlType#data} List.
     */
    private void generateData(){

        for(int index = 0; index < this.getDataAmount(); index++){
            this.getData().add(this.getDataType().generate().toString());
        }
    }
}
