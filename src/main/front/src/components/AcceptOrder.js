
const AcceptOrder = ({ accept, id }) => {
    const acceptHandler = async() => {
        
            await fetch(`/manage/accept-order?orderId=${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: "",
            }).then((res) => {
                console.log(res.json().success);
            })
        
    }
    return (
        <div>
            <button type="button" onClick={acceptHandler}>accept</button>
        </div>
    )
}
export default AcceptOrder;