import axios from "axios";
import { useContext } from "react";
import { useNavigate } from 'react-router-dom';
import { LoginContext } from "../View/SigninView";

//axios.defaults.withCredentials = true;
const Signin = () => {
    const info = useContext(LoginContext);
    const navigate = useNavigate();
    const SigninClick = () => {
        if (info.id < 1) {
            alert("id empty");
        }
        if (info.pw < 1) {
            alert('pw empty');
        }
        axios.post('/proxy/sign/signin', {
            id: info.id,
            password: info.password,
        }).then((res) => {
            console.log(res);
        }).catch((e) => {
            console.log(e);
            console.log(e.response.status);
            if (e.response.status === 404) {
                navigate("/main");
            }
        });
    }
    return (
        <div>
            <button type="button" onClick={SigninClick}>Go</button>
            <button type='button' onClick={() => {
                    navigate('/signup');
                }}>singup</button>
        </div>
    );
}

export default Signin;