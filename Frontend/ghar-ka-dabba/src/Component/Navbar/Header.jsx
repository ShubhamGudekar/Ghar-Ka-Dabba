import React from 'react';
import { NavLink } from 'react-router-dom';

export default function Header(props) {
    
    // let { title } = props;
    let loggedIn = JSON.parse(sessionStorage.getItem("loginState"));
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container">
                <div className="navbar-header">
                    <NavLink className="navbar-brand" to="/">gharkadabba</NavLink>
                </div>
                <div align="right">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item"><NavLink className="nav-link" to="/about">About Us</NavLink></li>
                    {/* <li className="nav-item"><NavLink className="nav-link" to="/contact">Contact Us</NavLink></li> */}
                   
                    <li className="nav-item" ><NavLink className="nav-link" to="/signin">Signin</NavLink></li>
                    <li className="nav-item" ><NavLink className="nav-link" to="/signup">Signup</NavLink></li>
                </ul>
                </div>
                </div>
        </nav>
         
    )
}

