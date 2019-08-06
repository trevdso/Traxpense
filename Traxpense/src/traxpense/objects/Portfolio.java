/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traxpense.objects;

import traxpense.objects.User;

/**
 *
 * @author Trevor
 */
public class Portfolio extends User{
    private String assets;
    private String liabilities;
    
    public Portfolio()
    {
        super();//creates an instance of its parent; Profile.
    }
}
