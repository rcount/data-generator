package sample.Models;

import com.google.gson.annotations.Expose;
import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

/**
 * Public class to get the pseudorandom NumberData.
 *
 * <p>This class implements {@link Generatable}.
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
public class NumberData extends Tablable{

    /**
     * Private static final {@code int} holding the minimum value an {@code int} can
     * have, -2<sup>31</sup>.
     */
    private static final int MIN_VALUE = 0x80000000;

    /**
     * Private static final {@code int} holding the maximum value an {@code int} can
     * have, 2<sup>31</sup>-1.
     */
    private static final int MAX_VALUE = 0x7fffffff;

    /**
     * Private static final {@code int} hold the {@code int} zero value.
     */
    private static final int ZER0 = 0x00000000;




    /**
     * Private {@code int} to hold the minimum bound for the pseudorandomly generated number.
     */

    private int min = 0;

    /**
     * Private {@code int} to hold the maximum bound for the pseudorandomly generated number.
     */

    private int max = 0;

    //MARK: - Constructors for the NumberData Class -

    /**
     * Public no args Constructor for the {@code NumberData} class. Using this constructor will
     * generate a number between {@link NumberData#MIN_VALUE} inclusive and
     * {@link NumberData#MAX_VALUE} exclusive.
     */
    public NumberData(){
        this(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Public one arg Constructor for the {@code NumberData} class. Using this constructor will
     * generate a number between {@link NumberData#ZER0} inclusive and
     * {@code max} exclusive.
     *
     * @param max An {@code int} for the upper bound of the pseudorandomly generated number.
     */
    public NumberData(int max){
        this(ZER0, max);
    }

    /**
     * Public two arg Constructor for the {@code NumberData} class. Using this constructor will
     * generate a number between {@code min} inclusive and {@code max} exclusive.
     *
     * @param min   An {@code int} for the lower bound of the pseudorandomly generated number.
     * @param max   An {@code int} for the upper bound of the pseudorandomly generated number.
     */
    public NumberData(int min, int max){
        super();
        if(min < max){
            this.setMin(min);
            this.setMax(max);
        }else{
            this.setMin(max);
            this.setMax(min);
        }
    }

    //MARK: - Public methods for the NumberData Class -

//    public void setColumnName(String columnName){
//        this.columnName = columnName;
//    }
//
//    public void setDataType(String dataType){
//        this.dataType = dataType;
//    }
//
//    public void setAttribute(String attribute){
//        this.attribute = attribute;
//    }

    //MARK: - Private methods for the NumberData Class -

    /**
     * Public mutator for the {@link NumberData#min} attribute.
     *
     * @param min   An {@code int} for the lower bound of the pseudorandomly generated number.
     */
    private void setMin(int min) {
        this.min = min;
    }

    /**
     * Public mutator for the {@link NumberData#max} attribute.
     *
     * @param max   An {@code int} for the upper bound of the pseudorandomly generated number.
     */
    private void setMax(int max) {
        this.max = max;
    }

    /**
     * Public accessor for the {@link NumberData#min} attribute.
     *
     * @return  An {@code int} for the lower bound of the pseudorandomly generated number.
     */
    protected int getMin() {
        return this.min;
    }

    /**
     * Public accessor for the {@link NumberData#max} attribute.
     *
     * @return  An {@code int} for the upper bound of the pseudorandomly generated number.
     */
    protected int getMax() {
        return this.max;
    }

    //MARK: - Method to make the class conform to Generatable -

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return DataType.valueOf(RandomGenerator.getInt(this.getMin(), this.getMax()));

    }
}
