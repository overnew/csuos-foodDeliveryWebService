
const AcceptOrder = ({ accept, id }) => {
    const acceptHandler = async() => {
        
            await fetch(`/manage/accept-order?orderId=${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: "",
            }).then((res) => {
               // console.log(res.json().success);
                return res.json();
            }).then((json) => {
                console.log(json);
            }).catch((err) => {
                console.log(err);
            })
        
    }
    return (
        <div>
            {   
                !accept ?
                    <button type="button" onClick={acceptHandler}>accept</button> :
                    <button type="button">accpeted</button>
            }
        </div>
    )
}
export default AcceptOrder;