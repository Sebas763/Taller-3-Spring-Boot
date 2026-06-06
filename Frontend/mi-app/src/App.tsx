import { useState } from 'react'
import { ProductList } from "./components/ProductList";
import { UserList } from "./components/UserList";
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'


function App() {
  const [count, setCount] = useState(0)
  
  return (
    
    <>
    <ProductList/>
    <UserList/>
      </>
  )
}

export default App
