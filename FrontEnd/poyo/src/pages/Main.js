import { useState } from "react";
import Home from "../components/home/Home";
import Splash from "../components/splash/Splash";

export default function Main() {
  const [modal, setModal] = useState(true);
  setTimeout(() => {
    setModal(false);
  }, 1300);

  return (
    <>
      {modal ? <Splash /> : null}
      <Home />
    </>
  );
}
