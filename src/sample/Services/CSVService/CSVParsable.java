package sample.Services.CSVService;


import com.sun.istack.internal.NotNull;

/**
 * Public abstract class for {@code Models} that can be parsed from A {@code .csv} file.
 * Even model that we have a {@code .csv} file for in the project must extend to this class.
 * They also must have an {@code Enum} that conforms to the {@link Attributes} interface.
 * This is so we can have one class that parses all the {@code .csv} files in the project.
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
public abstract class CSVParsable {

    /**
     * Public interface inside the {@code CSVParsable} class that is to be conformed to by
     * An enum inside a class that extends {@code CSVParsable}. That way we can be sure to get the
     * a list of the correct attributes for a class
     */
    public interface Attributes{
        int getIndex();
    }


    /**
     * Public method to create and return a new instance of a class that extends {@code CSVParsable}
     *
     * @param parsable  An instance of a class that conforms to {@code CSVParsable}
     *
     * @return          A new instance of a class that conforms to {@code CSVParsable}
     */
    public abstract CSVParsable newInstance(CSVParsable parsable);

    /**
     * Public abstract method to parse a String of comma separated values from a {@code .csv} file.
     *
     * @param parse     A {@code String} that contains comma separated values from a {@code .csv} file to parse
     */
    public abstract void parse(@NotNull String parse);

}
