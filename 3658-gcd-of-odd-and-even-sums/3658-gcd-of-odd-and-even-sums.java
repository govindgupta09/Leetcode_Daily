class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        int odd = 1, even = 2;
        for (int i = 0; i < n; i++) {
            sumEven = sumEven + even;
            sumOdd = sumOdd + odd;
            odd+=2;
            even+=2;
        }
        return gcd(sumOdd, sumEven);
    }

    public int gcd(int n1, int n2) {
        if (n2 == 0) {
            return Math.abs(n1);
        }
        return gcd(n2, n1 % n2);
    }
}