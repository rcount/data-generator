package sample.Models;

import sample.Models.Interfaces.Generatable;

/**
 * Public class to get a pseudorandomly generated Mac Address.
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
public class MacAddress  extends HexString {

    /**
     * Private static final {@code int} for the length of a MAC Address.
     * The addresses are 12 digits long and grouped as 6 2 digit {@code Hexadecimal} numbers
     *
     * <p>Example: {@code 8D:67:8B:21:18:47}</p>
     */
    private static final int MAC_DIGIT_COUNT = 12;

    /**
     * Private static final {@code String} to hold the regex for the output of the class
     */
    private static final String MAC_REGEX = ".{2}(?=.)";

    /**
     * Private static final {@code String} to hold the pattern for the regex of the class
     */
    private static final String MAC_PATTERN = "$0:";


    /**
     * Public no args constructor for the class
     */
    public MacAddress(){
        super(MAC_DIGIT_COUNT);
    }

    /**
     * Private method to get a pseudorandom MAC address, that is a group of 6 {@code Hexadecimal}
     * digits each between {@code 00} inclusive and {@code FF} inclusive
     *
     * <p>Example: {@code 8D:67:8B:21:18:47}</p>
     *
     * @return A {@code String} representing a pseudorandom MAC Address
     */
    private String getMacAddress(){
        String output = this.getHexString();

        return this.hexFormatter(output, MAC_REGEX, MAC_PATTERN);

    }

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return DataType.valueOf(this.getMacAddress());
    }
}
