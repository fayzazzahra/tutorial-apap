import React, { Component } from "react";
import Item from "../../components/layout/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import Search from "../../components/search";
import {Link} from "react-router-dom"
import { Fab } from "@material-ui/core";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';

class ItemList extends Component {
constructor(props) {
    super(props);
    this.state = {
    items: [],
    isLoading: false,
    isCreate: false,
    isEdit: false,
    searchQuery: "",
    cartItems: [],
    id: "",
    title: "",
    price: 0,
    description: "",
    category: "",
    quantity: 0
    };
    this.handleClickLoading = this.handleClickLoading.bind(this);
    this.handleAddItem = this.handleAddItem.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.loadData = this.loadData.bind(this);
    this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
    this.handleEditItem = this.handleEditItem.bind(this);
    this.handleSearchSubmit = this.handleSearchSubmit.bind(this);
    this.getCart = this.getCart.bind(this);

}


handleAddItem() {
    this.setState({ isCreate:true});
    console.log(this.state.isCreate);
}

handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate:false, isEdit: false });
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

handleClickLoading() {
    const currentLoading = this.state.isLoading;
    this.setState({ isLoading: !currentLoading });
    console.log(this.state.isLoading);
}

async loadData() {
    try {
        const { data } = await APIConfig.get("/item");
        this.setState({ items: data.result });
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}

componentDidMount() {
    console.log("componentDidMount()");
    this.loadData();
    this.getCart();
}

shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate()");
    return true;
}

handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
}

async handleSubmitItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity
      };
      await APIConfig.post("/item", data);
      this.setState({
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0
      })
      this.loadData();
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
    // this.handleCancel(event);
}

async handleSubmitEditItem(event) {
    event.preventDefault();
    try {
        const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity
        };
        await APIConfig.put(`/item/${this.state.id}`, data);
        this.setState({
        id: "",
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0
        })
        this.loadData();
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
    this.handleCancel(event);
}

async handleSearchSubmit() {
    try {
        const { data } = await APIConfig.get(`/item?title=${this.state.searchQuery}`);
        this.setState({ items: data.result });
        console.log("ya")
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        console.log("ok")
    }
    console.log(this.state.searchQuery)
}

async getCart() {
    try {
        const { data } = await APIConfig.get("/cart");
        this.setState({ cartItems: data.result });
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}


render() {
    console.log(this.state.items, "items")
    return (
    <div className={classes.itemList}>
    <h1 className={classes.title}>All Items</h1>
    <div style={ {position: "fixed", top: 25, right: 25} }>
    <Link to="/cart">
        <Fab variant="extended">
            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                <ShoppingCartIcon />
            </Badge>
        </Fab>
    </Link>
    </div>
    <Button action={this.handleAddItem}>
        Add Item
    </Button>
    <Search submit={this.handleSearchSubmit} searchQuery={this.state.searchQuery} 
        action={(e)=>this.setState({searchQuery:e.target.value})}>
    </Search>
    <div>
        {this.state.items.map((item) => (
        <Item
        key={item.id}
        id={item.id}
        title={item.title}
        price={item.price}
        description={item.description}
        addToCartList = {this.getCart}
        category={item.category}
        quantity={item.quantity}
        handleEdit = {() => (this.handleEditItem(item))}
    />
))}
</div>
<Modal
show={this.state.isCreate || this.state.isEdit}
handleCloseModal={this.handleCancel}
modalTitle={this.state.isCreate
            ? "Add Item"
            : `Edit Item ID ${this.state.id}`}
>   
<form>
    <input
        className={classes.textField}
        type="text"
        placeholder="Nama Item"
        name="title"
        value={this.state.title}
        onChange={this.handleChangeField}
    />
    <input
        className={classes.textField}
        type="number"
        placeholder="Harga"
        name="price"
        value={this.state.price}
        onChange={this.handleChangeField}
    />
    <textarea
        className={classes.textField}
        placeholder="Deskripsi"
        name="description"
        rows="4"
        value={this.state.description}
        onChange={this.handleChangeField}
    />
    <input 
        className={classes.textField}
        type="text"
        placeholder="Kategori"
        name="category"
        value={this.state.category}
        onChange={this.handleChangeField}
    />
    <input 
        className={classes.textField}
        type="number"
        placeholder="qty"
        name="quantity"
        value={this.state.quantity}
        onChange={this.handleChangeField}
    />
    <Button action={this.state.isCreate
        ? this.handleSubmitItem
        : this.handleSubmitEditItem}>Create</Button>
    <Button action={this.handleCancel}>Cancel</Button>
</form>
</Modal>
</div>

);
}

}

export default ItemList;