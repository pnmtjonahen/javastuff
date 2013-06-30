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
 * Class Module.
 * 
 * @version $Revision$ $Date$
 */
public class Module implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _moduleChoice
     */
    private nl.tjonahen.cpv.applicationxml.ModuleChoice _moduleChoice;

    /**
     * Field _altDd
     */
    private nl.tjonahen.cpv.applicationxml.AltDd _altDd;


      //----------------/
     //- Constructors -/
    //----------------/

    public Module() 
     {
        super();
    } //-- nl.tjon.a.hen.applicationxml.Module()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'altDd'.
     * 
     * @return AltDd
     * @return the value of field 'altDd'.
     */
    public nl.tjonahen.cpv.applicationxml.AltDd getAltDd()
    {
        return this._altDd;
    } //-- nl.tjon.a.hen.applicationxml.AltDd getAltDd() 

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
     * Returns the value of field 'moduleChoice'.
     * 
     * @return ModuleChoice
     * @return the value of field 'moduleChoice'.
     */
    public nl.tjonahen.cpv.applicationxml.ModuleChoice getModuleChoice()
    {
        return this._moduleChoice;
    } //-- nl.tjon.a.hen.applicationxml.ModuleChoice getModuleChoice() 

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
     * Sets the value of field 'altDd'.
     * 
     * @param altDd the value of field 'altDd'.
     */
    public void setAltDd(nl.tjonahen.cpv.applicationxml.AltDd altDd)
    {
        this._altDd = altDd;
    } //-- void setAltDd(nl.tjon.a.hen.applicationxml.AltDd) 

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
     * Sets the value of field 'moduleChoice'.
     * 
     * @param moduleChoice the value of field 'moduleChoice'.
     */
    public void setModuleChoice(nl.tjonahen.cpv.applicationxml.ModuleChoice moduleChoice)
    {
        this._moduleChoice = moduleChoice;
    } //-- void setModuleChoice(nl.tjon.a.hen.applicationxml.ModuleChoice) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Module
     */
    public static nl.tjonahen.cpv.applicationxml.Module unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.tjonahen.cpv.applicationxml.Module) Unmarshaller.unmarshal(nl.tjonahen.cpv.applicationxml.Module.class, reader);
    } //-- nl.tjon.a.hen.applicationxml.Module unmarshal(java.io.Reader) 

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
