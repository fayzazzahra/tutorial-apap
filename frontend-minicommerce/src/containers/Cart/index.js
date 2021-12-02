import React, { Component } from "react";
import {Link} from 'react-router-dom'
import Item from "../../components/layout/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class Cart extends Component {
constructor(props) {
    super(props);
    this.state = {
    items: [],
    isLoading: false,
    id: "",
    title: "",
    price: 0,
    description: "",
    category: "",
    quantity: 0
    };
 
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.loadData = this.loadData.bind(this);
   

}

handleEditItem(item) {
    this.setState({
        isEdit: true,
        id: item.id,
        title: item.title,
        price: item.price,
        description: item.description,
        category: item.category,
        quantity: item.quantity
    })
}



componentDidMount() {
    console.log("componentDidMount()");
    this.loadData();
}

async loadData() {
    try {
        const { data } = await APIConfig.get("/cart");
        this.setState({ items: data.result });
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}


shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate()");
    return true;
}

async handleSubmitItem() {
    try {
        await APIConfig.get(`/cart/checkout`);
        this.setState({ items: [] });
        console.log("ya")
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        console.log("ok")
    }
    console.log(this.state.searchQuery)
}


render() {
    console.log(this.state.items, "items")
    return (
    <div className={classes.itemList}>
    <h1 className={classes.title}>Cart Items</h1>
    <div style={ {position: "fixed", top: 25, left: 25} } >
        <Link to="/">
       
        <button>Back</button>
        </Link>
       
    </div>
    {
        this.state.items.length>0 &&
        <div style={ {position: "fixed", top: 25, right: 25} }>
        <button onClick={this.handleSubmitItem}>Checkout</button>
    </div>
    }
    
    <div>
        {this.state.items.map((el) => (
        <Item
        key={el.id}
        id={el.id}
        title={el.item.title}
        totalQuantity={el.quantity}
        price={el.item.price}
        description={el.item.description}
        category={el.item.category}
        quantity={el.item.quantity}
        type={"cart"}
      
    />
))}
</div>

</div>

);
}

}

export default Cart;