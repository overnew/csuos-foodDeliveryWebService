const OrderItem = ({
    author, text, id
}) => {
    return (
        <div className="OrderItem">
            <div>
                <span>
                    {console.log(author)}
                    이름 : {author} | 내용 : {text}
                </span>
                <br />
            </div>
        </div>
    )
}

export default OrderItem;