namespace BLL;
using BOL;
using DAL;


public class CustomerManager
{
    public List<Customer> GetAllCustomers(){
        return DBManager.GetAllCustomers();
    }
}
