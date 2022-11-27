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
            <AcceptOrder accepted={accepted} id={id} />

        </div>
    );
}
export default ManageOrderItem;