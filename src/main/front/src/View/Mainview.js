import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { OrderContext } from "../App";
import OrderItem from "../components/OrderItem";
import AudioRecord from "../components/AudioRecord.js"
import Signout from '../components/Signout.js'

export const OrderDtoContext = React.createContext();
const Mainview = () => {
    const navigate = useNavigate();
    const [userData, setData] = useState([]);
    const onOrder = () => {
        navigate('/order');
    }
    const getData = async () => {
        const res = await fetch("/member/get-my-data", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: "",
        }).then((res) => {
            return res.json();
        }).then((json) => {
            return json.orderDtoList;
        })
        const initData = res.map((it) => {
            setData(userData => [...userData, it]);
        });
    }
    useEffect(() => {
        getData();
    }, []);
    
    return (
        <div className="Mainview">
            <h2>이전 주문목록</h2>
            <div>
                {userData.map((it) => {
                    return (<OrderItem key={it.id} {...it} />);
                })}
            </div>
            <button type="button" onClick={onOrder}>order</button>
            <AudioRecord />
            <Signout />
        </div>
    );
}
export default Mainview;