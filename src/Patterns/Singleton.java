/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

/**
 *
 * @author thomas.duppenthaler
 */
public class Singleton
{
    private static final Singleton INSTANCE = new Singleton();
    
    private Singleton()
    {
        
    }

    public static Singleton getINSTANCE()
    {
        return INSTANCE;
    }

}
