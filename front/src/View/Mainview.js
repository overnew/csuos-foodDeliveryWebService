import { useContext } from "react";
import { OrderContext } from "../App";
import OrderItem from "../components/OrderItem";

const Mainview = () => {
    const orderList = useContext(OrderContext);
    return (
        <div>
            <h2>이전 주문 목록</h2>
            <hr />
            <div>
                {orderList.map((it) => {
                    <OrderItem key={it.id} {...it} />
                })}
            </div>
        </div>
    );
}
export default Mainview;