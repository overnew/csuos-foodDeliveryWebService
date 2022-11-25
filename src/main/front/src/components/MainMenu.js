const MainMenu = ({ order, setOrder }) => {
    const handleInputType = (e) => {
        if (e.target.value === 'VALENTINE') {
            setOrder({
                ...order,
                dinnerType: e.target.value,
                bacon: 0,
                bread: 0,
                baguetteBread:0,
                champagne: 0,
                coffee_cup: 0,
                coffee_port: 0,
                eggScramble: 0,
                salad: 0,
                steak: 1,
                wine: 1,
            })
        } else if (e.target.value === 'FRENCH') {
            setOrder({
                ...order,
                dinnerType: e.target.value,
                bacon: 0,
                bread: 0,
                baguetteBread:0,
                champagne: 0,
                coffee_cup: 1,
                coffee_port: 0,
                eggScramble: 0,
                salad: 1,
                steak: 1,
                wine: 1,
            })
        } else if (e.target.value === 'ENGLISH') {
            setOrder({
                ...order,
                dinnerType: e.target.value,
                bacon: 1,
                bread: 1,
                baguetteBread:0,
                champagne: 0,
                coffee_port: 0,
                coffee_cup: 0,
                eggScramble: 1,
                salad: 0,
                steak: 1,
                wine: 0,
            })
        } else if (e.target.value === 'CHAMPAGNE') {
            setOrder({
                ...order,
                dinnerType: e.target.value,
                bacon: 0,
                bread: 0,
                baguetteBread: 1,
                champagne: 1,
                coffee_cup: 0,
                coffee_port: 1,
                eggScramble: 0,
                salad: 0,
                steak: 1,
                wine: 1,
            })
        }
        console.log(order);
    }
    const handleInputStyle = (e) => {
        setOrder({
            ...order,
            dinnerStyle: e.target.value
        });
        console.log(order);
    }
    
    return (
        <div className="MainMenu">              
            <select name="dinnerType" onChange={handleInputType}>
                <option defaultValue="null">Please Choose Type</option>
                <option value="VALENTINE">VALENTINE</option>
                <option value="FRENCH">FRENCH</option>
                <option value="ENGLISH">ENGLISH</option>
                <option value="CHAMPAGNE">CHAMPAGNE</option>
            </select>
            <br />
            <select name="dinnerStyle" onChange={handleInputStyle}>
                <option defaultValue="null">Please Choose Style</option>
                <option value="SIMPLE">SIMPLE</option>
                <option value="GRAND">GRAND</option>
                <option value="DELUXE">DELUXE</option>
            </select>
        </div>
    );
}
export default MainMenu;