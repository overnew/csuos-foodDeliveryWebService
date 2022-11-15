import React, { useEffect, useReducer, useRef, useState } from 'react';
import './App.css';
import SigninView from './View/SigninView.js';
import Mainview from './View/Mainview.js';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import SignupView from './View/SignupView';
import axios from 'axios';


export const UserInfoContext = React.createContext();
export const OrderContext = React.createContext();
const reducerUser = (state, action) => {
  switch (action.type) {
    case 'USER': {
      return action.data;
    }
    
  }
}

function App() {
  const [userData, dispatchUser] = useReducer(reducerUser, []);

  const [orderData, setOrder] = useState([]);

  const dataId = useRef(0);

  const getUserData = async () => {
    const res = axios.get('https://jsonplaceholder.typicode.com/users');
    
    const initData = res.map((it) => {
      return ({
        id: it.email,
        pw: it.phone,
        name: it.username,
        addr: it.website,
        //grade: grade,
      });
    });
    dispatchUser({ type: 'USER', data: initData });
  }

  const getOrderData = async() => {
    const res = await fetch
      ('https://jsonplaceholder.typicode.com/comments')
      .then((res) => res.json());
    const initData = res.slice(0, 20).map((it) => {
      return {
        author: it.email,
        text: it.body,
        id: dataId.current++,
      }
    });
    return initData;
  }
  
  useEffect(() => {
    setOrder(getOrderData());
  }, []);
  return (
    <div className="App">
      <h2>미스터 대박 디너 서비스</h2>
      <UserInfoContext.Provider value={userData}>
      <OrderContext.Provider value={orderData}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<SigninView />} />
            <Route path="/main" element={<Mainview />} />
            <Route path="/signup" element={<SignupView />} />
          </Routes>
        </BrowserRouter>
      </OrderContext.Provider>
      </UserInfoContext.Provider>
    </div>
  );
}

export default App;
