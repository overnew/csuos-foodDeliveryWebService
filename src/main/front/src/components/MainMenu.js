const MainMenu = ( order, setOrder ) => {
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
    
    return (
        <div className="MainMenu">              
            <select name="dinnerType" onChange={handleInputType}>
                <option defaultValue="null">Please Choose Type</option>
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