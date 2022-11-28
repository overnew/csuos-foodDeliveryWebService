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
                    주문시각:{orderTime.replace('T','일 ').slice(0,20)}
                </span>
                <br />
                <span>
                    예약시간:{reservationTime.replace('T','일 ')}
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
                    <span>음식종류:{dinnerType}</span>
                    <br />
                    <span>음식타입:{dinnerStyle}</span>   
                    <br />
                    <span>배이컨:{bacon}</span>
                    <br />
                    <span>빵:{bread}</span>
                    <br />
                    <span>바게트빵:{baguetteBread}</span>
                    <br />
                    <span>샴패인:{champagne}</span>
                    <br />
                    <span>커피(단위:잔):{coffee_cup}</span>
                    <br />
                    <span>커피(단위:포트):{coffee_port}</span>
                    <br />
                    <span>스크램블에그:{eggScramble}</span>
                    <br />
                    <span>샐러드:{salad}</span>
                    <br />
                    <span>스테이크:{steak}</span>
                    <br />
                    <span>와인:{wine}</span>
            </div>
            }
        </div>
    )
}
export default OrderItem;