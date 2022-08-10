/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.shar0525.web;

import java.awt.Color;
import javax.faces.component.UIColumn;
import javax.faces.context.FacesContextWrapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav Sharma
 */
public class ColorConverterTest {
    
    public ColorConverterTest() {
    }

    /**
     * Test of getAsObject method, of class ColorConverter.
     */
    @Test
    public void testGetAsObject() 
    {
        ColorConverter colorConverter = new ColorConverter();
        Color expectedColor = new Color(18,18,18);   
        Color actualColor = (Color)colorConverter.getAsObject(new FacesContextWrapper(){}, new UIColumn(), "#121212");
        assertEquals(expectedColor,actualColor);
    }

    /**
     * Test of getAsString method, of class ColorConverter.
     */
    @Test
    public void testGetAsString() 
    {
        ColorConverter colorConverter = new ColorConverter();
        String expectedColorString = "#121212";    
        String actualColorString = colorConverter.getAsString(new FacesContextWrapper(){}, new UIColumn(), new Color(18,18,18));  
        assertEquals(expectedColorString,actualColorString);
    }
    
}
