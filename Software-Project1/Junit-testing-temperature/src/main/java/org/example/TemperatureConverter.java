
package org.example;

public class TemperatureConverter {
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - (double)32.0F) * (double)5.0F / (double)9.0F;
    }

    public double celsiusToFahrenheit(double celsius) {
        return celsius * (double)9.0F / (double)5.0F + (double)32.0F;
    }

    public boolean isExtremeTemperature(double celsius) {
        return celsius < (double)-40.0F || celsius > (double)50.0F;
    }
}
