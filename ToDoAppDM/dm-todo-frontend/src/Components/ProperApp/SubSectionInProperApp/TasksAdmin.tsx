import React from 'react'
import { Container } from '@mui/material'
import TaskElement from '../../Basic/TaskElement';
interface Shelf {
    id: number;
    description: string;
  }
  
  interface Product {
    idProduct: number;
    nameProduct: string;
    category: any; 
  }
  
  interface Task {
    idTask: number;
    description: string;
    product?: Product; 
    shelfFrom?: Shelf;
    shelfTo?: Shelf; 
  }

const TasksAdmin = ({task=[], funassigned, funtask}: {task: Task[],  funassigned: () => void, funtask: () => void}) => {

  return (
    <div className='bg-radial from-[var(--c2)] to-[var(--c1)] min-h-screen'>
      <Container>
        <div className='w-full h-full items-center'>
          
          {task.length === 0 ? (
            <p>No tasks found</p>
          ) : (
            <ul>
              {task.map((task) => (
                  
                <li key={task.idTask} style={{ display: 'inline-block', margin: '0 10px' }}>
                  <TaskElement task={task} isDone={true} isUser={false} idassigned={-1} funassigned={funassigned} funtask={funtask}/>
                </li>
              ))}
            </ul>
          )}
        </div>
      </Container>
    </div>
  )
}

export default TasksAdmin