import { useState,createContext } from "react";
import Signup from "../components/Signup.js";

export const signupContext = new createContext();

const SignupView = () => {
    const [info, setInfo] = useState({
        id: "",
        password: "",
        address: "",
        name:"",
        personalInfoAgreement: false
    });

    //id data input handler
    const handleInputId = (e) => {
        setInfo({
            ...info,
            id: e.target.value,
        });
        
    }
    //pw data input handler
    const handleInputPw = (e) => {
        setInfo({
            ...info,
            password:e.target.value,
        });
        
    }
    const handleInputAddress = (e) => {
        setInfo({
            ...info,
            address: e.target.value
        })
    }
    const handleInfoAgreement = (e) => {
        console.log(e.target.checked);
        if (e.target.checked === true) {
            setInfo({
                ...info,
                personalInfoAgreement: true
            })
            console.log("out");
            console.log(info.personalInfoAgreement);
        } else {
            setInfo({
                ...info,
                personalInfoAgreement: false
            })
            console.log("out");
            console.log(info.personalInfoAgreement);
        }
    }
    const handleName = (e) => {
        setInfo({
            ...info,
            name: e.target.value
        })
    }
    return (
        <div className="signup">
            <input
                    type='text' placeholder="id" name='input_id' value={info.id} onChange={handleInputId}/>
            <input
                type='password' placeholder="password" name='input_pw' value={info.password} onChange={handleInputPw}/>
            <input
                type='text' name='input_name' placeholder="name"value={info.name} onChange={handleName}/>
            <input
                type="text" name="input_addr" placeholder="address" value={info.address} onChange={handleInputAddress} />
            <div className="pi">
            <span htmlFor="personalInfo">personalInfo</span>
                <input className="checkbox"
                    type="checkbox" name="personalInfo" onChange={handleInfoAgreement} />                
            </div>
            <signupContext.Provider value={info}>
            <Signup />
            </signupContext.Provider>
        </div>
    )
}
export default SignupView;