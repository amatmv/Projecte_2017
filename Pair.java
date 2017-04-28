
public class Pair<A, B> {
    public A primer;
    public B segon;

    public Pair(A primer, B segon) {
        super();
        primer = primer;
        segon = segon;
    }


    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;
        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
                    ((  this.primer == otherPair.primer ||
                            ( this.primer != null && otherPair.primer != null &&
                                    this.primer.equals(otherPair.primer))) &&
                            (  this.segon == otherPair.segon ||
                                    ( this.segon != null && otherPair.segon != null &&
                                            this.segon.equals(otherPair.segon))) );
        }

        return false;
    }
}