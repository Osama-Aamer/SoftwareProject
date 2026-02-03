

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {
    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        this.converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius_FreezingPoint() {
        double result = this.converter.fahrenheitToCelsius((double)32.0F);
        Assertions.assertEquals((double)0.0F, result, 0.001, "32°F should convert to 0°C");
    }

    @Test
    void testFahrenheitToCelsius_BoilingPoint() {
        double result = this.converter.fahrenheitToCelsius((double)212.0F);
        Assertions.assertEquals((double)100.0F, result, 0.001, "212°F should convert to 100°C");
    }

    @Test
    void testFahrenheitToCelsius_NegativeTemperature() {
        double result = this.converter.fahrenheitToCelsius((double)-40.0F);
        Assertions.assertEquals((double)-40.0F, result, 0.001, "-40°F should convert to -40°C");
    }

    @Test
    void testFahrenheitToCelsius_BodyTemperature() {
        double result = this.converter.fahrenheitToCelsius(98.6);
        Assertions.assertEquals((double)37.0F, result, 0.1, "98.6°F should convert to approximately 37°C");
    }

    @Test
    void testFahrenheitToCelsius_RoomTemperature() {
        double result = this.converter.fahrenheitToCelsius((double)68.0F);
        Assertions.assertEquals((double)20.0F, result, 0.001, "68°F should convert to 20°C");
    }

    @Test
    void testCelsiusToFahrenheit_FreezingPoint() {
        double result = this.converter.celsiusToFahrenheit((double)0.0F);
        Assertions.assertEquals((double)32.0F, result, 0.001, "0°C should convert to 32°F");
    }

    @Test
    void testCelsiusToFahrenheit_BoilingPoint() {
        double result = this.converter.celsiusToFahrenheit((double)100.0F);
        Assertions.assertEquals((double)212.0F, result, 0.001, "100°C should convert to 212°F");
    }

    @Test
    void testCelsiusToFahrenheit_NegativeTemperature() {
        double result = this.converter.celsiusToFahrenheit((double)-40.0F);
        Assertions.assertEquals((double)-40.0F, result, 0.001, "-40°C should convert to -40°F");
    }

    @Test
    void testCelsiusToFahrenheit_BodyTemperature() {
        double result = this.converter.celsiusToFahrenheit((double)37.0F);
        Assertions.assertEquals(98.6, result, 0.1, "37°C should convert to approximately 98.6°F");
    }

    @Test
    void testCelsiusToFahrenheit_RoomTemperature() {
        double result = this.converter.celsiusToFahrenheit((double)20.0F);
        Assertions.assertEquals((double)68.0F, result, 0.001, "20°C should convert to 68°F");
    }

    @Test
    void testIsExtremeTemperature_BelowExtremeCold() {
        Assertions.assertTrue(this.converter.isExtremeTemperature((double)-50.0F), "-50°C should be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_ExactlyMinusForty() {
        Assertions.assertFalse(this.converter.isExtremeTemperature((double)-40.0F), "-40°C should not be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_AboveExtremeHot() {
        Assertions.assertTrue(this.converter.isExtremeTemperature((double)60.0F), "60°C should be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_ExactlyFifty() {
        Assertions.assertFalse(this.converter.isExtremeTemperature((double)50.0F), "50°C should not be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_NormalTemperature() {
        Assertions.assertFalse(this.converter.isExtremeTemperature((double)25.0F), "25°C should not be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_Zero() {
        Assertions.assertFalse(this.converter.isExtremeTemperature((double)0.0F), "0°C should not be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_JustBelowLowerBoundary() {
        Assertions.assertTrue(this.converter.isExtremeTemperature(-40.1), "-40.1°C should be considered extreme");
    }

    @Test
    void testIsExtremeTemperature_JustAboveUpperBoundary() {
        Assertions.assertTrue(this.converter.isExtremeTemperature(50.1), "50.1°C should be considered extreme");
    }

    @Test
    void testRoundTripConversion_Celsius() {
        double celsius = (double)25.0F;
        double fahrenheit = this.converter.celsiusToFahrenheit(celsius);
        double backToCelsius = this.converter.fahrenheitToCelsius(fahrenheit);
        Assertions.assertEquals(celsius, backToCelsius, 0.001, "Round trip conversion should return the same value");
    }

    @Test
    void testRoundTripConversion_Fahrenheit() {
        double fahrenheit = (double)77.0F;
        double celsius = this.converter.fahrenheitToCelsius(fahrenheit);
        double backToFahrenheit = this.converter.celsiusToFahrenheit(celsius);
        Assertions.assertEquals(fahrenheit, backToFahrenheit, 0.001, "Round trip conversion should return the same value");
    }
}
