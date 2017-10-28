/*
 * Urna
 */
package generics;

/**
 *
 * @author George
 * @param <U>
 */
public class Urna<U extends Number> {
    U myNumber;

    public U getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(U myNumber) {
        this.myNumber = myNumber;
    }

}
