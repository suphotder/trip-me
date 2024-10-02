import { useState } from "react";

export const PhotoModalViewModel = (props) => {
  const [photo, setPhoto] = useState();
  const [isOpenPhoto, setOpenPhoto] = useState(false);
  return { photo, setPhoto, isOpenPhoto, setOpenPhoto };
};
