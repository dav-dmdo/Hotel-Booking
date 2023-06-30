/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;

/**
 *
 * @author david
 */
public class ClientMethods implements DataTypeMethods<Client>{

    @Override
    public boolean isEqual(Client client1, Client client2) {
        return client1.id.equals(client2.id);
    }

    @Override
    public boolean greaterThan(Client client1, Client client2) {
        return client1.id.compareTo(client2.id) > 0;
    }

    @Override
    public boolean lessThan(Client client1, Client client2) {
        return client1.id.compareTo(client2.id) < 0;
    }

    @Override
    public String toString(Client client) {
        String stringClient = "";
        if((client.id != null) && (client.phone != null))
            return "ID: "+ client.id +" Full name: "+ client.firstName+" "+ client.lastName+" email: "+client.email+" Gender: "+client.gender+" Phone: "+client.phone ;
        if(client.id == null)
            return "ID: N/A "+" Full name: "+ client.firstName+" "+ client.lastName+" email: "+client.email+" Gender: "+client.gender+" Phone: "+client.phone;
        if(client.phone == null)
            return "ID: "+ client.id +" Full name: "+ client.firstName+" "+ client.lastName+" email: "+client.email+" Gender: "+client.gender+" Phone: N/A";
        return stringClient;
    }
    
    @Override
    public Integer getIdentification(Client client) {
        return client.id;
    }
    
    @Override
    public Integer getNumericalKey(Client client){
        return client.id;
    }
    
    @Override
    public String getStringKey(Client client){
        return client.firstName+" "+client.lastName;
    }
    
    
}
