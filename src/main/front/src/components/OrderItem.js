
const OrderItem = ({
    accepted, address, bacon, baguetteBread,bread, champagne,
    coffee_cup,coffee_port, dinnerStyle, dinnerType, eggScramble,
    id, orderTime, orderedMemberId, price,
    reservationTime, salad, steak, wine
}) => {
    return (
        <div>
            <div className="Info">
                <span>
                    주문자:{orderedMemberId}|주문시각:{orderTime}
                </span>
                <br />
                <span>
                    예약시간:{reservationTime}|주문수락:{accepted}
                </span>
                <br/>
                <span>
                    주소:{address}|가격:{price}|id:{id}
                </span>
            </div>
            <div className="orderInfo">
                <span>
                    종류:{dinnerType}|스타일:{dinnerStyle}
                </span>
                <br />
                <span>bacon:{bacon} | bread:{bread}</span>
                <br />
                <span>baguetteBread:{baguetteBread}|champagne:{champagne}</span>
                <br />
                <span>coffee_cup:{coffee_cup}|coffee_port:{coffee_port}</span>
                <br />
                <span>eggScramble:{eggScramble}|salad:{salad}</span>
                <br />
                <span>steak:{steak}|wine:{wine}</span>
            </div>
        </div>
    )
}
export default OrderItem;