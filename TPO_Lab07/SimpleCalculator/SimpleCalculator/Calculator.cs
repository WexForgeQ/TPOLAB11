﻿namespace SimpleCalculator
{
    public class Calculator
    {
        public static double Add(double number1, double number2) => RoundNumber(number1 + number2);
        public static double Subtract(double number1, double number2) => RoundNumber(number1 - number2);
        public static double Multiply(double number1, double number2) => RoundNumber(number1 * number2);
        public static double Divide(double number1, double number2)
        {
            if (number2 == 0)
                throw new DivideByZeroException();

            return RoundNumber(number1 / number2);
        }
        public static double ExtractRoot(double number, double power) => RoundNumber(RaiseToThePower(number, 1 / power));
        public static double ExtractSquareRoot(double number)
        {
            double temporarySquareRoot;
            double squareRoot = number / 2;
            do
            {
                temporarySquareRoot = squareRoot;
                squareRoot = (temporarySquareRoot + (number / temporarySquareRoot)) / 2;
            } while ((temporarySquareRoot - squareRoot) != 0);
            return RoundNumber(squareRoot);
        }
        public static double RaiseToThePower(double number, double power)
        {
            if (power % 1 == 0 && power >= 1)
            {
                var initialNumber = number;
                for (int i = 1; i <= power - 1; i++)
                    number *= initialNumber;
                return RoundNumber(number);
            }
            else
                return RoundNumber(Math.Pow(number, power));
        }
        public static double RoundNumber(double operationResult) => Math.Round(operationResult, 3);
    }
}