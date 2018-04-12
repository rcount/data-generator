package sample.Services;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.font.NumericShaper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Class that generates random data that is required
 * Created by Stephen Vickers on Feb 7, 2018
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
public final class RandomGenerator {


    //MARK: - Private static final attributes for RandomGenerator Class -

    /**
     * Private static final {@code String} to hold the warning if a {@code Bound} for the {@link RandomGenerator#getInt(int)}
     * Method is less than {@code Zero}.
     */
    private static final String BAD_BOUND = "Bound must be positive";

    /**
     * Private static final {@code String} to hold the warning if a {@code min} is greater than the {@code max} for the
     * {@link RandomGenerator#getInt(int, int)} method.
     */
    private static final String BAD_RANGE = "Max must be greater than min";

    /**
     * A constant holding the minimum value an {@code int} can
     * have, -2<sup>31</sup>.
     */
    private static final int INT_MIN = 0x80000000;

    /**
     * A constant holding the maximum value an {@code int} can
     * have, 2<sup>31</sup>-1.
     */
    private static final int INT_MAX = 0x7fffffff;

    /**
     * A constant holding the minimum value a {@code long} can
     * have, -2<sup>63</sup>.
     */
    private static final long LONG_MAX = 0x7FFFFFFFFFFFFFFFL;

    /**
     * A constant holding the maximum value a {@code long} can
     * have, 2<sup>63</sup> -1.
     */
    private static final long LONG_MIN = 0x8000000000000000L;

    /**
     * Private static constant holding a value of an {@code int} 0;
     */
    private static final int INT_ZERO = 0x00000000;

    /**
     * Private static {@code double} to hold 0.0 for the {@link RandomGenerator#getDouble()} methods.
     */
    private static final double DOUBLE_ZERO = 0.0d;

    /**
     * Private static {@code double} to hole 1.0 for the {@link RandomGenerator#getDouble()} methods.
     */
    private static final double DOUBLE_ONE = 1.0d;

    /**
     * Private static {@code int} to hold the Radix of a Hexadecimal digit.
     */
    private static final int HEX_RADIX = 16;

    /**
     * Private static final {@code int} to hold the radix of a Octal number
     */
    private static final int OCT_RADIX = 8;

    /**
     * Private static final {@code int} to hold the lower bound for the number of letters in
     * a pseudorandom {@code String}
     */
    private static final int STRING_LOWER_BOUND = 5;

    /**
     * Private static final {@code int} to hold the upper bound for the number of letters in
     * a pseudorandom {@code String}
     */
    private static final int STRING_UPPER_BOUND = 50;

    /**
     * Private static {@code List<String>} that holds all 16 Hexadecimal Digits that we use to generate
     * random hex characters with {@link RandomGenerator#getHexDigit()}
     */
    private static List<String> stringLetters = Arrays.asList("0","1","2","3","4","5","6","7","8","9",
                                                           "A","B","C","D","E","F","G", "H", "I","J",
                                                            "K","L","M","N","O","P","Q","R","S","T",
                                                            "U","V","W","X","Y","Z");

    //MARK: - Constructors for the RandomGenerator class.

    /**
     * Private Constructor for the class that allows the use of the {@code RandomGenerator class} as
     * a static class.
     */
    private RandomGenerator(){}

    /**
     * Public static method that is used to return a pseudorandom {@code int} between
     * {@link RandomGenerator#INT_MIN} and {@link RandomGenerator#INT_MAX}
     *
     * @return  A pseudorandom {@code int}.
     */
    public static int getInt(){
        return getInt(INT_MIN, INT_MAX);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code int} between
     * {@link RandomGenerator#INT_ZERO} inclusive to the {@code bound} provided exclusive.
     *
     * @param bound     An {@code int} provided for the upper bound of the random
     *                  number
     * @return          A random {@code int} between 0 (inclusive) and the bound (exclusive)
     *
     * @throws          IllegalArgumentException if the bound is negative.
     */
    public static int getInt(int bound){
        if(INT_ZERO > bound){
            throw new IllegalArgumentException(BAD_BOUND);
        }
        return getInt(INT_ZERO, bound);
    }

    /**
     * Public static method to get an {@code int} between the min inclusive and the max exclusive
     *
     * @param min       An {@code int} that is the minimum or lower bound of the number range.
     * @param max       An {@code int} that is the maximum or lower bound of the number range.
     *
     * @return          An {@code int} that is between {@code min} inclusive and {@code max} exclusive
     *
     * @throws          IllegalArgumentException if the {@code min} is greater than or equal to the {@code max}
     */
    public static int getInt(int min, int max){
        if(min > max){
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static List<Integer> getListOfInts(int start, int end){
        List<Integer> temp = new ArrayList<>();


        for(int index = start; index < end; index++){
            temp.add(index);
        }

        return temp;
    }

    /**
     * Public static method to get a pseudorandom {@code long} between {@link RandomGenerator#LONG_MIN} and
     * {@link RandomGenerator#LONG_MAX}
     *
     * @return      A pseudorandom {@code long} between {@code RandomGenerator.LONG_MIN}
     *              and {@code RandomGenerator.LONG_MAX}
     */
    public static long getLong(){
        return getLong(LONG_MIN, LONG_MAX);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code long} between
     * {@link RandomGenerator#INT_ZERO} inclusive to the {@code bound} provided exclusive.
     *
     * @param bound     A {@code long} to be used for the upper bound of the pseudorandom number
     *
     * @return          A pseudorandom {@code long} between {@code RandomGenerator.INT_ZERO}
     *                  {@code bound} provided
     *
     *@throws           IllegalArgumentException if the {@code bound} is less than {@code RandomGenerator.INT_ZERO}
     */
    public static long getLong(long bound){
        if(INT_ZERO > bound){
            throw new IllegalArgumentException(BAD_RANGE);
        }

        return getLong(INT_ZERO, bound);
    }

    /**
     * Public static method to get a pseudorandom {@code long} between the {@code min} inclusive
     * and the {@code max} exclusive
     *
     * @param min   A {@code long} that is the lower bound of the number generated
     * @param max   A {@code long} that is the upper bound of the number generated
     *
     * @return      A pseudorandom long that is between {@code min} inclusive and {@code max} exclusive
     *
     * @throws      IllegalArgumentException if {@code min} is greater than {@code max}
     */
    public static long getLong(long min, long max){

        if (min > max){
            throw new IllegalArgumentException(BAD_RANGE);
        }

        return ThreadLocalRandom.current().nextLong(min, max);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code double} between
     * 0 inclusive and 1 exclusive
     *
     * @return  A pseudorandom {@code double}
     */
    public static double getDouble(){
        return getDouble(DOUBLE_ZERO, DOUBLE_ONE);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code double} between
     * 0.0 inclusive and the bound exclusive
     *
     * @param bound     A {@code double} that is the upper limit of the number we want.
     *
     * @return          A pseudorandom {@code double} between 0.0 inclusive and {@code bound} exclusive
     *
     * @throws IllegalArgumentException if {@code bound} is less than 0.0
     */
    static public double getDouble(double bound){
        if(!(bound > 0.0)){
            throw new IllegalArgumentException(BAD_BOUND);
        }

        return getDouble(DOUBLE_ZERO, bound);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code double} between
     * min inclusive and max exclusive
     *
     * @param min   A {@code double} that is the lower bound of the number range
     * @param max   A {@code double} that is the upper bound of the number range
     *
     * @return      A {@code double} between min inclusive and max exclusive
     * @throws IllegalArgumentException    if the {@code min} is greater than or equal to the {@code max}
     */
    public static double getDouble(double min, double max){

        if(min >= max){
            throw new IllegalArgumentException(BAD_RANGE);
        }

        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code boolean}
     *
     * @return  A pseudorandom {@code boolean}
     */
    public static boolean getBoolean(){
        return ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * Public static method that is used to return pseudorandom {@code Hexadecimal Digit}.
     *
     * @return  A {@code Hexadecimal Digit} between 0 inclusive and F inclusive
     */
    public static String getHexDigit(){
        int index = RandomGenerator.getInt(HEX_RADIX);

        return RandomGenerator.stringLetters.get(index);
    }

    /**
     * Public static method that is used to return a pseudorandom {@code Octal Digit}
     *
     * @return A {@code Octal Digit} between 0 inclusive and 7 inclusive
     */
    public static String getOctalDigit(){
        int index = RandomGenerator.getInt(OCT_RADIX);

        return RandomGenerator.stringLetters.get(index);
    }



    /**
     * Public method generate a pseudorandom {@code String} containing letters from {@code RandomGenerator#stringLetters}
     *
     * @return  A {@code String} with a {@code String#length()} between {@code STRING_LOWER_BOUND} inclusive
     *          and {@code STRING_UPPER_BOUND} exclusive
     */
    public static String getString(){
        int numberOfDigits = RandomGenerator.getInt(STRING_LOWER_BOUND, STRING_UPPER_BOUND);

        return getString(numberOfDigits);
    }

    /**
     * Public method to generate a pseudorandom {@code String} only containing letters from the {@code baseString}
     *
     * @param baseString    A {@code String} containing the letters from which we generate a pseudorandom {@code String}
     *
     * @return              A {@code String} containing only letter from {@code baseString} between
     *                      {@code STRING_LOWER_BOUND} inclusive and {@code STRING_UPPER_BOUND} exclusive.
     */
    public static String getString(String baseString){
        int numberOfDigits = RandomGenerator.getInt(STRING_LOWER_BOUND, STRING_UPPER_BOUND);

        return RandomGenerator.getString(baseString, numberOfDigits);
    }

    /**
     * Public method to get a pseudorandom {@code Sting} containing letters from {@code RandomGenerator#stringLetters}
     *
     * @param numberOfLetters    An {@code int} representing the number of letters we want in our {@code String}
     *
     * @return                  A {@code String} {@code numberOfLetters} long with letters from {@code RandomGenerator#stringLetters}
     */
    public static String getString(int numberOfLetters){
        return getString(RandomGenerator.stringLetters, numberOfLetters);
    }

    /**
     * Public method to get a pseudorandom {@code String} containing letters from {@code baseString} {@code numberOfLetters} long
     *
     * @param baseString        A {@code string} containing the letters we want to use in output pseudorandom {@code String}
     * @param numberOfLetters   An {@code int} representing how long we want the {@code String} returned to be.
     *
     * @return                  A {@code String} of {@code numberOfLetters} long and consisting of only letters in
     *                          {@code baseString}
     */
    public static String getString(String baseString, int numberOfLetters){
        List<String> temp = Arrays.asList(baseString.split(""));

        return RandomGenerator.getString(temp, numberOfLetters);
    }

    /**
     * Public method to get a pseudorandom {@code String} containing letters from {@code baseString} {@code numberOfLetters} long
     *
     * @param baseLetters       A {@code List<String>} containing the letters we want to use in output pseudorandom {@code String}
     * @param numberOfLetters   An {@code int} representing how long we want the {@code String} returned to be.
     *
     * @return                  A {@code String} of {@code numberOfLetters} long and consisting of only letters in
     *                          {@code baseString}
     */
    public static String getString(List<String> baseLetters, int numberOfLetters){
        String output = "";

        for (int index = 0; index< numberOfLetters; index++){
            output = output.concat(baseLetters.get(RandomGenerator.getInt(RandomGenerator.stringLetters.size())));
        }

        return output;
    }


    /**
     * Public static method that is used to return {@code Hexadecimal Color}
     *
     * @return  A {@code Hexadecimal Color} between #000000 inclusive and #FFFFFF inclusive
     */
    public static String getHexColor(){
        String color = "";

        for(int i = 0; i < 6; i++){
            color += RandomGenerator.getHexDigit();
        }

        return String.format("#%s", color);
    }

    /**
     * Public static method to get a pseudorandom {@link LocalDate}
     *
     * @param minYear   A {@link int} representing the lower bound for the year
     * @param minMonth  A {@link int} representing the lower bound for the month
     * @param minDay    A {@link int} representing the lower bound for the day
     * @param maxYear   A {@link int} representing the upper bound for the year
     * @param maxMonth  A {@link int} representing the upper bound for the month
     * @param maxDay    A {@link int} representing the upper bound for the day
     *
     * @return          A {@code LocalDate} object with a pseudorandom {@code Date}
     */
    public static LocalDate getDate(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay){
        int minDate = (int) LocalDate.of(minYear, minMonth, minDay).toEpochDay();
        int maxDate = (int) LocalDate.of(maxYear, maxMonth, maxDay).toEpochDay();
        long randomDate = minDate + getInt(maxDate - minDate);

        return LocalDate.ofEpochDay(randomDate);
    }

    /**
     * * Public static method to get a pseudorandom {@link LocalDateTime}
     *
     * @param minYear   A {@link int} representing the lower bound for the year
     * @param minMonth  A {@link int} representing the lower bound for the month
     * @param minDay    A {@link int} representing the lower bound for the day
     * @param maxYear   A {@link int} representing the upper bound for the year
     * @param maxMonth  A {@link int} representing the upper bound for the month
     * @param maxDay    A {@link int} representing the upper bound for the day
     *
     * @return          A {@code LocalDateTime} object with a pseudorandom {@code time}
     */
    public static LocalDateTime getDateTime(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay){
        int minDate = (int) LocalDate.of(minYear, minMonth, minDay).toEpochDay();
        int maxDate = (int) LocalDate.of(maxYear, maxMonth, maxDay).toEpochDay();
        long randomDate = minDate + getInt(maxDate - minDate);

        return LocalDateTime.ofEpochSecond(randomDate, 0, ZoneOffset.MAX);
    }
}
