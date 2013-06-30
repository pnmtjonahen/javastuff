package nl.tjonahen.cpv.ear;
/*
 *  $Id$
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class ModuleFile extends JarFile {

	private boolean jarWar = false;
	
	public ModuleFile(boolean jarWar, File file) throws IOException {
		super(file);
		this.jarWar = jarWar;
	}

	public ModuleFile(boolean jarWar, String fileName) throws IOException {
		super(fileName);
		this.jarWar = jarWar;
	}

	/**
	 * Gets all dependencies (Manifest-Class-Path or WEB-INF/lib entries)
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<String> getDependencies() throws IOException {
		List<String> deps = new ArrayList<String>();
		getManifestEntries(deps);	
		getWebInfLibEntries(deps);
		return deps;
	}

	private void getWebInfLibEntries(List<String> deps) {
		if (!jarWar) {
			Enumeration<JarEntry> entrys = entries();
			while (entrys.hasMoreElements()) {
				JarEntry jarEntry = entrys.nextElement();
				if (jarEntry.getName().startsWith("WEB-INF/lib/") && jarEntry.getName().endsWith(".jar") ) {
					deps.add(jarEntry.getName());
				}
			}
		}
	}

	private void getManifestEntries(List<String> deps) throws IOException {
		Manifest manifest = getManifest();
		if (manifest == null) return;
		Attributes mainAttributes = manifest.getMainAttributes();
		if (mainAttributes == null) return;
		String classPath = mainAttributes.getValue(Attributes.Name.CLASS_PATH);
		if (classPath != null) {
			StringTokenizer st = new StringTokenizer(classPath);
			while (st.hasMoreTokens()) {
				deps.add(st.nextToken());
			}	
		}
	}
	private void getFile(String fileName, OutputStream os) throws IOException {
		BufferedInputStream is = new BufferedInputStream(getInputStream(getEntry(fileName)));
		int count;
		byte data[] = new byte[2048];
		while ((count = is.read(data, 0, 2048)) != -1) {
			os.write(data, 0, count);
		}
		os.flush();
		is.close();
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
		return getEntry(naam) != null; 
	}

}
