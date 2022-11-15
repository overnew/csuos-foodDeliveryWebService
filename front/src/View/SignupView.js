import { useState } from "react";
import { createContext } from "react";
import Signup from "../components/Signup.js";

export const signupContext = new createContext();

const SignupView = () => {
    const [info, setInfo] = useState({
        id: "",
        password: "",
        // name: "",
        // addr: "",
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
    //id data input handler
    const handleInputName = (e) => {
        setInfo({
            ...info,
            name: e.target.value,
        });
    }
    //pw data input handler
    const handleInputAddr = (e) => {
        setInfo({
            ...info,
            addr:e.target.value,
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
            <div className="nameInput">
                <label htmlFor="input_name">이름  </label>
                <input
                    type='text' name='input_name' value={info.name} onChange={handleInputName}/>
            </div>
            <div className="addrInput">
                <label htmlFor="input_addr">주소  </label>
                <input
                    type='addr' name='input_addr' value={info.addr} onChange={handleInputAddr}/>
            </div>
            <signupContext.Provider value={info}>
                <Signup />
            </signupContext.Provider>
        </div>
    )
}
export default SignupView;