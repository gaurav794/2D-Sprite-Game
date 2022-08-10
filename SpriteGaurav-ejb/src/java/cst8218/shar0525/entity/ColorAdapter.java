/*************************************************************************************************************
Filename            : ColorAdapter.java
Author              : Gaurav Sharma
Student No          : 040 956 858
Course Name/Number  : CST8218 Web Enterprise Application
Lab Section         : 301
Labs/Assignments    : Assignment 1
Submission Date     : March 26, 2021
Due Date            : March 26, 2021
Professor           : Todd Kelly
Purpose             : Marshal and unmarshal the xml document to java understandable datatype which is Color object.                 
*************************************************************************************************************/
package cst8218.shar0525.entity;

import java.awt.Color;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Gaurav Sharma
 */
public class ColorAdapter extends XmlAdapter<ColorAdapter.ColorValueType, Color> {
        @Override
        public Color unmarshal(ColorValueType v) throws Exception {
            return new Color(v.red, v.green, v.blue);
        }
        @Override
        public ColorValueType marshal(Color v) throws Exception {
            return new ColorValueType(v.getRed(), v.getRed(), v.getBlue());
        }
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ColorValueType {
            private int red;
            private int green;
            private int blue;
            public ColorValueType() {
            }
            public ColorValueType(int red, int green, int blue) {
                this.red = red;
                this.green = green;
                this.blue = blue;
            }
        } 
}

