import React, { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import ManageOrderItem from "../components/ManageOrderItem";

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
        <div>
            <h2>Main</h2>
            <div>
            {order.map((it) => {
                return (<ManageOrderItem key={it.id} {...it} />);
                })}
            </div>
            <button type="button" onClick={handleStock}>stock</button>
        </div>
    );
}
export default ManagerMainView;