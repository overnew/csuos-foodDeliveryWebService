import React, { useState, createContext } from "react";
import Signin from '../components/Signin.js';
import { useNavigate } from "react-router-dom";

export const LoginContext = React.createContext();

const SigninView = () => {
    //input field&state
    const [state, setState] = useState({
        id: "",
        pw: "",
    });
    const navigate = useNavigate();

    //id data input handler
    const handleInputId = (e) => {
        setState({
            ...state,
            id: e.target.value,
        });
    }
    //pw data input handler
    const handleInputPw = (e) => {
        setState({
            ...state,
            pw:e.target.value,
        });
    }

    return (
        <LoginContext.Provider value={state}>
            <div className="Signin">
                <div className="idInput">
                    <label htmlFor="input_id">ID  </label>
                    <input
                        type='text' name='input_id' value={state.id} onChange={handleInputId}
                    />
                </div>
                <div className="pwInput">
                    <label htmlFor="input_pw">PW  </label>
                    <input
                        type='password' name='input_pw' value={state.pw} onChange={handleInputPw}
                    />
                </div>
                <Signin />
            </div>
        </LoginContext.Provider>
    );
}

export default SigninView;