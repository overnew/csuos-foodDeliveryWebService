import { useState } from "react";

const OrderItem = ({
    accepted, address, bacon, baguetteBread,bread, champagne,
    coffee_cup,coffee_port, dinnerStyle, dinnerType, eggScramble,
    id, orderTime, orderedMemberId, price,
    reservationTime, salad, steak, wine
}) => {
    const [visible, setVisible] = useState(false);

    return (
        <div>
            <div className="Info">
                <span>
                    주문시각:{orderTime}
                </span>
                <br />
                <span>
                    예약시간:{reservationTime}
                </span>
                <br />
                <span>
                    주소:{address}|가격:{price}
                </span>
                <br />
                {!accepted ?
                    <span>
                        주문 확인 중...
                    </span> :
                    <span>
                        주문 확인 완료!
                    </span>
                    }
            </div>
            <button onClick={() => {
                setVisible(!visible);
            }}>
                ▼
            </button>
            <hr />
            {visible &&
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
            }
        </div>
    )
}
export default OrderItem;