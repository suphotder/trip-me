import React, { memo } from "react";
import { useNavigate } from "react-router-dom";
import styles from "./TagView.module.scss";

function TagView(props) {
  const navigate = useNavigate();

  const navigateToTrips = (keyword) => {
    navigate("/trips?keyword=" + keyword);
  };

  return (
    <>
      {props.text}
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
    </>
  );
}

export default memo(TagView);
