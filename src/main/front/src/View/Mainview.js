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
            console.log(json.orderDtoList);
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
            <div className="topbar">
                <h2>이전 주문목록</h2>
                
            </div>
            <div className="topbarutils">
                <button type="button" onClick={onOrder}>주문</button>
                <Signout />
                <AudioRecord />
            </div>
            <hr />
            <div className="prevorderitem">
                {userData.map((it) => {
                    return (
                        <p>
                            <OrderItem key={it.id} {...it} />
                        </p>);
                })}
            </div>
            
            
        </div>
    );
}
export default Mainview;