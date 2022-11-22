import { useState,createContext } from "react";
import Signup from "../components/Signup.js";

export const signupContext = new createContext();

const SignupView = () => {
    const [info, setInfo] = useState({
        id: "",
        password: "",
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
    return (
        <div className="signup">
            <div className="idInput">
                <label htmlFor="input_id">ID  </label>
                <input
                    type='text' name='input_id' value={info.id} onChange={handleInputId}/>
            </div>
            <div className="pwInput">
                <label htmlFor="input_pw">PW  </label>
                <input
                    type='password' name='input_pw' value={info.password} onChange={handleInputPw}/>
            </div>

            <signupContext.Provider value={info}>
                <Signup />
            </signupContext.Provider>
        </div>
    )
}
export default SignupView;