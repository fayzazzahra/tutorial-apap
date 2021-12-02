import React from "react";
import classes from "./styles.module.css";

const Search = (props) => {
const {action,children,searchQuery,submit} = props;
 return (
 <div>
  <input type="text"
         onChange={action}
         value={searchQuery}>
    {children}
    </input>
    <button onClick={submit} type="submit">Search</button>
    </div>
 );
}

export default Search;