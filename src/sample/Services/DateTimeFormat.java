package sample.Services;

/**
 * Public class to hold {@code formats} for the {@code DateTime} class. This
 * class is just a convenience class that makes getting a {@code Date} or a {@code Time}
 * easier to create in the correct format.
 *
 * <p>DateTimeFormat is class by {@code DateTimeFormat.X} where X is the format you want to use.</p>
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
public class DateTimeFormat {

    //MARK: - Public Attributes for the DateTimeFormat Class -

    /**
     * Public static final {@code String} to get A {@link java.time.LocalDate} in the
     * Default format it is returned in.
     */
    public static final String DATE_DEFAULT = "default";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDate} object
     *
     * <p>For a date of {@code 2018-2-18} the output would be {@code 02-18-2018}</p>
     */
    public static final String DATE_MM_DD_YYYY = "MM-dd-yyyy";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDate} object
     *
     * <p>For a date of {@code 2018-2-18} the output would be {@code 02-18-18}</p>
     */
    public static final String DATE_MM_DD_YY = "MM-dd-yy";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDate} object
     *
     * <p>For a date of {@code 2018-2-18} the output would be {@code Feb 18, 2018}</p>
     */
    public static final String DATE_MMM_DD_YYYY = "MMM dd, yyyy";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDate} object
     *
     * <p>For a date of {@code 2018-2-18} the output would be {@code 18-02-2018}</p>
     */
    public static final String DATE_DD_MM_YYYY = "dd-MM-yyyy";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDate} object
     *
     * <p>For a date of {@code 2018-2-18} the output would be {@code 18-02-18}</p>
     */
    public static final String DATE_DD_MM_YY = "dd-MM-yy";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDate} object
     *
     * <p>For a date of {@code 2018-2-18} the output would be {@code 18 Feb, 2018}</p>
     */
    public static final String DATE_DD_MMM_YYYY = "dd MMM, YYYY";


    public static final String TIME_DEFAULT = "HH:mm:ss.SSS";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDateTime} object
     *
     * <p>For a time of {@code 9:00:00} the output would be {@code 09:00:00 AM}.
     * For a time of {@code 21:00:00} the output would be {@code 09:00:00 PM}</p>
     */
    public static final String TIME_TWELVE_HH_MM_SS_A = "hh:mm:ss a";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDateTime} object
     *
     * <p>For a time of {@code 9:00:00} the output would be {@code 09:00:00}.
     * For a time of {@code 21:00:00} the output would be {@code 09:00:00}</p>
     */
    public static final String TIME_TWELVE_HH_MM_SS =  "hh:mm:ss";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDateTime} object
     *
     * <p>For a time of {@code 9:00:00} the output would be {@code 09:00 AM}.
     * For a time of {@code 21:00:00} the output would be {@code 09:00 PM}</p>
     */
    public static final String TIME_TWELVE_HH_MM_A = "hh:mm a";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDateTime} object
     *
     * <p>For a time of {@code 9:00:00} the output would be {@code 09:00:00}.
     * For a time of {@code 21:00:00} the output would be {@code 09:00:00}</p>
     */
    public static final String TIME_TWENTY_FOUR_HH_MM_SS = "HH:mm:ss";

    /**
     * Public static final {@code String} to hold the a format for a {@link java.time.LocalDateTime} object
     *
     * <p>For a time of {@code 9:00:00} the output would be {@code 09:00}.
     * For a time of {@code 21:00:00} the output would be {@code 09:00}</p>
     */
    public static final String TIME_TWENTY_FOUR_HH_MM = "HH:mm";

    //MARK: - Constructors for the DateTimeFormat class -

    /**
     * Private constructor for the {@code DateTimeFormat} class that allows
     * This class to be used as a static class.
     */
    private DateTimeFormat(){}
}
