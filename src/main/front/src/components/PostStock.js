import { useContext } from "react";
import { StockContext } from "../View/StockManageView";

const PostStock = () => {
    const stock = useContext(StockContext);
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
        })
    }
    return (
        <div>
            <button type='button' onClick={onClick}>적용</button>
        </div>
    )
}
export default PostStock;