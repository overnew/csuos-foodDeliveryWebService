import { useContext } from "react";
import { OrderDtoContext } from "../View/Mainview";

const OrderItem = () => {
    const OrderDto = useContext(OrderDtoContext);
    console.log(OrderDto);
    return (
        <div>
            <p>이전목록</p>
        </div>
    )
}
export default OrderItem;