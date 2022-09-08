import { useEffect, useState } from "react";
import Home from "../components/home/Home";
import Splash from "../components/splash/Splash";
import axios from "axios"

export default function Main() {
  const [modal, setModal] = useState(true);
  setTimeout(() => {
    setModal(false);
  }, 1300);

  const getGame = async() => {
    const res = await axios.get(`http://54.180.58.142:8080/poyo/games`, {
      headers: {
        "Content-type" : "application.json",
      },
    });
    console.log(res);
  };

  useEffect(()=> {
    getGame();
  },[]);
  return (
    <>
      {modal ? <Splash /> : null}
      <Home />
    </>
  );
}
