import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
    
  );
  
}

export default App;


// import React from "react";

// import List from "./components/List";
// // import Emptystate from "./components/EmptyState";
// // import listMovies from "movies.json";

// import "./App.css";
// import Item from "./components/Item";

// export default class App extends React.Component {
//   state = {
//     favItems: [],
//   };

//   noState ={
//     favItems: [],
//   };

//   hideFav = true;

//   handleToggle = () => {  
//     const cartHidden = this.state.cartHidden;
//     this.setState({ cartHidden: !cartHidden });
//   };



//   render() {
//     return (
//         <div className="container-fluid">
//             <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
//             <div style={{ position: "fixed", top: 25, right: 25 }}>
//                  <Fab variant="extended" onClick={this.handleToggle}>
//                      {this.state.cartHidden ?
//                          <Badge color="secondary" badgeContent={this.state.cartItems.length}>
//                               <ShoppingCartIcon />
//                          </Badge>
//                            : <ViewStreamIcon/>}
//                  </Fab>
//             </div>
//             <p className="text-center text-secondary text-sm font-italic">
//                  (this is a <strong>class-based</strong> application)
//             </p>
//             <p className="text-center text-primary" >Your Balance: <b> {this.state.balance}</b> </p>
//             <div className="container pt-3">
//                  <div className="row mt-3">
//                           {!this.state.cartHidden ? (
//                               <div className="col-sm">
//                                   <List
//                                        title="My Cart"
//                                        items={this.state.cartItems}
//                                        onItemClick={() => {}}
//                                   ></List>
//                               </div>
//                          ): <div className="col-sm">
//                               <List
//                                   title="List Items"
//                                   items={this.state.shopItems}
//                                   onItemClick={this.handleAddItemToCart}
//                                   isShopList={true}
//                               ></List>
//                          </div>}
//                      </div>
//             </div>
//         </div>
//     );
// }
// }

