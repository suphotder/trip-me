import React, { memo } from "react";

function StatusView(props) {
  const { children } = props;
  return (
    <div
      style={{
        height: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        marginTop: -150,
      }}
    >
      {children}
    </div>
  );
}

export default memo(StatusView);
