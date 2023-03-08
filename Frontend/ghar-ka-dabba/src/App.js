import React, { useState } from "react";
// import "./App.css";
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
import ApprovedVendorList from "./Component/Pages/ApprovedVendorList";
import UnApprovedVendorList from "./Component/Pages/UnApprovedVendorList";
import BlockedVendorList from "./Component/Pages/BlockedVendorList";
import CustomerList from "./Component/Pages/CustomerList";
import ForgotPassword from "./Component/Pages/ForgotPassword";
import ChangePassword from "./Component/Pages/ChangePassword";

function App() {
  const [checkLoggedIn, setCheckLoggedIn] = useState(false);

  const updateLogin = (val) => {
    setCheckLoggedIn(val);
  };

  return (
    <Router>
      <Navbar signIn={checkLoggedIn} signOut={updateLogin} />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/Home" element={<Home />} />
        <Route path="/sign-in" element={<Login isLogged={updateLogin} />} />
        <Route path="/sign-up" element={<SignUp />} />
        <Route path="/forgotpassword" element={<ForgotPassword />} />
        <Route path="/changePassword" element={<ChangePassword />} />

        <Route path="/vendor/:id" element={<VendorSubsList />} />
        <Route path="subcription/plan/:spid" element={<SubscriptionPlanDetails />} />
        <Route path="/customer" element={<Customer />} />

        <Route path="/vendor" element={<Vendor />} />

        <Route path="/admin" element={<Admin />} />
        <Route path="/getAllApprovedVendors" element={<ApprovedVendorList />} />
        <Route path="/getBlockedVendors" element={<BlockedVendorList />} />
        <Route path="/getUnapprovedVendors" element={<UnApprovedVendorList />} />
        <Route path="/getAllCustomers" element={<CustomerList />} />
      </Routes>
    </Router>
  );
}

export default App;
