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

import java.util.Vector;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Application.
 * 
 * @version $Revision$ $Date$
 */
public class Application implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _icon
     */
    private nl.tjonahen.cpv.applicationxml.Icon _icon;

    /**
     * Field _displayName
     */
    private nl.tjonahen.cpv.applicationxml.DisplayName _displayName;

    /**
     * Field _description
     */
    private nl.tjonahen.cpv.applicationxml.Description _description;

    /**
     * Field _moduleList
     */
    private java.util.Vector _moduleList;

    /**
     * Field _securityRoleList
     */
    private java.util.Vector _securityRoleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Application() 
     {
        super();
        _moduleList = new Vector();
        _securityRoleList = new Vector();
    } //-- nl.tjon.a.hen.applicationxml.Application()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addModule
     * 
     * 
     * 
     * @param vModule
     */
    public void addModule(nl.tjonahen.cpv.applicationxml.Module vModule)
        throws java.lang.IndexOutOfBoundsException
    {
        _moduleList.addElement(vModule);
    } //-- void addModule(nl.tjon.a.hen.applicationxml.Module) 

    /**
     * Method addModule
     * 
     * 
     * 
     * @param index
     * @param vModule
     */
    public void addModule(int index, nl.tjonahen.cpv.applicationxml.Module vModule)
        throws java.lang.IndexOutOfBoundsException
    {
        _moduleList.insertElementAt(vModule, index);
    } //-- void addModule(int, nl.tjon.a.hen.applicationxml.Module) 

    /**
     * Method addSecurityRole
     * 
     * 
     * 
     * @param vSecurityRole
     */
    public void addSecurityRole(nl.tjonahen.cpv.applicationxml.SecurityRole vSecurityRole)
        throws java.lang.IndexOutOfBoundsException
    {
        _securityRoleList.addElement(vSecurityRole);
    } //-- void addSecurityRole(nl.tjon.a.hen.applicationxml.SecurityRole) 

    /**
     * Method addSecurityRole
     * 
     * 
     * 
     * @param index
     * @param vSecurityRole
     */
    public void addSecurityRole(int index, nl.tjonahen.cpv.applicationxml.SecurityRole vSecurityRole)
        throws java.lang.IndexOutOfBoundsException
    {
        _securityRoleList.insertElementAt(vSecurityRole, index);
    } //-- void addSecurityRole(int, nl.tjon.a.hen.applicationxml.SecurityRole) 

    /**
     * Method enumerateModule
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateModule()
    {
        return _moduleList.elements();
    } //-- java.util.Enumeration enumerateModule() 

    /**
     * Method enumerateSecurityRole
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSecurityRole()
    {
        return _securityRoleList.elements();
    } //-- java.util.Enumeration enumerateSecurityRole() 

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
     * Returns the value of field 'displayName'.
     * 
     * @return DisplayName
     * @return the value of field 'displayName'.
     */
    public nl.tjonahen.cpv.applicationxml.DisplayName getDisplayName()
    {
        return this._displayName;
    } //-- nl.tjon.a.hen.applicationxml.DisplayName getDisplayName() 

    /**
     * Returns the value of field 'icon'.
     * 
     * @return Icon
     * @return the value of field 'icon'.
     */
    public nl.tjonahen.cpv.applicationxml.Icon getIcon()
    {
        return this._icon;
    } //-- nl.tjon.a.hen.applicationxml.Icon getIcon() 

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
     * Method getModule
     * 
     * 
     * 
     * @param index
     * @return Module
     */
    public nl.tjonahen.cpv.applicationxml.Module getModule(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _moduleList.size())) {
            throw new IndexOutOfBoundsException("getModule: Index value '"+index+"' not in range [0.."+_moduleList.size()+ "]");
        }
        
        return (nl.tjonahen.cpv.applicationxml.Module) _moduleList.elementAt(index);
    } //-- nl.tjon.a.hen.applicationxml.Module getModule(int) 

    /**
     * Method getModule
     * 
     * 
     * 
     * @return Module
     */
    public nl.tjonahen.cpv.applicationxml.Module[] getModule()
    {
        int size = _moduleList.size();
        nl.tjonahen.cpv.applicationxml.Module[] mArray = new nl.tjonahen.cpv.applicationxml.Module[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.tjonahen.cpv.applicationxml.Module) _moduleList.elementAt(index);
        }
        return mArray;
    } //-- nl.tjon.a.hen.applicationxml.Module[] getModule() 

    /**
     * Method getModuleCount
     * 
     * 
     * 
     * @return int
     */
    public int getModuleCount()
    {
        return _moduleList.size();
    } //-- int getModuleCount() 

    /**
     * Method getSecurityRole
     * 
     * 
     * 
     * @param index
     * @return SecurityRole
     */
    public nl.tjonahen.cpv.applicationxml.SecurityRole getSecurityRole(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _securityRoleList.size())) {
            throw new IndexOutOfBoundsException("getSecurityRole: Index value '"+index+"' not in range [0.."+_securityRoleList.size()+ "]");
        }
        
        return (nl.tjonahen.cpv.applicationxml.SecurityRole) _securityRoleList.elementAt(index);
    } //-- nl.tjon.a.hen.applicationxml.SecurityRole getSecurityRole(int) 

    /**
     * Method getSecurityRole
     * 
     * 
     * 
     * @return SecurityRole
     */
    public nl.tjonahen.cpv.applicationxml.SecurityRole[] getSecurityRole()
    {
        int size = _securityRoleList.size();
        nl.tjonahen.cpv.applicationxml.SecurityRole[] mArray = new nl.tjonahen.cpv.applicationxml.SecurityRole[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.tjonahen.cpv.applicationxml.SecurityRole) _securityRoleList.elementAt(index);
        }
        return mArray;
    } //-- nl.tjon.a.hen.applicationxml.SecurityRole[] getSecurityRole() 

    /**
     * Method getSecurityRoleCount
     * 
     * 
     * 
     * @return int
     */
    public int getSecurityRoleCount()
    {
        return _securityRoleList.size();
    } //-- int getSecurityRoleCount() 

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
     * Method removeAllModule
     * 
     */
    public void removeAllModule()
    {
        _moduleList.removeAllElements();
    } //-- void removeAllModule() 

    /**
     * Method removeAllSecurityRole
     * 
     */
    public void removeAllSecurityRole()
    {
        _securityRoleList.removeAllElements();
    } //-- void removeAllSecurityRole() 

    /**
     * Method removeModule
     * 
     * 
     * 
     * @param index
     * @return Module
     */
    public nl.tjonahen.cpv.applicationxml.Module removeModule(int index)
    {
        java.lang.Object obj = _moduleList.elementAt(index);
        _moduleList.removeElementAt(index);
        return (nl.tjonahen.cpv.applicationxml.Module) obj;
    } //-- nl.tjon.a.hen.applicationxml.Module removeModule(int) 

    /**
     * Method removeSecurityRole
     * 
     * 
     * 
     * @param index
     * @return SecurityRole
     */
    public nl.tjonahen.cpv.applicationxml.SecurityRole removeSecurityRole(int index)
    {
        java.lang.Object obj = _securityRoleList.elementAt(index);
        _securityRoleList.removeElementAt(index);
        return (nl.tjonahen.cpv.applicationxml.SecurityRole) obj;
    } //-- nl.tjon.a.hen.applicationxml.SecurityRole removeSecurityRole(int) 

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
     * Sets the value of field 'displayName'.
     * 
     * @param displayName the value of field 'displayName'.
     */
    public void setDisplayName(nl.tjonahen.cpv.applicationxml.DisplayName displayName)
    {
        this._displayName = displayName;
    } //-- void setDisplayName(nl.tjon.a.hen.applicationxml.DisplayName) 

    /**
     * Sets the value of field 'icon'.
     * 
     * @param icon the value of field 'icon'.
     */
    public void setIcon(nl.tjonahen.cpv.applicationxml.Icon icon)
    {
        this._icon = icon;
    } //-- void setIcon(nl.tjon.a.hen.applicationxml.Icon) 

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
     * Method setModule
     * 
     * 
     * 
     * @param index
     * @param vModule
     */
    public void setModule(int index, nl.tjonahen.cpv.applicationxml.Module vModule)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _moduleList.size())) {
            throw new IndexOutOfBoundsException("setModule: Index value '"+index+"' not in range [0.."+_moduleList.size()+ "]");
        }
        _moduleList.setElementAt(vModule, index);
    } //-- void setModule(int, nl.tjon.a.hen.applicationxml.Module) 

    /**
     * Method setModule
     * 
     * 
     * 
     * @param moduleArray
     */
    public void setModule(nl.tjonahen.cpv.applicationxml.Module[] moduleArray)
    {
        //-- copy array
        _moduleList.removeAllElements();
        for (int i = 0; i < moduleArray.length; i++) {
            _moduleList.addElement(moduleArray[i]);
        }
    } //-- void setModule(nl.tjon.a.hen.applicationxml.Module) 

    /**
     * Method setSecurityRole
     * 
     * 
     * 
     * @param index
     * @param vSecurityRole
     */
    public void setSecurityRole(int index, nl.tjonahen.cpv.applicationxml.SecurityRole vSecurityRole)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _securityRoleList.size())) {
            throw new IndexOutOfBoundsException("setSecurityRole: Index value '"+index+"' not in range [0.."+_securityRoleList.size()+ "]");
        }
        _securityRoleList.setElementAt(vSecurityRole, index);
    } //-- void setSecurityRole(int, nl.tjon.a.hen.applicationxml.SecurityRole) 

    /**
     * Method setSecurityRole
     * 
     * 
     * 
     * @param securityRoleArray
     */
    public void setSecurityRole(nl.tjonahen.cpv.applicationxml.SecurityRole[] securityRoleArray)
    {
        //-- copy array
        _securityRoleList.removeAllElements();
        for (int i = 0; i < securityRoleArray.length; i++) {
            _securityRoleList.addElement(securityRoleArray[i]);
        }
    } //-- void setSecurityRole(nl.tjon.a.hen.applicationxml.SecurityRole) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Application
     */
    public static nl.tjonahen.cpv.applicationxml.Application unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
    	
        return (nl.tjonahen.cpv.applicationxml.Application) Unmarshaller.unmarshal(nl.tjonahen.cpv.applicationxml.Application.class, reader);
    } //-- nl.tjon.a.hen.applicationxml.Application unmarshal(java.io.Reader) 

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
