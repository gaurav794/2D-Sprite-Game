/*************************************************************************************************************
Filename            : ColorConverter.java
Author              : Gaurav Sharma
Student No          : 040 956 858
Course Name/Number  : CST8218 Web Enterprise Application
Lab Section         : 301
Labs/Assignments    : Assignment 1
Submission Date     : March 26, 2021
Due Date            : March 26, 2021
Professor           : Todd Kelly
Purpose             : Converts the user input(string) into Color object and vice versa
Reference           : https://mkyong.com/jsf2/custom-converter-in-jsf-2-0/ .
*************************************************************************************************************/
package cst8218.shar0525.web;

import cst8218.shar0525.entity.Sprite;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Gaurav Sharma
 */
@FacesConverter("cst8218.shar0525.ColorConverter")
public class ColorConverter implements Converter {
    
    private Color color;//Store color value
    private Sprite sprite;
    private String colorValue;
    private StringBuilder hexBuilder = new StringBuilder("#");
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) 
    {
        
    // Regex to check valid hexadecimal color code.
    Pattern pattern = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(value);
    boolean matchFound = matcher.find();
    
    //if HEX format is invalid
    if(!matchFound){
        FacesMessage msg = 
            new FacesMessage("Invalid Color format. Example: HEX Color: #FF00AE","Color Conversion error." );
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ConverterException(msg);
    }
    
        color = Color.decode(value);   
        return color;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) 
    {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(value.toString());
        while(m.find()) {
            hexBuilder.append(Integer.toHexString(Integer.parseInt(m.group())));
        }
        
        return hexBuilder.toString();
    }
    
    
}
