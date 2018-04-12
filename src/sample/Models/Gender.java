package sample.Models;

import sample.Services.RandomGenerator;

/**
 * Public class to generate a random Gender. For the sake of arguments we only return
 * "Male" or "Female"
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
public class Gender extends Tablable {

    /**
     * Public no args constructor for the class
     */
    public Gender(){}

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        boolean isFemale= RandomGenerator.getBoolean();
        return DataType.valueOf(isFemale ? "Female": "Male");
    }
}
