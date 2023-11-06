using NUnit.Framework;
using SimpleCalculator;

namespace SimpleCalculator.Tests
{
    [TestFixture]
    public class CalculatorTests
    {
        [Test]
        public void Add_ReturnsCorrectSum()
        {
            double result = Calculator.Add(2.5, 3.7);
            Assert.AreEqual(6.2, result);
        }

        [Test]
        public void Subtract_ReturnsCorrectDifference()
        {
            double result = Calculator.Subtract(5.9, 1.2);
            Assert.AreEqual(4.7, result);
        }

        [Test]
        public void Multiply_ReturnsCorrectProduct()
        {
            double result = Calculator.Multiply(2.5, 4);
            Assert.AreEqual(10, result);
        }

        [Test]
        public void Divide_ReturnsCorrectQuotient()
        {
            double result = Calculator.Divide(10, 2);
            Assert.AreEqual(5, result);
        }

        [Test]
        public void ExtractRoot_ReturnsCorrectRoot()
        {
            double result = Calculator.ExtractRoot(16, 2);
            Assert.AreEqual(4, result);
        }

        [Test]
        public void ExtractSquareRoot_ReturnsCorrectSquareRoot()
        {
            double result = Calculator.ExtractSquareRoot(9);
            Assert.AreEqual(3, result);
        }

        [Test]
        public void RaiseToThePower_ReturnsCorrectResultForIntegerPower()
        {
            double result = Calculator.RaiseToThePower(2, 3);
            Assert.AreEqual(8, result);
        }

        [Test]
        public void RaiseToThePower_ReturnsCorrectResultForNonIntegerPower()
        {
            double result = Calculator.RaiseToThePower(27, 1.5);
            Assert.AreEqual(140.29599999999999d, result);
        }

        [Test]
        public void RoundNumber_ReturnsRoundedValue_PositiveNumber()
        {
            double result = Calculator.RoundNumber(5.6789);
            Assert.AreEqual(5.679, result);
        }

        [Test]
        public void RoundNumber_ReturnsRoundedValue_NegativeNumber()
        {
            double result = Calculator.RoundNumber(-3.14159);
            Assert.AreEqual(-3.142, result);
        }

        [Test]
        public void Divide_ByZero_ThrowsDivideByZeroException()
        {
            Assert.Throws<DivideByZeroException>(() => Calculator.Divide(10, 0));
        }

        [Test]
        [TestCase(2, 3, ExpectedResult = 8)]
        [TestCase(0, 5, ExpectedResult = 0)]
        [TestCase(2.5, 2, ExpectedResult = 6.25)]
        public double RaiseToThePower_ReturnsCorrectResult(double number, double power)
        {
            return Calculator.RaiseToThePower(number, power);
        }
    }
}