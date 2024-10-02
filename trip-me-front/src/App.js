import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import TripPage from "./views/TripPage";

function App() {
  // return <TripPage />;
  return (
    <Router>
      <Routes>
        <Route path="/" element={<TripPage />} />
        <Route path="/trips" element={<TripPage />} />
      </Routes>
    </Router>
  );
}

export default App;
