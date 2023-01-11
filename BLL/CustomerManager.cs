namespace BLL;
using BOL;
using DAL;


public class CustomerManager
{
    public List<Customer> GetAllCustomers(){
        return DBManager.GetAllCustomers();
    }

    public Customer SignIn(string email,string password){
        return DBManager.SignIn(email,password);
    }
}
