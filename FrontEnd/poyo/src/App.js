import { Route, Routes } from "react-router-dom";
import loadable from "@loadable/component";
import "./styles/globals.css";

const Main = loadable(() => import("./pages/Main"));
const Search = loadable(() => import("./pages/Search"));
const Detail = loadable(() => import("./pages/Detail"));

function App() {
  return (
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="/search/:id" element={<Search />} />
      <Route path="/detail" element={<Detail />} />
    </Routes>
  );
}

export default App;
