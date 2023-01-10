using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using gharKaDabba.Models;
using BLL;
using BOL;

namespace gharKaDabba.Controllers;

public class AuthController : Controller
{
    private readonly ILogger<AuthController> _logger;


    public IActionResult DisplayAll(){
        CustomerManager cm = new CustomerManager();
        List<Customer> custData = (List<Customer>)cm.GetAllCustomers(); 
        this.ViewData["custData"]=custData;
        return View();
    }

    public IActionResult SignIn(){
        return View();
    }

    public IActionResult SignUp(){
        return View();
    }

    public IActionResult ValidateUser(string email,string password){
        CustomerManager cm = new CustomerManager();
        List<Customer> custData = (List<Customer>)cm.GetAllCustomers(); 
        Customer userFound = custData.Find(cust=>cust.Email.Equals(email)&&cust.Password.Equals(password));
        // if(userFound==null)
        //     return RedirectToAction(UserNotFound);
        // return RedirectToAction(Welcome);
        return View();
    }

    public IActionResult Welcome(){
        return View();
    }

    public IActionResult UserNotFound(){
        return View();
    }
}