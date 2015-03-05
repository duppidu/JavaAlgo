/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author thomas.duppenthaler
 */
public class Licht implements Switchable
{
  
     private boolean on;

     @Override
    public void setOn(boolean on)
    {
        this.on = on;
    }

    @Override
    public String toString()
    {
        return "Licht{" + "on=" + on + '}';
    }

    @Override
    public void setOff(boolean off)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
