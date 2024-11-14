import './App.css';

import React from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import HomePage from "./pages/HomePage";


const isAuthenticated = () => {
  return sessionStorage.getItem("isAuthenticated") === "true"; 
};

const PrivateRoute = ({ element, ...rest }) => {
  return isAuthenticated() ? element : <Navigate to="/login" />;
};

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/home" element={<PrivateRoute element={<HomePage />} />} />
        <Route path="/" element={<Navigate to="/login" />} />
      </Routes>
    </Router>
  );
}

export default App;

