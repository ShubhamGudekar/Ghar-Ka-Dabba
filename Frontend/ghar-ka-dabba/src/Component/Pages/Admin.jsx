import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import swal from "sweetalert";
import { IP_ADDRS } from "../../Service/Constant"

function Admin() {
    const [admin, setAdmin] = useState({
        email: "",
        id: "",
        jwt: ""
    });

    const [loggedIn, setLoggedIn] = useState(false);

    const navigate = useNavigate();

    useEffect(() => {
        let adm = JSON.parse(sessionStorage.getItem("admin"));
        if (adm == null) {
            swal("Not Authorized", "", "error");
        }
        else {
            setLoggedIn(true);
            setAdmin({
                id: adm.id,
                email: adm.email,
                jwt: adm.jwt
            })
        }
    }, [])


    return (
        <>
            {loggedIn ?
                (<>
                    <div className="jumbotron" style={{ marginLeft: 20 }}>
                        <h3 style={{ marginTop: 10 }}>Hello ,
                        </h3>
                        <h1 style={{ marginLeft: 30 }}>
                            Admin
                        </h1>
                        <h5 style={{ marginLeft: 30 }}>
                            {admin.email}
                        </h5>
                    </div>
                    <hr className="my-4" />

                    <div className="container" style={{ marginBottom: "50px", textAlign: "center" }}>
                        <div className="row" >
                            <div className="col-sm-6">
                                <div className="card" onClick={() => navigate("/updateVendor")}>
                                    <div className="card-body" >
                                        <h5 className="card-title">Update Profile</h5>
                                        <p className="card-text">Update your account details.</p>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6">
                                <div className="card" onClick={() => navigate("/addSubcriptionPlan")}>
                                    <div className="card-body">
                                        <h5 className="card-title">Add Subscription Plan</h5>
                                        <p className="card-text">Add new Subscription Plan Details</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="row my-3">
                            <div className="col-sm-6">
                                <div className="card" onClick={() => navigate("/changePasswordVendor")}>
                                    <div className="card-body">
                                        <h5 className="card-title">Change Password</h5>
                                        <p className="card-text">Change your password</p>

                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6">
                                <div className="card" onClick={() => navigate("/editSubscriptionPlan")}>
                                    <div className="card-body">
                                        <h5 className="card-title">Edit Subscription Plan</h5>
                                        <p className="card-text">Edit Subscription Plan Details</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="row" >
                            <div className="col-sm-6">
                                <div className="card" onClick={() => navigate("/disableSubscriptionPlan")}>
                                    <div className="card-body" >
                                        <h5 className="card-title">Disable Subscription Plan</h5>
                                        <p className="card-text">Make Subscription Plan Unavaliable for Purchase</p>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6">
                                <div className="card" onClick={() => navigate("/enableSubscriptionPlan")}>
                                    <div className="card-body">
                                        <h5 className="card-title">Enable Subscription Plan</h5>
                                        <p className="card-text">Make Subscription Plan Avaliable for Purchase</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </>)

                : <div style={{ textAlign: "center" }}><h1>Please Log in to Access this page</h1></div>}
        </>
    )

}

export default Admin;