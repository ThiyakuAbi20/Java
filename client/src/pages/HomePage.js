import React from "react";
import { useNavigate } from "react-router-dom";
import "../App.css";

function HomePage() {
  const navigate = useNavigate();

  const handleLogout = () => {
    sessionStorage.removeItem("isAuthenticated");
    navigate("/login");
  };

  return (
    <div className="home-page">
      <h2>Welcome to the Home Page!</h2>
      <p>Welcome to the Attendance System! Our platform streamlines attendance tracking, allowing for efficient and accurate record-keeping. Easily manage student or employee attendance, track time and presence, and generate reports with just a few clicks. Designed for convenience and reliability, our system helps organizations save time and improve productivity by providing real-time attendance insights. Explore a smarter way to handle attendance today!</p>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
}

export default HomePage;
