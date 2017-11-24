/*
 * Copyright (C) 2017 Philippe Tjon - A - Hen philippe@tjonahen.nl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.hpmon;

import java.io.IOException;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import sun.management.ConnectorAddressLink;

/**
 *
 * @author Philippe Tjon - A - Hen
 */
public class HeapMonitor {

    public static void main(String[] args) throws IOException, 
            MalformedObjectNameException, 
            InstanceNotFoundException, 
            MBeanException, 
            ReflectionException, 
            InterruptedException, 
            AttributeNotFoundException 
    {
// create jmx connection with PID
        final String address = ConnectorAddressLink.importFrom(Integer.valueOf(args[0]));
        if (address == null) {
            System.err.println("Process "+args[0]+" not found...");
            return;
        }
        final JMXServiceURL url = new JMXServiceURL(address);
        final JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        jmxc.connect();


// call the garbage collector before the test using the Memory Mbean
        jmxc.getMBeanServerConnection().invoke(new ObjectName("java.lang:type=Memory"), "gc", null, null);

//create a loop to get values every second
        while (true) {
//get an instance of the HeapMemoryUsage Mbean
            final CompositeData cd = (CompositeData) jmxc.getMBeanServerConnection().getAttribute(new ObjectName("java.lang:type=Memory"), "HeapMemoryUsage");
//get an instance of the OperatingSystem Mbean
            final Object osMbean = jmxc.getMBeanServerConnection().getAttribute(new ObjectName("java.lang:type=OperatingSystem"), "ProcessCpuTime");

            System.out.println("{\"ts\":\"" + System.currentTimeMillis() + "\",\"hpmax\":\"" + cd.get("max") + "\",\"hpused\":\"" + cd.get("used") + "\",\"cpu\":\"" + osMbean + "\"}");

            Thread.sleep(1000); 
        }

    }
}
