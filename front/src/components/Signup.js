import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { signupContext } from "../View/SignupView";




const Signup = () => {
    const info = useContext(signupContext);
    const navigate = useNavigate();

    const SignupClick = async () => {
        const idRegExp = /^[a-zA-Z][0-9a-zA-Z]{5,11}$/;
        const pwRegExp = /^[a-zA-Z][0-9a-zA-Z]{5,11}$/;
        
        if (!idRegExp.test(info.id)) {
            alert("ID는 영문과 숫자 포함 6-12자리 이내로 입력해주세요.");
        } else if (!pwRegExp.test(info.password)) {
            alert("Password는 영문과 숫자 포함 6-12자리 이내로 입력해주세요.");
        } else {
            const userData = {
                id: info.id,
                password: info.password,
            };
        
            await fetch("/sign/signup", {
                method: 'post',
                headers: {
                    'Content-Type': 'application/json',
                    userData,
                },
                body: JSON.stringify({ userData })
            }).then((res) => {
                navigate("/signin");
            }).catch((err) => {
                console.log(err);
                console.log("false");
                console.log(userData);
            
            })
        }
    }
    return (
        <div>
            <button type="button" onClick={SignupClick}>submit</button>
        </div>
    )
}
export default Signup;