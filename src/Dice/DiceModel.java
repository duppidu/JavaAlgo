/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice;

/**
 *
 * @author thomas.duppenthaler
 */
public class DiceModel
{
    private int rangeMin; // Kleinste Zahl auf dem Würfel
    private int rangeMax; // Grösste Zahl auf dem Würfel
    private int value; // Gewürfelte Zahl

    public DiceModel() // Standart Würfel
    {
        rangeMin = 1;
        rangeMax = 6;
    }

    public DiceModel(int min, int max) // frei definierbarer Würfel
    {
        setRange(min, max);
    }

    /**
     *
     * @param min Kleinste Zahl auf dem Würfel
     * @param max Grösste Zahl auf dem Würfel
     */
    public void setRange(int min, int max)
    {
        this.rangeMin = min;
        this.rangeMax = max;
    }

    public void roll() //Würfeln ergiebt die Zuffalszahl
    {

        int delta = rangeMax - rangeMin + 1;

        this.value = (int) (Math.random() * delta + this.rangeMin); //errechnen der Zufallszahl
    }

    public int getValue() // rückgabe der gewürfelten Zahl
    {
        return value;
    }

  
    public String valueToString()
    {
        return "|" + value;
    }

    /**
     *
     * @param countNum Wie oft soll gewürfelt werden
     */
    public void countSides(int countNum) //Analyse eines Würfels von 1-6
    {

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int x = 0;
        do
        {
            roll();
            switch (value) //Zählt die Anzahl der gewürfelten Zahlen hoch 
            {
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
                case 3:
                    num3++;
                    break;
                case 4:
                    num4++;
                    break;
                case 5:
                    num5++;
                    break;
                case 6:
                    num6++;
                    break;
            }
            x++;
        } while (x <= countNum);

        System.out.println("Eins " + num1 + " mal von " + countNum + " mal Würfeln");
        System.out.println("Zwei " + num2 + " mal von " + countNum + " mal Würfeln");
        System.out.println("Drei " + num3 + " mal von " + countNum + " mal Würfeln");
        System.out.println("Vier " + num4 + " mal von " + countNum + " mal Würfeln");
        System.out.println("Fünf " + num5 + " mal von " + countNum + " mal Würfeln");
        System.out.println("Sechs " + num6 + " mal von " + countNum + " mal Würfeln");

    }

    public void controll(int countNum) //Analyse eines  belibigen Würfels 
    {
        int x = 0;
        int[] ergebnis;
        ergebnis = new int[rangeMax+1]; //länge des Arrays
        int y = rangeMin; //erste zurückgegebene Zahl
        
        do
        {
            roll();
            ergebnis[getValue()]++; //Hochzählen der gewürfelten Zahl
            x++;
        } while (x < countNum);
        
        do   // Ausgabe der Ergebnisse
        {

            System.out.println(y + " wurde " + ergebnis[y] + " mal von " + countNum + " mal Würfeln gewürfelt");
            y++;
        } while (y < ergebnis.length);
    }
}
