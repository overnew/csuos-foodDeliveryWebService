const OrderItem = ({
    id, OrderTime, orderedMemberId
}) => {
    return (
        <div className="OrderItem">
            <h2>주문목록</h2>
            <div>
                <span>
                    시간 : {OrderTime} | 아이디 : {orderedMemberId} | 주문번호 : {id}
                </span>
                <br />
            </div>
        </div>
    )
}

export default OrderItem;