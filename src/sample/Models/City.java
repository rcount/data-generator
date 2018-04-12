package sample.Models;


/**
 * Public class to represent a city in somewhere in the world.
 * This class implements {@link Comparable} to compare two {@code City} objects
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
public final class City implements Comparable<City>{

    //MARK: - Private attributes for the City class -

    /**
     * Private {@code String} to hold the name of a City
     */
    private String city;

    //MARK: - Constructors for the City class -

    /**
     * Public no args constructor for the {@code City} class
     */
    public City(){}

    /**
     * Public overloaded constructor for the {@code City} class
     *
     * @param city  A {@code String} containing the name of the city
     */
    public City(String city){
        this.setCity(city);
    }

    /**
     * Public overloaded constructor for the {@code City} class
     *
     * @param city  A {@code City} instance that we get a new instance for
     */
    public City(City city){
        this(city.getCity());
    }

    //MARK: - Public methods for the City class -

    /**
     * Public method to get a new instance for the {@code City} object calling it.
     *
     * @return  A new instance of the {@code City} object that called the method.
     */
    public City newInstance(){
        return new City(this);
    }

    /**
     * Public static method to get a new instance of a {@code City} object.
     *
     * @param city      A {@code City} object that we want a new instance of.
     * @return          A new instance of the {@code City} passed into the method.
     */
    public static City newInstance(City city){
        return new City(city);
    }

    /**
     * Public static method to get a new instance of a {@code City} object
     *
     * @param city      A {@code String} containg the name of the {@code City} that we want to get
     * @return          A new instance of the {@code City} class with the name of the param city.
     */
    public static City newInstance(String city){
        return new City(city);
    }

    /**
     * Public mutator for the {@link City#city} attribute
     *
     * @param city      A {@code String} containing the name of the {@code City} object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Public assessor for the {@link City#city} attribute
     *
     * @return      A {@code String} containing the name of the {@code City} object
     */
    public String getCity() {
        return city;
    }

    //MARK: - Override of the Object methods -

    /**
     * Public method to see if two {@code City} object are equal
     *
     * @param o     A {@code Object} that we want to compare to the calling {@code City} object
     * @return      A {@code boolean} representation indicating whether or not the objects are equal
     *              {@code true} if they are, {@code false} if they aren't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return this.getCity().equals(city.getCity());
    }

    /**
     * Public overload of the {@link City#equals(Object)} method that checks if a String has the
     * is equal to the {@link City#city} attribute.
     *
     * <p>This is just for convenience of having it, as a {@code City} object is really a wrapper for a {@code String} object.
     *
     * @param o     A {@code String} that we want to compare to the calling {@code City} object
     * @return      A {@code boolean} representation indication whether or not the objects are equal
     *              {@code true} if they are, {@code false} if they aren't
     */
    public boolean equals(String o){
        return this.getCity().equals(o);
    }

    /**
     * Public method to get a HashCode for the {@code City} object
     *
     * @return  An {@code int} representation of the {@code City} object
     */
    @Override
    public int hashCode() {

        int result =  31;

        result *= this.getCity().hashCode() ^ 20 >> this.getCity().hashCode() ^ 12
                >> this.getCity().hashCode() >> 7 ^ this.getCity().hashCode() ^ 4;

        return result;
    }

    /**
     * Public method to get a {@code String} representation of the {@code City} object
     *
     * @return  A {@code String} representation of the {@code City} object
     */
    @Override
    public String toString() {
        return this.getCity();
    }

    //MARK: - Public override of the Comparable methods -

    /**
     * Public method to compare two {@code City} Objects
     *
     * @param city  A {@code City} object we want to compare to the calling instance.
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code City} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code City} passed in the param.
     */
    @Override
    public int compareTo(City city) {
        return this.compareTo(city.getCity());
    }

    /**
     * Public method to compare a {@code String} object to a {@code City} object that called the method.
     *
     * <p>This is just for convenience of having it, as a {@code City} object is really a wrapper for a {@code String} object.
     *
     * @param city  A {@code City} object we want to compare to the calling instance.
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code City} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code City} passed in the param.
     */
    public int compareTo(String city){
        return this.getCity().compareTo(city);
    }

    /**
     * Public method to compare two {@code City} Objects, ignoring the case of the {@link City#city} attribute.
     *
     * @param city  A {@code City} object we want to compare to the calling instance.
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code City} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code City} passed in the param.
     */
    public int compareToIgnoreCase(City city){
        return this.compareToIgnoreCase(city.getCity());
    }

    /**
     * Public method to compare a {@code String} object to a {@code City} object that called the method, ignoring the case
     * of the string and the {@link City#city}
     *
     * <p>This is just for convenience of having it, as a {@code City} object is really a wrapper for a {@code String} object.
     *
     * @param city  A {@code City} object we want to compare to the calling instance.
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code City} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code City} passed in the param.
     */
    public int compareToIgnoreCase(String city){
        return this.getCity().compareToIgnoreCase(city);
    }


}
