import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { orderContext } from "../View/OrderView.js";


const Order = () => {
    const order = useContext(orderContext);
    const navigate = useNavigate();

    const OrderClick = async () => {

        var orderData = {
            orderedMemberId: "",
            dinnerStyle: "",
            dinnerType: "",
            bacon: 0,
            bread: 0,
            baguetteBread:0,
            champagne: 0,
            coffee_cup: 0,
            coffee_port: 0,
            eggScramble: 0,
            salad: 0,
            steak: 0,
            wine: 0,
            address: "",
            reservationTime:""
        };
        orderData.dinnerStyle = order.dinnerStyle;;
        orderData.dinnerType = order.dinnerType;
        orderData.bacon = order.bacon;
        orderData.bread = order.bread;
        orderData.baguetteBread = order.baguetteBread;
        orderData.champagne = order.champagne;
        orderData.coffee_cup = order.coffee_cup;
        orderData.coffee_port = order.coffee_port;
        orderData.eggScramble = order.eggScramble;
        orderData.salad = order.salad;
        orderData.steak = order.steak;
        orderData.wine = order.wine;
        orderData.address = order.address;
        orderData.orderedMemberId = sessionStorage.getItem('user_id');
        orderData.reservationTime = order.reservationTime;
        if ((orderData.dinnerType === 'CHAMPAGNE') && (orderData.dinnerStyle != 'DELUXE')) {
            alert("CHAMPAGNE은 DELUXE로만 가능합니다!")
            
            return;
        }
        await fetch("/order/make-order", {
            method: 'POST',
                headers: {
                'Content-Type': 'application/json',
                orderData
            },
            body: JSON.stringify(orderData)
        }).then((res) => {
            console.log(res.json());
            console.log(JSON.stringify(orderData));
            navigate("/main");
        }).catch((err) => {
            return err.json();
        }).then((json) => {
            console.log(json);
        })
    }
    return (
        <div>
            <button type="button" onClick={OrderClick}>submit</button>
        </div>
    );
}
export default Order;