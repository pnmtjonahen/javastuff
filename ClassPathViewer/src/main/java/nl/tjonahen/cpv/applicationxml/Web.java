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
 * Class Web.
 * 
 * @version $Revision$ $Date$
 */
public class Web implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _webUri
     */
    private nl.tjonahen.cpv.applicationxml.WebUri _webUri;

    /**
     * Field _contextRoot
     */
    private nl.tjonahen.cpv.applicationxml.ContextRoot _contextRoot;


      //----------------/
     //- Constructors -/
    //----------------/

    public Web() 
     {
        super();
    } //-- nl.tjon.a.hen.applicationxml.Web()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'contextRoot'.
     * 
     * @return ContextRoot
     * @return the value of field 'contextRoot'.
     */
    public nl.tjonahen.cpv.applicationxml.ContextRoot getContextRoot()
    {
        return this._contextRoot;
    } //-- nl.tjon.a.hen.applicationxml.ContextRoot getContextRoot() 

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
     * Returns the value of field 'webUri'.
     * 
     * @return WebUri
     * @return the value of field 'webUri'.
     */
    public nl.tjonahen.cpv.applicationxml.WebUri getWebUri()
    {
        return this._webUri;
    } //-- nl.tjon.a.hen.applicationxml.WebUri getWebUri() 

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
     * Sets the value of field 'contextRoot'.
     * 
     * @param contextRoot the value of field 'contextRoot'.
     */
    public void setContextRoot(nl.tjonahen.cpv.applicationxml.ContextRoot contextRoot)
    {
        this._contextRoot = contextRoot;
    } //-- void setContextRoot(nl.tjon.a.hen.applicationxml.ContextRoot) 

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
     * Sets the value of field 'webUri'.
     * 
     * @param webUri the value of field 'webUri'.
     */
    public void setWebUri(nl.tjonahen.cpv.applicationxml.WebUri webUri)
    {
        this._webUri = webUri;
    } //-- void setWebUri(nl.tjon.a.hen.applicationxml.WebUri) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Web
     */
    public static nl.tjonahen.cpv.applicationxml.Web unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.tjonahen.cpv.applicationxml.Web) Unmarshaller.unmarshal(nl.tjonahen.cpv.applicationxml.Web.class, reader);
    } //-- nl.tjon.a.hen.applicationxml.Web unmarshal(java.io.Reader) 

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
