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
public class Kaffemaschine implements Switchable
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
        return "Kaffemaschine{" + "on=" + on + '}';
    }

    @Override
    public void setOff(boolean off)
    {
        
    }
    
    
    
    
    
}
