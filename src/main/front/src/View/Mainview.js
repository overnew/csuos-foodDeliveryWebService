import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { OrderContext } from "../App";
import AudioRecord from "../components/AudioRecord";
import OrderItem from "../components/OrderItem";

const Mainview = () => {
    const orderList = useContext(OrderContext);
    const navigate = useNavigate();

    const onOrder = () => {
        navigate('/order');
    }
    return (
        <div className="Mainview">
            <button type="button" onClick={onOrder}>order</button>
            <AudioRecord />
        </div>
    );
}
export default Mainview;