package sample.Models;

import com.google.gson.annotations.Expose;
import sample.Models.Interfaces.Generatable;

import java.util.Objects;

/**
 * Public class to access a "DataType" for the output to a file.
 * This class is essentially a wrapper for {@link String} but it gives us a single type to output to a file.
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
public class DataType {

    //MARK: - Private attributes for the class -

    /**
     * Private static final {@link String} to hold an empty string.
     * This is used if null data is passed to the class, that way
     * we don't try to return, or print {@code null} data.
     */
    private static final String EMPTY = "";

    /**
     * Private {@link String} to hold the data passed into the class.
     */
    private String value = "";

    /**
     * Public one arg constructor for the {@code DataType} class.
     *
     * @param value     A {@link String} containing the data for the class.
     */
    public DataType(String value){
        this.setValue(value == null ? EMPTY : value);
    }

    //MARK: - Public methods for the class -

    /**
     * Public static method to get a new {@code DataType} instance with the Value passed to it.
     *
     * @param value     A {@link String} containing the Data for the instance
     * @return          A new {@code DataType} containing the {@code value} passed into it.
     */
    public static DataType valueOf(String value){
        return new DataType(value);
    }

    /**
     * Public static method to get a new {@code DataType} instance with the Value passed to it.
     *
     * @param value     A {@code int} containing the Data for the instance
     * @return          A new {@code DataType} containing the {@code value} passed into it.
     */
    public static DataType valueOf(int value){
        return DataType.valueOf(String.valueOf(value));
    }

    /**
     * Public static method to get a new {@code DataType} instance with the Value passed to it.
     *
     * @param value     A {@code double} containing the Data for the instance
     * @return          A new {@code DataType} containing the {@code value} passed into it.
     */
    public static DataType valueOf(double value){
        return  DataType.valueOf(String.valueOf(value));
    }

    /**
     * Public static method to get a new {@code DataType} instance with the Value passed to it.
     *
     * @param value     A {@link Object} containing the Data for the instance
     * @return          A new {@code DataType} containing the {@code value} passed into it.
     */
    public static DataType valueOf(Object value){
        return DataType.valueOf(value == null ? EMPTY : value.toString());
    }

    //MARK: - Private methods for the class -

    /**
     * Private mutator for the {@link DataType#value} attribute.
     *
     * @param value A {@link String} containing the data for the instance.
     */
    private void setValue(String value) {
        this.value = value;
    }

    /**
     * Private accessor for the {@link DataType#value} attribute.
     *
     * @return  A {@link String} containing the data for the instance.
     */
    private String getValue() {
        return this.value;
    }

    //MARK: - Override of the Object methods for the class -

    /**
     * Public override of the {@link Object#hashCode()} method for the {@code DataType} class.
     *
     * @return  A {@code int} representation of the {@link DataType#value}.
     */
    @Override
    public int hashCode() {
        return this.getValue().hashCode();
    }

    /**
     * Public override of the {@link Object#equals(Object)} method for the {@code DataType} class.
     *
     * @param obj   An {@link Object} that we want to compare to the instance.
     * @return      A {@code boolean} for whether or not the {@code obj} is equal to the calling instance,
     *              {@code true} if it is, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(!(obj instanceof DataType)) return false;

        DataType other = (DataType) obj;
        return Objects.equals(this.getValue(), other.getValue());
    }

    /**
     * Public override of the {@link Object#toString()} method for the {@code DataType} class.
     *
     * @return  A {@link String} containing the {@link DataType#value}.
     */
    @Override
    public String toString() {
        return this.getValue();
    }
}
