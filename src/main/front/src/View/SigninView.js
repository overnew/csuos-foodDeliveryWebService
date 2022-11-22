import React, { useState } from "react";
import Signin from '../components/Signin.js';
import { useNavigate } from "react-router-dom";

export const LoginContext = React.createContext();

const SigninView = () => {
    //input field&state
    const [info, setState] = useState({
        id: "",
        password: "",
    });
    const navigate = useNavigate();

    //id data input handler
    const handleInputId = (e) => {
        setState({
            ...info,
            id: e.target.value,
        });
    }
    //pw data input handler
    const handleInputPw = (e) => {
        setState({
            ...info,
            password:e.target.value,
        });
    }

    return (
        <LoginContext.Provider value={info}>
            <div className="Signin">
                <div className="idInput">
                    <label htmlFor="input_id">ID  </label>
                    <input
                        type='text' name='input_id' value={info.id} onChange={handleInputId}
                    />
                </div>
                <div className="pwInput">
                    <label htmlFor="input_pw">PW  </label>
                    <input
                        type='password' name='input_pw' value={info.pw} onChange={handleInputPw}
                    />
                </div>
                <Signin />
            </div>
        </LoginContext.Provider>
    );
}

export default SigninView;