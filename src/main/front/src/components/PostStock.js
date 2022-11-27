import { useContext } from "react";
import { StockContext } from "../View/StockManageView";

const PostStock = () => {
    const stock = useContext(StockContext);
    
    return (
        <div>
            <button type='button' onClick={onClick}>적용</button>
        </div>
    )
}
export default PostStock;