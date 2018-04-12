package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;
import sample.Services.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Public Class to get a pseudorandom {@code Date} or {@code Time}
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
public final class DateTime extends Tablable {

    //MARK: - Private Attributes for the DateTime Class -

    /**
     * Private static final int for the standard minimum year for the {@link DateTime#getDate()}
     */
    private static final int DEFAULT_MIN_YEAR = 1901;

    /**
     * Private static final int for the standard minimum month for the {@link DateTime#getDate()}
     */
    private static final int DEFAULT_MIN_MONTH = 1;

    /**
     * Private static final int for the standard minimum day for the {@link DateTime#getDate()}
     */
    private static final int DEFAULT_MIN_DAY = 1;

    /**
     * Private static final int for the standard maximum year for the {@link DateTime#getDate()}
     */
    private static final int DEFAULT_MAX_YEAR = 2050;

    /**
     * Private static final int for the standard maximum month for the {@link DateTime#getDate()}
     */
    private static final int DEFAULT_MAX_MONTH = 1;

    /**
     * Private static final int for the standard maximum day for the {@link DateTime#getDate()}
     */
    private static final int DEFAULT_MAX_DAY = 1;


    //MARK: - Constructors for the DateTime Class -

    /**
     * Private Constructor for the {@code DateTime} class
     * This is so the class can be called as a static class
     */
    public DateTime(){}

    //MARK: - Public Methods for the DateTime Class -

    /**
     * Public static method to get a pseudorandom Date between {@link DateTime#DEFAULT_MIN_YEAR} inclusive
     * and {@link DateTime#DEFAULT_MAX_YEAR} exclusive
     *
     * @return  A {@code String} representing the pseudorandom Date created
     */
    public String getDate(){
        return getRandomDate(DEFAULT_MIN_YEAR, DEFAULT_MIN_MONTH, DEFAULT_MIN_DAY, DEFAULT_MAX_YEAR, DEFAULT_MAX_MONTH, DEFAULT_MAX_DAY).toString();
    }

    /**
     * Public static method to get a pseudorandom Date between {@code minYear} inclusive
     * and {@code maxYear} exclusive
     *
     * @param minYear   An {@code int} representing the lower bound of the year
     * @param maxYear   An {@code int} representing the upper bound of the year
     *
     * @return          A {@code String} representing a Date Between {@code minYear-1-1} and {@code maxYear-1-1}
     */
    public String getDate(int minYear, int maxYear){
        return getRandomDate(minYear, DEFAULT_MIN_MONTH, DEFAULT_MIN_DAY, maxYear, DEFAULT_MAX_MONTH, DEFAULT_MAX_DAY).toString();
    }

    /**
     * Public static method to get a pseudorandom Date between {@code minYear-minMonth-minDay} inclusive and
     * {@code maxYear, maxMonth, maxDay} exclusive.
     *
     * @param minYear   An {@code int} representing the lower bound for the year.
     * @param minMonth  An {@code int} representing the lower bound for the month.
     * @param minDay    An {@code int} representing the lower bound for the day.
     * @param maxYear   An {@code int} representing the upper bound for the year.
     * @param maxMonth  An {@code int} representing the upper bound for the month.
     * @param maxDay    An {@code int} representing the upper bound for the day.
     *
     * @return          A {@code String} representing a pseudorandom generated Date
     */
    public String getDate(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay){
        return getRandomDate(minYear, minMonth, minDay, maxYear, maxMonth, maxDay).toString();
    }

    /**
     * Public Static method to get a pseudorandom Date between {@link DateTime#DEFAULT_MIN_YEAR} inclusive
     * and {@link DateTime#DEFAULT_MAX_YEAR} exclusive in the format that is provided
     *
     * <p>If user enters a format of "d MMM, yyyy" the date of 2018-2-14 would be 14 Feb, 2018</p>
     *
     * @param format    A {@code String} representing the format that the Date needs to be returned in.
     *
     * @return          A {@code String} representing a pseudorandom Date in the format provided.
     */
    public String getDate(String format){
        LocalDate date = getRandomDate(DEFAULT_MIN_YEAR, DEFAULT_MIN_MONTH, DEFAULT_MIN_DAY, DEFAULT_MAX_YEAR, DEFAULT_MAX_MONTH, DEFAULT_MAX_DAY);

        return this.getDate(date, format);
    }

    /**
     *  Public static method to get a pseudorandom Date between {@code minYear} inclusive
     * and {@code maxYear} exclusive in the format that is provided
     *
     * <p>If user enters a format of "d MMM, yyyy" the date of 2018-2-14 would be 14 Feb, 2018</p>
     *
     * @param minYear   An {@code int} representing the lower bound of the year
     * @param maxYear   An {@code int} representing the upper bound of the year
     * @param format    A {@code String} representing the format that the Date needs to be returned in.
     *
     * @return          A {@code String} representing a pseudorandom Date in the format provided.
     */
    public String getDate(int minYear, int maxYear, String format){
        LocalDate date = getRandomDate(minYear, DEFAULT_MIN_MONTH, DEFAULT_MIN_DAY, maxYear, DEFAULT_MAX_MONTH, DEFAULT_MAX_DAY);

        return this.getDate(date, format);
    }

    /**
     * Public static method to get a pseudorandom Date between {@code minYear-minMonth-minDay} inclusive and
     * {@code maxYear, maxMonth, maxDay} exclusive.
     *
     * <p>For the format if you have a Date of 2018-2-14 and the format of {@code dd MMM, yyyy} it will be returned as
     * {@code 12 Feb, 2018}</p>
     *
     * @param minYear   An {@code int} representing the lower bound for the year.
     * @param minMonth  An {@code int} representing the lower bound for the month.
     * @param minDay    An {@code int} representing the lower bound for the day.
     * @param maxYear   An {@code int} representing the upper bound for the year.
     * @param maxMonth  An {@code int} representing the upper bound for the month.
     * @param maxDay    An {@code int} representing the upper bound for the day.
     * @param format    A {@code String} representing how you want the Date to be formatted as.
     *
     * @return          A {@code String} representing a pseudorandom Date in the format provided.
     */
    public String getDate(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay, String format){
        LocalDate date = getRandomDate(minYear, minMonth, minDay, maxYear, maxMonth, maxDay);

        return  this.getDate(date, format);
    }


    /**
     * Public Static method to get a pseudorandom {@code Time} of the day.
     *
     * @return      A {@code String} representing a random {@code Time} of the day.
     *              <p>Will be returned in the format of {@link DateTimeFormat#TIME_DEFAULT} which is {@code HH:mm:ss.SSS}
     *              Will be a 24 hour hour, minutes, seconds, and fraction of a second to three decimal places.
     *              Nine in the morning will be {@code 09:00:00.000} while Nine in the evening will be {@code 21:00:00.000}</p>
     *
     */
    public String getTime(){
        LocalDateTime dateTime = getRandomDateTime(DEFAULT_MIN_YEAR, DEFAULT_MIN_MONTH, DEFAULT_MIN_DAY, DEFAULT_MAX_YEAR, DEFAULT_MAX_MONTH, DEFAULT_MAX_DAY);

        return this.getTime(dateTime, DateTimeFormat.TIME_DEFAULT);
    }

    /**
     * Public static method to get a pseudorandom {@code Time} of the day in the format provided
     *
     * @param format    A {@code String} holding the format of that we want to get the {@code Time} returned in
     *
     * @return          A {@code String} representing a pseudorandom {@code Time} of the day.
     *                  <p>Will be returned in the {@code format} provided in {@code format}
     *                  If the {@code format} is {@code "HH:mm:ss"} and the time is Nine in the morning it will be {@code 09:00:00}.
     *                  If the time in Nine in the evening then it will be {@code 21:00:00}.
     *                  If the {@code format} is {@code "hh:mm:ss"} the time of Nine in the morning or nine in the evening will be
     *                  {@code 09:00:00}</p>
     */
    public String getTime(String format){
        LocalDateTime dateTime = getRandomDateTime(DEFAULT_MIN_YEAR, DEFAULT_MIN_MONTH, DEFAULT_MIN_DAY, DEFAULT_MAX_YEAR, DEFAULT_MAX_MONTH, DEFAULT_MAX_DAY);

        return this.getTime(dateTime, format);
    }

    //MARK: - Private Methods for the DateTime Class -

    /**
     * Private Static method to get a {@code LocalDate} formatted to the desired format
     *  <p>For the format if you have a Date of 2018-2-14 and the format of {@code dd MMM, yyyy} it will be returned as
     * {@code 12 Feb, 2018}</p>
     *
     * @param date      A {@code LocalDate} that we want to format.
     * @param format    A {@code String} representing the format for the return of the {@code DateTime}
     *
     * @return          A {@code String} representing the {@code DateTime} in the correct format.
     */
    private String getDate(LocalDate date, String format){
        if (format.equals(DateTimeFormat.DATE_DEFAULT)){
            return date.toString();
        } else {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
          return date.format(formatter);
        }
    }

    /**
     * Private method to get a {@code DateTime} in the Format provided
     *
     * <p>For the format if you have a Time of 9 in the morning and a Format of {@code HH:mm:ss} then the output would be
     * 09:00:00. A time of 9 in the evening would be 21:00:00</p>
     *
     * @param time      A {@code LocalDateTime} that we want to format.
     * @param format    A {@code String} representing the format for the return of the {@code DateTime}
     *
     * @return          A {@code String} representing the {@code DateTime} in the correct format.
     */
    private String getTime(LocalDateTime time, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        return time.format(formatter);
    }

    /**
     * Public static method to get a pseudorandom Date between {@code minYear-minMonth-minDay} inclusive and
     * {@code maxYear, maxMonth, maxDay} exclusive.
     *
     * @param minYear   An {@code int} representing the lower bound for the year.
     * @param minMonth  An {@code int} representing the lower bound for the month.
     * @param minDay    An {@code int} representing the lower bound for the day.
     * @param maxYear   An {@code int} representing the upper bound for the year.
     * @param maxMonth  An {@code int} representing the upper bound for the month.
     * @param maxDay    An {@code int} representing the upper bound for the day.
     *
     * @return          A pseudorandom {@code LocalDate}.
     */
    private LocalDate getRandomDate(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay){
        return RandomGenerator.getDate(minYear, minMonth, minDay, maxYear, maxMonth, maxDay);
    }

    /**
     * * Public static method to get a pseudorandom Date between {@code minYear-minMonth-minDay} inclusive and
     * {@code maxYear, maxMonth, maxDay} exclusive.
     *
     * @param minYear   An {@code int} representing the lower bound for the year.
     * @param minMonth  An {@code int} representing the lower bound for the month.
     * @param minDay    An {@code int} representing the lower bound for the day.
     * @param maxYear   An {@code int} representing the upper bound for the year.
     * @param maxMonth  An {@code int} representing the upper bound for the month.
     * @param maxDay    An {@code int} representing the upper bound for the day.
     *
     * @return          A pseudorandom {@code LocalDateTime}.
     */
    private LocalDateTime getRandomDateTime(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay){
        return RandomGenerator.getDateTime(minYear,minMonth, minDay, maxYear, maxMonth, maxDay);
    }


    @Override
    public DataType generate() {
        return new DataType(this.getDate());
    }
}
