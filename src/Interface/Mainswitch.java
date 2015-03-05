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
public class Mainswitch implements Switchable
{
    Switchable[] switchs = new Switchable[10];
    private boolean on;                                 //Mainswitch
    int pos = 0;

    @Override
    public void setOn(boolean on)
    {
        this.on = on;
        for (Switchable actSwitch : switchs)
        {
            if (actSwitch != null)
            {
                actSwitch.setOn(true);
            }
        }
    }
 @Override
    public void setOff(boolean off)
    {
        
    }

   public void add(Switchable sw)
   {
       switchs[pos]=sw;
       pos ++;
   }
    @Override
        public String toString()
    {
        return "Mainswitch{" + "on=" + on + '}';
    }

    
    public static void main(String[] args)
    {
        Mainswitch mainSwitch= new Mainswitch();
        mainSwitch.add(new TV());
       
        
    }

   
}
