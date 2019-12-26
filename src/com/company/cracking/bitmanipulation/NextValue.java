package com.company.cracking.bitmanipulation;

public class NextValue {

    int getLargeButSmallestValue(int value) {
        int bit = value;
        int zeroCount = 0;
        int oneCount = 0;

        while ((bit & 1) == 0 && (bit != 0)) {
            zeroCount++;
            bit >>= 1;
        }

        while ((bit & 1) == 1) {
            oneCount++;
            bit >>= 1;
        }

        if (zeroCount + oneCount == 31) {
            return -1;
        }

        int p = zeroCount + oneCount;
        value |= (1 << p);
        value &= -(1 << p);
        value |= (1 << oneCount - 1) - 1;

        return value;
    }

    int getSmallButLargest(int value) {
        int bit = value;
        int oneCount = 0;
        int zeroCount = 0;

        if (value == -1 || value == 0) {
            return -1;
        }

        while ((bit & 1) == 1) {
            oneCount++;
            bit >>= 1;
        }

        while ((bit & 1) == 0) {
            zeroCount++;
            bit >>= 1;
        }

        int p = oneCount + zeroCount;
        value &= ~(1 << p);
        value |= (1 << p) - 1;
        value &= -(1 << zeroCount - 1);
        return value;

    }
}
