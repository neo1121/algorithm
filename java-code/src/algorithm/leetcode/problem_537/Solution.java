package algorithm.leetcode.problem_537;

public class Solution {
    public static class ComplexNumber {
        public int real;
        public int imaginary;

        public ComplexNumber(String num) {
            int i = 0;
            while (num.charAt(i) != '+') {
                i++;
            }
            this.real = Integer.parseInt(num.substring(0, i));
            this.imaginary = Integer.parseInt(num.substring(i + 1, num.length() - 1));
        }

        public ComplexNumber(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public ComplexNumber multi(ComplexNumber num) {
            int real = this.real * num.real - this.imaginary * num.imaginary;
            int imaginary = this.real * num.imaginary + this.imaginary * num.real;
            return new ComplexNumber(real, imaginary);
        }

        @Override
        public String toString() {
            return this.real + "+" + this.imaginary + "i";
        }
    }

    public String complexNumberMultiply(String num1, String num2) {
        return new ComplexNumber(num1).multi(new ComplexNumber(num2)).toString();
    }
}
