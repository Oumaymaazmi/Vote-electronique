/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.UUID;

/**
 *
 * @author HamzaPC
 */
public class ApplicationServer {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
    	
    	LocateRegistry.createRegistry(1011);
    	ServiceImpl obj = new ServiceImpl();
    	System.out.println(obj.toString());
    	Naming.bind("rmi://localhost:1011/SI", obj);
        
        
        //final String uuid = UUID.randomUUID().toString().replace("-", "");
        //System.out.println("uuid = " + uuid);
        
    }
    
}
