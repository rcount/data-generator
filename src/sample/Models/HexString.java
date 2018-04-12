package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

/**
 * Public class to generate a random String in Hexadecimal.
 * That is a base 16 radix coasting of numbers 0-9 and letters A-F
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
public class HexString extends Tablable {

    //MARK: - Private attributes for the class -

    /**
     * Private static final int for the Default length of a HexString
     */
    private static final int DEFAULT_LENGTH = 16;

    /**
     * Private attribute to hold the length that a HexString should be
     */
    private int length = 0;

    //MARK: - Constructors for the class -

    /**
     * Public no arg constructor for the class
     */
    public HexString(){
        this(DEFAULT_LENGTH);
    }

    /**
     * Public one arg constructor for the class
     *
     * @param length    An {@code int} containing the length a HexString should be
     */
    public HexString(int length){
        this.setLength(length);
    }

    /**
     * Public two arg constructor for the class. This constructor will take a length min and length max
     * and create string of a random length between the two.
     *
     * @param lenMin    An {@code int} representing the minimum length we want a string to be
     * @param lenMax    An {@code int} representing the maximum length we want a string to be
     */
    public HexString(int lenMin, int lenMax){
        if(lenMin < lenMax){
            this.setLength(RandomGenerator.getInt(lenMin, lenMax));
        }else{
            this.setLength(RandomGenerator.getInt(lenMax, lenMin));
        }
    }

    /**
     * Public mutator for the {@link HexString#length} attribute.
     *
     * @param length    An {@code int} representing the length we want the HexString to be
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Public accessor for the {@link HexString#length} attribute.
     *
     * @return   An {@code int} containing the length we want the HexString to be
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Protected method to get a hex string of {@link HexString#length} characters long
     *
     * @return   A base 16 {@code String} of {@link HexString#length} characters long
     */
    protected String getHexString(){
        String output = "";

        for(int index = 0; index < this.getLength(); index++){
            output = output.concat(RandomGenerator.getHexDigit());
        }

        return output;
    }

    /**
     * Protected method to format the HexString. This method is used by {@link MacAddress} and
     * {@link IPv6} to get them formatted the correct way.
     *
     * @param hexString A {@code Sting} that we want for format
     * @param regex     A {@code String} containing the Regex for the format
     * @param pattern   A {@code String} containing the pattern for the Regex.
     * @return
     */
    protected String hexFormatter(String hexString, String regex, String pattern){
        return hexString.replaceAll(regex, pattern);
    }

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return  DataType.valueOf(this.getHexString());
    }
}
