import React, { memo } from "react";
import styles from "./DetailView.module.scss";
import TagView from "./TagView";

function DetailView(props) {
  const { title, description, tags } = props;
  return (
    <>
      <div className={styles.TextTitle}>{title}</div>
      <div className={styles.TextDescription}>{description}</div>
      <div style={{ margin: "2px 0 2px 0" }}>
        <a>อ่านต่อ</a>
      </div>
      <div className={styles.Tag}>
        หมวด
        <TagView tags={tags} />
      </div>
    </>
  );
}

export default memo(DetailView);
