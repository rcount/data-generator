package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * Public class to get a {@code double} representing a Longitude for a particular place.
 * This class is called by {@code Longitude.get()} to get a pseudorandom {@code Longitude}
 * between -180 inclusive and 180 exclusive.
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
public final class Longitude extends Tablable {

    /**
     * Private static final {@code double} representing the lowest possible {@code Longitude}
     */
    private static final double LONG_MIN = -180.1d;

    /**
     * Private static final {@code double} representing the highest possible {@code Longitude}
     */
    private static final double LONG_MAX = 180.0d;

    /**
     * Private static final {@code String} to hold the format for the {@link DecimalFormat} of the Output.
     */
    private static final String OUTPUT_FORMAT = "#.######";

    /**
     * Private no args constructor for {@link Longitude} class.
     * This allows us to use the {@link Longitude} as a static class
     */
    public Longitude(){}

    /**
     * Public method to get a random {@link Longitude} between {@link Longitude#LONG_MIN} inclusive
     * and {@link Longitude#LONG_MAX} exclusive
     *
     * @return      A {@link String} representing the pseudorandom {@link Longitude} generated.
     *              As a {@code Longitude} in decimal form is only 4 digits max that is what is returned.
     */
    private String getLong(){

        //create a DecimalFormat with the proper pattern and set the rounding mode.
        DecimalFormat decimalFormat = new DecimalFormat(OUTPUT_FORMAT);
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        return decimalFormat.format(RandomGenerator.getDouble(LONG_MIN, LONG_MAX));
    }

    @Override
    public DataType generate() {
        return DataType.valueOf(this.getLong());
    }
}
