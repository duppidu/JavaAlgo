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
public class SingeltonTest
{
    public static void main(String[] args)
    {
        Singleton s1 =  Singleton.getINSTANCE();
        Singleton s2 =  Singleton.getINSTANCE();
        System.out.println("s1:"+s1.toString());
        System.out.println("s2:"+s2.toString());
    }
}
