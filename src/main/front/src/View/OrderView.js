import { useState, createContext } from "react"
import Order from '../components/Order.js'
import MainMenu from '../components/MainMenu.js'
import AddtionalMenu from "../components/AddtionalMenu.js";
export const orderContext = new createContext();

const OrderView = () => {
    
    const [order, setOrder] = useState({
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
    });
    const handleAddress = (e) => {
        setOrder({
            ...order,
            address: e.target.value
        })
    }
    
    return (
        <div className="Order">
            <MainMenu order={order} setOrder={setOrder} />
            <AddtionalMenu order={order} setOrder={setOrder} />
            <div className="address">
                <label htmlFor="input_address">address  </label>
                <br/>
                    <input
                        type='text' name='address' value={order.address} onChange={handleAddress} />
                <br />
            </div>
            <orderContext.Provider value={order}>
                <Order />
            </orderContext.Provider>
        </div>
    )
}
export default OrderView;