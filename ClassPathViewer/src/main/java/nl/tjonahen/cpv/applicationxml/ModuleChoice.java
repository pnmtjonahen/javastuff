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
 * Class ModuleChoice.
 * 
 * @version $Revision$ $Date$
 */
public class ModuleChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _connector
     */
    private nl.tjonahen.cpv.applicationxml.Connector _connector;

    /**
     * Field _ejb
     */
    private nl.tjonahen.cpv.applicationxml.Ejb _ejb;

    /**
     * Field _java
     */
    private nl.tjonahen.cpv.applicationxml.Java _java;

    /**
     * Field _web
     */
    private nl.tjonahen.cpv.applicationxml.Web _web;


      //----------------/
     //- Constructors -/
    //----------------/

    public ModuleChoice() 
     {
        super();
    } //-- nl.tjon.a.hen.applicationxml.ModuleChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'connector'.
     * 
     * @return Connector
     * @return the value of field 'connector'.
     */
    public nl.tjonahen.cpv.applicationxml.Connector getConnector()
    {
        return this._connector;
    } //-- nl.tjon.a.hen.applicationxml.Connector getConnector() 

    /**
     * Returns the value of field 'ejb'.
     * 
     * @return Ejb
     * @return the value of field 'ejb'.
     */
    public nl.tjonahen.cpv.applicationxml.Ejb getEjb()
    {
        return this._ejb;
    } //-- nl.tjon.a.hen.applicationxml.Ejb getEjb() 

    /**
     * Returns the value of field 'java'.
     * 
     * @return Java
     * @return the value of field 'java'.
     */
    public nl.tjonahen.cpv.applicationxml.Java getJava()
    {
        return this._java;
    } //-- nl.tjon.a.hen.applicationxml.Java getJava() 

    /**
     * Returns the value of field 'web'.
     * 
     * @return Web
     * @return the value of field 'web'.
     */
    public nl.tjonahen.cpv.applicationxml.Web getWeb()
    {
        return this._web;
    } //-- nl.tjon.a.hen.applicationxml.Web getWeb() 

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
     * Sets the value of field 'connector'.
     * 
     * @param connector the value of field 'connector'.
     */
    public void setConnector(nl.tjonahen.cpv.applicationxml.Connector connector)
    {
        this._connector = connector;
    } //-- void setConnector(nl.tjon.a.hen.applicationxml.Connector) 

    /**
     * Sets the value of field 'ejb'.
     * 
     * @param ejb the value of field 'ejb'.
     */
    public void setEjb(nl.tjonahen.cpv.applicationxml.Ejb ejb)
    {
        this._ejb = ejb;
    } //-- void setEjb(nl.tjon.a.hen.applicationxml.Ejb) 

    /**
     * Sets the value of field 'java'.
     * 
     * @param java the value of field 'java'.
     */
    public void setJava(nl.tjonahen.cpv.applicationxml.Java java)
    {
        this._java = java;
    } //-- void setJava(nl.tjon.a.hen.applicationxml.Java) 

    /**
     * Sets the value of field 'web'.
     * 
     * @param web the value of field 'web'.
     */
    public void setWeb(nl.tjonahen.cpv.applicationxml.Web web)
    {
        this._web = web;
    } //-- void setWeb(nl.tjon.a.hen.applicationxml.Web) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ModuleChoice
     */
    public static nl.tjonahen.cpv.applicationxml.ModuleChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.tjonahen.cpv.applicationxml.ModuleChoice) Unmarshaller.unmarshal(nl.tjonahen.cpv.applicationxml.ModuleChoice.class, reader);
    } //-- nl.tjon.a.hen.applicationxml.ModuleChoice unmarshal(java.io.Reader) 

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
