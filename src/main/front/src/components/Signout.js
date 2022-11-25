import { useNavigate } from "react-router-dom";

const Signout = () => {
    const navigate = useNavigate();
    const click = () => {
        fetch('/sign/sign-out', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: "",
        }).then((res) => {
            console.log(res.json());
            navigate('/');
        })
    }
    return (
        <div className="signout">
            <button type="button" onClick={click}>로그아웃</button>
        </div>
    )
}
export default Signout;