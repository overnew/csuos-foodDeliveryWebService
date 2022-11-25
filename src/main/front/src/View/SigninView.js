import React, { useState } from "react";
import Signin from '../components/Signin.js';

export const LoginContext = React.createContext();

const SigninView = () => {
    //input field&state
    const [info, setState] = useState({
        id: "",
        password: "",
    });

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
    //address data input handler
    

    return (
        <LoginContext.Provider value={info}>
            <div className="Signin">
                <input
                    type='text' name='input_id' placeholder="id" value={info.id} onChange={handleInputId}
                />
                <input
                    type='password' name='input_pw' placeholder="password" value={info.pw} onChange={handleInputPw}
                />
                <Signin />
            </div>
        </LoginContext.Provider>
    );
}

export default SigninView;