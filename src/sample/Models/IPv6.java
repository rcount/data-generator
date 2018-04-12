package sample.Models;

import sample.Models.Interfaces.Generatable;

/**
 * Public class to get a pseudorandomly generated IPv6 number.
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
public class IPv6 extends HexString{

    //MARK: - Private attributes for the class -

    /**
     * Private static final {@code int} for length of an IPv6 address.
     * The addresses are 32 digits long grouped as 8 4 digit {@code Hexadecimal} numbers
     *
     * <p>Example: {@code 871E:F47E:B729:B5AF:AF02:D5E6:9867:90BC}</p>
     */
    private static final int IPV6_DIGIT_COUNT = 32;

    /**
     * Private static final {@code String} to hold the regex for the output of the class
     */
    private static final String IPV6_REGEX = ".{4}(?=.)";

    /**
     * Private static final {@code String} to hold the pattern for the regex of the class
     */
    private static final String IPV6_PATTERN = "$0:";



    //MARK: - Constructors for the class -

    /**
     * Public no args constructor for the {@code IPv6} class
     */
    public IPv6(){
        super(IPV6_DIGIT_COUNT);
    }

    /**
     * Private method to get a pseudorandom IPv6 Internet address, that is a group of 8 {@code Hexadecimal}
     * digits each between {@code 0000} inclusive and {@code FFFF} inclusive
     *
     * <p>Example: {@code 871E:F47E:B729:B5AF:AF02:D5E6:9867:90BC} </p>
     *
     * @return  A {@code String} representing a pseudorandom IPv6 internet address
     */
    private String getIPv6() {

        String output = this.getHexString();

        return this.hexFormatter(output, IPV6_REGEX, IPV6_PATTERN);
    }

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return DataType.valueOf(this.getIPv6());
    }
}
