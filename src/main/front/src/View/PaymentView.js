import { createContext, useState } from "react";
import Order from '../components/Order.js';
import { useLocation, useNavigate } from "react-router-dom";

export const orderContext = new createContext();

const PaymentView = () => {
    const location = useLocation();
    let order = location.state;
    let tempPrice = 0;
    
    for (let key in order) {
        
        if (key === 'bacon') {
            tempPrice += order.bacon * 4000;
        }
        if (key === 'bread') {
            tempPrice += order.bread * 1500;
        }
        if (key === 'baguette') {
            tempPrice += order.baguette * 2000;
        }
        if (key === 'champagne') {
            tempPrice += order.champagne * 15000;
        }
        if (key === 'coffee_cup') {
            tempPrice += order.coffee_cup * 2000;
        }
        if (key === 'coffee_port') {
            tempPrice += order.coffee_port * 10000;
        }
        if (key === 'eggScramble') {
            tempPrice += order.eggScramble * 4000;
        }
        if (key === 'salad') {
            tempPrice += order.salad * 4000;
        }
        if (key === 'steak') {
            tempPrice += order.steak * 30000;
        }
        if (key === 'wine') {
            tempPrice += order.wine * 15000;
        }
    }
    if (order.dinnerStyle === 'SIMPLE') {
        tempPrice+=8000
    } else if (order.dinnerStyle === 'GRAND') {
        tempPrice += 15000;
    } else if (order.dinnerStyle === 'DELUXE') {
        tempPrice += 30000;
    }
    order.price = tempPrice;
    console.log(order);

    return (
        <div className="Payment">
            <h2>시발</h2>
            <input type="text" placeholder="카드번호" />
            <input type="text" placeholder="cvc" />
            <div>
                <orderContext.Provider value={order}>
                    <Order />
                </orderContext.Provider>
            </div>
            
        </div>
    )
}
export default PaymentView;