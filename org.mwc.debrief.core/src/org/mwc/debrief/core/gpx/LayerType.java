/*
 *    Debrief - the Open Source Maritime Analysis Application
 *    http://debrief.info
 *
 *    (C) 2000-2014, PlanetMayo Ltd
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the Eclipse Public License v1.0
 *    (http://www.eclipse.org/legal/epl-v10.html)
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 */
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.30 at 10:32:43 PM EDT 
//


package org.mwc.debrief.core.gpx;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for layerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="layerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="textlabel" type="{org.mwc.debrief.core}textlabelType"/>
 *         &lt;element name="line" type="{org.mwc.debrief.core}lineType"/>
 *         &lt;element name="rectangle" type="{org.mwc.debrief.core}rectangleType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LineThickness" type="{http://www.w3.org/2001/XMLSchema}integer" default="1" />
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Visible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "layerType", propOrder = {
    "textlabel",
    "line",
    "rectangle"
})
public class LayerType {

    @XmlElement(required = true)
    protected TextlabelType textlabel;
    @XmlElement(required = true)
    protected LineType line;
    @XmlElement(required = true)
    protected RectangleType rectangle;
    @XmlAttribute(name = "LineThickness")
    protected BigInteger lineThickness;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Visible")
    protected Boolean visible;

    /**
     * Gets the value of the textlabel property.
     * 
     * @return
     *     possible object is
     *     {@link TextlabelType }
     *     
     */
    public TextlabelType getTextlabel() {
        return textlabel;
    }

    /**
     * Sets the value of the textlabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextlabelType }
     *     
     */
    public void setTextlabel(final TextlabelType value) {
        this.textlabel = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link LineType }
     *     
     */
    public LineType getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineType }
     *     
     */
    public void setLine(final LineType value) {
        this.line = value;
    }

    /**
     * Gets the value of the rectangle property.
     * 
     * @return
     *     possible object is
     *     {@link RectangleType }
     *     
     */
    public RectangleType getRectangle() {
        return rectangle;
    }

    /**
     * Sets the value of the rectangle property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectangleType }
     *     
     */
    public void setRectangle(final RectangleType value) {
        this.rectangle = value;
    }

    /**
     * Gets the value of the lineThickness property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineThickness() {
        if (lineThickness == null) {
            return new BigInteger("1");
        } else {
            return lineThickness;
        }
    }

    /**
     * Sets the value of the lineThickness property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineThickness(final BigInteger value) {
        this.lineThickness = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Gets the value of the visible property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isVisible() {
        if (visible == null) {
            return true;
        } else {
            return visible;
        }
    }

    /**
     * Sets the value of the visible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVisible(final Boolean value) {
        this.visible = value;
    }

}
