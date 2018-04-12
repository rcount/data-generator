package sample.Models;

/**
 * Public class for to hold a name
 * Created Feb 1, 2018 by Stephen Vickers
 *
 * Copyright 2018, Stephen Vickers, Shane May
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public final class Name{

    //MARK: - Private attributes for the Name class -

    /**
     * Private string to hold the name
     */
    private String name = "";


    /**
     * Public overloaded constructor for the {@code Name} class
     *
     * @param name  A {@code String} that holds a name
     */
    public Name(String name) {
        this.setName(name);
    }


    /**
     * Public overloaded static method to get a new instance of the {@code Name} class
     *
     * @param name  A {@code String} that is to be copied into the new instance of the name
     *
     * @return      A new instance {@code Name} containing the {@code name} held in
     *              the {@link Name#name} variable
     */
    public static Name newInstance(String name){
        return new Name(name);
    }


    /**
     * Public assessor for the {@link Name} class
     *
     * @return  A {@link String} with the {@link Name#name} value.
     */
    private String getName() {
        return this.name;
    }

    /**
     * Public mutator for the {@link Name} class
     * @param name  A {@code String} that containing the name.
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Public override of the {@link Object#toString()} method
     *
     * @return A {@code String} representing the {@code Name}.
     */
    @Override
    public String toString() {
        return this.getName();
    }

}
