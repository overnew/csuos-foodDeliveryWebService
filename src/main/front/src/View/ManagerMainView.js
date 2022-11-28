import React, { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import ManageOrderItem from "../components/ManageOrderItem";
import Signout from "../components/Signout";

export const ManageOrderListContext = React.createContext();
const ManagerMainView = () => {
    const navigate = useNavigate();
    const [order, setOrder] = useState([]);
    const getList = async () => {
        const res = await fetch("/manage/all-orders")
            .then((res) => {
                return res.json()
            }).then((res) => {
                console.log(res.content);
                return res.content;
            })
        const initData = res.map((it) => {
            setOrder(order => [...order, it]);
            
        });
    }
    
    useEffect(() => {
        getList();
    }, []);
    const handleStock = () => {
        navigate('/stock');
    }
    return(
        <div className="ManagerMainView">
            <div className="topbar">
                <h2>현 주문목록</h2>
            </div>
            <div className="topbarutils">
                <button type="button" onClick={handleStock}>재고</button>
                <Signout />
            </div>
            
            <div className="ordereditems">
            {order.map((it) => {
                return (
                    <p>
                    <ManageOrderItem key={it.id} {...it } />
                    </p>
                )})}
            </div>
        </div>
    );
}
export default ManagerMainView;