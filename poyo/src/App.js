import { Route, Routes } from "react-router-dom";
import loadable from "@loadable/component";

const Main = loadable(() => import("./pages/Main"));
const Detail = loadable(() => import("./pages/Detail"));

function App() {
  return (
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="/detail" element={<Detail />} />
    </Routes>
  );
}

export default App;
