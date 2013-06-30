package nl.tjonahen.cpv.ear;

/*
 * $Id: EarFile.java 14 2005-11-22 12:19:26Z ordina $
 * 
 * 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import nl.tjonahen.cpv.applicationxml.Application;
import nl.tjonahen.cpv.applicationxml.Ejb;
import nl.tjonahen.cpv.applicationxml.Module;
import nl.tjonahen.cpv.applicationxml.Web;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

public class EarFile {
	
	private ZipFile zipFile = null;
	private List<String> fileNames = new ArrayList<String>();
	private Application application = null;
	
	public EarFile(String earFile) {
		try {
			zipFile = new ZipFile(earFile);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Enumeration zipEntries = zipFile.entries();
		while (zipEntries.hasMoreElements()) {
			ZipEntry zipEntry = (ZipEntry) zipEntries.nextElement();
			fileNames.add(zipEntry.getName());
		}
		
	}

	/**
	 * @return Returns the fileNames.
	 */
	public List<String> getFileNames() {
		return fileNames;
	}
	
	void getFile(String fileName, OutputStream os) throws IOException {
		BufferedInputStream is = new BufferedInputStream(zipFile.getInputStream(zipFile.getEntry(fileName)));
		int count;
		byte data[] = new byte[2048];
		while ((count = is.read(data, 0, 2048)) != -1) {
			os.write(data, 0, count);
		}
		os.flush();
		is.close();
	}

	public Application getApplicationXml() throws MarshalException, ValidationException, IOException {
		if (application != null)
				return application;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		getFile("META-INF/application.xml", new BufferedOutputStream(baos));
		
		application = Application.unmarshal(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray())));
		return application;
	}
	
	public List<String> getEjbModules() throws MarshalException, ValidationException, IOException {
		Application app = getApplicationXml();
		List<String> modules = new ArrayList<String>();
		
		for (int i = 0; i < app.getModuleCount(); i++) {
			Module module = app.getModule(i);
			Ejb ejbModule = module.getModuleChoice().getEjb();
			if (ejbModule != null) {
				modules.add(ejbModule.getContent());
			}
		}
		return modules;
	}

	public List<String> getWebModules() throws MarshalException, ValidationException, IOException {
		Application app = getApplicationXml();
		List<String> modules = new ArrayList<String>();
		
		for (int i = 0; i < app.getModuleCount(); i++) {
			Module module = app.getModule(i);
			Web webModule = module.getModuleChoice().getWeb();
			if (webModule != null) {
				modules.add(webModule.getWebUri().getContent());
			}
		}
		return modules;
	}

	
	public JarFile getJarModule(String moduleNaam) throws MarshalException, ValidationException, IOException {
		Application app = getApplicationXml();
		for (int i = 0; i < app.getModuleCount(); i++) {
			Module module = app.getModule(i);
			Ejb ejbModule = module.getModuleChoice().getEjb();
			if (ejbModule != null) {
				if (moduleNaam.equals(ejbModule.getContent())) {
					File tmpFile = File.createTempFile("cpv", "tmp");
					FileOutputStream fos = new FileOutputStream(tmpFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					getFile(ejbModule.getContent(), bos);
					bos.close();
					fos.close();
					
					return  new JarFile(tmpFile);
				}
			}
		}
		return null;
	}
	public ModuleFile getModule(String moduleNaam) throws MarshalException, ValidationException, IOException {
		Application app = getApplicationXml();
		for (int i = 0; i < app.getModuleCount(); i++) {
			Module module = app.getModule(i);
			Ejb ejbModule = module.getModuleChoice().getEjb();
			if (ejbModule != null) {
				if (moduleNaam.equals(ejbModule.getContent())) {
					File tmpFile = File.createTempFile("cpv", "tmp");
					FileOutputStream fos = new FileOutputStream(tmpFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					getFile(ejbModule.getContent(), bos);
					bos.close();
					fos.close();
					
					return  new ModuleFile(true, tmpFile);
				}
			}
			Web webModule = module.getModuleChoice().getWeb();
			if (webModule != null) {
				if (moduleNaam.equals(webModule.getWebUri().getContent())) {
					File tmpFile = File.createTempFile("cpv", "tmp");
					FileOutputStream fos = new FileOutputStream(tmpFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					getFile(webModule.getWebUri().getContent(), bos);
					bos.close();
					fos.close();
					
					return  new ModuleFile(false, tmpFile);
				}
			}
		}
		return null;
	}

	public ModuleFile getJarFile(String moduleNaam) throws IOException {
		if (!isModuleInEar(moduleNaam)) return null;
		File tmpFile = File.createTempFile("cpv", "tmp");
		FileOutputStream fos = new FileOutputStream(tmpFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		getFile(moduleNaam, bos);
		bos.close();
		fos.close();
		return new ModuleFile(true, tmpFile);
	}
	
	private boolean isModuleInEar(String naam) {
		return zipFile.getEntry(naam) != null; 
	}
}
