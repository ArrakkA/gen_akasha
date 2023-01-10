import React, {useEffect, useState} from "react";
import {Routes, Route, Link} from "react-router-dom";
import axios from "axios";
import Home from "./pages/Home"
import About from "./pages/About";


const App = () => {
  return (
    <div className="App">
      <nav>
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/about" element = {<About/>}/>
      </Routes>
      <Home/>
    </div>
  );
}

export default App;