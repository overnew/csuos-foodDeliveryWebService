const AddtionalMenu = (order, setOrder) => {
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
    return (
        <div className="AdditnonalMenu">
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
    )
}
export default AddtionalMenu;