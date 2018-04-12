package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

/**
 *  Public class to get a pseudorandomly generated number in Hexadecimal format.
 *  i.e. a base 8 radix containing numbers between 0 and 7.
 *
 * <p> The class extends {@link NumberData} and implements {@link Generatable}
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
public final class Octal extends NumberData  {

    //MARK: - Constructor for the class -

    /**
     * Public no args constructor for the {@code Octal} class. Using this constructor will
     * generate a number between {@link NumberData#MIN_VALUE} inclusive and
     * {@link NumberData#MAX_VALUE} exclusive.
     */
    public Octal(){
        super();
    }

    /**
     * Public one arg constructor for the {@code Octal} class. Using this constructor will
     * generate a number between {@link NumberData#ZER0} inclusive and
     * {@code max} exclusive.
     *
     * @param max   An {@code int} for the upper bound for the pseudorandomly generated number.
     */
    public Octal(int max){
        super(max);
    }

    /**
     * Public two args constructor for the {@code Octal} class. Using this constructor will
     * generate a number between {@code min} inclusive and {@code max} exclusive.
     *
     * @param min   An {@code int} for the upper bound for the pseudorandomly generated number.
     * @param max   An {@code int} for the upper bound for the pseudorandomly generated number.
     */
    public Octal(int min, int max){
        super(min, max);
    }

    //MARK: - Methods to conform to Generatable -

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        String octal = Integer.toOctalString(RandomGenerator.getInt(this.getMin(), this.getMax()));
        return DataType.valueOf(octal);
    }
}
