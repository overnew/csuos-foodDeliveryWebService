import { useEffect, useState } from "react";
import AcceptOrder from "./AcceptOrder";

const ManageOrderItem = ({
    accepted, address, bacon, bread, baguetteBread, champagne,
    coffee_cup, coffee_port, dinnerStyle, dinnerType, eggScramble,
    id, orderTime, orderedMemberId, price,
    reservationTime, salad, steak, wine
}) => {
    const [member, setMember] = useState([]);
    const getMember = async () => {
        const res = await fetch("/manage/all-members")
            .then((res) => {
                return res.json();
            }).then((json) => {
                console.log(json.content);
                return json.content;
            });
        const initData = () => {
            for (let key = 0; key < res.length; key++){
                setMember([...member, res.key]);
            }
        }
    }
    useEffect(() =>{
        getMember();
        console.log(member);
    }, []);
    const [visible, setVisible] = useState(false);

    return (
        <div className="ManageOrderItem">
            <div className="Info">
                <span>주문자:{orderedMemberId}</span>
                <br />
                <span>주문시각:{orderTime.replace('T','일')}</span>
                <br />
                <span>예약시간:{reservationTime.replace('T','일')}</span>
                <br />
                {!accepted ?
                    <span>
                        주문 확인:X
                    </span> :
                    <span>
                        주문 확인 :O
                    </span>
                }
                <br />
                <span>주소:{address}</span>
                <br />
                <span>가격:{price}</span>
                <br />
                <span>주문순서:{id}</span>
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
            <AcceptOrder accepted={accepted} id={id} />

        </div>
    );
}
export default ManageOrderItem;