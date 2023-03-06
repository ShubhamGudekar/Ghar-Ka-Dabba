// import { useState } from 'react';

// export default function Form() {

//   // States for registration
// //   const [name, setName] = useState('');
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const [firstname, setFirstname] = useState('');
//   const [lastname, setlastname] = useState('');
//   const [mobile, setMobile] = useState('');
//   const [role, setRole] = useState('');
//   const [line1, setLine1] = useState('');
//   const [line2, setLine2] = useState('');
//   const [city, setCity] = useState('');
//   const [pincode, setPincode] = useState('');
//   const [state, setState] = useState('');

//   // States for checking the errors
//   const [submitted, setSubmitted] = useState(false);
//   const [error, setError] = useState(false);

// //   // Handling the name change
// //   const handleName = (e) => {
// //     setName(e.target.value);
// //     setSubmitted(false);
// //   };

//   // Handling the firstname change
//   const handleFirstName = (e) => {
//     setFirstname(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the lastname change
//   const handleLastName = (e) => {
//     setlastname(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the email change
//   const handleEmail = (e) => {
//     setEmail(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the password change
//   const handlePassword = (e) => {
//     setPassword(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the mobile change
//   const handleMobile = (e) => {
//     setMobile(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the mobile change
//   const handleRole = (e) => {
//     setRole(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the address line1 change
//   const handleLine1 = (e) => {
//     setLine1(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the address line2 change
//   const handleLine2 = (e) => {
//     setLine2(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the city change
//   const handleCity = (e) => {
//     setCity(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the pincode change
//   const handlePincode = (e) => {
//     setPincode(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the state change
//   const handleState = (e) => {
//     setState(e.target.value);
//     setSubmitted(false);
//   };

//   // Handling the form submission
//   const handleSubmit = (e) => {
//     e.preventDefault();
//     if (firstname === '' || lastname === '' || email === '' || password === ''
//     || mobile === '' || role === '' || line1 === '' || line2 === '' || city === '' ||
//        pincode === '' || state === '') {
//       setError(true);
//     } else {
//       setSubmitted(true);
//       setError(false);
//     }
//   };

//   // Showing success message
//   const successMessage = () => {
//     return (
//       <div
//         className="success"
//         style={{
//           display: submitted ? '' : 'none',
//         }}>
//         <h1>User {name} successfully registered!!</h1>
//       </div>
//     );
//   };

//   // Showing error message if error is true
//   const errorMessage = () => {
//     return (
//       <div
//         className="error"
//         style={{
//           display: error ? '' : 'none',
//         }}>
//         <h1>Please enter all the fields</h1>
//       </div>
//     );
//   };

//   return (
//     <div className="form">
//       <div>
//         <h1>User Registration</h1>
//       </div>

//       {/* Calling to the methods */}
//       <div className="messages">
//         {errorMessage()}
//         {successMessage()}
//       </div>

//       <form>
//         {/* Labels and inputs for form data */}
//         <label className="label">Name</label>
//         <input onChange={handleName} className="input"
//           value={name} type="text" />

//         <label className="label">Email</label>
//         <input onChange={handleEmail} className="input"
//           value={email} type="email" />

//         <label className="label">Password</label>
//         <input onChange={handlePassword} className="input"
//           value={password} type="password" />

//         <button onClick={handleSubmit} className="btn" type="submit">
//           Submit
//         </button>
//       </form>
//     </div>
//   );
// }
