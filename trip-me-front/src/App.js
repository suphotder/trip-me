import React from "react";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import TripPage from "./views/TripPage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/trips" />} />
        <Route path="/trips" element={<TripPage />} />
      </Routes>
    </Router>
  );
}

export default App;
