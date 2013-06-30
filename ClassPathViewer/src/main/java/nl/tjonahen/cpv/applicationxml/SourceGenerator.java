package nl.tjonahen.cpv.applicationxml;

/*
 * $Id: SourceGenerator.java 12 2005-11-21 19:51:08Z ordina $
 * 
 * Castor source code generator.
 */

public class SourceGenerator {

	public static void main(String[] args) {
//		String[] args2 = {"src/nl/tjon/a/hen/applicationxml/application_1_3.dtd", "src/nl/tjon/a/hen/applicationxml/application_1_3.xsd"};
//		try {
//			Converter.main(args2);
//		} catch (SchemaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DTDException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String[] actualArgs = { "-i", "src/nl/tjon/a/hen/applicationxml/application_1_3.xsd", "-dest", "src", "-package", "nl.tjon.a.hen.applicationxml" };
		org.exolab.castor.builder.SourceGenerator.main(actualArgs);
		System.out.println("Done, refresh workspace");
	}
}
