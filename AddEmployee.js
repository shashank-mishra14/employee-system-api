import React, { useState } from "react";
import { useNavigate } from "react-router";
import EmployeeService from "./services/EmployeeService";

const AddEmployee = () => {

    const [employee, setEmployee] = useState({

        id: "",
        firstName: "",
        lastName: "",
        emailId: "",
     });

     const navigaye = useNavigate();

     const handleChange = (e) => {
         const value = e.target.value;
         setEmployee({ ...employee, [e.target.name]: value});
     };

     const saveEmployee = (e) => {
         e.preventDefault();
         EmployeeService.saveEmployee(employee)
         .then((response) => {
          console.log(response); 
          navigaye("/employeeList");

         }).catch((error)=>{
             console.log(error);
         });
        };
         const reset =(e) => {
             e.preventDefault();
             setEmployee({
                id: "",
                firstName: "",
                lastName: "",
                emailId: "",

             });
         };

     
    
        
        
    
}

export default AddEmployee
