/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.9.1</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.tjonahen.cpv.applicationxml;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Icon.
 * 
 * @version $Revision$ $Date$
 */
public class Icon implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _smallIcon
     */
    private nl.tjonahen.cpv.applicationxml.SmallIcon _smallIcon;

    /**
     * Field _largeIcon
     */
    private nl.tjonahen.cpv.applicationxml.LargeIcon _largeIcon;


      //----------------/
     //- Constructors -/
    //----------------/

    public Icon() 
     {
        super();
    } //-- nl.tjon.a.hen.applicationxml.Icon()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'id'.
     * 
     * @return String
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * Returns the value of field 'largeIcon'.
     * 
     * @return LargeIcon
     * @return the value of field 'largeIcon'.
     */
    public nl.tjonahen.cpv.applicationxml.LargeIcon getLargeIcon()
    {
        return this._largeIcon;
    } //-- nl.tjon.a.hen.applicationxml.LargeIcon getLargeIcon() 

    /**
     * Returns the value of field 'smallIcon'.
     * 
     * @return SmallIcon
     * @return the value of field 'smallIcon'.
     */
    public nl.tjonahen.cpv.applicationxml.SmallIcon getSmallIcon()
    {
        return this._smallIcon;
    } //-- nl.tjon.a.hen.applicationxml.SmallIcon getSmallIcon() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * Sets the value of field 'largeIcon'.
     * 
     * @param largeIcon the value of field 'largeIcon'.
     */
    public void setLargeIcon(nl.tjonahen.cpv.applicationxml.LargeIcon largeIcon)
    {
        this._largeIcon = largeIcon;
    } //-- void setLargeIcon(nl.tjon.a.hen.applicationxml.LargeIcon) 

    /**
     * Sets the value of field 'smallIcon'.
     * 
     * @param smallIcon the value of field 'smallIcon'.
     */
    public void setSmallIcon(nl.tjonahen.cpv.applicationxml.SmallIcon smallIcon)
    {
        this._smallIcon = smallIcon;
    } //-- void setSmallIcon(nl.tjon.a.hen.applicationxml.SmallIcon) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Icon
     */
    public static nl.tjonahen.cpv.applicationxml.Icon unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.tjonahen.cpv.applicationxml.Icon) Unmarshaller.unmarshal(nl.tjonahen.cpv.applicationxml.Icon.class, reader);
    } //-- nl.tjon.a.hen.applicationxml.Icon unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
