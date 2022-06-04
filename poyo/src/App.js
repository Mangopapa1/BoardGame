import { Route, Routes } from "react-router-dom";
import loadable from "@loadable/component";

const Main = loadable(() => import("./pages/Main"));

function App() {
  return (
    <Routes>
      <Route path="/" element={<Main />} />
    </Routes>
  );
}

export default App;
