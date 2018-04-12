package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

/**
 * Public Class to get a pseudorandomly generated number as a Binary number,
 * i.e. 1's and 0's with a 2 radix.
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
public final class Binary extends NumberData {

    //MARK: - Constructors for the class

    /**
     * Public no args constructor for the {@code Binary} class. Using this constructor will
     * Generate a pseudorandom number between {@link NumberData#MIN_VALUE} inclusive and
     * {@link NumberData#MAX_VALUE} exclusive.
     */
    public Binary(){
        super();
    }

    /**
     * Public one arg constructor for the {@code Binary} class. Using this constructor will
     * Generate a pseudorandom number between {@link NumberData#ZER0} inclusive and
     * {@code max} exclusive.
     *
     * @param max   An {@code int} representing the upper bound for the {@code Binary} number generated.
     */
    public Binary(int max){
        super(max);
    }

    /**
     * Public two arg constructor for the {@code Binary} class. Using this constructor will
     * Generate a pseudorandom number between {@code min} inclusive and {@code max} exclusive.
     *
     * @param min An {@code int} containing the lower bound for the pseudorandomly generated number.
     * @param max An {@code int} containing the upper bound for the pseudorandomly generated number.
     */
    public Binary(int min, int max){
        super(min, max);
    }

    //MARK: - Methods to conform to Generatable -

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        String binary = Integer.toBinaryString(RandomGenerator.getInt(this.getMin(), this.getMax()));
        return  DataType.valueOf(binary);
    }
}
