import { useContext } from "react";
import { useNavigate } from 'react-router-dom';
import { sessionContext } from "../App";
import { LoginContext } from "../View/SigninView";


const Signin = () => {
    const info = useContext(LoginContext);
    const session = useContext(sessionContext);
    const navigate = useNavigate();

    const SigninClick = async () => {
        
        //결제기능 추가!
        const idRegExp = /^[a-zA-Z][0-9a-zA-Z]{5,11}$/;
        const pwRegExp = /^[a-zA-Z][0-9a-zA-Z]{5,11}$/;
        
        if (!idRegExp.test(info.id)) {
            alert("ID는 영문과 숫자 포함 6-12자리 이내로 입력해주세요.");
        } else if (!pwRegExp.test(info.password)) {
            alert("Password는 영문과 숫자 포함 6-12자리 이내로 입력해주세요.");
        } else {
            var userData = {
                "id": "",
                "password": ""
            };
            userData.id = info.id;
            userData.password = info.password;
            await fetch(`/sign/signin?id=${userData.id}&password=${userData.password}`, {
                method: 'POST',
                credentials:'same-origin',
                headers: {
                    'Content-Type': 'application/json',
                    userData
                }
            }).catch((err) => {
                console.log(err);
                console.log("false");
                console.log(userData);
            }).then((res) => {
                return res.json();
            }).then((json) => {
                console.log(json);
                
                if (json.success === true) {
                    sessionStorage.setItem('user_id', userData.id);
                    navigate('/main');
                }
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