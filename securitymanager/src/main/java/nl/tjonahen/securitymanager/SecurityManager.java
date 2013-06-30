/*
 * Copyright (C) 2013 Philippe Tjon-A-Hen philippe@tjonahen.nl
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
package nl.tjonahen.securitymanager;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logging security manager. Logs all security manager calls.
 *
 *
 */
public final class SecurityManager extends java.lang.SecurityManager {

    private void log(String msg) {
        Logger.getLogger(SecurityManager.class.getName()).log(Level.INFO, msg);
    }

    @Override
    public void checkAccept(String arg0, int arg1) {
        log("Accept Host:" + arg0 + " port:" + arg1);

    }

    @Override
    public void checkAccess(Thread arg0) {
        log("Access thread:" + arg0.getName());
    }

    @Override
    public void checkAccess(ThreadGroup arg0) {
        log("Access threadGroup:" + arg0.getName());
    }

    @Override
    public void checkAwtEventQueueAccess() {
        log("AwtEventQueueAccess");
    }

    @Override
    public void checkConnect(String arg0, int arg1, Object arg2) {
        log("Connect host:" + arg0 + " port:" + arg1 + " conext:" + arg2);
    }

    @Override
    public void checkConnect(String arg0, int arg1) {
        log("Connect host:" + arg0 + " port:" + arg1);
    }

    @Override
    public void checkCreateClassLoader() {
        log("CreateClassLoader");
    }

    @Override
    public void checkDelete(String arg0) {
        log("Delete file:" + arg0);
    }

    @Override
    public void checkExec(String arg0) {
        log("Exec process:" + arg0);
    }

    @Override
    public void checkExit(int arg0) {
        log("Exit status" + arg0);
    }

    @Override
    public void checkLink(String arg0) {
        log("Link library:" + arg0);
    }

    @Override
    public void checkListen(int arg0) {
        log("Listen port:" + arg0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void checkMemberAccess(Class arg0, int arg1) {
        log("MemberAccess Class:" + arg0.getName() + " whitch:" + arg1);
    }

    @Override
    public void checkMulticast(InetAddress arg0, byte arg1) {
        log("Multicast ip:" + arg0.getHostAddress() + " byte:" + arg1);
    }

    @Override
    public void checkMulticast(InetAddress arg0) {
        log("Multicast ip:" + arg0.getHostAddress());
    }

    @Override
    public void checkPackageAccess(String arg0) {
        log("PackageAccess package:" + arg0);
    }

    @Override
    public void checkPackageDefinition(String arg0) {
        log("PackageDefinition package:" + arg0);
    }

    @Override
    public void checkPermission(Permission arg0, Object arg1) {
        log("Permission permission:" + arg0.getName() + " context:" + arg1);
    }

    @Override
    public void checkPermission(Permission arg0) {
        log("Permission permission:" + arg0.getName());
    }

    @Override
    public void checkPrintJobAccess() {
        log("PrintJobAccess");
    }

    @Override
    public void checkPropertiesAccess() {
        log("PropertiesAccess");
    }

    @Override
    public void checkPropertyAccess(String arg0) {
        log("PropertyAccess property:" + arg0);
    }

    @Override
    public void checkRead(FileDescriptor arg0) {
        log("Read fileDescriptor:" + arg0.toString());
    }

    @Override
    public void checkRead(String arg0, Object arg1) {
        log("Read file:" + arg0 + " context:" + arg1);
    }

    @Override
    public void checkRead(String arg0) {
        log("Read file:" + arg0);
    }

    @Override
    public void checkSecurityAccess(String arg0) {
        log("SecurityAccess target:" + arg0);
    }

    @Override
    public void checkSetFactory() {
        log("SetFactory");
    }

    @Override
    public void checkSystemClipboardAccess() {
        log("SystemClipboardAccess");
    }

    @Override
    public boolean checkTopLevelWindow(Object arg0) {
        log("ToplevelWindow window:" + arg0);
        return true;
    }

    @Override
    public void checkWrite(FileDescriptor arg0) {
        log("Write fileDescriptor:" + arg0);
    }

    @Override
    public void checkWrite(String arg0) {
        log("Write file:" + arg0);
    }

    public SecurityManager() {
        super();
    }
}
