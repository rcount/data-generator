package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;
import java.text.NumberFormat;

/**
 * Public class to get a pseudorandomly generated {@code double} in the format of "Currency"
 * i.e. in the US it will be in the form of $1234.56.
 *
 * <p>This class implements {@link Generatable} interface.
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
public class Currency extends Tablable{


    //MARK: - Private attributes for the class -

    /**
     * Private static final {@code double} for the default Minimum currency.
     */
    private static final double MIN_DEFAULT = 0.0;

    /**
     * Private static final {@code double} for the default Maximum currency.
     */
    private static final double MAX_DEFAULT = 10_000_000.0;

    /**
     * Private {@code double} to hold the Minimum for the currency.
     */
    private double min = 0.0;

    /**
     * Private {@code double} to hold the Maximum for the currency.
     */
    private double max = 0.0;

    //MARK: - Constructors for the class -

    /**
     * Public no args constructor for the {@code Currency} class. Using this constructor will
     * generate a number between {@link Currency#MIN_DEFAULT} inclusive and
     * {@link Currency#MAX_DEFAULT} exclusive.
     */
    public Currency(){
        this(MAX_DEFAULT);
    }

    /**
     * Public one arg constructor for the {@code Currency} class. Using this constructor will
     * generate a number between {@link Currency#MIN_DEFAULT} inclusive and
     * {@code max} exclusive
     *
     * @param max   A {@code int} for the upper bound of the pseudorandomly generated Currency.
     */
    public Currency(int max){
        this(MAX_DEFAULT, (double)max);
    }

    /**
     * Public one arg constructor for the {@code Currency} class. Using this constructor will
     * generate a number between {@link Currency#MIN_DEFAULT} inclusive and
     * {@code max} exclusive
     *
     * @param max   A {@code double} for the upper bound of the pseudorandomly generated Currency.
     */
    public Currency(double max){
        this(MIN_DEFAULT, max);
    }

    /**
     * Public two arg constructor for the {@code Currency} class. Using this constructor will
     * generate a number between {@code min} inclusive and {@code max} exclusive.
     *
     * @param min   A {@code int} for the lower bound of the pseudorandomly generated Currency.
     * @param max   A {@code int} for the upper bound of the pseudorandomly generated Currency.
     */
    public Currency(int min, int max){
        this((double)min, (double) max);
    }

    /**
     * Public two arg constructor for the {@code Currency} class. Using this constructor will
     * generate a number between {@code min} inclusive and {@code max} exclusive.
     *
     * @param min   A {@code double} for the lower bound of the pseudorandomly generated Currency.
     * @param max   A {@code double} for the upper bound of the pseudorandomly generated Currency.
     */
    public Currency(double min, double max){
        if(min == max){
         this.setMin(MIN_DEFAULT);
         this.setMax(MAX_DEFAULT);
        }else if(min < max){
            this.setMin(min);
            this.setMax(max);
        }else{
            this.setMin(max);
            this.setMax(min);
        }
    }

    //MARK: - Private methods for the class -

    /**
     * Private mutator for the {@link Currency#min} attribute.
     *
     * @param min A {@code double} for the lower bound of the pseudorandomly generated Currency.
     */
    private void setMin(double min) {
        this.min = min;
    }

    /**
     * Private mutator for the {@link Currency#max} attribute.
     *
     * @param max   A {@code double} for the lower bound of the pseudorandomly generated Currency.
     */
    private void setMax(double max) {
        this.max = max;
    }

    /**
     * Private accessor for the {@link Currency#min} attribute.
     *
     * @return  A {@code double} for the lower bound of the pseudorandomly generated Currency.
     */
    private double getMin() {
        return min;
    }

    /**
     * Private accessor for the {@link Currency#max} attribute.
     *
     * @return  A {@code double} for the lower bound of the pseudorandomly generated Currency.
     */
    private double getMax() {
        return max;
    }

    //MARK: - Method to make the class conform to Generatable

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        double num = RandomGenerator.getDouble(this.getMin(), this.getMax());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return DataType.valueOf(formatter.format(num));
    }
}
