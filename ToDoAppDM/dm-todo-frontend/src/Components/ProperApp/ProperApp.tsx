
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavigationMenu from './NavigationMenu';
import TasksUser from './SubSectionInProperApp/TasksUser';
import Products from './SubSectionInProperApp/Products';
import { useEffect, useState } from 'react';
import ItemsExpDate from './SubSectionInProperApp/ItemsExpDate';
import TasksAdmin from './SubSectionInProperApp/TasksAdmin';

const ProperApp = () => {
  const [Taskdata, setTasks] = useState([])
  const [AssignedTaskdata, setAssignedTasks] = useState([])
  const [ProductsFromDB, setProducts] = useState([])
  const [itemsExp, setItemsExp] = useState([])
  async function fetchTask() {
    try {
      const response = await fetch('http://localhost:8080/api/tasks');
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setTasks(data);
      
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  }
  async function fetchItems() {
    try {
      const response = await fetch('http://localhost:8080/api/items/soonest');
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setItemsExp(data);
      
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  }
  async function fetchProducts() {
    try {
      const response = await fetch('http://localhost:8080/api/products');
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setProducts(data);
      
    } catch (error) {
      console.error('Error fetching Products:', error);
    }
  }
  async function fetchAssignedTask() {
    try {
      const response = await fetch('http://localhost:8080/api/assigned');
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setAssignedTasks(data);
      
    } catch (error) {
      console.error('Error fetching assigned tasks:', error);
    }
  }


   useEffect(()=>{
    fetchTask()
    fetchProducts()
    fetchAssignedTask()
    fetchItems()
   }, [])

  return (
    <Router>
      <NavigationMenu></NavigationMenu>
      <Routes>
        <Route path='/' element={<div className='bg-radial from-[var(--c2)] to-[var(--c1)] min-h-screen'></div>} />
        <Route path='/tasks' element={<TasksUser tasks={AssignedTaskdata} funtask={fetchTask} funassigned={fetchAssignedTask}/>} />
        <Route path='/tasksAdmin' element={<TasksAdmin task={Taskdata} funtask={fetchTask} funassigned={fetchAssignedTask}/>} />
        <Route path='/products' element={<Products products={ProductsFromDB} />} />
        <Route path='/ItemsExpDate' element={<ItemsExpDate items={itemsExp} />} />
      </Routes>
    </Router>
  );
};

export default ProperApp;