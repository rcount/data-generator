package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.FileNames;
import sample.Services.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class ISBN13 extends ISBN {

    /**
     * Private static final {@code int} for the length of an ISBN13 number,
     * without the check digit.
     */
    private static final int ISBN13_LENGTH = 12;

    /**
     * Private static final {@code int} for the mod function at the
     * end of the ISBN13 check digit calculation.
     */
    private static final int ISBN13_CHECK_MOD = 10;

    /**
     * Private static final {@code String} for the regex of how an ISBN10 number should be formatted.
     * it is formatted as it would appear on a UPC with 1 number, and two groups of 6 numbers
     *
     * <p>i.e. the number 1182651023818 would be formatted as 1-182651-023818</p>
     */
    private static final String ISBN13_REGEX = "(\\d)(\\d{6})(\\d{6})";

    /**
     * Private static final {@code String} for the pattern of the {@code regex} for the {@code ISBN13} number
     */
    private static final String ISBN13_PATTERN = "$1-$2-$3";

    /**
     * Private static final int {@code int} for the decimal radix.
     * This is used to get a number from 0-9 from {@link RandomGenerator#getInt(int)}
     */
    private static final int DECIMAL_RADIX = 10;

    private List<String> groups = new ArrayList<>();

    public ISBN13(){
        groups = this.getISBNGroups(FileNames.GS1_NUMBERS);
    }

    /**
     * Public static method to get an ISBN13 number.
     *
     * <p>This class does not make any assumptions of whether the number is an
     * actual VAlID ISBN13 number, but it is an accurate representation of one,
     * with a valid check digit based on the first 12 digits.
     *
     * @return  A {@code String} representing an ISBN13 number.
     */
    public String getISBN(){

        String isbn = this.groups.get(RandomGenerator.getInt(this.groups.size()));

        while (isbn.length() < ISBN13_LENGTH){
            isbn = isbn.concat(String.valueOf(RandomGenerator.getInt(DECIMAL_RADIX)));
        }

        isbn = isbn.concat(String.valueOf(getCheckDigit(isbn)));

        return isbnFormatter(isbn, ISBN13_REGEX, ISBN13_PATTERN);
    }

    /**
     * Private static method to get the check digit for an ISBN13 number.
     *
     * @param isbn  A {@code String} containing an ISBN10 number minus the check digit
     * @return      A {@code Int} containing the check digit for the ISBN13 number.
     */
    private int getCheckDigit(String isbn){
        int sum = 0;
        for (int index = 0; index < isbn.length(); index++){
            int digit = Integer.parseInt(String.valueOf(isbn.charAt(index)));

            sum += digit * (index % 2 == 1 ? 3 : 1);
        }

        return ISBN13_CHECK_MOD - (sum % ISBN13_CHECK_MOD);
    }

    @Override
    public DataType generate() {
        return DataType.valueOf(this.getISBN());
    }
}
