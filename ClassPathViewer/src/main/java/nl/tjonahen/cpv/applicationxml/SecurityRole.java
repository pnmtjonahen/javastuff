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
 * Class SecurityRole.
 * 
 * @version $Revision$ $Date$
 */
public class SecurityRole implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _description
     */
    private nl.tjonahen.cpv.applicationxml.Description _description;

    /**
     * Field _roleName
     */
    private nl.tjonahen.cpv.applicationxml.RoleName _roleName;


      //----------------/
     //- Constructors -/
    //----------------/

    public SecurityRole() 
     {
        super();
    } //-- nl.tjon.a.hen.applicationxml.SecurityRole()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'description'.
     * 
     * @return Description
     * @return the value of field 'description'.
     */
    public nl.tjonahen.cpv.applicationxml.Description getDescription()
    {
        return this._description;
    } //-- nl.tjon.a.hen.applicationxml.Description getDescription() 

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
     * Returns the value of field 'roleName'.
     * 
     * @return RoleName
     * @return the value of field 'roleName'.
     */
    public nl.tjonahen.cpv.applicationxml.RoleName getRoleName()
    {
        return this._roleName;
    } //-- nl.tjon.a.hen.applicationxml.RoleName getRoleName() 

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
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(nl.tjonahen.cpv.applicationxml.Description description)
    {
        this._description = description;
    } //-- void setDescription(nl.tjon.a.hen.applicationxml.Description) 

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
     * Sets the value of field 'roleName'.
     * 
     * @param roleName the value of field 'roleName'.
     */
    public void setRoleName(nl.tjonahen.cpv.applicationxml.RoleName roleName)
    {
        this._roleName = roleName;
    } //-- void setRoleName(nl.tjon.a.hen.applicationxml.RoleName) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SecurityRole
     */
    public static nl.tjonahen.cpv.applicationxml.SecurityRole unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.tjonahen.cpv.applicationxml.SecurityRole) Unmarshaller.unmarshal(nl.tjonahen.cpv.applicationxml.SecurityRole.class, reader);
    } //-- nl.tjon.a.hen.applicationxml.SecurityRole unmarshal(java.io.Reader) 

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
