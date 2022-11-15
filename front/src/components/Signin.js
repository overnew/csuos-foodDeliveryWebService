import axios from "axios";
import { useContext } from "react";
import { useNavigate } from 'react-router-dom';
import { LoginContext } from "../View/SigninView";

//axios.defaults.withCredentials = true;
const Signin = () => {
    const info = useContext(LoginContext);
    const navigate = useNavigate();
    const SigninClick = async () => {
        
        
        if (info.id < 1) {
            alert("아이디를 입력하세요");
        } else if (info.pw < 1) {
            alert("비밀번호를 입력하세요");
        } else {
            const userData = {
                id: info.id,
                password: info.password,
            };
            await fetch("/sign/signin", {
                method: 'post',
                headers: {
                    'Content-Type': 'application/json',
                    userData,
                },
                body: JSON.stringify({ userData })
            }).then((res) => {
                res = JSON.stringify(res);
                if (res.body === "fail") {
                    alert("존재하지 않는 회원입니다.");
                    navigate("/signin");
                } else if (res.body === `login success id = ${info.id}`) {
                    navigate("/main");
                }
            }).catch((err) => {
                console.log(err);
                console.log("false");
                console.log(userData);
        
            })
        }
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