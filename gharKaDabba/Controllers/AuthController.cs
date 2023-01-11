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

    [HttpGet]
    public IActionResult SignIn(){
        return View();
    }

    public IActionResult SignUp(){
        return View();
    }

    [HttpPost]
    public IActionResult SignIn(string email,string password){
        Console.WriteLine(email + "  "+password);
        CustomerManager cm = new CustomerManager();
        Customer custData = (Customer)cm.SignIn(email,password);
        if(custData==null)
            return View();
        return RedirectToAction("Welcome");
        
    }

    public IActionResult Welcome(){
        return View();
    }

    public IActionResult UserNotFound(){
        return View();
    }
}