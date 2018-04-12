package sample.Models;

import sample.Models.Interfaces.Generatable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Public class to represent a "state" or "Country" in the world.
 * This class implements {@link Comparable} interface
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
public final class State extends Tablable implements Comparable<State> {

    //MARK: - Private Attributes for the State Class -

    /**
     * Private {@code String} to hold the name of the State
     */
    private String state;

    //MARK: - Constructors for the State Class -

    /**
     * Public no args constructor for the {@code State} class -
     */
    public State(){
        this("");
    }

    /**
     * Public overloaded constructor for the {@code State} class
     *
     * @param state     A {@code String} containing the name of the state
     */
    public State(String state){
        this.setState(state);
    }

    /**
     * Public overloaded constructor for the {@code State} class
     *
     * @param state     A {@code State} that is being passed in for a new instance.
     */
    public State(State state){
        this(state.getState());
    }

    //MARK: - Public methods for the State class -


    @Override
    public DataType generate() {
        //TODO: implement method
        throw new NotImplementedException();
    }

    /**
     * Public method to get a new instance of a {@code State} object
     *
     * @return  A new instance of the {@code State} object this is called on.
     */
    public State newInstance(){
        return new State(this);
    }

    /**
     * Public static method to get a new instance of a {@code State} object
     *
     * @param state     A {@code String} containing the name of the {@code State}
     * @return          A new Instance of the {@code State} object
     */
    public static State newInstance(String state){
        return new State(state);
    }

    /**
     * Public static method to get a new instance of a {@code State} object
     *
     * @param state     A {@code State} object that we want to get a new instance of.
     * @return          A new instance of the {@code State} passed in the @param state.
     */
    public static State newInstance(State state){
        return new State(state);
    }

    /**
     * Public mutator for the {@link State#state} attribute
     *
     * @param state     A {@code String} containing the name of the {@code State}
     */
    public void setState(String state) {
        this.state = state.trim();
    }

    /**
     * Public assessor for the {@link State#state} attribute
     *
     * @return  A {@code String} containing the name of the {@code State}
     */
    public String getState() {
        return this.state;
    }

    //MARK: - Override of the Object methods -

    /**
     * Public method to see if two {@code State} objects equal each other.
     *
     * @param o     A {@code Object} that we want to compare to the State Instance
     * @return      A {@code boolean} that represents whether or not two {@code State} objects are equal;
     *              {@code true} if they are, {@code false} if they aren't.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof State)) return false;
        State state1 = (State) o;
        return this.getState().equals(state1.getState());
    }

    /**
     * Public method to get a HashCode representation of the {@code State} object.
     *
     * @return  An {@code int} representation of the {@code State} object.
     */
    @Override
    public int hashCode() {

        int result = 31;

        result *= result ^ this.getState().hashCode() >> 20 ^ this.getState().hashCode() >> 12
                ^ this.getState().hashCode() >> 7 ^ this.getState().hashCode() >> 4;

        return result;
    }

    /**
     * Public method to get a {@code String} representation of the {@code State} object.
     *
     * @return   A {@code String} representation of the {@code State} object.
     */
    @Override
    public String toString() {
        return this.getState();
    }

    //MARK: -Override of the Comparable methods -

    /**
     * Public method to compare two {@code State} objects
     *
     * @param o     A {@code State} that we want to compare to our {@code State} instance
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code State} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code State} passed in the param.
     */
    @Override
    public int compareTo(State o) {
        return this.compareTo(o.getState());
    }

    /**
     * Public method to compare a {@code State} object to a {@code String} object
     *
     * <p>This is just for convenience of having it, as a {@code State} object is really a wrapper for a {@code String} object.
     *
     * @param o     A {@code String} that we want to compare to our {@code State } instance
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code String} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code State} passed in the param.
     */
    public int compareTo(String o){
        return this.getState().compareTo(o);
    }

    /**
     * Public method to compare two {@code State} objects, ignoring the case of the words
     *
     * @param o     A {@code State} that we want to compare to our {@code State} instance
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code State} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code State} passed in the param.
     */
    public int compareToIgnoreCase(State o){
        return this.compareToIgnoreCase(o.getState());
    }

    /**
     * Public method to compare a {@code State} object to a {@code String} object, ignoring the case of the words
     *
     * <p>This is just for convenience of having it, as a {@code State} object is really a wrapper for a {@code String} object.
     *
     * @param o     A {@code String} that we want to compare to our {@code State} instance
     * @return      An {@code int} representing if the are the equal; {@code 0} if they are, a number {@code less than 0}
     *              if the calling object is less than the {@code String} passed in the param, a number {@code greater than 0}
     *              if the calling object is greater than the {@code State} passed in the param.
     */
    public int compareToIgnoreCase(String o){
        return this.getState().compareToIgnoreCase(o);
    }
}
