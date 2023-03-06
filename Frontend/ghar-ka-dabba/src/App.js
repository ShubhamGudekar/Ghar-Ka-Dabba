import React from "react";
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

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/Home" element={<Home />} />
        <Route path="/sign-in" element={<Login />} />
        <Route path="/sign-up" element={<SignUp />} />
        <Route path="/vendor/:id" element={<VendorSubsList />} />
        <Route path="subcription/plan/:spid" element={<SubscriptionPlanDetails />} />
        <Route path="/customer" element={<Customer />} />
      </Routes>
    </Router>
  );
}

export default App;
