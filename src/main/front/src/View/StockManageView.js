import React, { useEffect, useState } from 'react'
import PostStock from '../components/PostStock.js'
import GetStock from '../components/GetStock.js'
import AddtionalMenu from '../components/AddtionalMenu.js';

export const StockContext = new React.createContext();
const StockManageView = () => {
    const [stock, setStock] = useState({});
    useEffect(() => {
        GetStock(setStock);
    }, []);
    console.log(stock);
    

    return (
        <div>
            <AddtionalMenu order={stock} setOrder={setStock} />
            <StockContext.Provider value={stock}>
                <PostStock value={stock}/>
            </StockContext.Provider >
        </div>
    )

}
export default StockManageView;