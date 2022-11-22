import { useState, createContext } from "react"
import Order from '../components/Order.js'

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
    const handleInputStyle = (e) => {
        setOrder({
            ...order,
            dinnerStyle: e.target.value
        });
    }
    const handleInputType = (e) => {
        setOrder({
            ...order,
            dinnerType: e.target.value
        });
    }
    const handlebacon = (e) => {
        setOrder({
            ...order,
            bacon: e.target.value
        });
    }
    const handlebread = (e) => {
        setOrder({
            ...order,
            bacon: e.target.value
        });
    }
    const handlechampagne = (e) => {
        setOrder({
            ...order,
            bacon: e.target.value
        });
    }
    const handlecoffee = (e) => {
        setOrder({
            ...order,
            coffee: e.target.value
        });
    }
    const handleeggScramble = (e) => {
        setOrder({
            ...order,
            eggScramble: e.target.value
        });
    }
    const handlesalad = (e) => {
        setOrder({
            ...order,
            salad: e.target.value
        });
    }
    const handlesteak = (e) => {
        setOrder({
            ...order,
            steak: e.target.value
        });
    }
    const handlewine = (e) => {
        setOrder({
            ...order,
            wine: e.target.value
        });
    }
    const handleAddress = (e) => {
        setOrder({
            ...order,
            address:e.target.value
        })
    }
    return (
        <div className="Order">
            <div className="default option">
                <select name="dinnerStyle" onChange={handleInputStyle}>
                    <option defaultValue="null">Please Choose Style</option>
                    <option value="SIMPLE">SIMPLE</option>
                    <option value="GRAND">GRAND</option>
                    <option value="DELUXE">DELUXE</option>
                </select>
                <br />
                <select name="dinnerType" onChange={handleInputType}>
                    <option defaultValue="null">Please Choose Type</option>
                    <option value="FRENCH">FRENCH</option>
                    <option value="ENGLISH">ENGLISH</option>
                    <option value="CHAMPAGNE">CHAMPAGNE</option>
                </select>
            </div>
            <div className="addtional option">
                <label htmlFor="input_bacon">bacon  </label>
                    <input
                        type='number' name='bacon' value={order.bacon} onChange={handlebacon} />
                <br />
                <label htmlFor="input_bread">bread  </label>
                    <input
                        type='number' name='bread' value={order.bread} onChange={handlebread} />
                <br />
                <label htmlFor="input_champagne">champagne  </label>
                    <input
                        type='number' name='champagne' value={order.champagne} onChange={handlechampagne} />
                <br />
                <label htmlFor="input_coffee">coffee  </label>
                    <input
                        type='number' name='coffee' value={order.coffee} onChange={handlecoffee} />
                <br />
                <label htmlFor="input_eggScramble">eggScramble  </label>
                    <input
                        type='number' name='eggScramble' value={order.eggScramble} onChange={handleeggScramble} />
                <br />
                <label htmlFor="input_salad">salad  </label>
                    <input
                        type='number' name='salad' value={order.salad} onChange={handlesalad} />
                <br />
                <label htmlFor="input_steak">steak  </label>
                    <input
                        type='number' name='steak' value={order.steak} onChange={handlesteak} />
                <br />
                <label htmlFor="input_wine">wine  </label>
                    <input
                        type='number' name='wine' value={order.wine} onChange={handlewine} />
            </div>
            <div className="address">
            <label htmlFor="input_address">address  </label>
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