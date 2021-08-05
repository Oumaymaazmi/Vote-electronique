/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import bean.User;

/**
 *
 * @author HamzaPC
 */
public interface ServiceVote extends Remote {
    
    public void voter(User user) throws RemoteException;
    public List<User> listCondidature() throws RemoteException;
    public void resultatVote() throws RemoteException;
    
    
}
