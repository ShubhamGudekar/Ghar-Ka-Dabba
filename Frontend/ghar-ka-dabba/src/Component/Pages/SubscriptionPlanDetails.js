import React, { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
// import "../../index.css";
import { useState } from "react";
import axios from "axios";
import swal from "sweetalert";
import { IP_ADDRS } from "../../Service/Constant";

const SubscriptionPlanDetails = () => {
  const [subscriptionPlan, setSubcriptionPlan] = useState([]);
  const navigate = useNavigate();
  const { spid } = useParams();

  useEffect(() => {
    //Getting Subcription Details
    axios
      .get(`${IP_ADDRS}/subscription/plan/${spid}`)
      .then((res) => {
        console.log(res.data);
        setSubcriptionPlan(res.data);
      })
      .catch((err) => {
        console.log(err);
        swal("Something went Wrong", "", "error");
      });
  }, []);

  return (
    <div>
      <div className="jumbotron" style={{ marginLeft: 20 }}>
        <h1 className="display-4">
          {subscriptionPlan.name}
          <img src={`${IP_ADDRS}/subscription/${spid}/dp`} style={{ float: "right", margin: 18 }} height={165} width={165} />
        </h1>
        <p style={{ marginLeft: 30 }}>{subscriptionPlan.description}</p>
        <p style={{ marginLeft: 30 }}>Plan Type : {subscriptionPlan.planType}</p>
        <p style={{ marginLeft: 30 }}>Price : {subscriptionPlan.price} /- Rs</p>
      </div>
      <hr className="my-4" />
      <div className="container">
        <h2 style={{ margin: "25px" }}>Plan Details</h2>
      </div>
    </div>
  );
};

export default SubscriptionPlanDetails;
