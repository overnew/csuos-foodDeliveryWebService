import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { orderContext } from "../View/OrderView.js";


const Order = () => {
    const order = useContext(orderContext);
    const navigate = useNavigate();

    const OrderClick = async () => {

        var orderData = {
            "dinnerStyle": "",
            "dinnerType": "",
            "bacon": 0,
            "bread": 0,
            "champagne": 0,
            "coffee": 0,
            "eggScramble": 0,
            "salad": 0,
            "steak": 0,
            "wine": 0,
            "address": ""
        };
        orderData.dinnerStyle = order.dinnerStyle;
        orderData.dinnerType = order.dinnerType;
        orderData.bacon = order.bacon;
        orderData.bread = order.bread;
        orderData.champagne = order.champagne;
        orderData.coffee = order.coffee;
        orderData.eggScramble = order.eggScramble;
        orderData.salad = order.salad;
        orderData.steak = order.steak;
        orderData.wine = order.wine;
        if ((orderData.dinnerType === 'CHAMPAGNE') && (orderData.dinnerStyle != 'DELUXE')) {
            alert("CHAMPAGNE은 DELUXE로만 가능합니다!")
            navigate("/order");
        }
        await fetch("/order/make-order", {
            method: 'POST',
                headers: {
                'Content-Type': 'application/json',
                orderData
            },
            body: JSON.stringify(orderData)
        }).then((res) => {
            console.log(JSON.stringify(res));
            console.log(orderData);
            navigate("/");
        }).catch((err) => {
            console.log(JSON.stringify(err));
            console.log(orderData);
        })
    }
    return (
        <div>
            <button type="button" onClick={OrderClick}>submit</button>
        </div>
    );
}
export default Order;