import { useContext } from "react";
import { StockContext } from "../View/StockManageView";

const PostStock = () => {
    const stock = useContext(StockContext);
    const onClick = async() => {
        await fetch('/manage/stock', {
            method: 'POST',
            credentials:'same-origin',
            headers: {
                'Content-Type': 'application/json',
                stock
            },
            body: JSON.stringify(stock)
        }).then((res) => {
            return res.json();
        }).then((json) => {
            console.log(json);
        })
    }
    return (
        <div>
            <button type='button' onClick={onClick}>적용</button>
        </div>
    )
}
export default PostStock;