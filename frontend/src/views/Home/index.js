import React from "react";
import listItems from "../../items.json";
import List from "../../components/List/index";
import "./index.css";
import {Badge, Fab} from "@material-ui/core";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import { toggleButtonGroupClasses } from "@mui/material";

export default class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state =  {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }

    // render() {
    //     return (
    //         <div className="container-fluid">
    //             <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
    //             <p className="text-center text-secondary text-sm font-italic">
    //                 (this is a <strong>class-based</strong> application)
    //             </p>
    //             <div className="container pt-3">
    //                 <div className="row mt-3">
    //                     <div className="col-sm">
    //                         <List
    //                             title ="List Items"
    //                             items={listItems}
    //                             onItemClick={() => {}}
    //                         ></List>
    //                     </div>
    //                 </div>
    //             </div>
    //         </div>
    //     );
    // }

    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon/>
                            </Badge>
                            : <ViewStreamIcon/>}
                    </Fab>
                </div>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primary">Your Balance: <b> {this.state.balance}</b> </p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <button className="btn btn-primary" onClick={this.deleteAll}>Delete All</button>
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemFromCart}
                                    // onItemClick={() => {}}
                                ></List>
                            </div>
                        ) :  <div className="col-sm">
                            <List
                                title="List Items"
                                items={this.state.shopItems}
                                onItemClick={this.handleAddItemToCart}
                                isShopList={true}
                            ></List>
                        </div>}
                    </div>
                </div>
            </div>
        );
    }

    deleteAll = (item) => {
        // var balance = 0;
        for (let idx = 0; idx < this.state.cartItems; idx++) {
            // balance -= this.state.cartItems[idx].price;
            this.updateShopItem(this.state.cartItems[idx], false);  
        }
        this.setState((prevState) => ({
            cartItems : [],
            balance : 120
        }));
    }

    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if ((this.state.balance-item.price) >= 0) {
            if (targetInd < 0) {
                newItem.inCart = true;
                newItems.push(newItem);
                this.updateShopItem(newItem, true)
            }
            // this.setState({ cartItems: newItems });
            this.setState((prevState) => ({
                cartItems : newItems,
                balance : (prevState.balance-item.price)
            }));
        } else {
            alert("Balance not sufficient!")
        }
    };

    handleDeleteItemFromCart = (item) => {
        const cartItems = [...this.state.cartItems];
        const newCartItems = cartItems.filter((e) => e.id !== item.id);    
        this.setState((prevState) => ({
            cartItems : newCartItems,
            balance : prevState.balance+item.price
        }));
        this.updateShopItem(item, false)
    }

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden});
    };
    
    
}