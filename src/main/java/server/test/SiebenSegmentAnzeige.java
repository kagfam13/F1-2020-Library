package server.test;

import com.pi4j.io.gpio.*;

public class SiebenSegmentAnzeige {
    private GpioController gpio;
    private GpioPinDigitalOutput pinOben;
    private GpioPinDigitalOutput pinLOben;
    private GpioPinDigitalOutput pinROben;
    private GpioPinDigitalOutput pinMitte;
    private GpioPinDigitalOutput pinLUnten;
    private GpioPinDigitalOutput pinRUnten;
    private GpioPinDigitalOutput pinUnten;

    public SiebenSegmentAnzeige() {
        gpio = GpioFactory.getInstance();
        pinOben = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15,"Oben", PinState.LOW);
        pinROben = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"Rechts Oben", PinState.LOW);
        pinLOben = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16,"Links Oben", PinState.LOW);
        pinMitte = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"Mitte", PinState.LOW);
        pinLUnten = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05,"Links Unten", PinState.LOW);
        pinRUnten = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06,"Rechts Unten", PinState.LOW);
        pinUnten = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10,"Unten", PinState.LOW);
    }
    public void setNumber(int number) {
        switch (number) {
            case -1: printRevers(); break;
            case 0: printNull(); break;
            case 1: printOne(); break;
            case 2: printTwo(); break;
            case 3: printThree(); break;
            case 4: printFour(); break;
            case 5: printFive(); break;
            case 6: printSix(); break;
            case 7: printSeven(); break;
            case 8: printEight(); break;
            case 9: printNine(); break;
            default: allOff();
        }
    }

    private void printRevers() {
        allOff();
        pinMitte.high();
        pinRUnten.high();
    }

    private void allOff() {
        pinOben.low();
        pinROben.low();
        pinLOben.low();
        pinMitte.low();
        pinRUnten.low();
        pinLUnten.low();
        pinUnten.low();
    }

    private void printNull() {
        allOff();
        pinOben.high();
        pinROben.high();
        pinLOben.high();
        pinRUnten.high();
        pinLUnten.high();
        pinUnten.high();
    }

    private void printOne() {
        allOff();
        pinROben.high();
        pinRUnten.high();
    }

    private void printTwo() {
        allOff();
        pinOben.high();
        pinROben.high();
        pinMitte.high();
        pinLUnten.high();
        pinUnten.high();
    }

    private void printThree() {
        allOff();
        pinOben.high();
        pinROben.high();
        pinRUnten.high();
        pinMitte.high();
        pinUnten.high();
    }

    private void printFour() {
        allOff();
        pinLOben.high();
        pinROben.high();
        pinRUnten.high();
        pinMitte.high();
    }

    private void printFive() {
        allOff();
        pinOben.high();
        pinLOben.high();
        pinRUnten.high();
        pinMitte.high();
        pinUnten.high();
    }

    private void printSix() {
        allOff();
        pinOben.high();
        pinLOben.high();
        pinLUnten.high();
        pinMitte.high();
        pinRUnten.high();
        pinUnten.high();
    }

    private void printSeven() {
        allOff();
        pinOben.high();
        pinROben.high();
        pinRUnten.high();
    }

    private void printEight() {
        allOff();
        pinOben.high();
        pinLOben.high();
        pinROben.high();
        pinMitte.high();
        pinRUnten.high();
        pinLUnten.high();
        pinUnten.high();
    }

    private void printNine() {
        allOff();
        pinOben.high();
        pinLOben.high();
        pinROben.high();
        pinMitte.high();
        pinRUnten.high();
        pinUnten.high();
    }


}
