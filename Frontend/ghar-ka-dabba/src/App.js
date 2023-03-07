import React, { useState } from "react";
import "./App.css";
import Navbar from "./Component/Navbar/Navbar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./Component/Pages/Home";
import SignUp from "./Component/Pages/Signup";
import Signin from "./Component/Pages/Signin";
// import Footer from "./Component/Footer/Footer";
// import Header from "./Component/Navbar/Header";
import VendorSubsList from "./Component/Pages/VendorSubsList";
import SubscriptionPlanDetails from "./Component/Pages/SubscriptionPlanDetails";
import Customer from "./Component/Pages/Customer";
import Login from "./Component/Pages/Login";
import Vendor from "./Component/Pages/Vendor";
import Admin from "./Component/Pages/Admin";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const updateLogin = (val) => {
    setIsLoggedIn(val);
  };

  return (
    <Router>
      <Navbar signIn={isLoggedIn} signOut={updateLogin} />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/Home" element={<Home />} />
        <Route path="/sign-in" element={<Login isLogged={updateLogin} />} />
        <Route path="/sign-up" element={<SignUp />} />
        <Route path="/vendor/:id" element={<VendorSubsList />} />
        <Route path="subcription/plan/:spid" element={<SubscriptionPlanDetails />} />
        <Route path="/customer" element={<Customer />} />
        <Route path="/vendor" element={<Vendor />} />
        <Route path="/admin" element={<Admin />} />
      </Routes>
    </Router>
  );
}

export default App;
