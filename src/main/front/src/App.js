import React, { useEffect, useReducer, useRef, useState } from 'react';
import './App.css';
import SigninView from './View/SigninView.js';
import Mainview from './View/Mainview.js';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import SignupView from './View/SignupView';
import OrderView from './View/OrderView';


export const UserInfoContext = React.createContext();
export const OrderContext = React.createContext();
export const sessionContext = React.createContext();
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

  var sessionInfo;

  const dataId = useRef(0);

  
  useEffect(() => {
    
  }, []);
  return (
    <div className="App">
      <br />
      <UserInfoContext.Provider value={userData}>
        <OrderContext.Provider value={orderData}>
        <sessionContext.Provider value={sessionInfo}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<SigninView />} />
            <Route path="/main" element={<Mainview />} />
            <Route path="/signup" element={<SignupView />} />
            <Route path="/signin" element={<SigninView />} />
            <Route path="/order" element={<OrderView />} />
          </Routes>
          </BrowserRouter>
      </sessionContext.Provider>
      </OrderContext.Provider>
      </UserInfoContext.Provider>
    </div>
  );
}

export default App;
