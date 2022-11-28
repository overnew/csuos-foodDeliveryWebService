import { useNavigate } from "react-router-dom";

const AcceptOrder = ({ accept, id }) => {
    const navigate = useNavigate();
    const acceptHandler = async () => {
        
            await fetch(`/manage/accept-order?orderId=${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: "",
            }).then((res) => {
                return res.json();
            }).then((json) => {
                console.log(json);
                navigate('/manager-main');
            }).catch((err) => {
                console.log(err);
            })
        
    }
    return (
        <div className="accept">
            {   
                !accept ?
                    <button type="button" onClick={acceptHandler}>accept</button> :
                    <button type="button">accpeted</button>
            }
        </div>
    )
}
export default AcceptOrder;