/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thomas.duppenthaler
 */
public class MainswitchList implements Switchable
{

    private List<Switchable> switchs = new ArrayList();
    private boolean on;                                 //Mainswitch
    int pos = 0;

    @Override
    public void setOn(boolean on)
    {
        this.on = on;

        /* for (Object actSwitch : switchs)
         {
         if (actSwitch != null)
         {
         ((Switchable) actSwitch).setOn(true);
         }
         }  */
        for (Switchable actSwitch : switchs)
        {
            if (actSwitch != null)
            {
                actSwitch.setOn(true);
            }
        }
    }

    @Override
    public void setOff(boolean off
    )
    {
        /*
         for (int i = 0; i < switchs.size(); i++)
         {
         ((Switchable) switchs.get(i)).setOn(true);
         }
         */
        for (int i = 0; i < switchs.size(); i++)
        {
            switchs.get(i).setOn(true);
        }

    }

    public void add(Switchable sw)
    {
        switchs.add(sw);

    }

    public void remove(Switchable sw)
    {
        switchs.remove(sw);
    }

    @Override
    public String toString()
    {
        return "Mainswitch{" + "on=" + on + '}';
    }

    public static void main(String[] args)
    {
        Mainswitch mainSwitch = new Mainswitch();
        mainSwitch.add(new TV());

    }

}
