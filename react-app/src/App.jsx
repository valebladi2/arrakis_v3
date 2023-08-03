import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import HomePage from './components/HomePage';
import Login from './components/Login'
import { Bonds } from './components/Bonds';
import { Profile } from './components/Profile';
import {Route, Routes} from 'react-router-dom';
import Register from "./components/Register";

const App = () => {



  


  return (
    <>
      <Routes>
          <Route path="/" element={<Login/>} />
          <Route path="/home" element={<HomePage/>} />
          <Route path="/profile" element={<Profile/>} />
          <Route path="/bonds" element={<Bonds/>} />
          <Route path="/register" element={<Register/>}/>
          <Route path="/login" element={<Login/>}/>
      </Routes>
    </>);
}

export default App;
