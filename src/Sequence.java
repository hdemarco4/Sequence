import java.lang.Object.*;

/**
 * Integer sequence generators. A sequence is defined by its initial values, and a depth. The initial values represent the first values returned by the sequence. The depth is how many previous items are added together to calculate the next item in the sequence, after all initial values have been exhausted.

 Examples:
 Sequence({4, 9, 12}, 0) produces [4, 9, 12, 0, 0, 0, 0, ...]
 Sequence({1}, 1) produces [1, 1, 1, 1, 1, 1, ...]
 Sequence({3, 8}, 1) produces [3, 8, 8, 8, 8, 8, 8, ...]
 Sequence({2, 4}, 2) produces [2, 4, 6, 10, 16, 26, 42, 68, ...]
 Sequence({2, 4, 6, 8}, 3) produces [2, 4, 6, 8, 18, 32, 58, 108, ...]

 The behavior of sequences for which the depth is greater than number of the initial values is unspecified.

 @author CS4250 (Fall 2017)
 @author Heather DeMarco
 @version 2.1.2
 */

public class Sequence {
    Integer[] builtList;
    int d;
    Integer n;
    int l;
    int index = 0;

    /**
     * Constructs an arbitrary sequence.
     */
    public Sequence(){
        builtList = new Integer[] {};
        d = 0;
    }

    /**
     * Constructs a specified sequence.
     * @param init the initial values of the sequence
     * @param depth the number of historical values used in calculation
     */
    public Sequence(Integer[] init, int depth){
        builtList = init;
        d = depth;

    }


    /**
     * Accesses the next number in the sequence.
     * @return the next number in the sequence
     */
    public Integer next(){
        l = builtList.length;
        l--;

        if(index <= l){
            n = builtList[index];
        }
        else {
            if (d == 0)
                n = 0;

            else if (d ==1)
                n = builtList[l];

            else{
                for (int i = 1; i < d; i++) {
                    n += builtList[l];
                    l--;
                }
            }
        }
        index++;
        return n;
    }

}
