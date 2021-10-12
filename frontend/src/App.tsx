import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Switcher from './Switcher';
import Menu from './Menu';

function App() {
  return (
    <div className="App">

      <BrowserRouter>
          <div className="container">
           <Menu></Menu>
          </div>

      </BrowserRouter>

    </div>
  );
}

export default App;
