import { useState, createContext } from "react"
import MainMenu from '../components/MainMenu.js'
import AddtionalMenu from "../components/AddtionalMenu.js";
import { useNavigate } from "react-router-dom";


const OrderView = () => {
    const navigate = useNavigate();

    const [order, setOrder] = useState({
        dinnerStyle: "",
        dinnerType: "",
        bacon: 0,
        bread: 0,
        baguetteBread: 0,
        champagne: 0,
        coffee_cup: 0,
        coffee_port: 0,
        eggScramble: 0,
        salad: 0,
        steak: 0,
        wine: 0,
        address: "",
        reservationTime: "",
        price:0
    });
    const handleAddress = (e) => {
        
        setOrder({
            ...order,
            address: e.target.value
        })
    }
    const handleReservTime = (e) => {
        setOrder({
            ...order,
            reservationTime: e.target.value
        });
        console.log(e.target.value);
    }
    const onPayment = () => {
        if ((order.dinnerType === 'CHAMPAGNE') && (order.dinnerStyle != 'DELUXE')) {
            alert("CHAMPAGNE은 DELUXE로만 가능합니다!")
            
            return;
        } 
        for (var key in order) {
            if ( order[key] === '' || order[key] == null) {
                alert("빈 값이 있네요");
                return;
            }
        }
        navigate('/payment', {
            state: order
        } );
    }
    
    return (
        <div className="Order">
            <MainMenu order={order} setOrder={setOrder} />
            <AddtionalMenu order={order} setOrder={setOrder} />
            <div className="address">
                <label htmlFor="input_address" placeholder="">address  </label>
                <br/>
                    <input
                        type='text' name='address' value={order.address} onChange={handleAddress} />
                <br />
            </div>
            <div className="reservTime">
                <label htmlFor="input_reservtime">Reservation Time</label>
                <br />
                <input
                    type="datetime-local" value={order.reservationTime} onChange={handleReservTime}/>
            </div>
            <button type="button" onClick={onPayment}>payment</button>
        </div>
    )
}
export default OrderView;