import React from "react";
import { Nav, NavLink, NavMenu } from "./NavbarElement";
// import images from "../Carousal/images";
// import ImageSlider from "../Carousal/imageSlider";

const Navbar = () => {
  return (
    <>
      <Nav className="navbar navbar-expand-lg navbar-dark bg-dark" style={{ height: "50px" }}>
        <div className="container-fluid">
          <div className="navbar-header">
            <NavMenu>
              <NavLink className="navbar-brand" to="/">
                gharkadabba
              </NavLink>
              <NavLink className="navbar-brand" to="/customer">
                profile
              </NavLink>
            </NavMenu>
          </div>
          <div align="right">
            <NavMenu>
              <NavLink to="/sign-in">Sign in</NavLink>
              <NavLink to="/sign-up">Sign Up</NavLink>
            </NavMenu>
          </div>
        </div>
      </Nav>
    </>
  );
};

export default Navbar;
