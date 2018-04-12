package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Public class to get an ISBN10 (International Standard Book Number). It only has a private constructor to
 * be used as a Static class. Called as ISBN10.x where x is either an ISBN10 or ISBN13 number.
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
public final class ISBN10 extends ISBN {

    //MARK: - Private static final attributes for the class -

    /**
     * Private static final {@code int} for the length of an ISBN10 number,
     * without the check digit.
     */
    private static final int ISBN10_LENGTH = 9;

    /**
     * Private static final {@code int} for the mod function at the
     * end of the ISBN10 check digit calculation.
     */
    private static final int ISBN10_CHECK_MOD = 11;


    /**
     * Private static final int {@code int} for the decimal radix.
     * This is used to get a number from 0-9 from {@link RandomGenerator#getInt(int)}
     */
    private static final int DECIMAL_RADIX = 10;

    /**
     * Private static final {@code String} for the 10 value of the ISBN10
     * check digit. The check digit can be 0-9 or "X".
     */
    private static final String ISBN10_CHECK_10_VALUE = "X";

    /**
     * Private static final {@code String} for the regex of how an ISBN10 number should be formatted.
     * it is formatted as it would appear on a UPC with 1, a  number group of three numbers, a group of 5 numbers,
     * and a single number/letter at the end.
     *
     * <p>i.e. The number of 9906045280 would be formatted as 9-906-04528-0</p>
     */
    private static final String ISBN10_REGEX = "(\\d)(\\d{3})(\\d{5})(\\S)";

    /**
     * Private static string for the pattern of the {@code regex} for the {@code ISBN10} number
     */
    private static final String ISBN10_PATTERN = "$1-$2-$3-$4";

    /**
     * Private static {@link java.util.logging.Logger} to log to the console.
     */
    private static final Logger LOG = Logger.getLogger(ISBN10.class.getName());

    private List<String> groups = new ArrayList<>();

    //MARK: - Constructors for the class -

    public ISBN10(){
        super();
        this.groups = this.getISBNGroups(FileNames.ISBN10_GROUPS);
    }

    //MARK: - Public methods for the class -

    /**
     * Public static method to get an ISBN10 number.
     *
     * <p>This class does not make any assumptions of whether the number is an
     * actual VAlID ISBN10 number, but it is an accurate representation of one,
     * with a valid check digit based on the first 9 digits.
     *
     * @return  A {@code String} representing an ISBN10 number.
     */
    public String getISBN(){

        String isbn = this.groups.get(RandomGenerator.getInt(this.groups.size()));


        while (isbn.length() < ISBN10_LENGTH){
            isbn = isbn.concat(String.valueOf(RandomGenerator.getInt(DECIMAL_RADIX)));
        }

        int check = getCheckDigit(isbn);

        String output = String.valueOf(isbn);

        if(check == 10){
            output = output.concat(ISBN10_CHECK_10_VALUE);
        }else{
            output = output.concat(String.valueOf(check));
        }


        return this.isbnFormatter(output, ISBN10_REGEX, ISBN10_PATTERN);
    }



    //MARK: - Private methods for the class -



    /**
     * Private static method to get the check digit of an ISBN10 number.
     *
     * @param isbn  A {@code String} containing an ISBN10 number minus the check digit
     * @return      A {@code Int} containing the check digit for the ISBN10 number.
     */
    private static int getCheckDigit(String isbn){
        int sum = 0;

        for(int index = 0; index < isbn.length(); index++){
            sum += Integer.parseInt(String.valueOf(isbn.charAt(index))) * (index + 1);
        }


        return sum % ISBN10_CHECK_MOD;
    }


    //MARK: - Methods to conform to Generatable -

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return DataType.valueOf(this.getISBN());
    }
}
