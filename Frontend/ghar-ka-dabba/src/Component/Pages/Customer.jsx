import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import swal from "sweetalert";


function Customer() {
    const [customer, setCustomer] = useState({
        firstName: "",
        email: "",
        lastName: "",
        custId: "",
        jwt: ""
    });

    const navigate = useNavigate();

    useEffect(() => {
        let cust = JSON.parse(sessionStorage.getItem("customer"));
        console.log("email " + cust.email)
        axios.post(`http://localhost:8080/customers/findByEmail`, `${cust.email}`)
            .then((res) => {
                console.log(res.data);
                setCustomer({
                    firstName: res.data.firstName, lastName: res.data.lastName, custId: res.data.id,
                    jwt: cust.jwt
                })
            })
            .catch((err) => {
                console.log(err);
                swal("Something went Wrong", "", "error");
            });
    }, [])

    const logout = () => {
        sessionStorage.removeItem("customer");
        navigate("/");
    }
    return (
        <>

            <div className="container" style={{ marginBottom: "50px" }}>
                <div className="col-sm-3"><h2 className="">Hello, {customer.firstName} {customer.lastName}</h2></div>


                <div className="row">
                    <div className="col-sm-6">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Update Profile</h5>
                                <p className="card-text">Update your account details.</p>
                                <button onClick={() => navigate("/updateCustomer")} className="btn btn-primary">UPDATE</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-6">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">View Orders</h5>
                                <p className="card-text">Display Your All Orders </p>
                                <button onClick={() => navigate("/viewCustOrder")} className="btn btn-info">UPDATE</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="row my-3">
                    <div className="col-sm-6">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Change Password</h5>
                                <p className="card-text">Change your password.</p>
                                <button onClick={() => navigate("/changePasswordCustomer")} className="btn btn-success">CHANGE</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-6">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Current Subscription</h5>
                                <p className="card-text">Display details abour Current Plan</p>
                                <button onClick={() => navigate("/customerCurrentPlan")} className="btn btn-warning">CHECK</button>
                            </div>
                        </div>
                    </div>
                </div>



            </div>
        </>
    );

}

export default Customer;