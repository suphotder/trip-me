import React, { memo } from "react";
import { useNavigate } from "react-router-dom";

function TagView(props) {
  const navigate = useNavigate();

  const navigateToTrips = (keyword) => {
    navigate("/trips?keyword=" + keyword);
  };

  return (
    <div
      style={{
        color: "grey",
      }}
    >
      หมวด
      {props.tags?.map((item, index) => {
        return (
          <a
            key={index}
            style={{ marginLeft: 6 }}
            onClick={navigateToTrips.bind(this, item)}
          >
            <u>{item}</u>
          </a>
        );
      })}
    </div>
  );
}

export default memo(TagView);
