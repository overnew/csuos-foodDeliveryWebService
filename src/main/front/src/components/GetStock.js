
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

export default GetStock;