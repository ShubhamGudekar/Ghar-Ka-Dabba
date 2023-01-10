namespace DAL;
using BOL;
using MySql.Data.MySqlClient;

public class DBManager{

    private static string conString=@"server=localhost;port=3306;user=root; password=root123;database=gharkadabba";       
    
    public static List<Customer> GetAllCustomers(){
            List<Customer> allCustomers=new List<Customer>();
            MySqlConnection con=new MySqlConnection();
            con.ConnectionString=conString;
            try{
                con.Open();
                MySqlCommand cmd=new MySqlCommand();
                cmd.Connection=con;
                string query="SELECT * FROM Customer";
                cmd.CommandText=query;
                MySqlDataReader reader=cmd.ExecuteReader();
                while(reader.Read()){
                    int id = int.Parse(reader["cId"].ToString());
                    string firstName = reader["cFirstName"].ToString();
                    string lastName = reader["cLastName"].ToString();
                    string email = reader["cEmail"].ToString();
                    string password = reader["cPassword"].ToString();
                    string mobile = reader["cMobile"].ToString();
                    string registerDate = reader["cRegisterDate"].ToString();

                    Customer tempCustomer=new Customer(id,firstName,lastName,email,password,mobile,registerDate);
                    allCustomers.Add(tempCustomer);
                }
            }
            catch(Exception e){
                Console.WriteLine(e.Message);
            }
            finally{
                    con.Close();
            }
            return allCustomers;
    }
}