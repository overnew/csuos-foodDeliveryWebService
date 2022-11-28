import React, { useEffect, useState } from 'react'
import PostStock from '../components/PostStock.js'
import AddtionalMenu from '../components/AddtionalMenu.js';

export const StockContext = new React.createContext();
const StockManageView = () => {
    
    const [stock, setStock] = useState({
        bacon: 0,
        bread: 0,
        baguetteBread: 0,
        champagne: 0,
        coffee_cup: 0,
        coffee_port: 0,                    
        eggScramble: 0,                   
        salad: 0,                   
        steak: 0,                 
        wine: 0
    });
    useEffect(() => {
        GetStock(setStock);
        console.log(stock);
    }, []);

    const GetStock = async(setStock) => {
        await fetch("/manage/stock")
            .then((res) => {
                return res.json();
            }).then((json) => {
                setStock ({
                    bacon: json.bacon.quantity,
                    bread: json.bread.quantity,
                    baguetteBread:json.baguetteBread.quantity,
                    champagne: json.champagne.quantity,
                    coffee_cup: json.coffee_cup.quantity,
                    coffee_port:json.coffee_port.quantity,
                    eggScramble: json.eggScramble.quantity,
                    salad: json.salad.quantity,
                    steak: json.steak.quantity,
                    wine: json.wine.quantity
                });
            });
    }
    const onClick = async () => {
        await fetch("/manage/stock", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                stock
            },
            body: JSON.stringify(stock)
        }).then((res) => {
            return res.json();
        }).then((res) => {
            console.log(res);
            console.log(stock);
        })
    }

    return (
        <div className='StockView'>
            <AddtionalMenu order={stock} setOrder={setStock} />
            <button type='button' onClick={onClick}>submit</button>
        </div>
    )

}
export default StockManageView;