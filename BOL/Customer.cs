namespace BOL;
public class Customer
{
    public int Id{get;set;}
    public string FirstName{get;set;}
    public string LastName{get;set;}
    public string Email{get;set;}
    public string Password{get;set;}
    public string Mobile{get;set;}
    public DateTime RegisterDate{get;set;}

    public Customer(int id,string firstName,string lastName,string email,string password,string mobile,string registerDate){
        this.Id=id;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.Email=email;
        this.Password=password;
        this.Mobile=mobile;
        this.RegisterDate=DateTime.Parse(registerDate);
    }

}
