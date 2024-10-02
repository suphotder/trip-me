import React, { memo } from "react";
import styles from "./DetailView.module.scss";
import TagView from "./TagView";

function DetailView(props) {
  const { url, title, description, tags } = props.item;

  const openTrip = () => {
    window.open(url, "_blank", "noopener,noreferrer");
  };

  return (
    <>
      <div className={styles.TextTitle}>
        <a style={{ color: "black" }} onClick={openTrip}>
          {title}
        </a>
      </div>
      <div className={styles.TextDescription}>{description}</div>
      <div style={{ margin: "2px 0 2px 0" }}>
        <a onClick={openTrip}>อ่านต่อ</a>
      </div>
      <div className={styles.Tag}>
        หมวด
        <TagView tags={tags} />
      </div>
    </>
  );
}

export default memo(DetailView);
