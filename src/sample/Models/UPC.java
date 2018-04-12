package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.FileNames;
import sample.Services.RandomGenerator;
import sample.Services.TextFileIn;

import java.util.Arrays;
import java.util.List;

/**
 * Public class to get an UPC (Universal Product Code).
 *
 * <p>Called as UPC.getX where X is the type of UPC you want to get.
 *
 *  <p>Copyright 2018 Stephen Vickers, Shane May
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
public final class UPC extends Tablable {


    //MARK: - Private attributes for the UPC class -

    /**
     * Private static final {@code int} for the length of a UPC, minus the check digit
     */
    private static final int UPC_LENGTH = 11;

    /**
     * Private static final {@code int} for a base 10 radix
     */
    private static final int DECIMAL_RADIX = 10;

    /**
     * Private static final {@code String} to hold the {@code regex} for a UPC number
     */
    private static final String UPC_REGEX = "(\\d)(\\d{5})(\\d{5})(\\d)";

    /**
     * Private static final {@code String} to hold the replacement pattern for the {@link UPC#UPC_REGEX}
     */
    private static final String UPC_PATTERN = "$1-$2-$3-$4";

    /**
     * Private static final {@code List<Integer>} to hold the stating digits for a UPC number
     * This are all the possibilities for the first digit of a UPC number
     */
    private static final List<Integer> START_DIGITS = Arrays.asList(0,1,2,3,4,6,7);

    //MARK: - Constructors for the UPC Class -

    /**
     * Private constructor for the UPC class. This is so we can call static methods
     * on the class. This is the only way to use this class.
     */
    public UPC(){}



    //MARK: - Public methods for the UPC Class -


    /**
     * Public method to get a pseudorandomly generated UPC number. It is not grantee to be a
     * valid UPC number, but it will start with 0, 1, 2, 3, 4, 6, or 7 and contain a valid GS1 number
     * for country of the home base of a manufacturer.
     *
     * <p> It will also contain a valid check digit based on the other 11 digits of the number.
     * Again this is not a grantee that the UPC is an actual valid UPC, but if it was a valid UPC
     * the check Digit would be correct</p>
     *
     * @return  A {@code String} containing a UPC Number.
     */
    private String getUPC(){
        List<String> groups = this.getGroups();

        String upc = String.valueOf(START_DIGITS.get(RandomGenerator.getInt(START_DIGITS.size())));

        upc = upc.concat(String.valueOf(groups.get(RandomGenerator.getInt(groups.size()))));

        while (upc.length() < UPC_LENGTH){
           upc = upc.concat(String.valueOf(RandomGenerator.getInt(DECIMAL_RADIX)));
        }

        upc = upc.concat(String.valueOf(this.getCheckDigit(upc)));

        return UPC.upcFormatter(upc);

    }


    //MARK: - Private Methods for the UPC Class -

    /**
     * Private static method to get a {@link List} of all the GS1 numbers.
     *
     * @return  A <pre>List<String></pre> with all the valid GS1 numbers.
     */
    private List<String> getGroups(){
        TextFileIn fileIn = new TextFileIn(FileNames.GS1_NUMBERS);

        return Arrays.asList(fileIn.readFile().split("\n"));
    }

    /**
     * Private static method to calculate the last digit, or check digit of a UPC number
     *
     * @param upc  A {@code String} containing an UPC number we want to calculate the check
     *             digit for
     * @return     An {@code int} representing a valid check number for the given {@code upc}
     */
    private int getCheckDigit(String upc){

        //if the length of the upc is not 11 throw an IllegalArgumentException
        if(upc.length() != UPC_LENGTH){
            throw new IllegalArgumentException("Must be 12 characters long");
        }

        //get all the odd digits and add them up
        int odd = 0;
        for (int index = 0; index < upc.length(); index += 2){
            String digit = String.valueOf(upc.charAt(index));
            odd += Integer.parseInt(digit);
        }

        //multiply the sum of the odd digits by 3.
        odd *= 3;

        //get all the even digits and add them up
        int even = 0;
        for(int index = 1; index < upc.length(); index += 2){
            String digit = String.valueOf(upc.charAt(index));
            even += Integer.parseInt(digit);
        }

        //add the odd and even and mod it by 10
        int remainder = (odd + even) % DECIMAL_RADIX;

        //if the remainder is 0 then return it, otherwise return 10 - remainder
        return remainder == 0? remainder: DECIMAL_RADIX - remainder;
    }

    /**
     * Private static method to get a UPC formatted as it would appear to a person looking at it
     * with hyphens between each group of numbers
     *
     * <p>Given a upc number of 660315385324 it would be formatted as 6-60315-38532-4</p>
     *
     * @param upc   A {@code String} containing a UPC we want to format
     * @return      A {@code String} with the correct formatting
     */
    private static String upcFormatter(String upc){
        return upc.replaceAll(UPC_REGEX, UPC_PATTERN);
    }

    @Override
    public DataType generate() {
        return DataType.valueOf(this.getUPC());
    }
}
