
const AddtionalMenu = ({ order, setOrder }) => {
    const handlebacon = (e) => {
        setOrder({
            ...order,
            bacon: e.target.value
        });
    }
    const handlebread = (e) => {
        setOrder({
            ...order,
            bread: e.target.value
        });
    }
    const handleBaguetteBread = (e) => {
        setOrder({
            ...order,
            baguetteBread: e.target.value
        });
    }
    const handlechampagne = (e) => {
        setOrder({
            ...order,
            champagne: e.target.value
        });
    }
    const handlecoffeeCup = (e) => {
        setOrder({
            ...order,
            coffee_cup: e.target.value
        });
    }
    const handlecoffeePort = (e) => {
        setOrder({
            ...order,
            coffee_port: e.target.value
        })
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
        <div className="AdditionalMenu">
            <label htmlFor="input_bacon">bacon  </label>
            <br/>
            <input
                type='number' name='bacon' value={order.bacon} onChange={handlebacon} />
            <br />
            <label htmlFor="input_bread">bread  </label>
            <br/>
            <input
                type='number' name='bread' value={order.bread} onChange={handlebread} />
            <br />
            <label htmlFor="input_baguette">baguette  </label>
            <br/>
            <input
                type='number' name='bread' value={order.baguetteBread} onChange={handleBaguetteBread} />
            <br />
            <label htmlFor="input_champagne">champagne  </label>
            <br/>
            <input
                type='number' name='champagne' value={order.champagne} onChange={handlechampagne} />
            <br />
            <label htmlFor="input_coffee_cup">cup of coffee  </label>
            <br/>
            <input
                type='number' name='coffee_cup' value={order.coffee_cup} onChange={handlecoffeeCup} />
            <br />
            <label htmlFor="input_coffee_port">port of coffee  </label>
            <br/>
            <input
                type='number' name='coffee_port' value={order.coffee_port} onChange={handlecoffeePort} />
            <br />
            <label htmlFor="input_eggScramble">eggScramble  </label>
            <br/>
            <input
                type='number' name='eggScramble' value={order.eggScramble} onChange={handleeggScramble} />
            <br />
            <label htmlFor="input_salad">salad  </label>
            <br/>
            <input
                type='number' name='salad' value={order.salad} onChange={handlesalad} />
            <br />
            <label htmlFor="input_steak">steak  </label>
            <br/>
            <input
                type='number' name='steak' value={order.steak} onChange={handlesteak} />
            <br />
            <label htmlFor="input_wine">wine  </label>
            <br />
            <input
                type='number' name='wine' value={order.wine} onChange={handlewine} />
        </div>
    )
}
export default AddtionalMenu;