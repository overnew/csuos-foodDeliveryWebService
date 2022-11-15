import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { signupContext } from "../View/SignupView";
import axios from "axios";



const Signup = () => {
    const info = useContext(signupContext);
    const navigate = useNavigate();

    const SignupClick = async () => {
        if (info.id < 1) {
            alert("id empty");
        }
        if (info.pw < 1) {
            alert('pw empty');
        }
        // if (info.name < 2) {
        //     alert('name is empty');
        // }
        // if (info.addr < 2) {
        //     alert('address is empty');
        // }
        const userData = {
            id: info.id,
            password: info.password,
        };
        // await axios({
        //     method: 'POST',
        //     url: 'http://localhost:8080/sign/signup',
        //     data: userData,
        //     withCredentials:true,
        // }).then((res) => {
        //     console.log(res);
        //     alert('success register');
        //     navigate('/')
        // }).catch((e) => {
        //     console.log(e);
        //     alert('failed register');
        //     console.log(userData);
        //     navigate("/signup");
            
        // });
        
        await fetch("/sign/signup", {
            method: 'post',
            headers: {
                'Content-Type': 'application/json',
                userData,
            },
            body: JSON.stringify({ userData })
        }).then((res) => {
            console.log(res);
            console.log("ture");
            console.log(userData);
        }).catch((err) => {
            console.log(err);
            console.log("false");
            console.log(userData);
        })
    }
    return (
        <div>
            <button type="button" onClick={SignupClick}>submit</button>
        </div>
    )
}
export default Signup;