import java.util.*;

public class Exercise_1_4_AllContained {

    /**
     * Checks if every value contained in a1 is also contained in a2
     */
    public static boolean allContained(long[] a1, long[] a2) {

		Set<Long> aSet1 = new HashSet<>();
		Long[] aLong1 = new Long[a1.length];
		for (int i = 0; i < a1.length; i++) {
			aLong1[i] = a1[i];
		}

		aSet1.addAll(Arrays.asList(aLong1));	//TODO How not loop all of them, but only set of them? This line do it

        for (Long elem1 : aSet1) {
            int i = 0;
            for (; (i < a2.length) && (elem1 != a2[i]); i++);
            if (i == a2.length) return false;
        }
        return true;





	}

    public static final int MAX_LEN = 1000000;

    public static void main(String[] args) {
        long[] m0 = {};
        long[] m1 = {1, 2, 5};
        long[] m2 = {4, 3, 2, 1, 8, 7, 6, 5};
        long[] m3 = {2, 1, 5};
        long[] m4 = {2, 1, 4, 3, 2};

        System.out.println("m0 subset of m1: result " + allContained(m0, m1) + " | expected: true");
        System.out.println("m0 subset of m2: result " + allContained(m0, m2) + " | expected: true");
        System.out.println("m0 subset of m3: result " + allContained(m0, m3) + " | expected: true");
        System.out.println("m0 subset of m4: result " + allContained(m0, m4) + " | expected: true");
        System.out.println("m1 subset of m0: result " + allContained(m1, m0) + " | expected: false");
        System.out.println("m1 subset of m2: result " + allContained(m1, m2) + " | expected: true");
        System.out.println("m2 subset of m1: result " + allContained(m2, m1) + " | expected: false");
        System.out.println("m0 subset of m0: result " + allContained(m0, m0) + " | expected: true");
        System.out.println("m1 subset of m1: result " + allContained(m1, m1) + " | expected: true");
        System.out.println("m1 subset of m3: result " + allContained(m1, m3) + " | expected: true");
        System.out.println("m3 subset of m1: result " + allContained(m3, m1) + " | expected: true");
        System.out.println("m4 subset of m0: result " + allContained(m4, m0) + " | expected: false");
        System.out.println("m4 subset of m1: result " + allContained(m4, m1) + " | expected: false");
        System.out.println("m4 subset of m2: result " + allContained(m4, m2) + " | expected: true");
        System.out.println("m4 subset of m3: result " + allContained(m4, m3) + " | expected: false");
        System.out.println("m4 subset of m4: result " + allContained(m4, m4) + " | expected: true");

        // Running time test:
        for (int len = 100; len <= MAX_LEN; len *= 10) {
            System.out.println("Array length " + len + ": ");
            long[] a1 = new long[len];
            long[] a2 = new long[len];

            for (int i = 0; i < len; i++) {
                a1[i] = i;
                a2[len - 1 - i] = i;
            }
            long start = System.nanoTime();
            boolean result = allContained(a1, a2);
            long ende = System.nanoTime();

            System.out.println("\ta1 contained in a2: " + result + " Running time: "
                    + ((ende - start) / 1e6) + " ms");
        }
    }

}
