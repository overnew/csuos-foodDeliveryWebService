import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { signupContext } from "../View/SignupView";
//주소 : 도로명주소 api 사용
//이름 : 이름 (한글만 2자 이상)
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
        } else if (info.address === "") {
            alert("address를 입력해 주세요!");
        } else if (info.personalInfoAgreement === false) {
            alert("개인정보동의를 체크해 주세요!");
        }
        else {
            var userData = {
                "id": "",
                "password": "",
                "name": "",
                "address": "",
                "personalInfoAgreement": false
            };
            userData.id = info.id;
            userData.password = info.password;
            userData.address = info.address;
            userData.name = info.name;
            userData.personalInfoAgreement = info.personalInfoAgreement;

        
            await fetch("/sign/signup", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    userData
                },
                body: JSON.stringify(userData)
            }).catch((err) => {
                console.log(err);
                console.log("false");
                console.log(userData);
                console.log(userData);
            }).then((res) => {
                console.log(userData);
                console.log(res);
                navigate("/signin");
                return res.json();
            }).then((res) => {
                console.log(res);
            });
        }
    }
    return (
        <div className="signupbutton">
            <button type="button" onClick={SignupClick}>submit</button>
        </div>
    )
}
export default Signup;