import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { OrderContext } from "../App";
import OrderItem from "../components/OrderItem";

export const OrderDtoContext = React.createContext();
const Mainview = () => {
    const navigate = useNavigate();
    const [userData, setData] = useState({});
    const ordered = userData.orderDtoList;
    const onOrder = () => {
        navigate('/order');
    }
    const getData = async () => {
        await fetch("/member/get-my-data", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: "",
        }).then((res) => {
            return res.json();
        }).then((json) => {
            setData(json);
        })
    }
    useEffect(() => {
        getData();
        console.log(userData);
    }, []);
    
    return (
        <div className="Mainview">
            <h2>이전 주문목록</h2>
            <OrderDtoContext.Provider value={ordered}>
                <OrderItem />
            </OrderDtoContext.Provider>
            <button type="button" onClick={onOrder}>order</button>
            <AudioRecord />
        </div>
    );
}
export default Mainview;