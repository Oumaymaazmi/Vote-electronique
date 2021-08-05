

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements ServiceVote {

	protected ServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String echo(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return "test msg : "+ input;
	}

	@Override
	public void voter(User user) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listCondidature() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resultatVote() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
